package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_price
 *  注释:计价管理表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "SysPrice", description = "计价管理表")
public class SysPrice implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "车辆类型 1小型车 2中型车 3大型车 ")
	private java.lang.Integer car_type;
	
	@ApiModelProperty(value = "车辆年限 1-10 11：10年以上 ")
	private java.lang.Integer car_year;
	
	@ApiModelProperty(value = "车辆性质 1 载货 2载客 ")
	private java.lang.Integer car_category;
	
	@ApiModelProperty(value = "座位数 1小于5座 2 5-19座 3大于19座 ")
	private java.lang.Integer seat_num;
	
	@ApiModelProperty(value = "总质量 1 小于3.5T 2：3.5-6T 3 大于6T ")
	private java.lang.Integer weight;
	
	@ApiModelProperty(value = "是否需要等级评定 1 是 2 否 ")
	private java.lang.Integer is_need_appraise;
	
	@ApiModelProperty(value = "是否营运车辆 1是 0 否 ")
	private java.lang.Integer is_operate_car;
	
	@ApiModelProperty(value = "安检价格 ")
	private java.lang.Float check_price;
	
	@ApiModelProperty(value = "等级评定价格 ")
	private java.lang.Float level_price;
	
	@ApiModelProperty(value = "环检价格 ")
	private java.lang.Float all_round_price;
	
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
	public void setCar_type(java.lang.Integer car_type){
		this.car_type=car_type;
	}
	public java.lang.Integer getCar_type(){
		return this.car_type;
	}
	public void setCar_year(java.lang.Integer car_year){
		this.car_year=car_year;
	}
	public java.lang.Integer getCar_year(){
		return this.car_year;
	}
	public void setCar_category(java.lang.Integer car_category){
		this.car_category=car_category;
	}
	public java.lang.Integer getCar_category(){
		return this.car_category;
	}
	public void setSeat_num(java.lang.Integer seat_num){
		this.seat_num=seat_num;
	}
	public java.lang.Integer getSeat_num(){
		return this.seat_num;
	}
	public void setWeight(java.lang.Integer weight){
		this.weight=weight;
	}
	public java.lang.Integer getWeight(){
		return this.weight;
	}
	public void setIs_need_appraise(java.lang.Integer is_need_appraise){
		this.is_need_appraise=is_need_appraise;
	}
	public java.lang.Integer getIs_need_appraise(){
		return this.is_need_appraise;
	}
	public void setCheck_price(java.lang.Float check_price){
		this.check_price=check_price;
	}
	public java.lang.Float getCheck_price(){
		return this.check_price;
	}
	public void setLevel_price(java.lang.Float level_price){
		this.level_price=level_price;
	}
	public java.lang.Float getLevel_price(){
		return this.level_price;
	}
	public void setAll_round_price(java.lang.Float all_round_price){
		this.all_round_price=all_round_price;
	}
	public java.lang.Float getAll_round_price(){
		return this.all_round_price;
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
	public java.lang.Integer getIs_operate_car() {
		return is_operate_car;
	}
	public void setIs_operate_car(java.lang.Integer is_operate_car) {
		this.is_operate_car = is_operate_car;
	}
}
