package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMenuPersionRequest;
import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.request.SysPersionRequest;
import com.yxcoach.common.request.SysPersionQueryRequest;
import com.yxcoach.common.response.SysPersionParent_resp;
/**
 *  SysPersionService
 *  注释:权限表Service
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
public interface SysPersionService {
	
	/***
	 * 权限表列表分页
	 * @param sysPersionRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysPersionQueryRequest sysPersionQueryRequest) throws Exception;
	
	/***
	 * 查询权限表
	 * @param sysPersionRequest
	 * @return
	 * @throws Exception
	 */
    public SysPersion get(BaseViewRequest baseViewRequest) throws Exception;
    
    /***
     * 权限表添加
     * @param sysPersionRequest
     * @return
     * @throws Exception
     */
    public boolean add(SysPersionRequest sysPersionRequest) throws Exception;
    
    /***
     * 权限表修改
     * @param sysPersionRequest
     * @return
     * @throws Exception
     */
    public boolean update(SysPersionRequest sysPersionRequest) throws Exception;
	/***
	 * 删除权限表
	 * @param sysPersionRequest
	 * @return
	 * @throws Exception
	 */
    public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception;
    
    /**
	 * 新增用户给予权限的初始化接口
	 * 
	 */
	 public List<SysPersionParent_resp> selectmenuAll(java.lang.Long rid)throws Exception;
	 
	 public boolean uninoAdd(SysMenuPersionRequest sysMenuPersionRequest) throws Exception;
	 
	/**
	 * 根据菜单id查询菜单权限列表
	 * 
	 * @param sysPersionQueryRequest
	 * @return
	 */
	public List<SysPersion> listForMenu(
			SysPersionQueryRequest sysPersionQueryRequest);

}
