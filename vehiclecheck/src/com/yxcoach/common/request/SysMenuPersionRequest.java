package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

@ApiModel(value = "SysMenuPersionRequest", description = "权限菜单新增的对象数组")
public class SysMenuPersionRequest extends BaseQueryRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="角色id")
	private long rid;
	
	@ApiModelProperty(value="菜单id集合")
	private String[] mid;
	
	@ApiModelProperty(value="权限id集合")
	private String[] pid;

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String[] getMid() {
		return mid;
	}

	public void setMid(String[] mid) {
		this.mid = mid;
	}

	public String[] getPid() {
		return pid;
	}

	public void setPid(String[] pid) {
		this.pid = pid;
	}
	
	

}
