package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.request.SysUserQueryRequest;
import com.yxcoach.common.request.SysUserRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.response.SysUserInfoResp;
/**
 *  SysUserService
 *  注释:用户表Service
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
public interface SysUserService {
	
	/***
	 * 用户表列表分页
	 * @param sysUserRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysUserQueryRequest sysUserQueryRequest) throws Exception;
	
	/***
	 * 查询用户表
	 * @param sysUserRequest
	 * @return
	 * @throws Exception
	 */
    public SysUser get(BaseViewRequest baseViewRequest) throws Exception;
    
    /***
     * 用户表添加
     * @param sysUserRequest
     * @return
     * @throws Exception
     */
    public boolean add(SysUserRequest sysUserRequest) throws Exception;
    
    /***
     * 用户表修改
     * @param sysUserRequest
     * @return
     * @throws Exception
     */
    public boolean update(SysUserRequest sysUserRequest) throws Exception;
	/***
	 * 删除用户表
	 * @param sysUserRequest
	 * @return
	 * @throws Exception
	 */
    public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception;
    
    /***
     * 
     * @param loginRequest
     * @return
     * @throws Exception
     */
 	public List<SysUser> selectAll(LoginRequest loginRequest) throws Exception;
 	
 	/***
     * 
     * @param loginRequest
     * @return
     * @throws Exception
     */
 	public List<SysUser> selectAll1(LoginRequest loginRequest) throws Exception;
 	
 	/**
	 * 重置密码
	 * @param bsUserRequest
	 * @return
	 * @throws Exception
	 */
	public boolean resetPassWord(BaseViewRequest baseViewRequest) throws Exception;

	/**
	 * 更换手机号码
	 * @param sysUserRequest
	 * @return
	 * @throws Exception
	 */
	public boolean changeMobile(SysUserRequest sysUserRequest) throws Exception;
	
	 /***
     * 用户表修改
     * @param sysUserRequest
     * @return
     * @throws Exception
     */
    public boolean updateforyzm(SysUserRequest sysUserRequest) throws Exception;

	/**
	 * 修改密码
	 * @param sysUserRequest
	 * @return
	 * @throws Exception
	 */
	public boolean updatePwd(SysUserRequest sysUserRequest) throws Exception;
	
	/***
	 * 查询用户
	 * @param sysUserRequest
	 * @return
	 * @throws Exception
	 */
    public SysUserInfoResp getInfo(BaseViewRequest baseViewRequest) throws Exception;
    
	/**
	 * 手机号码查用户
	 * @param telphone
	 * @return
	 * @throws Exception
	 */
    public SysUser getUserByPhone(String telphone) throws Exception;
    
    /***
     * app修改用户信息
     * @param sysUserRequest
     * @return
     * @throws Exception
     */
    public boolean updateUser(SysUserRequest sysUserRequest) throws Exception;

    /**
     * 经纪人认证-审核人
     * @return
     */
	public List<SysUser> examinePerson() throws Exception;

}
