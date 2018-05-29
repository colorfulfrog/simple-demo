package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_activity
 *  注释:活动表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsActivity", description = "活动表")
public class BsActivity implements Serializable{
    private static final long serialVersionUID = 1L;
     	
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "活动名称 长度(30) 必填")
	private java.lang.String activity_name;
	
	@ApiModelProperty(value = "开始时间 ")
	private java.sql.Timestamp start_time;
	
	@ApiModelProperty(value = "结束时间 ")
	private java.sql.Timestamp end_time;
	
	@ApiModelProperty(value = "活动介绍 长度(200)")
	private java.lang.String remark;
	
	@ApiModelProperty(value = "是否启用 1 是  2 否 ")
	private java.lang.Integer isenable;
	
	@ApiModelProperty(value = "状态 1未开始 2进行中 3已结束 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "分配机制 1随机分配 ")
	private java.lang.Integer type;
	
	@ApiModelProperty(value = "单次发放张数 ")
	private java.lang.Integer num;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_user;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setActivity_name(java.lang.String activity_name){
		this.activity_name=activity_name;
	}
	public java.lang.String getActivity_name(){
		return this.activity_name;
	}
	public void setStart_time(java.sql.Timestamp start_time){
		this.start_time=start_time;
	}
	public java.sql.Timestamp getStart_time(){
		return this.start_time;
	}
	public void setEnd_time(java.sql.Timestamp end_time){
		this.end_time=end_time;
	}
	public java.sql.Timestamp getEnd_time(){
		return this.end_time;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	public java.lang.String getRemark(){
		return this.remark;
	}
	public void setIsenable(java.lang.Integer isenable){
		this.isenable=isenable;
	}
	public java.lang.Integer getIsenable(){
		return this.isenable;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	public java.lang.Integer getType(){
		return this.type;
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
	public void setUpdate_user(java.lang.Long update_user){
		this.update_user=update_user;
	}
	public java.lang.Long getUpdate_user(){
		return this.update_user;
	}
	public java.lang.Integer getNum() {
		return num;
	}
	public void setNum(java.lang.Integer num) {
		this.num = num;
	}
}
