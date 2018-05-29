package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 * 
 * 注释:优惠券表 rquest对象 创建人: liwei 创建日期:2018-05-15
 */
@ApiModel(value = "BsCouponQueryRequest", description = "优惠券表 rquest分页查询对象")
public class BsCouponQueryRequest extends BaseQueryRequest {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "优惠券类型ID ")
	private java.lang.Long coupon_type_id;
	@ApiModelProperty(value = "会员手机号")
	private java.lang.String telphone;
	@ApiModelProperty(value = "优惠券码")
	private java.lang.String coupon_code;
	@ApiModelProperty(value = "明细状态")
	private java.lang.String status;
	public java.lang.Long getCoupon_type_id() {
		return coupon_type_id;
	}
	public void setCoupon_type_id(java.lang.Long coupon_type_id) {
		this.coupon_type_id = coupon_type_id;
	}
	public java.lang.String getTelphone() {
		return telphone;
	}
	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}
	public java.lang.String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(java.lang.String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
}
