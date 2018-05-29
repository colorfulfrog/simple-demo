package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.annotation.Extend;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 * 
 * 注释:短信发送记录表 rquest对象 创建人: liwei 创建日期:2018-05-11
 */
@ApiModel(value = "SysMsgRecordQueryRequest", description = "短信发送记录表 rquest分页查询对象")
public class SysMsgRecordQueryRequest extends BaseQueryRequest {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "发送人 task:定时任务，用户ID：管理员后台发送 长度(20) 必填")
	private java.lang.String sender;
	
	@ApiModelProperty(value = "接受人 长度() 必填")
	private java.lang.String receiver;
	
	@ApiModelProperty(value = "短信内容 长度(1000) 必填")
	private java.lang.String msg_content;
	
	@ApiModelProperty(value = "状态 1成功 2失败 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "发送时间 ")
	private java.sql.Timestamp send_time;
	
	@ApiModelProperty(value = "短信类型 1手工群发 2定时任务 ")
	private java.lang.Integer msg_type;
	// 扩展字段
	@Extend("发送开始时间")
	private java.sql.Timestamp start_time;
	@Extend("发送结束时间")
	private java.sql.Timestamp end_time;
	
	
	@ApiModelProperty(value = "短信发送记录对象")
	private SysMsgRecord sysMsgRecord;

	public SysMsgRecord getSysMsgRecord() {
		return sysMsgRecord;
	}

	public void setSysMsgRecord(SysMsgRecord sysMsgRecord) {
		this.sysMsgRecord = sysMsgRecord;
	}

	public java.lang.String getSender() {
		return sender;
	}

	public void setSender(java.lang.String sender) {
		this.sender = sender;
	}

	public java.lang.String getReceiver() {
		return receiver;
	}

	public void setReceiver(java.lang.String receiver) {
		this.receiver = receiver;
	}

	public java.lang.String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(java.lang.String msg_content) {
		this.msg_content = msg_content;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.sql.Timestamp getSend_time() {
		return send_time;
	}

	public void setSend_time(java.sql.Timestamp send_time) {
		this.send_time = send_time;
	}

	public java.lang.Integer getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(java.lang.Integer msg_type) {
		this.msg_type = msg_type;
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
