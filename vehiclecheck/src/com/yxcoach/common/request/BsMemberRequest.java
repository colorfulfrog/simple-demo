package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:会员表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsMemberRequest", description = "会员表 rquest对象")
public class BsMemberRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "会员表对象")
	private BsMember bsMember;
	
	public void setBsMember(BsMember bsMember){
		this.bsMember=bsMember;
	}
	public BsMember getBsMember(){
		return this.bsMember;
	}	
}
