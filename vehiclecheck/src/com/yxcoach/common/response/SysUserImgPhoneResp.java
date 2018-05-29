package com.yxcoach.common.response;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author xiajiahao
 * 2018年4月8日
 */
@ApiModel(value = "SysUserImgPhoneResp", description = "用户头像手机号码")
public class SysUserImgPhoneResp implements Serializable{

	@ApiModelProperty(value = "好友表id ")
	private java.lang.Long id;	
	
	@ApiModelProperty(value = "好友id ")
	private java.lang.Long uid;
	
	@ApiModelProperty(value = "联系电话 长度(30) 必填")
	private java.lang.String telphone;
	
	@ApiModelProperty(value = "头像 长度(800)")
	private java.lang.String image;

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

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getUid() {
		return uid;
	}

	public void setUid(java.lang.Long uid) {
		this.uid = uid;
	}
	
	
}
