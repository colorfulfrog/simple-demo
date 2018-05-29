package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "WechatPayOrderRequest", description = "APP微信支付对象")
public class WechatPayOrderRequest extends BaseRequest{
	
	private String ip;
	
	private String authorization;
	
	private String proId;// 商品id
	
	private int price;//支付money

	private String outTradeNo;
	
	private String transactionId;
	
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
