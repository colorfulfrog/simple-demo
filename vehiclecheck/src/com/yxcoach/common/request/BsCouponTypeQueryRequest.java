package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:优惠券类型表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@ApiModel(value = "BsCouponTypeQueryRequest", description = "优惠券类型表 rquest分页查询对象")
public class BsCouponTypeQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "优惠券类型 1 代金券 2折扣券 ")
	private java.lang.Integer type;
	
	
	@ApiModelProperty(value = "状态 1正常 2过期 3停用 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "有效期开始时间 ")
	private java.sql.Timestamp start_time;
	
	@ApiModelProperty(value = "有效期结束时间 ")
	private java.sql.Timestamp end_time;

	@ApiModelProperty(value = "优惠券类型表对象")
	private BsCouponType bsCouponType;
	
	@ApiModelProperty(value = "活动ID")
	private java.lang.Long activity_id;

	@ApiModelProperty(value = "主键 自增长 ")
	private java.lang.Long id;
	
	public BsCouponType getBsCouponType() {
		return bsCouponType;
	}
	public void setBsCouponType(BsCouponType bsCouponType) {
		this.bsCouponType = bsCouponType;
	}
	public java.lang.Integer getType() {
		return type;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.sql.Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(java.sql.Timestamp start_time) {
		this.start_time = start_time;
	}
	public java.sql.Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(java.sql.Timestamp end_time) {
		this.end_time = end_time;
	}
	public java.lang.Long getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(java.lang.Long activity_id) {
		this.activity_id = activity_id;
	}
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
}
