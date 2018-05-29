package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.annotation.Extend;

/**
 *	
 *  表名:bs_car
 *  注释:车辆表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCar", description = "车辆表")
public class BsCar implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "车牌号 长度(20) 必填")
	private java.lang.String car_number;
	
	@ApiModelProperty(value = "车辆注册日期 ")
	private java.sql.Timestamp regist_date;
	
	@ApiModelProperty(value = "车辆座位数 ")
	private java.lang.Integer seat_num;
	
	@ApiModelProperty(value = "总质量 ")
	private java.lang.Float weight;
	
	@ApiModelProperty(value = "是否有道路运输证 1:有 0：没有 ")
	private java.lang.Integer is_operate_car;
	
	@ApiModelProperty(value = "是否需要等级评定 1 是 2 否 ")
	private java.lang.Integer is_need_appraise;
	
	@ApiModelProperty(value = "车辆性质 1 载货 2载客 ")
	private java.lang.Integer car_category;
	
	@ApiModelProperty(value = "车架号 长度(30)")
	private java.lang.String frame_num;
	
	@ApiModelProperty(value = "发动机号 长度(30)")
	private java.lang.String engine_num;
	
	@ApiModelProperty(value = "车型 1 小型，2 中型，3 大型 ")
	private java.lang.Integer type;
	
	@ApiModelProperty(value = "所属车主 ")
	private java.lang.Long owner;
	
	@ApiModelProperty(value = "审核状态 1 待审核 2 审核通过 3 审核不通过 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "下次检测日期")
	private java.sql.Timestamp next_check_date;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "所属车主姓名 ")
	private java.lang.String owner_name;
	
	//扩展字段
	@Extend("所属车主联系电话")
	private java.lang.String telphone;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setCar_number(java.lang.String car_number){
		this.car_number=car_number;
	}
	public java.lang.String getCar_number(){
		return this.car_number;
	}
	public void setRegist_date(java.sql.Timestamp regist_date){
		this.regist_date=regist_date;
	}
	public java.sql.Timestamp getRegist_date(){
		return this.regist_date;
	}
	public void setSeat_num(java.lang.Integer seat_num){
		this.seat_num=seat_num;
	}
	public java.lang.Integer getSeat_num(){
		return this.seat_num;
	}
	public void setWeight(java.lang.Float weight){
		this.weight=weight;
	}
	public java.lang.Float getWeight(){
		return this.weight;
	}
	public void setIs_operate_car(java.lang.Integer is_operate_car){
		this.is_operate_car=is_operate_car;
	}
	public java.lang.Integer getIs_operate_car(){
		return this.is_operate_car;
	}
	public java.lang.Integer getIs_need_appraise() {
		return is_need_appraise;
	}
	public void setIs_need_appraise(java.lang.Integer is_need_appraise) {
		this.is_need_appraise = is_need_appraise;
	}
	public java.lang.Integer getCar_category() {
		return car_category;
	}
	public void setCar_category(java.lang.Integer car_category) {
		this.car_category = car_category;
	}
	public void setFrame_num(java.lang.String frame_num){
		this.frame_num=frame_num;
	}
	public java.lang.String getFrame_num(){
		return this.frame_num;
	}
	public void setEngine_num(java.lang.String engine_num){
		this.engine_num=engine_num;
	}
	public java.lang.String getEngine_num(){
		return this.engine_num;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setOwner(java.lang.Long owner){
		this.owner=owner;
	}
	public java.lang.Long getOwner(){
		return this.owner;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public java.sql.Timestamp getNext_check_date() {
		return next_check_date;
	}
	public void setNext_check_date(java.sql.Timestamp next_check_date) {
		this.next_check_date = next_check_date;
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
	public java.lang.String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(java.lang.String owner_name) {
		this.owner_name = owner_name;
	}
	public java.lang.String getTelphone() {
		return telphone;
	}
	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}
	
}
