package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.BsWithdrawCashBill;
import com.yxcoach.common.request.BsWithdrawCashBillQueryRequest;
/**
 *  BsWithdrawCashBillService
 *  注释:提现记录表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface BsWithdrawCashBillService {
	
	/***
	 * 提现记录表列表分页
	 * @param bsWithdrawCashBillRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsWithdrawCashBillQueryRequest bsWithdrawCashBillQueryRequest) throws Exception;
	
	/***
	 * 查询提现记录表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsWithdrawCashBill get(Long id) throws Exception;
    
    /***
     * 提现记录表添加
     * @param bsWithdrawCashBill
     * @return
     * @throws Exception
     */
    public boolean add(BsWithdrawCashBill bsWithdrawCashBill) throws Exception;
    
    /***
     * 提现记录表修改
     * @param bsWithdrawCashBill
     * @return
     * @throws Exception
     */
    public boolean update(BsWithdrawCashBill bsWithdrawCashBill) throws Exception;
	/***
	 * 删除提现记录表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
