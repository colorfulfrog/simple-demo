package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsBulletin;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:车检动态表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsBulletinRequest", description = "车检动态表 rquest对象")
public class BsBulletinRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "车检动态表对象")
	private BsBulletin bsBulletin;
	
	public void setBsBulletin(BsBulletin bsBulletin){
		this.bsBulletin=bsBulletin;
	}
	public BsBulletin getBsBulletin(){
		return this.bsBulletin;
	}	
}
