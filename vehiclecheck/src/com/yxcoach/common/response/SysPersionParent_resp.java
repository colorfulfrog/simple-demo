package com.yxcoach.common.response;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModelProperty;


public class SysPersionParent_resp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "一级菜单ID")
	private Long id;
	
	@ApiModelProperty(value = "一级菜单名称")
	private String menuName;
	
	@ApiModelProperty(value = "二级菜单集合")
	private List<SysChildren_resp> children;
	
	@ApiModelProperty(value = "是否有一级菜单")
	private boolean checked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<SysChildren_resp> getChildren() {
		return children;
	}

	public void setChildren(List<SysChildren_resp> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
	
	

}
