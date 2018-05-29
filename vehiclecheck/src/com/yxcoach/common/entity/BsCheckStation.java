package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_check_station
 *  注释:检测站表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCheckStation", description = "检测站表")
public class BsCheckStation implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "检测站名称 长度(30) 必填")
	private java.lang.String station_name;
	
	@ApiModelProperty(value = "经度 必填")
	private java.lang.String longitude;
	
	@ApiModelProperty(value = "纬度 必填")
	private java.lang.String latitude;
	
	@ApiModelProperty(value = "地址 长度(200)")
	private java.lang.String station_address;
	
	@ApiModelProperty(value = "电话 长度(30)")
	private java.lang.String telephone;
	
	@ApiModelProperty(value = "是否启用 1 是  2 否 ")
	private java.lang.Integer isenable;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setStation_name(java.lang.String station_name){
		this.station_name=station_name;
	}
	public java.lang.String getStation_name(){
		return this.station_name;
	}
	public void setLongitude(java.lang.String longitude){
		this.longitude=longitude;
	}
	public java.lang.String getLongitude(){
		return this.longitude;
	}
	public void setLatitude(java.lang.String latitude){
		this.latitude=latitude;
	}
	public java.lang.String getLatitude(){
		return this.latitude;
	}
	public void setStation_address(java.lang.String station_address){
		this.station_address=station_address;
	}
	public java.lang.String getStation_address(){
		return this.station_address;
	}
	public void setTelephone(java.lang.String telephone){
		this.telephone=telephone;
	}
	public java.lang.String getTelephone(){
		return this.telephone;
	}
	public void setIsenable(java.lang.Integer isenable){
		this.isenable=isenable;
	}
	public java.lang.Integer getIsenable(){
		return this.isenable;
	}
	public void setGmt_create(java.sql.Timestamp gmt_create){
		this.gmt_create=gmt_create;
	}
	public java.sql.Timestamp getGmt_create(){
		return this.gmt_create;
	}
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setGmt_modify(java.sql.Timestamp gmt_modify){
		this.gmt_modify=gmt_modify;
	}
	public java.sql.Timestamp getGmt_modify(){
		return this.gmt_modify;
	}
}
