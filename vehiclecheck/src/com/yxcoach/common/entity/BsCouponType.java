package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_coupon_type
 *  注释:优惠券类型表
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "BsCouponType", description = "优惠券类型表")
public class BsCouponType implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "主键 自增长 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "优惠券名称 长度(30) 必填")
	private java.lang.String coupon_name;
	
	@ApiModelProperty(value = "优惠券类型 1 代金券 2折扣券 ")
	private java.lang.Integer type;
	
	@ApiModelProperty(value = "优惠券额度 ")
	private java.lang.Float coupon_limit;
	
	@ApiModelProperty(value = "优惠折扣 type=2时赋值 ")
	private java.lang.Float discount;
	
	@ApiModelProperty(value = "有效期开始时间 ")
	private java.sql.Timestamp start_time;
	
	@ApiModelProperty(value = "有效期结束时间 ")
	private java.sql.Timestamp end_time;
	
	@ApiModelProperty(value = "发放数量 ")
	private java.lang.Long num;
	
	@ApiModelProperty(value = "使用上限金额 ")
	private java.lang.Long use_limit;
	
	@ApiModelProperty(value = "使用范围 1车检 ")
	private java.lang.Integer scope;
	
	@ApiModelProperty(value = "自动发放条件 1被邀请注册 2新用户 3支付 4评价 ")
	private java.lang.Integer gift_condition;
	
	@ApiModelProperty(value = "状态 1正常 2过期 3停用 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long modify_user;
	
	@ApiModelProperty(value = "版本号 ")
	private java.lang.Long vision;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setCoupon_name(java.lang.String coupon_name){
		this.coupon_name=coupon_name;
	}
	public java.lang.String getCoupon_name(){
		return this.coupon_name;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setCoupon_limit(java.lang.Float coupon_limit){
		this.coupon_limit=coupon_limit;
	}
	public java.lang.Float getCoupon_limit(){
		return this.coupon_limit;
	}
	public void setDiscount(java.lang.Float discount){
		this.discount=discount;
	}
	public java.lang.Float getDiscount(){
		return this.discount;
	}
	public void setStart_time(java.sql.Timestamp start_time){
		this.start_time=start_time;
	}
	public java.sql.Timestamp getStart_time(){
		return this.start_time;
	}
	public void setEnd_time(java.sql.Timestamp end_time){
		this.end_time=end_time;
	}
	public java.sql.Timestamp getEnd_time(){
		return this.end_time;
	}
	public void setNum(java.lang.Long num){
		this.num=num;
	}
	public java.lang.Long getNum(){
		return this.num;
	}
	public void setUse_limit(java.lang.Long use_limit){
		this.use_limit=use_limit;
	}
	public java.lang.Long getUse_limit(){
		return this.use_limit;
	}
	public void setScope(java.lang.Integer scope){
		this.scope=scope;
	}
	public java.lang.Integer getScope(){
		return this.scope;
	}
	public void setGift_condition(java.lang.Integer gift_condition){
		this.gift_condition=gift_condition;
	}
	public java.lang.Integer getGift_condition(){
		return this.gift_condition;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setGmt_create(java.sql.Timestamp gmt_create){
		this.gmt_create=gmt_create;
	}
	public java.sql.Timestamp getGmt_create(){
		return this.gmt_create;
	}
	public void setGmt_modify(java.sql.Timestamp gmt_modify){
		this.gmt_modify=gmt_modify;
	}
	public java.sql.Timestamp getGmt_modify(){
		return this.gmt_modify;
	}
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setModify_user(java.lang.Long modify_user){
		this.modify_user=modify_user;
	}
	public java.lang.Long getModify_user(){
		return this.modify_user;
	}
	public void setVision(java.lang.Long vision){
		this.vision=vision;
	}
	public java.lang.Long getVision(){
		return this.vision;
	}
}
