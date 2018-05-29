package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:车辆表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCarQueryRequest", description = "车辆表 rquest分页查询对象")
public class BsCarQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "车牌号 长度(20) 必填")
	private java.lang.String car_number;
	
	@ApiModelProperty(value = "车型 1 小型，2 中型，3 大型 ")
	private java.lang.Integer car_type;
	
	@ApiModelProperty(value = "所属车主 ")
	private java.lang.String owner_name;


	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	public java.lang.String getCar_number() {
		return car_number;
	}

	public void setCar_number(java.lang.String car_number) {
		this.car_number = car_number;
	}
	public java.lang.Integer getCar_type() {
		return car_type;
	}

	public void setCar_type(java.lang.Integer car_type) {
		this.car_type = car_type;
	}

	public java.lang.String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(java.lang.String owner_name) {
		this.owner_name = owner_name;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
}
