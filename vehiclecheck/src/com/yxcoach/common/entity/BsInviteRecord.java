package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_invite_record
 *  注释:好友推荐邀请表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsInviteRecord", description = "好友推荐邀请表")
public class BsInviteRecord implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = " ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "邀请人微信号 长度(64) 必填")
	private java.lang.String inviter_wechat_id;
	
	@ApiModelProperty(value = "被邀请人微信号 长度(64)")
	private java.lang.String invitee_wechat_id;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setInviter_wechat_id(java.lang.String inviter_wechat_id){
		this.inviter_wechat_id=inviter_wechat_id;
	}
	public java.lang.String getInviter_wechat_id(){
		return this.inviter_wechat_id;
	}
	public void setInvitee_wechat_id(java.lang.String invitee_wechat_id){
		this.invitee_wechat_id=invitee_wechat_id;
	}
	public java.lang.String getInvitee_wechat_id(){
		return this.invitee_wechat_id;
	}
}
