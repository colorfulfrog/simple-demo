package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:计价管理表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "SysPriceRequest", description = "计价管理表 rquest对象")
public class SysPriceRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "计价管理表对象")
	private SysPrice sysPrice;
	
	public void setSysPrice(SysPrice sysPrice){
		this.sysPrice=sysPrice;
	}
	public SysPrice getSysPrice(){
		return this.sysPrice;
	}	
}
