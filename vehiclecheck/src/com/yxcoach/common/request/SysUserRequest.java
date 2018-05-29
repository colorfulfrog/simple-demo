package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysUser;

/**
 *	
 *  注释:用户表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysUserRequest", description = "用户表 rquest对象")
public class SysUserRequest extends BaseRequest{

	@ApiModelProperty(value = "用户表对象")
	private SysUser sysUser;
	@ApiModelProperty(value = "账号 长度(30) 必填")
	private java.lang.String login_name;
	
	@ApiModelProperty(value = "用户密码 长度(100) 必填")
	private java.lang.String user_pwd;
	
	@ApiModelProperty(value = "联系电话 长度(30) 必填")
	private java.lang.String telphone;
	private String yzm;
	
	private Long rid;
	
	
	
	@ApiModelProperty(value = "验证码")
	private String code;
	
	@ApiModelProperty(value = "密码")
	private String password;
	
	@ApiModelProperty(value = "新密码")
	private String new_pwd;
	
	public void setSysUser(SysUser sysUser){
		this.sysUser=sysUser;
	}
	public SysUser getSysUser(){
		return this.sysUser;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public java.lang.String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(java.lang.String login_name) {
		this.login_name = login_name;
	}
	public java.lang.String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(java.lang.String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}

	public java.lang.String getTelphone() {
		return telphone;
	}
	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNew_pwd() {
		return new_pwd;
	}
	public void setNew_pwd(String new_pwd) {
		this.new_pwd = new_pwd;
	}
	
	
	
}
