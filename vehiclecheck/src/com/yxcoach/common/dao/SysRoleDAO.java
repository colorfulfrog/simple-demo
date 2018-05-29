package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.SysRole;

/**
 *	
 *  sys_roleDao
 *  注释:角色表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@MyBatisDao
@Component("SysRoleDAO")
public interface SysRoleDAO{
	/**
	 * 获取角色表分页数据
	 */
	public List<SysRole> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取角色表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询角色表
	 */
	public SysRole getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改角色表
	 */
	public Integer update(SysRole sysRole) throws Exception;
	/**
	 * 添加角色表
	 */
	public Integer add(SysRole sysRole)throws Exception;
	/**
	 * 根据ID删除角色表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 获取所有数据
	 */
	public List<SysRole> selectAll() throws Exception;
	
	/**
	 *  根据角色查询权限
	 */
	public List<Map<String,Integer>>  selecPersion(Map<String,String> map) throws Exception;
	
	/**
	 * 根据条件进行分页的数据
	 * （角色权限）
	 */
	
	public List<SysRole> selectPage2(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取分页数据数量
	 * （角色权限）
	 */
	public Integer selectPageCount2(Map<String,Object> map) throws Exception;
	
}