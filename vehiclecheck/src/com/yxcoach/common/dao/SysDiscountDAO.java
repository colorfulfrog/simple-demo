package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.SysDiscount;

/**
 *	
 *  sys_discountDao
 *  注释:预约折扣表
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@MyBatisDao
@Component("sysDiscountDAO")
public interface SysDiscountDAO{
	/**
	 * 获取预约折扣表分页数据
	 */
	public List<SysDiscount> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取预约折扣表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询预约折扣表
	 */
	public SysDiscount getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改预约折扣表
	 */
	public Integer update(SysDiscount sysDiscount) throws Exception;
	/**
	 * 添加预约折扣表
	 */
	public Integer add(SysDiscount sysDiscount)throws Exception;
	/**
	 * 根据ID删除预约折扣表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	public List<SysDiscount> getAllDiscounts();
}