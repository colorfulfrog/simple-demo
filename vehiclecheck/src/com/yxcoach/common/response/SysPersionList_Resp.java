package com.yxcoach.common.response;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class SysPersionList_Resp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "是否有权限")
	private boolean checked;
	
	@ApiModelProperty(value = "权限ID")
	private Long id;
	
	@ApiModelProperty(value = "权限名称")
	private String persionName;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersionName() {
		return persionName;
	}

	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	

}
