package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:权限表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysPersionRequest", description = "权限表 rquest对象")
public class SysPersionRequest extends BaseRequest{

	@ApiModelProperty(value = "权限表对象")
	private SysPersion sysPersion;
	
	public void setSysPersion(SysPersion sysPersion){
		this.sysPersion=sysPersion;
	}
	public SysPersion getSysPersion(){
		return this.sysPersion;
	}	
}
