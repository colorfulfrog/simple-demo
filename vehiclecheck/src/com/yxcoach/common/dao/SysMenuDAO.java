package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.SysMenu;

/**
 *	
 *  sys_menuDao
 *  注释:菜单表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@MyBatisDao
@Component("SysMenuDAO")
public interface SysMenuDAO{
	/**
	 * 获取菜单表分页数据
	 */
	public List<SysMenu> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取菜单表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询菜单表
	 */
	public SysMenu getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改菜单表
	 */
	public Integer update(SysMenu sysMenu) throws Exception;
	/**
	 * 添加菜单表
	 */
	public Integer add(SysMenu sysMenu)throws Exception;
	/**
	 * 根据ID删除菜单表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 查询角色菜单（一二级）
	 * @param map2018年3月26日10:38:57
	 * @return
	 */
	public List<SysMenu> selectRoleMemu(Map<String, Object> map);
	
	/**
	 * 获取所有数据
	 */
	public List<SysMenu> selectAll(Map<String,Object> map) throws Exception;
	
	/**
	 * 一级菜单包含的所有二级菜单
	 * @param map
	 * @return
	 */
	public List<SysMenu> selectMemuAll2(java.lang.Long id);
	
	/***
	 * 删除一级菜单时 对应的删除二级菜单
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public Integer deleteByPid(java.lang.Long pid) throws Exception;
	
	/**
	 * 查询所有的一级菜单
	 * 
	 * 
	 */
	public List<SysMenu> selectMemuAll();
	
}