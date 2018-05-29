package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:菜单表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysMenuQueryRequest", description = "菜单表 rquest分页查询对象")
public class SysMenuQueryRequest extends BaseQueryRequest{
	@ApiModelProperty(value="菜单名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
