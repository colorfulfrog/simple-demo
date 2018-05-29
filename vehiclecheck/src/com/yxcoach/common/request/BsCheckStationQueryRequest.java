package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:检测站表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCheckStationQueryRequest", description = "检测站表 rquest分页查询对象")
public class BsCheckStationQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "检测站名称 长度(30) 必填")
	private java.lang.String station_name;
	
	@ApiModelProperty(value = "是否启用 1 是  2 否 ")
	private java.lang.Integer isenable;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getStation_name() {
		return station_name;
	}

	public void setStation_name(java.lang.String station_name) {
		this.station_name = station_name;
	}

	public java.lang.Integer getIsenable() {
		return isenable;
	}

	public void setIsenable(java.lang.Integer isenable) {
		this.isenable = isenable;
	}
}
