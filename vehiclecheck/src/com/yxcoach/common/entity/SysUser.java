package com.yxcoach.common.entity;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_user
 *  注释:用户表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysUser", description = "用户表")
public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7919478635920248298L;

	/**
	 * 
	 */
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "账号 长度(30) 必填")
	private java.lang.String login_name;
	
	@ApiModelProperty(value = "用户名称 长度(30) 必填")
	private java.lang.String user_name;
	
	@ApiModelProperty(value = "用户密码 长度(100) 必填")
	private java.lang.String user_pwd;
	
	@ApiModelProperty(value = "用户类型 1、 系统管理员   ")
	private java.lang.Integer user_type;
	
	@ApiModelProperty(value = "联系电话 长度(30) 必填")
	private java.lang.String telphone;
	
	@ApiModelProperty(value = "是否管理员   1、管理员  2、非管理员 ")
	private java.lang.Integer ismanager;
	
	@ApiModelProperty(value = "状态 1、正常  2、锁定  3、永久禁用 ")
	private java.lang.Integer use_status;
	
	@ApiModelProperty(value = "备注 长度(200)")
	private java.lang.String remark;
	
	@ApiModelProperty(value = "所属企业 ")
	private java.lang.String cid;
	
	@ApiModelProperty(value = "所属检测站")
	private java.lang.String check_station_id;
	
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
	
	@ApiModelProperty(value = "友盟设备号 长度(200)")
	private java.lang.String device_token;
	
	@ApiModelProperty(value = " 长度(800)")
	private java.lang.String image;
	
	@ApiModelProperty(value = " 长度(30)")
	private java.lang.String nickname;
	
	//扩展字段
	private java.lang.Long rid;//角色id
	
	@ApiModelProperty(value = "所属检测站")
	private java.lang.String check_station_name;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setLogin_name(java.lang.String login_name){
		this.login_name=login_name;
	}
	public java.lang.String getLogin_name(){
		return this.login_name;
	}
	public void setUser_name(java.lang.String user_name){
		this.user_name=user_name;
	}
	public java.lang.String getUser_name(){
		return this.user_name;
	}
	public void setUser_pwd(java.lang.String user_pwd){
		this.user_pwd=user_pwd;
	}
	public java.lang.String getUser_pwd(){
		return this.user_pwd;
	}
	public void setUser_type(java.lang.Integer user_type){
		this.user_type=user_type;
	}
	public java.lang.Integer getUser_type(){
		return this.user_type;
	}
	public void setTelphone(java.lang.String telphone){
		this.telphone=telphone;
	}
	public java.lang.String getTelphone(){
		return this.telphone;
	}
	public void setIsmanager(java.lang.Integer ismanager){
		this.ismanager=ismanager;
	}
	public java.lang.Integer getIsmanager(){
		return this.ismanager;
	}
	public void setUse_status(java.lang.Integer use_status){
		this.use_status=use_status;
	}
	public java.lang.Integer getUse_status(){
		return this.use_status;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
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
	public void setDevice_token(java.lang.String device_token){
		this.device_token=device_token;
	}
	public java.lang.String getDevice_token(){
		return this.device_token;
	}
	public void setImage(java.lang.String image){
		this.image=image;
	}
	public java.lang.String getImage(){
		return this.image;
	}
	public void setNickname(java.lang.String nickname){
		this.nickname=nickname;
	}
	public java.lang.String getNickname(){
		return this.nickname;
	}
	
	public java.lang.Long getRid() {
		return rid;
	}
	public void setRid(java.lang.Long rid) {
		this.rid = rid;
	}
	public java.lang.String getCid() {
		return cid;
	}
	public void setCid(java.lang.String cid) {
		this.cid = cid;
	}
	public java.lang.String getCheck_station_id() {
		return check_station_id;
	}
	public void setCheck_station_id(java.lang.String check_station_id) {
		this.check_station_id = check_station_id;
	}
	public java.lang.String getCheck_station_name() {
		return check_station_name;
	}
	public void setCheck_station_name(java.lang.String check_station_name) {
		this.check_station_name = check_station_name;
	}
}
