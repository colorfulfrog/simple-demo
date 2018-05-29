package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysConfig;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:参数配置表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "SysConfigRequest", description = "参数配置表 rquest对象")
public class SysConfigRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "参数配置表对象")
	private SysConfig sysConfig;
	
	public void setSysConfig(SysConfig sysConfig){
		this.sysConfig=sysConfig;
	}
	public SysConfig getSysConfig(){
		return this.sysConfig;
	}	
}
