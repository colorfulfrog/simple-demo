package com.yxcoach.common.service;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.request.SysRoleRequest;
import com.yxcoach.common.request.SysRoleQueryRequest;
/**
 *  SysRoleService
 *  注释:角色表Service
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
public interface SysRoleService {
	
	/***
	 * 角色表列表分页
	 * @param sysRoleRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysRoleQueryRequest sysRoleQueryRequest) throws Exception;
	
	/***
	 * 查询角色表
	 * @param sysRoleRequest
	 * @return
	 * @throws Exception
	 */
    public SysRole get(BaseViewRequest baseViewRequest) throws Exception;
    
    /***
     * 角色表添加
     * @param sysRoleRequest
     * @return
     * @throws Exception
     */
    public boolean add(SysRoleRequest sysRoleRequest) throws Exception;
    
    /***
     * 角色表修改
     * @param sysRoleRequest
     * @return
     * @throws Exception
     */
    public boolean update(SysRoleRequest sysRoleRequest) throws Exception;
	/***
	 * 删除角色表
	 * @param sysRoleRequest
	 * @return
	 * @throws Exception
	 */
    public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception;
    
    /**
  	 * 获取所有数据 2018年3月26日10:38:27
  	 */
  	public List<SysRole> selectAll() throws Exception; 
  	
  	/**
	 * 根据角色查询权限
	 * @param map 2018年3月26日10:38:31
	 * @return
	 * @throws Exception
	 */
    public List<Map<String,Integer>>  selecPersion(Map<String,String> map) throws Exception;

}
