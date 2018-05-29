package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.response.SysPersion_Resp;

/**
 *	
 *  sys_persionDao
 *  注释:权限表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@MyBatisDao
@Component("SysPersionDAO")
public interface SysPersionDAO{
	/**
	 * 获取权限表分页数据
	 */
	public List<SysPersion> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取权限表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询权限表
	 */
	public SysPersion getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改权限表
	 */
	public Integer update(SysPersion sysPersion) throws Exception;
	/**
	 * 添加权限表
	 */
	public Integer add(SysPersion sysPersion)throws Exception;
	/**
	 * 根据ID删除权限表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/***
	 * 根据菜单编号删除权限
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	public Integer deleteByMId(java.lang.Long mid) throws Exception;
	
	/**
	 * 权限管理分页查询
	 * @param id
	 * @return
	 */
	public List<SysPersion_Resp> SysPersionselectPage(java.lang.Long id);
	
	public List<SysPersion> selectByMenuId(Integer id);
	
}