package com.yxcoach.common.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.response.SysUserResp;
import com.yxcoach.common.service.BsMsglogService;
import com.yxcoach.common.service.LoginService;
import com.yxcoach.common.service.SysUserService;

@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);
	
	@Resource(name = "SysUserServiceImpl")
	private SysUserService sysUserService;
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	@Value("${redis.token.keyapp}")
	private String APP_USER_TOKEN;
	@Value("${redis.token.expire}")
	private Long SYS_USER_TOKEN_EXPIRE;
	
	@Resource(name = "BsMsglogService")
	private BsMsglogService bsMsglogService;
	
	/*
	 * 用户名密码登录
	 */
	@Override
	public BaseResponse userLogin(LoginRequest loginRequest) throws Exception {
		/**登录校验*/
		if(Util.isNull(loginRequest.getUsername())||Util.isNull(loginRequest.getPassword())){	
			log.info("用户名或密码不能为空");
			return BaseResponse.response(2, "用户名或密码不能为空");
		}
		List<SysUser> list = sysUserService.selectAll(loginRequest);
		if(list==null||list.size()==0){
			log.info("用户名不存在");
			return BaseResponse.response(2, "用户名不存在");
		}
		String md5pass = Util.md5(loginRequest.getPassword());
		
		//		String md5pass=sys_user_vo.getPassword();
		if(!list.get(0).getUser_pwd().equals(md5pass)){
			log.info("用户名或密码错误");
			return BaseResponse.response(2, "用户名或密码错误");
		}
		SysUser user=list.get(0);
		//判断redis中是否有值
		if (redisTemplate.hasKey(APP_USER_TOKEN+":"+user.getLogin_name())) {
			String token = (String)redisTemplate.opsForValue().get(APP_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(APP_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(APP_USER_TOKEN+":"+token);

		}
		
		/**创建token*/
		String token=UUID.randomUUID().toString();
		if(user.getUse_status()!=1){
			String status=user.getUse_status()==2 ? "用户被锁定" : "用户被永久锁定";
			log.info(status);
			return BaseResponse.response(2, status);
		}
		
		
//		user.setUser_pwd(null);
//		loginRequest.setToken(token);
//		loginRequest.setPassword(null);

		/**将token和用户信息写入redis和设置过期时间*/
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+token,user);		
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+user.getLogin_name(),token);		
		redisTemplate.expire(APP_USER_TOKEN+":"+token, 30, TimeUnit.DAYS);
		redisTemplate.expire(APP_USER_TOKEN+":"+user.getLogin_name(), 30, TimeUnit.DAYS);

		log.info(user.getUser_name()+"登录成功");
		SysUserResp sysUserResp=new SysUserResp();
		sysUserResp.setToken(token);
		sysUserResp.setRid(user.getRid());
		sysUserResp.setIsmanager(user.getIsmanager());
		sysUserResp.setUsername(user.getUser_name());
		sysUserResp.setTelphone(user.getTelphone());
		sysUserResp.setUser_type(user.getUser_type());
		sysUserResp.setUser_pwd(user.getUser_pwd());
		/**登录成功返回token和基本用户信息*/
		return BaseResponse.response(1, sysUserResp);

	}

	
	@Override
	public BaseResponse userLogout(String token) throws Exception {
		//判断redis中是否有值
		if (redisTemplate.hasKey(APP_USER_TOKEN+":"+token)) {
			SysUser user = (SysUser) redisTemplate.opsForValue().get(APP_USER_TOKEN+":"+token);
			redisTemplate.delete(APP_USER_TOKEN+":"+user.getUser_name());
			redisTemplate.delete(APP_USER_TOKEN+":"+token);

			log.info(user.getUser_name()+"注销用户成功");
		}
		return BaseResponse.response(1, "注销用户成功");
	}

	/*
	 * 根据token获取redis中的用户信息
	 */
	@Override
	public BaseResponse getUserByToken(String token) throws Exception {
		SysUser user=(SysUser) redisTemplate.opsForValue().get(APP_USER_TOKEN+":"+token);		
		if(user==null){
			log.info("用户登录过期");
			return BaseResponse.response(2,"用户登录过期");
		}			
		return BaseResponse.response(1,user);		
	}

	/*
	 * 电话号码验证码登录
	 */
	public BaseResponse userLogin1(LoginRequest loginRequest) throws Exception {
		/**登录校验*/
		if(Util.isNull(loginRequest.getTelphone())){	
			log.info("电话号码不能为空");
			return BaseResponse.response(2, "用户名或密码不能为空");
		}
		List<SysUser> list = sysUserService.selectAll(loginRequest);
		if(list.size()==0){
			return BaseResponse.response(2, "用户未注册！");
		}
		Integer str=(Integer)redisTemplate.opsForValue().get("YZM:"+loginRequest.getTelphone());
		if(str==null){
			log.info("验证码已过期");
			return BaseResponse.response(2, "验证码已过期");
		}
		if(!str.equals(loginRequest.getYzm())){
			log.info("验证码错误");
			return BaseResponse.response(2, "验证码错误");
		}
		SysUser user=list.get(0);
		if(user==null){
			return BaseResponse.response(2, "用户不存在请注册");
		}
		//判断redis中是否有值
		if (redisTemplate.hasKey(APP_USER_TOKEN+":"+user.getLogin_name())) {
			String token = (String)redisTemplate.opsForValue().get(APP_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(APP_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(APP_USER_TOKEN+":"+token);

		}
		
		/**创建token*/
		String token=UUID.randomUUID().toString();
		if(user.getUse_status()!=1){
			String status=user.getUse_status()==2 ? "用户被锁定" : "用户被永久锁定";
			log.info(status);
			return BaseResponse.response(2, status);
		}
		
		
//		user.setUser_pwd(null);
//		loginRequest.setToken(token);
//		loginRequest.setPassword(null);

		/**将token和用户信息写入redis和设置过期时间*/
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+token,user);		
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+user.getLogin_name(),token);		
		redisTemplate.expire(APP_USER_TOKEN+":"+token, 30, TimeUnit.DAYS);
		redisTemplate.expire(APP_USER_TOKEN+":"+user.getLogin_name(), 30, TimeUnit.DAYS);

		log.info(user.getUser_name()+"登录成功");
		SysUserResp sysUserResp=new SysUserResp();
		sysUserResp.setToken(token);
		sysUserResp.setRid(user.getRid());
		sysUserResp.setUsername(user.getUser_name());
		sysUserResp.setIsmanager(user.getIsmanager());
		sysUserResp.setTelphone(user.getTelphone());
		sysUserResp.setUser_type(user.getUser_type());

		sysUserResp.setUser_pwd(user.getUser_pwd());
		/**登录成功返回token和基本用户信息*/
		return BaseResponse.response(1, sysUserResp);
	}


	//设置验证码
	public boolean foryzm(LoginRequest loginRequest) throws Exception {
			redisTemplate.opsForValue().set("YZM:"+loginRequest.getTelphone(),loginRequest.getYzm());
			redisTemplate.expire("YZM:"+loginRequest.getTelphone(), 600, TimeUnit.SECONDS);
			return bsMsglogService.send(1, loginRequest.getTelphone(), "您好:本次验证码为:"+loginRequest.getYzm());
	}
}
