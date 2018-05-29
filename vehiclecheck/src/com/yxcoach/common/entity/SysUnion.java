package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_union
 *  注释:角色权限表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-26
 */
@ApiModel(value = "SysUnion", description = "角色权限表")
public class SysUnion implements Serializable{

	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "角色编号 ")
	private java.lang.Long rid;
	
	@ApiModelProperty(value = "权限编号 ")
	private java.lang.Long oid;
	
	@ApiModelProperty(value = "类型1、(角色rid、菜单oid)2、(角色rid,权限oid)4、(角色rid,用户oid) ")
	private java.lang.Integer type;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setRid(java.lang.Long rid){
		this.rid=rid;
	}
	public java.lang.Long getRid(){
		return this.rid;
	}
	public void setOid(java.lang.Long oid){
		this.oid=oid;
	}
	public java.lang.Long getOid(){
		return this.oid;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
	}
}
