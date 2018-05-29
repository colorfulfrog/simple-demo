package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.request.SysMenuRequest;
import com.yxcoach.common.request.SysMenuQueryRequest;
/**
 *  SysMenuService
 *  注释:菜单表Service
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
public interface SysMenuService {
	
	/***
	 * 菜单表列表分页
	 * @param sysMenuRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysMenuQueryRequest sysMenuQueryRequest) throws Exception;
	
	/***
	 * 查询菜单表
	 * @param sysMenuRequest
	 * @return
	 * @throws Exception
	 */
    public SysMenu get(BaseViewRequest baseViewRequest) throws Exception;
    
    /***
     * 菜单表添加
     * @param sysMenuRequest
     * @return
     * @throws Exception
     */
    public boolean add(SysMenuRequest sysMenuRequest) throws Exception;
    
    /***
     * 菜单表修改
     * @param sysMenuRequest
     * @return
     * @throws Exception
     */
    public boolean update(SysMenuRequest sysMenuRequest) throws Exception;
	/***
	 * 删除菜单表
	 * @param sysMenuRequest
	 * @return
	 * @throws Exception
	 */
    public boolean delete(BaseDeleteRequest baseDeleteRequest) throws Exception;
    
    /**
	 * 重置角色菜单权限等redis缓存
	 * @throws Exception
	 */
	public void resetRoleMenu() throws Exception;
	
	/**
	 * 获取所有数据
	 */
	public List<SysMenu> selectAll(SysMenuQueryRequest queryRequest)
			throws Exception;

}
