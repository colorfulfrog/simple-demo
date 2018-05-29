package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsWithdrawCashBill;

/**
 *	
 *  bs_withdraw_cash_billDao
 *  注释:提现记录表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsWithdrawCashBillDAO")
public interface BsWithdrawCashBillDAO{
	/**
	 * 获取提现记录表分页数据
	 */
	public List<BsWithdrawCashBill> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取提现记录表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询提现记录表
	 */
	public BsWithdrawCashBill getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改提现记录表
	 */
	public Integer update(BsWithdrawCashBill bsWithdrawCashBill) throws Exception;
	/**
	 * 添加提现记录表
	 */
	public Integer add(BsWithdrawCashBill bsWithdrawCashBill)throws Exception;
	/**
	 * 根据ID删除提现记录表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
}