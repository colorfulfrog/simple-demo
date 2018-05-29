package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:菜单表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysMenuRequest", description = "菜单表 rquest对象")
public class SysMenuRequest extends BaseRequest{

	@ApiModelProperty(value = "菜单表对象")
	private SysMenu sysMenu;
	
	@ApiModelProperty(value = "是否是一级菜单0表示是 1表示不是一级菜单")
	private int type;
	
	public void setSysMenu(SysMenu sysMenu){
		this.sysMenu=sysMenu;
	}
	public SysMenu getSysMenu(){
		return this.sysMenu;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}	
	
}
