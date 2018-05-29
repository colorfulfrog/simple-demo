package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_discount
 *  注释:预约折扣表
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "SysDiscount", description = "预约折扣表")
public class SysDiscount implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "提前预约安检天数 ")
	private java.lang.Integer pre_order_days;
	
	@ApiModelProperty(value = "折扣系数 ")
	private java.lang.Float discount;
	
	@ApiModelProperty(value = "有效期开始时间 ")
	private java.sql.Timestamp start_date;
	
	@ApiModelProperty(value = "有效期结束时间 ")
	private java.sql.Timestamp end_date;
	
	@ApiModelProperty(value = "状态 1启动 0停用 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_user;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setPre_order_days(java.lang.Integer pre_order_days){
		this.pre_order_days=pre_order_days;
	}
	public java.lang.Integer getPre_order_days(){
		return this.pre_order_days;
	}
	public void setDiscount(java.lang.Float discount){
		this.discount=discount;
	}
	public java.lang.Float getDiscount(){
		return this.discount;
	}
	public void setStart_date(java.sql.Timestamp start_date){
		this.start_date=start_date;
	}
	public java.sql.Timestamp getStart_date(){
		return this.start_date;
	}
	public void setEnd_date(java.sql.Timestamp end_date){
		this.end_date=end_date;
	}
	public java.sql.Timestamp getEnd_date(){
		return this.end_date;
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
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setGmt_modify(java.sql.Timestamp gmt_modify){
		this.gmt_modify=gmt_modify;
	}
	public java.sql.Timestamp getGmt_modify(){
		return this.gmt_modify;
	}
	public void setUpdate_user(java.lang.Long update_user){
		this.update_user=update_user;
	}
	public java.lang.Long getUpdate_user(){
		return this.update_user;
	}
}
