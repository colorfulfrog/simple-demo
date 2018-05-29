package com.yxcoach.common.response;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.response.BaseResponse;
@ApiModel(value = "登录返回对象")
public class SysUserResp implements Serializable {
	
	/**登录之后的token*/
	@ApiModelProperty(value = "请求返回token")
	private java.lang.String token;
	/**1、 平台
       2、企业
       3、政府*/	
	@ApiModelProperty(value = "用户类型：1：平台；2：企业；3：政府")
	private java.lang.Integer user_type;
	/**真实姓名*/	
	@ApiModelProperty(value = "真实姓名")
	private java.lang.String real_name;
	/**手机号码*/	
	@ApiModelProperty(value = "手机号码")
	private java.lang.String telphone;
	/**1、管理员
       2、非管理员*/
	@ApiModelProperty(value = "是否为管理员：1：管理员；2：非管理员")
	private java.lang.Integer ismanager;
	/**所属企业id*/	
	@ApiModelProperty(value = "所属企业id")
	private java.lang.Long cid;
	/**所属分公司id*/	
	@ApiModelProperty(value = "所属分公司id")
	private java.lang.Long oid;
	/**用户角色id*/
	@ApiModelProperty(value = "用户角色id")
	private java.lang.Long rid;
	/**角色名称*/
	@ApiModelProperty(value = "用户角色名称")
	private String roleName;
	/**所属企业*/
	@ApiModelProperty(value = "所属企业名称")
	private String corpName;
	/**所属分公司*/
	@ApiModelProperty(value = "所属分公司名称")
	private String orgName;
	
	@ApiModelProperty(value = "分机号")
	private java.lang.String extension;
	private java.lang.String user_pwd;
	
	private String username;
	
	public java.lang.String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(java.lang.String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public java.lang.String getExtension() {
		return extension;
	}
	public void setExtension(java.lang.String extension) {
		this.extension = extension;
	}
	public java.lang.String getToken() {
		return token;
	}
	public void setToken(java.lang.String token) {
		this.token = token;
	}
	public java.lang.Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(java.lang.Integer user_type) {
		this.user_type = user_type;
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
	public java.lang.Integer getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(java.lang.Integer ismanager) {
		this.ismanager = ismanager;
	}
	public java.lang.Long getCid() {
		return cid;
	}
	public void setCid(java.lang.Long cid) {
		this.cid = cid;
	}
	public java.lang.Long getOid() {
		return oid;
	}
	public void setOid(java.lang.Long oid) {
		this.oid = oid;
	}
	public java.lang.Long getRid() {
		return rid;
	}
	public void setRid(java.lang.Long rid) {
		this.rid = rid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
