package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.SysPrice;

/**
 *	
 *  sys_priceDao
 *  注释:计价管理表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("sysPriceDAO")
public interface SysPriceDAO{
	/**
	 * 获取计价管理表分页数据
	 */
	public List<SysPrice> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取计价管理表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询计价管理表
	 */
	public SysPrice getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改计价管理表
	 */
	public Integer update(SysPrice sysPrice) throws Exception;
	/**
	 * 添加计价管理表
	 */
	public Integer add(SysPrice sysPrice)throws Exception;
	/**
	 * 根据ID删除计价管理表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 条件查询
	 */
	public SysPrice getByCon(SysPrice sysPrice) throws Exception;
}