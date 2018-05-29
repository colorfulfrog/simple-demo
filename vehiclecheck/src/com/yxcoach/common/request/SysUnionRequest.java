package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysUnion;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:角色权限表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-26
 */
@ApiModel(value = "SysUnionRequest", description = "角色权限表 rquest对象")
public class SysUnionRequest extends BaseRequest{

	@ApiModelProperty(value = "角色权限表对象")
	private SysUnion sysUnion;
	
	public void setSysUnion(SysUnion sysUnion){
		this.sysUnion=sysUnion;
	}
	public SysUnion getSysUnion(){
		return this.sysUnion;
	}	
}
