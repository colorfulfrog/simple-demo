package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_role
 *  注释:角色表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysRole", description = "角色表")
public class SysRole implements Serializable{

	@ApiModelProperty(value = " ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "角色名称 长度(30) 必填")
	private java.lang.String role_name;
	
	@ApiModelProperty(value = "角色类型 1、平台  2、企业  3、政府 长度(30)")
	private java.lang.String role_type;
	
	@ApiModelProperty(value = "数据权限 长度(500)")
	private java.lang.String role_data;
	
	@ApiModelProperty(value = "备注 长度(200)")
	private java.lang.String remake;
	
	@ApiModelProperty(value = "所属企业 ")
	private java.lang.Long cid;
	
	@ApiModelProperty(value = "所属分公司 ")
	private java.lang.Long oid;
	
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
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setRole_name(java.lang.String role_name){
		this.role_name=role_name;
	}
	public java.lang.String getRole_name(){
		return this.role_name;
	}
	public void setRole_type(java.lang.String role_type){
		this.role_type=role_type;
	}
	public java.lang.String getRole_type(){
		return this.role_type;
	}
	public void setRole_data(java.lang.String role_data){
		this.role_data=role_data;
	}
	public java.lang.String getRole_data(){
		return this.role_data;
	}
	public void setRemake(java.lang.String remake){
		this.remake=remake;
	}
	public java.lang.String getRemake(){
		return this.remake;
	}
	public void setCid(java.lang.Long cid){
		this.cid=cid;
	}
	public java.lang.Long getCid(){
		return this.cid;
	}
	public void setOid(java.lang.Long oid){
		this.oid=oid;
	}
	public java.lang.Long getOid(){
		return this.oid;
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
}
