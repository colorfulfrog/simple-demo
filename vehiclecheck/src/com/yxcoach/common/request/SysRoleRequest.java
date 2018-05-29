package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:角色表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysRoleRequest", description = "角色表 rquest对象")
public class SysRoleRequest extends BaseRequest{

	@ApiModelProperty(value = "角色表对象")
	private SysRole sysRole;
	
	public void setSysRole(SysRole sysRole){
		this.sysRole=sysRole;
	}
	public SysRole getSysRole(){
		return this.sysRole;
	}	
}
