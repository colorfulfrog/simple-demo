package com.yxcoach.common.service;

import java.sql.Timestamp;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsOrder;
import com.yxcoach.common.request.BsOrderQueryRequest;
/**
 *  BsOrderService
 *  注释:订单表Service
 *  创建人: liwei
 *  创建日期:2018-05-10
 */
public interface BsOrderService {
	
	/***
	 * 订单表列表分页
	 * @param bsOrderRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception;
	
	/***
	 * 查询订单表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsOrder get(Long id) throws Exception;
    
    /***
     * 订单表添加
     * @param bsOrder
     * @return
     * @throws Exception
     */
    public BsOrder add(BsOrder bsOrder) throws Exception;
    
    /***
     * 订单表修改
     * @param bsOrder
     * @return
     * @throws Exception
     */
    public boolean update(BsOrder bsOrder) throws Exception;
	/***
	 * 删除订单表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /**
     * 账务流水 分页
     * @param bsOrderQueryRequest
     * @return
     * @throws Exception
     */
	public PageInfo accountflowPage(BsOrderQueryRequest bsOrderQueryRequest)
			throws Exception;

	/**
	 * 退款单分页
	 * @param bsOrderQueryRequest
	 * @return
	 * @throws Exception
	 */
	public PageInfo refundPage(BsOrderQueryRequest bsOrderQueryRequest)
			throws Exception;
	/**
     * 预算全部费用
     * @param order_date 预约车检日期
     * @param car_id 车辆ID
     * @param isDiscount 是否计算折扣
     * @return
     */
	public Map<String,Object> budget(Long car_id,Timestamp order_date,boolean isDiscount) throws Exception;
	
	/**
	 * 窗口付款
	 * @param order_id 订单ID
	 * @return
	 * @throws Exception
	 */
	public JSONObject payOffline(Long order_id) throws Exception;

	/**
	 * 取消订单
	 * @param order_id 订单ID
	 * @return
	 */
	public boolean cancel(Long order_id) throws Exception;

	/**
	 * 订单详情
	 * @param order_id 订单ID
	 * @return
	 * @throws Exception
	 */
	public JSONObject detail(Long order_id) throws Exception;

	/**
	 * 申请退款
	 * @param order_id 订单ID
	 * @param refund_type 退款类型 1在线退款 2线下打款
	 * @return
	 * @throws Exception
	 */
	public boolean applyRefund(Long order_id, Integer refund_type) throws Exception;
	
	/***
	 * 订单表后台列表分页
	 * @param bsOrderRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectBackstagePage(BsOrderQueryRequest bsOrderQueryRequest) throws Exception;
	
	
    /***
     * 订单查询后台 修改 /取消 / 上传检测结果  /开始检测 / 确认收款
     * @param bsOrder
     * @return
     * @throws Exception
     */
    public boolean updateOperation(BsOrder bsOrder) throws Exception;
}
