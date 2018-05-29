package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yxcoach.common.base.annotation.MyBatisDao;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.response.SysUserImgPhoneResp;
import com.yxcoach.common.response.SysUserInfoResp;

/**
 *	
 *  sys_userDao
 *  注释:用户表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@MyBatisDao
@Component("sysUserDAO")
public interface SysUserDAO{
	/**
	 * 获取用户表分页数据
	 */
	public List<SysUser> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取用户表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询用户表
	 */
	public SysUser getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改用户表
	 */
	public Integer update(SysUser sysUser) throws Exception;
	/**
	 * 添加用户表
	 */
	public Integer add(SysUser sysUser)throws Exception;
	/**
	 * 根据ID删除用户表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 获取所有数据
	 */
	public List<SysUser> selectAll(Map<String,Object> map) throws Exception;
	
	/**
	 * 重复验证
	 * @param param
	 * @return
	 */
	public SysUser checkExist(Map param) throws Exception;
	

	/**
	 * 获取所有数据
	 */
	public List<SysUser> selectAll1(Map<String,Object> map) throws Exception;
	
	public SysUser checkExist1(Map param) throws Exception;
	
	/**
	 * 根据ID查询用户
	 */
	public SysUserInfoResp getInfo(java.lang.Long id) throws Exception;
	
	/**
	 * 获取好友列表分页数据
	 */
	public List<SysUser> friendPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取好友列表分页数据条数
	 */
	public Integer friendPageCount(Map<String,Object> map) throws Exception;
	
	/**
	 * 根据类型查我的好友
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysUserImgPhoneResp> getMyFriend(Long id)throws Exception;
	
	/**
	 * 根据类型查我的申请
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysUserImgPhoneResp> getMyApply(Long id)throws Exception;
	
	
	/**
	 * 根据类型查我的新朋友
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysUserImgPhoneResp> getMyNewFriend(Long id)throws Exception;
	
	/**
	 * 手机号码查用户
	 * @param telphone
	 * @return
	 * @throws Exception
	 */
    public SysUser getUserByPhone(String telphone) throws Exception;
    
    /**
     * 经纪人认证-审核人
     * @return
     */
	public List<SysUser> selectExaminePerson() throws Exception;
	
}