package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.SysConfig;

/**
 *	
 *  sys_configDao
 *  注释:参数配置表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("sysConfigDAO")
public interface SysConfigDAO{
	/**
	 * 获取参数配置表分页数据
	 */
	public List<SysConfig> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取参数配置表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询参数配置表
	 */
	public SysConfig getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改参数配置表
	 */
	public Integer update(SysConfig sysConfig) throws Exception;
	/**
	 * 添加参数配置表
	 */
	public Integer add(SysConfig sysConfig)throws Exception;
	/**
	 * 根据ID删除参数配置表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 查询所有配置参数
	 */
	public List<SysConfig> all() throws Exception;
}