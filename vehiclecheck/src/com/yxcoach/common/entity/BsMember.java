package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.annotation.Extend;

/**
 *	
 *  表名:bs_member
 *  注释:会员表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsMember", description = "会员表")
public class BsMember implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = " 长度(64) 必填")
	private java.lang.String wechat_id;
	
	@ApiModelProperty(value = " 长度(200) 必填")
	private java.lang.String open_id;
	
	@ApiModelProperty(value = "昵称 长度(30)")
	private java.lang.String nickname;
	
	@ApiModelProperty(value = "头像 长度(800) 必填")
	private java.lang.String qrcode_url;
	
	@ApiModelProperty(value = "会员类型 1：车主 3：经纪人 ")
	private java.lang.Integer type;
	
	@ApiModelProperty(value = "真实姓名 长度(30)")
	private java.lang.String real_name;
	
	@ApiModelProperty(value = "联系电话 长度(30)")
	private java.lang.String telphone;
	
	@ApiModelProperty(value = "状态 1、待审核  2、认证通过  3、认证失败 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "邀请人数 ")
	private java.lang.Integer invite_num;
	
	@ApiModelProperty(value = "注册来源 1：平台 2：经纪人 3：上门客户 ")
	private java.lang.Integer source;
	
	@ApiModelProperty(value = "身份证号码 长度(30)")
	private java.lang.String pin;
	
	@ApiModelProperty(value = "身份证正面照 长度(200)")
	private java.lang.String pin_front_url;
	
	@ApiModelProperty(value = "身份证背面照(头像) 长度(200)")
	private java.lang.String pin_back_url;
	
	@ApiModelProperty(value = "审核人")
	private java.lang.Long audit_user;
	
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
	
	@ApiModelProperty(value = "认证时间 ")
	private java.sql.Timestamp identify_date;
	
	@ApiModelProperty(value = "认证不通过原因/描述 ")
	private java.lang.String audit_desc;
	
	//扩展字段
	@Extend(value = "用户名称")
	private java.lang.String user_name;
	@Extend(value = "优惠代金劵")
	private java.lang.String coupon_type_id;
	@Extend(value = "会员类型 1：车主 3：经纪人(前台无法识别type)")
	private java.lang.Integer typex;
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setWechat_id(java.lang.String wechat_id){
		this.wechat_id=wechat_id;
	}
	public java.lang.String getWechat_id(){
		return this.wechat_id;
	}
	public void setOpen_id(java.lang.String open_id){
		this.open_id=open_id;
	}
	public java.lang.String getOpen_id(){
		return this.open_id;
	}
	public void setNickname(java.lang.String nickname){
		this.nickname=nickname;
	}
	public java.lang.String getNickname(){
		return this.nickname;
	}
	public void setQrcode_url(java.lang.String qrcode_url){
		this.qrcode_url=qrcode_url;
	}
	public java.lang.String getQrcode_url(){
		return this.qrcode_url;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
	public void setReal_name(java.lang.String real_name){
		this.real_name=real_name;
	}
	public java.lang.String getReal_name(){
		return this.real_name;
	}
	public void setTelphone(java.lang.String telphone){
		this.telphone=telphone;
	}
	public java.lang.String getTelphone(){
		return this.telphone;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setInvite_num(java.lang.Integer invite_num){
		this.invite_num=invite_num;
	}
	public java.lang.Integer getInvite_num(){
		return this.invite_num;
	}
	public void setSource(java.lang.Integer source){
		this.source=source;
	}
	public java.lang.Integer getSource(){
		return this.source;
	}
	public void setPin(java.lang.String pin){
		this.pin=pin;
	}
	public java.lang.String getPin(){
		return this.pin;
	}
	public void setPin_front_url(java.lang.String pin_front_url){
		this.pin_front_url=pin_front_url;
	}
	public java.lang.String getPin_front_url(){
		return this.pin_front_url;
	}
	public void setPin_back_url(java.lang.String pin_back_url){
		this.pin_back_url=pin_back_url;
	}
	public java.lang.String getPin_back_url(){
		return this.pin_back_url;
	}
	public void setAudit_user(java.lang.Long audit_user){
		this.audit_user=audit_user;
	}
	public java.lang.Long getAudit_user(){
		return this.audit_user;
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
	public java.sql.Timestamp getIdentify_date() {
		return identify_date;
	}
	public void setIdentify_date(java.sql.Timestamp identify_date) {
		this.identify_date = identify_date;
	}
	public java.lang.String getAudit_desc() {
		return audit_desc;
	}
	public void setAudit_desc(java.lang.String audit_desc) {
		this.audit_desc = audit_desc;
	}
	public java.lang.String getUser_name() {
		return user_name;
	}
	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}
	public java.lang.String getCoupon_type_id() {
		return coupon_type_id;
	}
	public void setCoupon_type_id(java.lang.String coupon_type_id) {
		this.coupon_type_id = coupon_type_id;
	}
	public java.lang.Integer getTypex() {
		return typex;
	}
	public void setTypex(java.lang.Integer typex) {
		this.typex = typex;
	}
}
