package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;

/**
 *	
 *  注释:用户表 rquest对象
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysUserQueryRequest", description = "用户表 rquest分页查询对象")
public class SysUserQueryRequest extends BaseQueryRequest{

	private String telphone;
	private String user_name;
	private Long check_station_id;
	private Long rid;
	private Long use_status;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getUse_status() {
		return use_status;
	}

	public void setUse_status(Long use_status) {
		this.use_status = use_status;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Long getCheck_station_id() {
		return check_station_id;
	}

	public void setCheck_station_id(Long check_station_id) {
		this.check_station_id = check_station_id;
	}
}
