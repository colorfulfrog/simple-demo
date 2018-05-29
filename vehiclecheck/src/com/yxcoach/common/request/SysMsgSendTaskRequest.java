package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:短信定时任务表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "SysMsgSendTaskRequest", description = "短信定时任务表 rquest对象")
public class SysMsgSendTaskRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "短信定时任务表对象")
	private SysMsgSendTask sysMsgSendTask;
	
	public void setSysMsgSendTask(SysMsgSendTask sysMsgSendTask){
		this.sysMsgSendTask=sysMsgSendTask;
	}
	public SysMsgSendTask getSysMsgSendTask(){
		return this.sysMsgSendTask;
	}	
}
