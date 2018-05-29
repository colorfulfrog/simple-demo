package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.BsOrder;

/**
 *	
 *  bs_orderDao
 *  注释:订单表
 *  创建人: liwei
 *  创建日期:2018-05-10
 */
@MyBatisDao
@Component("bsOrderDAO")
public interface BsOrderDAO{
	/**
	 * 获取订单表分页数据
	 */
	public List<BsOrder> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取订单表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询订单表
	 */
	public BsOrder getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改订单表
	 */
	public Integer update(BsOrder bsOrder) throws Exception;
	/**
	 * 添加订单表
	 */
	public Integer add(BsOrder bsOrder)throws Exception;
	/**
	 * 根据ID删除订单表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 账务流水分页    获取订单表分页数据条数
	 */
	public Integer selectflowPageCount(Map<String, Object> map);
	/**
	 *  账务流水分页  获取订单表分页数据
	 */
	public List<BsOrder> selectflowPage(Map<String, Object> map);
	
	
	/**
	 * 退款单分页     获取订单表分页数据
	 */
	public Integer selectRefundPageCount(Map<String, Object> map);
	
	/**
	 * 退款单分页    获取订单表分页数据条数
	 */
	public List<BsOrder> selectRefundPage(Map<String, Object> map); 
	
	/**
	 * 获取后台订单表分页数据
	 */
	public List<BsOrder> selectBackstagePage(Map<String,Object> map) throws Exception;
	/**
	 * 获取后台订单表分页数据条数
	 */
	public Integer selectBackstagePageCount(Map<String,Object> map) throws Exception;
	
	/**
	 * 订单查询后台 修改 /取消 / 上传检测结果  /开始检测 / 确认收款
	 */
	public Integer updateOperation(BsOrder bsOrder) throws Exception;
	
}