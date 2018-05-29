package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:角色表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysRoleQueryRequest", description = "角色表 rquest分页查询对象")
public class SysRoleQueryRequest extends BaseQueryRequest{

private String roleName;
	
	private String roleType;
	
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
