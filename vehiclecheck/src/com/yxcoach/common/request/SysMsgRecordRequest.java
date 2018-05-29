package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:短信发送记录表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "SysMsgRecordRequest", description = "短信发送记录表 rquest对象")
public class SysMsgRecordRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "短信发送记录表对象")
	private SysMsgRecord sysMsgRecord;
	
	public void setSysMsgRecord(SysMsgRecord sysMsgRecord){
		this.sysMsgRecord=sysMsgRecord;
	}
	public SysMsgRecord getSysMsgRecord(){
		return this.sysMsgRecord;
	}	
}
