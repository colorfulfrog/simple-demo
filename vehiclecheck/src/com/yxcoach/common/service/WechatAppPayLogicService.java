package com.yxcoach.common.service;

import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;

import com.yxcoach.common.base.pay.wechat.utils.HttpResult;
import com.yxcoach.common.base.pay.wechat.utils.RestResult;

/**
 *  WeixinAppPayLogicService
 *  注释:订单表Service
 *  创建人: Tim
 *  创建日期:2018-04-02
 */
public interface WechatAppPayLogicService {
	
	/**
	 * 微信支付 统一下订单入口
	 * @param userId
	 * @param proId
	 * @param ip
	 * @param price
	 * @return
	 */
	RestResult unifiedOrder(String userId, String proId, String ip, int price);

	/**
	 * 微信回调
	 * @param request
	 * @return
	 */
	String callback(HttpServletRequest request);

	/**
	 * 查询订单接口
	 * @param params
	 * @return
	 */
	HttpResult<String> checkOrderStatus(SortedMap<String, Object> params);
	

}
