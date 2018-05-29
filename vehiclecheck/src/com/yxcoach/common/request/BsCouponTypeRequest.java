package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:优惠券类型表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "BsCouponTypeRequest", description = "优惠券类型表 rquest对象")
public class BsCouponTypeRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "优惠券类型表对象")
	private BsCouponType bsCouponType;
	
	public void setBsCouponType(BsCouponType bsCouponType){
		this.bsCouponType=bsCouponType;
	}
	public BsCouponType getBsCouponType(){
		return this.bsCouponType;
	}	
}
