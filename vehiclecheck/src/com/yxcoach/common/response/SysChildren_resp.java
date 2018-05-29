package com.yxcoach.common.response;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class SysChildren_resp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "二级菜单ID")
	private Long secondid;
	
	@ApiModelProperty(value = "二级菜单名称")
	private String secondMenuName;
	
	@ApiModelProperty(value = "二级菜单所对应的权限")
	private List<SysPersionList_Resp> sysPersionList;
	
	@ApiModelProperty(value = "是否有二级菜单")
	private boolean checked;

	public Long getSecondid() {
		return secondid;
	}

	public void setSecondid(Long secondid) {
		this.secondid = secondid;
	}

	public String getSecondMenuName() {
		return secondMenuName;
	}

	public void setSecondMenuName(String secondMenuName) {
		this.secondMenuName = secondMenuName;
	}

	public List<SysPersionList_Resp> getSysPersionList() {
		return sysPersionList;
	}

	public void setSysPersionList(List<SysPersionList_Resp> sysPersionList) {
		this.sysPersionList = sysPersionList;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	

}
