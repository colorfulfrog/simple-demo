package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_persion
 *  注释:权限表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysPersion", description = "权限表")
public class SysPersion implements Serializable{

	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "菜单编号 ")
	private java.lang.Long m_id;
	
	@ApiModelProperty(value = "权限名称 长度(50) 必填")
	private java.lang.String persion_name;
	
	@ApiModelProperty(value = "权限 长度(100) 必填")
	private java.lang.String persion;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setM_id(java.lang.Long m_id){
		this.m_id=m_id;
	}
	public java.lang.Long getM_id(){
		return this.m_id;
	}
	public void setPersion_name(java.lang.String persion_name){
		this.persion_name=persion_name;
	}
	public java.lang.String getPersion_name(){
		return this.persion_name;
	}
	public void setPersion(java.lang.String persion){
		this.persion=persion;
	}
	public java.lang.String getPersion(){
		return this.persion;
	}
}
