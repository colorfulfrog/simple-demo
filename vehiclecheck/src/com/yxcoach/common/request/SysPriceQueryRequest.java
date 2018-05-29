package com.yxcoach.common.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 * 
 * 注释:计价管理表 rquest对象 创建人: liwei 创建日期:2018-05-09
 */
@ApiModel(value = "SysPriceQueryRequest", description = "计价管理表 rquest分页查询对象")
public class SysPriceQueryRequest extends BaseQueryRequest {
	private static final long serialVersionUID = 1L;
	// 查询条件
	// 车辆年限
	@ApiModelProperty(value = "车辆年限 1-10 11：10年以上 ")
	private java.lang.Integer car_year;
	// 座位数
	// 总质量
	// 是否运营

	@ApiModelProperty(value = "座位数 1小于5座 2 5-19座 3大于19座 ")
	private java.lang.Integer seat_num;
	
	@ApiModelProperty(value = "总质量 1 小于3.5T 2：3.5-6T 3 大于6T ")
	private java.lang.Integer weight; 
	
	@ApiModelProperty(value = "是否营运车辆 1是 0 否 ")
	private java.lang.Integer is_operate_car;
	
	public java.lang.Integer getCar_year() {
		return car_year;
	}

	public void setCar_year(java.lang.Integer car_year) {
		this.car_year = car_year;
	}

	public java.lang.Integer getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(java.lang.Integer seat_num) {
		this.seat_num = seat_num;
	}

	public java.lang.Integer getWeight() {
		return weight;
	}

	public void setWeight(java.lang.Integer weight) {
		this.weight = weight;
	}

	public java.lang.Integer getIs_operate_car() {
		return is_operate_car;
	}

	public void setIs_operate_car(java.lang.Integer is_operate_car) {
		this.is_operate_car = is_operate_car;
	}

	@ApiModelProperty(value = "计价管理对象")
	private SysPrice sysPrice;

	public SysPrice getSysPrice() {
		return sysPrice;
	}

	public void setSysPrice(SysPrice sysPrice) {
		this.sysPrice = sysPrice;
	}
}
