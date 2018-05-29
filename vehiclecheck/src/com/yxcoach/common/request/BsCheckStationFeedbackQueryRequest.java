package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:检测站评价表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsCheckStationFeedbackQueryRequest", description = "检测站评价表 rquest分页查询对象")
public class BsCheckStationFeedbackQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "检测站ID")
	private java.lang.Long station_id;
	
	@ApiModelProperty(value = "评分 ")
	private java.lang.Float score;
	
	@ApiModelProperty(value = "订单编号")
	private java.lang.String order_no;
	
	@ApiModelProperty(value = "开始时间 ")
	private String beginTime;
	@ApiModelProperty(value = "结束时间 ")
	private String endTime;

	public java.lang.Long getStation_id() {
		return station_id;
	}

	public void setStation_id(java.lang.Long station_id) {
		this.station_id = station_id;
	}

	public java.lang.Float getScore() {
		return score;
	}

	public void setScore(java.lang.Float score) {
		this.score = score;
	}

	public java.lang.String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(java.lang.String order_no) {
		this.order_no = order_no;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
