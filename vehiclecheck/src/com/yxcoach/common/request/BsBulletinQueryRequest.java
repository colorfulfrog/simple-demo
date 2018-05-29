package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:车检动态表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsBulletinQueryRequest", description = "车检动态表 rquest分页查询对象")
public class BsBulletinQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "标题 长度(128) 必填")
	private java.lang.String title;
	
	@ApiModelProperty(value = "发布人 长度(64) 必填")
	private java.lang.String publisher;
	
	@ApiModelProperty(value = "开始时间 ")
	private String beginTime;
	@ApiModelProperty(value = "结束时间 ")
	private String endTime;
	public java.lang.String getTitle() {
		return title;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getPublisher() {
		return publisher;
	}
	public void setPublisher(java.lang.String publisher) {
		this.publisher = publisher;
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
