package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_config
 *  注释:参数配置表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "SysConfig", description = "参数配置表")
public class SysConfig implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "经纪人分成 ")
	private java.lang.Float broker_commission;
	
	@ApiModelProperty(value = "车主分成 ")
	private java.lang.Float car_owner_commission;
	
	@ApiModelProperty(value = "退款手续费 ")
	private java.lang.Float refund_fee;
	
	@ApiModelProperty(value = "提现手续费 ")
	private java.lang.Float withdraw_cash_fee;
	
	@ApiModelProperty(value = "支付有效期（分钟） ")
	private java.lang.Integer payment_expire;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_user;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setBroker_commission(java.lang.Float broker_commission){
		this.broker_commission=broker_commission;
	}
	public java.lang.Float getBroker_commission(){
		return this.broker_commission;
	}
	public void setCar_owner_commission(java.lang.Float car_owner_commission){
		this.car_owner_commission=car_owner_commission;
	}
	public java.lang.Float getCar_owner_commission(){
		return this.car_owner_commission;
	}
	public void setRefund_fee(java.lang.Float refund_fee){
		this.refund_fee=refund_fee;
	}
	public java.lang.Float getRefund_fee(){
		return this.refund_fee;
	}
	public void setWithdraw_cash_fee(java.lang.Float withdraw_cash_fee){
		this.withdraw_cash_fee=withdraw_cash_fee;
	}
	public java.lang.Float getWithdraw_cash_fee(){
		return this.withdraw_cash_fee;
	}
	public void setPayment_expire(java.lang.Integer payment_expire){
		this.payment_expire=payment_expire;
	}
	public java.lang.Integer getPayment_expire(){
		return this.payment_expire;
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
	public void setUpdate_user(java.lang.Long update_user){
		this.update_user=update_user;
	}
	public java.lang.Long getUpdate_user(){
		return this.update_user;
	}
}
