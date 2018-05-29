package com.yxcoach.common.response;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:SysUserInfoResp
 *  注释:用户信息
 *  创建人: xiajiahoa
 *  创建日期:2018-04-4
 */
@ApiModel(value = "SysUserInfoResp", description = "用户信息")
public class SysUserInfoResp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7919478635920248298L;

	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "用户名称 长度(30) 必填")
	private java.lang.String user_name;
	
	@ApiModelProperty(value = "真实姓名 长度(30) 必填")
	private java.lang.String real_name;
	
	@ApiModelProperty(value = "联系电话 长度(30) 必填")
	private java.lang.String telphone;
	
	@ApiModelProperty(value = "头像 长度(800)")
	private java.lang.String image;
	
	@ApiModelProperty(value = "昵称 长度(30)")
	private java.lang.String nickname;
	
	@ApiModelProperty(value = "收货地址")
	private java.lang.String user_address;
	
	@ApiModelProperty(value = "好友数量 ")
	private java.lang.Integer friendNum;
	
	@ApiModelProperty(value = "我的申请数量 ")
	private java.lang.Integer applyNum;
	
	@ApiModelProperty(value = "新朋友数量 ")
	private java.lang.Integer newFriendNum;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public java.lang.String getReal_name() {
		return real_name;
	}

	public void setReal_name(java.lang.String real_name) {
		this.real_name = real_name;
	}

	public java.lang.String getTelphone() {
		return telphone;
	}

	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}

	public java.lang.String getImage() {
		return image;
	}

	public void setImage(java.lang.String image) {
		this.image = image;
	}

	public java.lang.String getNickname() {
		return nickname;
	}

	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	public java.lang.String getUser_address() {
		return user_address;
	}

	public void setUser_address(java.lang.String user_address) {
		this.user_address = user_address;
	}

	public java.lang.Integer getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(java.lang.Integer friendNum) {
		this.friendNum = friendNum;
	}

	public java.lang.Integer getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(java.lang.Integer applyNum) {
		this.applyNum = applyNum;
	}

	public java.lang.Integer getNewFriendNum() {
		return newFriendNum;
	}

	public void setNewFriendNum(java.lang.Integer newFriendNum) {
		this.newFriendNum = newFriendNum;
	}
	
	
}
