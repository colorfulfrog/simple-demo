package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_check_station_feedback
 *  注释:检测站评价表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsCheckStationFeedback", description = "检测站评价表")
public class BsCheckStationFeedback implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "订单号 ")
	private java.lang.Long order_id;
	
	@ApiModelProperty(value = "检测站ID")
	private java.lang.Long station_id;
	
	@ApiModelProperty(value = "评分 ")
	private java.lang.Float score;
	
	@ApiModelProperty(value = "标签 长度(20)")
	private java.lang.String feedback_label;
	
	@ApiModelProperty(value = "评价内容 长度(800)")
	private java.lang.String content;
	
	@ApiModelProperty(value = "回访情况 长度(800)")
	private java.lang.String return_visits;
	
	@ApiModelProperty(value = "评价时间")
	private java.sql.Timestamp feedback_date;
	
	@ApiModelProperty(value = "评价会员用户ID")
	private java.lang.Long member_id;
	
	/*扩展属性*/
	@ApiModelProperty(value = "检测站名称")
	private java.lang.String station_name;
	@ApiModelProperty(value = "业务类型： 1 车检，其他预留 ")
	private java.lang.Integer service_type;
	@ApiModelProperty(value = "总订单量 ")
	private java.lang.Integer order_count;
	
	@ApiModelProperty(value = "用户名称")
	private java.lang.String nickname;
	@ApiModelProperty(value = "用户手机号")
	private java.lang.String telephone;
	@ApiModelProperty(value = "订单编号")
	private java.lang.String order_no;
	@ApiModelProperty(value = "评价开始时间 ")
	private java.sql.Timestamp beginTime;
	@ApiModelProperty(value = "评价结束时间 ")
	private java.sql.Timestamp endTime;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setOrder_id(java.lang.Long order_id){
		this.order_id=order_id;
	}
	public java.lang.Long getOrder_id(){
		return this.order_id;
	}
	public void setScore(java.lang.Float score){
		this.score=score;
	}
	public java.lang.Float getScore(){
		return this.score;
	}
	public void setFeedback_label(java.lang.String feedback_label){
		this.feedback_label=feedback_label;
	}
	public java.lang.String getFeedback_label(){
		return this.feedback_label;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	public java.lang.String getContent(){
		return this.content;
	}
	public void setReturn_visits(java.lang.String return_visits){
		this.return_visits=return_visits;
	}
	public java.lang.String getReturn_visits(){
		return this.return_visits;
	}
	public void setFeedback_date(java.sql.Timestamp feedback_date){
		this.feedback_date=feedback_date;
	}
	public java.sql.Timestamp getFeedback_date(){
		return this.feedback_date;
	}
	public void setMember_id(java.lang.Long member_id){
		this.member_id=member_id;
	}
	public java.lang.Long getMember_id(){
		return this.member_id;
	}
	public java.lang.Long getStation_id() {
		return station_id;
	}
	public void setStation_id(java.lang.Long station_id) {
		this.station_id = station_id;
	}
	public java.lang.String getStation_name() {
		return station_name;
	}
	public void setStation_name(java.lang.String station_name) {
		this.station_name = station_name;
	}
	public java.lang.Integer getService_type() {
		return service_type;
	}
	public void setService_type(java.lang.Integer service_type) {
		this.service_type = service_type;
	}
	public java.lang.Integer getOrder_count() {
		return order_count;
	}
	public void setOrder_count(java.lang.Integer order_count) {
		this.order_count = order_count;
	}
	public java.lang.String getNickname() {
		return nickname;
	}
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}
	public java.lang.String getTelephone() {
		return telephone;
	}
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(java.lang.String order_no) {
		this.order_no = order_no;
	}
	public java.sql.Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(java.sql.Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public java.sql.Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}
}
