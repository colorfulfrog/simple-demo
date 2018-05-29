package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_coupon
 *  注释:优惠券表
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "BsCoupon", description = "优惠券表")
public class BsCoupon implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = " ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "优惠券类型ID ")
	private java.lang.Long coupon_type_id;
	
	@ApiModelProperty(value = "优惠券码 长度(64)")
	private java.lang.String coupon_code;
	
	@ApiModelProperty(value = "活动ID ")
	private java.lang.Long activity_Id;
	
	@ApiModelProperty(value = "会员ID ")
	private java.lang.Long member_id;
	
	
	@ApiModelProperty(value = "领取时间")
	private java.sql.Timestamp receive_date;
	
	@ApiModelProperty(value = "使用时间 ")
	private java.lang.Long use_date;
	
	@ApiModelProperty(value = "状态 1正常 2过期 3停用 4未领取 5未使用 6已使用 ")
	private java.lang.Long status;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setCoupon_type_id(java.lang.Long coupon_type_id){
		this.coupon_type_id=coupon_type_id;
	}
	public java.lang.Long getCoupon_type_id(){
		return this.coupon_type_id;
	}
	public void setCoupon_code(java.lang.String coupon_code){
		this.coupon_code=coupon_code;
	}
	public java.lang.String getCoupon_code(){
		return this.coupon_code;
	}
	public void setActivity_Id(java.lang.Long activity_Id){
		this.activity_Id=activity_Id;
	}
	public java.lang.Long getActivity_Id(){
		return this.activity_Id;
	}
	public void setMember_id(java.lang.Long member_id){
		this.member_id=member_id;
	}
	public java.lang.Long getMember_id(){
		return this.member_id;
	}
	public java.sql.Timestamp getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(java.sql.Timestamp receive_date) {
		this.receive_date = receive_date;
	}
	public java.lang.Long getUse_date() {
		return use_date;
	}
	public void setUse_date(java.lang.Long use_date) {
		this.use_date = use_date;
	}
	public java.lang.Long getStatus() {
		return status;
	}
	public void setStatus(java.lang.Long status) {
		this.status = status;
	}
}
