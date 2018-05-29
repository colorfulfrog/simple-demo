package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsActivity;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:活动表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsActivityRequest", description = "活动表 rquest对象")
public class BsActivityRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "活动表对象")
	private BsActivity bsActivity;
	
	public void setBsActivity(BsActivity bsActivity){
		this.bsActivity=bsActivity;
	}
	public BsActivity getBsActivity(){
		return this.bsActivity;
	}	
}
