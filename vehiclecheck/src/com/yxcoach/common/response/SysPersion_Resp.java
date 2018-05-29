package com.yxcoach.common.response;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class SysPersion_Resp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "菜单ID")
	private Long id;
	
	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	
	@ApiModelProperty(value = "权限功能")
	private String persionName;
	
	@ApiModelProperty(value = "权限描述")
	private String remark;
	
	@ApiModelProperty(value = "创建时间")
	private java.sql.Timestamp create_date;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPersionName() {
		return persionName;
	}

	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.sql.Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(java.sql.Timestamp create_date) {
		this.create_date = create_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
