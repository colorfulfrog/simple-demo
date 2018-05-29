package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.SysUnion;

/**
 *	
 *  sys_unionDao
 *  注释:角色权限表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-26
 */
@MyBatisDao
@Component("sysUnionDAO")
public interface SysUnionDAO{
	/**
	 * 获取角色权限表分页数据
	 */
	public List<SysUnion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取角色权限表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询角色权限表
	 */
	public SysUnion getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改角色权限表
	 */
	public Integer update(SysUnion sysUnion) throws Exception;
	/**
	 * 添加角色权限表
	 */
	public Integer add(SysUnion sysUnion)throws Exception;
	/**
	 * 根据ID删除角色权限表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/***
	 * 根据角色id查询权限
	 * @param rid
	 * @return
	 * @throws Exception
	 */
	public List<SysUnion> selectByRid(Map<String,Object> map) throws Exception;
	
	/***
	 * 删除角色ID 查出菜单和权限
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer deleteByRidType(Map<String,Object> map) throws Exception;
	
	/**
	 * 删除角色
	 */
	public Integer deleteByOid(java.lang.Long oid) throws Exception;
	
	/***
	 * 查询用户角色
	 * @param sysUnion
	 * @return
	 * @throws Exception
	 */
	public SysUnion selectUserRoles(SysUnion sysUnion) throws Exception;
	
	/***
	 * 根据用户id查角色id
	 * @param rid
	 * @return
	 * @throws Exception
	 */
	public SysUnion getByOid(Map<String,Object> map) throws Exception;
	
}