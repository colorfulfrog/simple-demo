package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysDiscount;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:预约折扣表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "SysDiscountRequest", description = "预约折扣表 rquest对象")
public class SysDiscountRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "预约折扣表对象")
	private SysDiscount sysDiscount;
	
	public void setSysDiscount(SysDiscount sysDiscount){
		this.sysDiscount=sysDiscount;
	}
	public SysDiscount getSysDiscount(){
		return this.sysDiscount;
	}	
}
