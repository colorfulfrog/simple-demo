package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.exception.YxBizException;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.dao.SysUnionDAO;
import com.yxcoach.common.dao.SysUserDAO;
import com.yxcoach.common.entity.SysUnion;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.request.SysUserQueryRequest;
import com.yxcoach.common.request.SysUserRequest;
import com.yxcoach.common.response.SysUserInfoResp;
import com.yxcoach.common.service.SysUserService;
/**
 * @ClassName: SysUserServiceImpl
 * @Description: 用户表 serviceImpl
 * @author yangzhipeng
 * @date 2018-03-24
 */
@Transactional(readOnly = true)
@Service("SysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService{

	@Resource(name = "sysUserDAO")
	private SysUserDAO sysUserDAO;
		
	@Resource(name = "sysUnionDAO")
	private SysUnionDAO sysUnionDAO;
	
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	@Value("${redis.token.keyapp}")
	private String APP_USER_TOKEN;
	@Value("${redis.token.expire}")
	private Long SYS_USER_TOKEN_EXPIRE;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysUserQueryRequest sysUserQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=sysUserQueryRequest.getPageOption();
		if(sysUserQueryRequest.getPageOption().getRows()==null) sysUserQueryRequest.getPageOption().setRows(20);
		if(sysUserQueryRequest.getPageOption().getPage()==null) sysUserQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysUserQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysUserQueryRequest.getPageOption().getPage() - 1) * sysUserQueryRequest.getPageOption().getRows());
		if (Util.isNotNull(sysUserQueryRequest.getUser_name())) {
			map.put("userName", sysUserQueryRequest.getUser_name());
		}
		if (Util.isNotNull(sysUserQueryRequest.getCheck_station_id())) {
			map.put("check_station_id", sysUserQueryRequest.getCheck_station_id());
		}
		if (Util.isNotNull(sysUserQueryRequest.getUse_status())) {
			map.put("usestatus", sysUserQueryRequest.getUse_status());
		}
		if (Util.isNotNull(sysUserQueryRequest.getTelphone())) {
			map.put("telphone", sysUserQueryRequest.getTelphone());
		}
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.sysUserDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysUserQueryRequest.getPageOption().getRows(), sysUserQueryRequest.getPageOption().getPage(), count, new ArrayList<SysUser>());
		}
		List<SysUser> list = this.sysUserDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysUserQueryRequest.getPageOption().getRows(), sysUserQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	
	

	/**
	 * 查询一条记录
	 */
	public SysUser get(BaseViewRequest baseViewRequest) throws Exception {
		return sysUserDAO.getById(baseViewRequest.getId());
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysUserRequest sysUserRequest) throws Exception {
	    SysUser sysUser= sysUserRequest.getSysUser();
	    Map<String, Object> map = new HashMap<String,Object>();
	    map.put("loginName", sysUser.getLogin_name());
	    map.put("telphone", sysUser.getTelphone());
	    SysUser suser= sysUserDAO.checkExist(map);
	    
	    SysUser suser1= sysUserDAO.checkExist1(map);
	    if(suser!=null){
	    	throw new YxBizException("该用户名已存在");
	    }
	    if(suser1!=null){
	    	throw new YxBizException("手机号码已被注册");
	    }
		Integer result = sysUserDAO.add(sysUser);
		Integer result1=0;
		if(result>0){
			SysUnion u = new SysUnion();
			u.setRid(sysUser.getRid());
			u.setType(4);
			u.setOid(sysUser.getId());
			result1= sysUnionDAO.add(u);
		}
		return (result>0&&result1>0)?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysUserRequest sysUserRequest) throws Exception {
	    SysUser sysUser= sysUserRequest.getSysUser();	    
	    SysUser olduser= sysUserDAO.getById(sysUser.getId());
	    if(!olduser.getUser_pwd().equals(sysUser.getUser_pwd())){
	    	sysUser.setUser_pwd(Util.md5(sysUser.getUser_pwd()));
	    }
		Integer result = sysUserDAO.update(sysUser);
		SysUnion sysUnion= new SysUnion();
		sysUnion.setOid(sysUser.getId());
		sysUnion.setRid(sysUser.getRid());
		sysUnion.setType(4);
		sysUnionDAO.update(sysUnion);
		return result>0?true:false;
	}
	
	/**
	 * 更换手机号码
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean changeMobile(SysUserRequest sysUserRequest) throws Exception {
		String telphone= sysUserRequest.getTelphone();
		String code= sysUserRequest.getCode();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("telphone", telphone);
		SysUser suser1= sysUserDAO.checkExist1(map);
		if(suser1!=null){
	    	throw new YxBizException("手机号码已被占用");
	    }
		if(Util.isNull(telphone)){
			throw new YxBizException("手机号码不能为空");
		}
		if(Util.isNull(code)){
			throw new YxBizException("验证码不能为空");
		}
	    SysUser sysUser= sysUserRequest.getSysUser();	
	    sysUser.setTelphone(telphone); 
	    //SysUser olduser= sysUserDAO.getById(sysUser.getId());
	    /**
	     * 取短信验证码，  
	     *  需要通过手机号去redis取验证码   
	     *  
	     */
	    try {
	    	Integer yzcode=(Integer) redisTemplate.opsForValue().get("YZM:"+sysUser.getTelphone());
		    if(null==yzcode||!yzcode.toString().equals(code)){
		    	throw new YxBizException("验证码有误或已过期");
		    }
		} catch (Exception e) {
			throw new YxBizException("验证码有误或已过期");
		}
		Integer result = sysUserDAO.update(sysUser);
	    /**
		 * 更新redis 中的用户缓存
		 */
	    /**将token和用户信息写入redis和设置过期时间*/
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+sysUserRequest.getToken(),sysUser);		
		redisTemplate.expire(APP_USER_TOKEN+":"+sysUserRequest.getToken(), SYS_USER_TOKEN_EXPIRE, TimeUnit.MINUTES);
		return result>0?true:false;
	}
	
	
	/**
	 * 修改密码
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean updatePwd(SysUserRequest sysUserRequest) throws Exception {
		SysUser sysUser= sysUserRequest.getSysUser();	 
		if(Util.isNull(sysUserRequest.getPassword())){
			throw new YxBizException("原密码不能为空");
		}
		if(Util.isNull(sysUserRequest.getNew_pwd())){
			throw new YxBizException("新密码不能为空");
		}
		if(!sysUser.getUser_pwd().equals(Util.md5(sysUserRequest.getPassword()))){
			throw new YxBizException("原密码输入错误");
		}
	   /// SysUser destUser=sysUserDAO.selectAll(map)(sysUser.getId());
	    sysUser.setUser_pwd(Util.md5(sysUserRequest.getNew_pwd())); 
	    Integer result=sysUserDAO.update(sysUser);
	    /**
		 * 更新redis 中的用户缓存
		 */
	    /**将token和用户信息写入redis和设置过期时间*/
		redisTemplate.opsForValue().set(APP_USER_TOKEN+":"+sysUserRequest.getToken(),sysUser);		
		redisTemplate.expire(APP_USER_TOKEN+":"+sysUserRequest.getToken(), SYS_USER_TOKEN_EXPIRE, TimeUnit.MINUTES);
		
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception {
		Integer result = sysUserDAO.deleteById(baseDeleteRequest.getId());
		Integer result1= sysUnionDAO.deleteByOid(baseDeleteRequest.getId());
		return (result>0&&result1>0)?true:false;
	}




	@Override
	public List<SysUser> selectAll(LoginRequest loginRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (Util.isNotNull(loginRequest.getTelphone())) {
			map.put("telphone", loginRequest.getTelphone());
		}
		if(Util.isNotNull(loginRequest.getUsername())){
			map.put("username", loginRequest.getUsername());
		}
		return sysUserDAO.selectAll(map);
	}
	
	@Override
	public List<SysUser> selectAll1(LoginRequest loginRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (Util.isNotNull(loginRequest.getTelphone())) {
			map.put("telphone", loginRequest.getTelphone());
		}
		if(Util.isNotNull(loginRequest.getUsername())){
			map.put("username", loginRequest.getUsername());
		}
		return sysUserDAO.selectAll1(map);
	}




	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean resetPassWord(BaseViewRequest baseViewRequest)
			throws Exception {
		SysUser suser= new SysUser();
		suser.setId(baseViewRequest.getId());
		suser.setUser_pwd(Util.md5("888888"));
		Integer result=sysUserDAO.update(suser);
		return result>0?true:false;
	}




	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateforyzm(SysUserRequest sysUserRequest) throws Exception {
		 	SysUser sysUser= sysUserRequest.getSysUser();	    
			Integer result = sysUserDAO.update(sysUser);
			return result>0?true:false;
	}

	/**
	 * 查用户详情
	 */
	public SysUserInfoResp getInfo(BaseViewRequest req) throws Exception {
		SysUser user = sysUserDAO.getById(req.getId());
		SysUserInfoResp info = sysUserDAO.getInfo(req.getId());
		info.setTelphone(user.getTelphone());
		info.setImage(user.getImage());
		return info;
	}

	/**
	 * 手机号码查用户
	 */
	public SysUser getUserByPhone(String telphone) throws Exception {
		SysUser user = sysUserDAO.getUserByPhone(telphone);
		return user;
	}

	/**
	 * app修改用户信息
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateUser(SysUserRequest req) throws Exception {
		SysUser sysUser = req.getSysUser();
		Integer result = sysUserDAO.update(sysUser);
		return result >0?true:false;
	}




    /**
     * 经纪人认证-审核人
     * @return
     */
	@Override
	public List<SysUser> examinePerson() throws Exception {
		return sysUserDAO.selectExaminePerson();
	}

}
