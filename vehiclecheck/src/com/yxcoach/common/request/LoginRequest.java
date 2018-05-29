package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseRequest;

@ApiModel(value = "登录请求对象")
public class LoginRequest extends BaseRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "请求返回token")
	private String token;
	
	@ApiModelProperty(value = "后台登录账号")
	private String telphone;
	
	@ApiModelProperty(value = "后台登录密码")
	private String password;
	
	private String username;
	
	@ApiModelProperty(value = "验证码")
	private Integer yzm;
	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getYzm() {
		return yzm;
	}
	public void setYzm(Integer yzm) {
		this.yzm = yzm;
	}
	
	
	
}
