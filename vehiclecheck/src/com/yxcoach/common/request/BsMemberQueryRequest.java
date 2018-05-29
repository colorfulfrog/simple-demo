package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 * 
 * 注释:会员表 rquest对象 创建人: liwei 创建日期:2018-05-09
 */
@ApiModel(value = "BsMemberQueryRequest", description = "会员表 rquest分页查询对象")
public class BsMemberQueryRequest extends BaseQueryRequest {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "昵称 长度(30)")
	private java.lang.String nickname;
	
	@ApiModelProperty(value = "真实姓名 长度(30)")
	private java.lang.String real_name;
	
	@ApiModelProperty(value = "会员类型 1：车主 3：经纪人 ")
	private java.lang.Integer typex;
	
	@ApiModelProperty(value = "状态 1、待审核  2、认证通过  3、认证失败 ")
	private java.lang.Integer status;

	@ApiModelProperty(value = "联系电话 长度(30)")
	private java.lang.String telphone;
	
	@ApiModelProperty(value = "注册来源 1：平台 2：经纪人 3：上门客户 ")
	private java.lang.Integer source;
	
	@ApiModelProperty(value = "审核人")
	private java.lang.Long audit_user;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = " 长度(64) 必填")
	private java.lang.String wechat_id;
	
	public java.lang.String getNickname() {
		return nickname;
	}

	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	public java.lang.String getReal_name() {
		return real_name;
	}

	public void setReal_name(java.lang.String real_name) {
		this.real_name = real_name;
	}


	public java.lang.Integer getTypex() {
		return typex;
	}

	public void setTypex(java.lang.Integer typex) {
		this.typex = typex;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Long getAudit_user() {
		return audit_user;
	}

	public void setAudit_user(java.lang.Long audit_user) {
		this.audit_user = audit_user;
	}

	public java.lang.String getTelphone() {
		return telphone;
	}

	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}

	public java.lang.Integer getSource() {
		return source;
	}

	public void setSource(java.lang.Integer source) {
		this.source = source;
	}


	@ApiModelProperty(value = "会员表对象")
	private BsMember bsMember;

	public BsMember getBsMember() {
		if(bsMember ==null)
			return new BsMember();
		return bsMember;
	}

	public void setBsMember(BsMember bsMember) {
		this.bsMember = bsMember;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getWechat_id() {
		return wechat_id;
	}

	public void setWechat_id(java.lang.String wechat_id) {
		this.wechat_id = wechat_id;
	}
}
