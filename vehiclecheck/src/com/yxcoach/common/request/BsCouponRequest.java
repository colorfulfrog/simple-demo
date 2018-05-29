package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:优惠券表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "BsCouponRequest", description = "优惠券表 rquest对象")
public class BsCouponRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "优惠券表对象")
	private BsCoupon bsCoupon;
	
	public void setBsCoupon(BsCoupon bsCoupon){
		this.bsCoupon=bsCoupon;
	}
	public BsCoupon getBsCoupon(){
		return this.bsCoupon;
	}	
}
