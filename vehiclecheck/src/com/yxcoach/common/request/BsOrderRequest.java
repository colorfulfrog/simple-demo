package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsOrder;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:订单表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-10
 */
@ApiModel(value = "BsOrderRequest", description = "订单表 rquest对象")
public class BsOrderRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "订单表对象")
	private BsOrder bsOrder;
	
	@ApiModelProperty(value = "验证码")
	private String verification_code;
	
	@ApiModelProperty(value = "车辆ID")
	private Long car_id;
	
	@ApiModelProperty(value = "预约日期 ")
	private java.sql.Timestamp order_date;
	
	@ApiModelProperty(value = "订单ID")
	private Long order_id;
	
	@ApiModelProperty(value = "退款类型 1在线退款 2窗口退款 ")
	private java.lang.Integer refund_type;
	
	public void setBsOrder(BsOrder bsOrder){
		this.bsOrder=bsOrder;
	}
	public BsOrder getBsOrder(){
		return this.bsOrder;
	}
	public String getVerification_code() {
		return verification_code;
	}
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
	public Long getCar_id() {
		return car_id;
	}
	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}
	public java.sql.Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(java.sql.Timestamp order_date) {
		this.order_date = order_date;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public java.lang.Integer getRefund_type() {
		return refund_type;
	}
	public void setRefund_type(java.lang.Integer refund_type) {
		this.refund_type = refund_type;
	}	
}
