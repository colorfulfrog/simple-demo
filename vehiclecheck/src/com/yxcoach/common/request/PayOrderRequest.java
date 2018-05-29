package com.yxcoach.common.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by alan on 18/04/08.
 */
@ApiModel(value = "PayOrderRequest", description = "订单支付rquest对象")
public class PayOrderRequest extends BaseRequest {

	private String body;//对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body
	private String subject;//商品的标题/交易标题/订单标题/订单关键字等
	private BigDecimal totalAmount;//订单总金额
	private String productCode;//销售产品码，商家和支付宝签约的产品码
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
    
    
}
