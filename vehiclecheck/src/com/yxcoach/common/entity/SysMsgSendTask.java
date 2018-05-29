package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.annotation.Extend;

/**
 * 
 * 表名:sys_msg_send_task 注释:短信定时任务表 创建人: liwei 创建日期:2018-05-11
 */
@ApiModel(value = "SysMsgSendTask", description = "短信定时任务表")
public class SysMsgSendTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;

	@ApiModelProperty(value = "短信类别 1 检测到期提醒 ")
	private java.lang.Integer type;

	@ApiModelProperty(value = "内容 长度(800) 必填")
	private java.lang.String content;

	@ApiModelProperty(value = "状态 1启用 0 停用 ")
	private java.lang.Integer status;

	@ApiModelProperty(value = "提前多少天发送 ")
	private java.lang.Integer days;

	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;

	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;

	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;

	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_user;

	// 扩展字段
	@Extend("创建开始时间")
	private java.sql.Timestamp start_time;
	@Extend("创建结束时间")
	private java.sql.Timestamp end_time;

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setDays(java.lang.Integer days) {
		this.days = days;
	}

	public java.lang.Integer getDays() {
		return this.days;
	}

	public void setGmt_create(java.sql.Timestamp gmt_create) {
		this.gmt_create = gmt_create;
	}

	public java.sql.Timestamp getGmt_create() {
		return this.gmt_create;
	}

	public void setGmt_modify(java.sql.Timestamp gmt_modify) {
		this.gmt_modify = gmt_modify;
	}

	public java.sql.Timestamp getGmt_modify() {
		return this.gmt_modify;
	}

	public void setGmt_user(java.lang.Long gmt_user) {
		this.gmt_user = gmt_user;
	}

	public java.lang.Long getGmt_user() {
		return this.gmt_user;
	}

	public void setUpdate_user(java.lang.Long update_user) {
		this.update_user = update_user;
	}

	public java.lang.Long getUpdate_user() {
		return this.update_user;
	}

	public java.sql.Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(java.sql.Timestamp start_time) {
		this.start_time = start_time;
	}

	public java.sql.Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(java.sql.Timestamp end_time) {
		this.end_time = end_time;
	}
}
