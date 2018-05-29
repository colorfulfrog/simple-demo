package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:权限表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysPersionQueryRequest", description = "权限表 rquest分页查询对象")
public class SysPersionQueryRequest extends BaseQueryRequest{
	@ApiModelProperty(value="菜单ID")
	private Integer menuId;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	
	
}
