package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsInviteRecord;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:好友推荐邀请表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsInviteRecordRequest", description = "好友推荐邀请表 rquest对象")
public class BsInviteRecordRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "好友推荐邀请表对象")
	private BsInviteRecord bsInviteRecord;
	
	public void setBsInviteRecord(BsInviteRecord bsInviteRecord){
		this.bsInviteRecord=bsInviteRecord;
	}
	public BsInviteRecord getBsInviteRecord(){
		return this.bsInviteRecord;
	}	
}
