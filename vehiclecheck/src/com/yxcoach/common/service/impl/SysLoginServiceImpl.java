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
import com.yxcoach.common.service.SysLoginService;
import com.yxcoach.common.service.SysUserService;

@Service("SysLoginServiceImpl")
public class SysLoginServiceImpl implements SysLoginService {
	private static final Log log = LogFactory.getLog(SysLoginServiceImpl.class);
	
	@Resource(name = "SysUserServiceImpl")
	private SysUserService sysUserService;
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	@Value("${redis.token.key}")
	private String SYS_USER_TOKEN;
	@Value("${redis.token.expire}")
	private Long SYS_USER_TOKEN_EXPIRE;
	
	
	/*
	 * app用户名登录接口
	 */
	@Override
	public BaseResponse userLogin(LoginRequest loginRequest) throws Exception {
		/**登录校验*/
		if(Util.isNull(loginRequest.getUsername())||Util.isNull(loginRequest.getPassword())){	
			log.info("用户名或密码不能为空");
			return BaseResponse.response(2, "用户名或密码不能为空");
		}
		List<SysUser> list = sysUserService.selectAll1(loginRequest);
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
		if (redisTemplate.hasKey(SYS_USER_TOKEN+":"+user.getLogin_name())) {
			String token = (String)redisTemplate.opsForValue().get(SYS_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(SYS_USER_TOKEN+":"+user.getLogin_name());
			redisTemplate.delete(SYS_USER_TOKEN+":"+token);

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
		redisTemplate.opsForValue().set(SYS_USER_TOKEN+":"+token,user);		
		redisTemplate.opsForValue().set(SYS_USER_TOKEN+":"+user.getLogin_name(),token);		
		redisTemplate.expire(SYS_USER_TOKEN+":"+token, 1, TimeUnit.DAYS);
		redisTemplate.expire(SYS_USER_TOKEN+":"+user.getLogin_name(), 1, TimeUnit.DAYS);

		log.info(user.getUser_name()+"登录成功");
		SysUserResp sysUserResp=new SysUserResp();
		sysUserResp.setToken(token);
		sysUserResp.setUsername(user.getUser_name());
		sysUserResp.setRid(user.getRid());
		sysUserResp.setIsmanager(user.getIsmanager());
		sysUserResp.setTelphone(user.getTelphone());
		sysUserResp.setUser_type(user.getUser_type());

		sysUserResp.setUser_pwd(user.getUser_pwd());
		/**登录成功返回token和基本用户信息*/
		return BaseResponse.response(1, sysUserResp);

	}

	/*
	 * 根据token注销用户接口
	 */
	@Override
	public BaseResponse userLogout(String token) throws Exception {
		//判断redis中是否有值
		if (redisTemplate.hasKey(SYS_USER_TOKEN+":"+token)) {
			SysUser user = (SysUser) redisTemplate.opsForValue().get(SYS_USER_TOKEN+":"+token);
			redisTemplate.delete(SYS_USER_TOKEN+":"+user.getUser_name());
			redisTemplate.delete(SYS_USER_TOKEN+":"+token);

			log.info(user.getUser_name()+"注销用户成功");
		}
		return BaseResponse.response(1, "注销用户成功");
	}

	/*
	 * 根据token获取redis中的用户信息
	 */
	@Override
	public BaseResponse getUserByToken(String token) throws Exception {
		SysUser user=(SysUser) redisTemplate.opsForValue().get(SYS_USER_TOKEN+":"+token);		
		if(user==null){
			log.info("用户登录过期");
			return BaseResponse.response(2,"用户登录过期");
		}			
		return BaseResponse.response(1,user);		
	}

}
