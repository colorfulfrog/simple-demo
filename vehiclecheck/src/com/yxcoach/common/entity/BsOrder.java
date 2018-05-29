package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_order
 *  注释:订单表
 *  创建人: liwei
 *  创建日期:2018-05-10
 */
@ApiModel(value = "BsOrder", description = "订单表")
public class BsOrder implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "	 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "检测站ID 长度(45) 必填")
	private java.lang.Long station_id;
	
	@ApiModelProperty(value = "订单号 长度(45) 必填")
	private java.lang.String order_no;
	
	@ApiModelProperty(value = "车辆ID 长度(20) 必填")
	private java.lang.Long car_id;
	
	@ApiModelProperty(value = "安检费用 ")
	private java.math.BigDecimal check_fee;
	
	@ApiModelProperty(value = "等级评定费用 ")
	private java.math.BigDecimal level_fee;
	
	@ApiModelProperty(value = "环检费用 ")
	private java.math.BigDecimal all_round_check_fee;
	@ApiModelProperty(value = "折扣金额 ")
	private java.math.BigDecimal discount_fee;
	@ApiModelProperty(value = "优惠金额 ")
	private java.math.BigDecimal coupon_fee;
	
	@ApiModelProperty(value = "订单总金额 (安检费用+等级评定费用+环检费用)*折扣-优惠券")
	private java.math.BigDecimal total_fee;
	
	@ApiModelProperty(value = "优惠券ID ")
	private java.lang.Long coupon_id;
	
	@ApiModelProperty(value = "预约用户编号 ")
	private java.lang.Long member_id;
	
	@ApiModelProperty(value = "预约用户手机号 长度(20) 必填")
	private java.lang.String telephone;
	
	@ApiModelProperty(value = "业务类型： 1 车检，其他预留 ")
	private java.lang.Integer service_type;
	
	@ApiModelProperty(value = "支付类型 1在线支付 2线下窗口支付 ")
	private java.lang.Integer pay_type;
	
	@ApiModelProperty(value = "支付状态 0未支付  1已支付 ")
	private java.lang.Integer pay_status;
	

	@ApiModelProperty(value = "支付时间 ")
	private java.sql.Timestamp pay_date;
	
	@ApiModelProperty(value = "外部交易号,比如支付宝微信等交易流水号 长度(100)")
	private java.lang.String out_pay_no;
	
	@ApiModelProperty(value = "支付商户编号 长度(32)")
	private java.lang.String pay_seller_id;
	
	@ApiModelProperty(value = "支付客户编号 长度(32)")
	private java.lang.String pay_buyer_id;
	
	
	@ApiModelProperty(value = "退款金额 ")
	private java.math.BigDecimal refund_fee;
	
	@ApiModelProperty(value = "退款时间 ")
	private java.sql.Timestamp refund_date;
	
	
	@ApiModelProperty(value = "订单状态 1待支付2待检测 3检测中 4已完成 5退款待审核 6待退款（退款审核通过）7退款审核不通过 8已退款 9关闭 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "预约日期 ")
	private java.sql.Timestamp order_date;
	
	@ApiModelProperty(value = "检测结果图 长度(200)")
	private java.lang.String check_result_img;
	
	@ApiModelProperty(value = "退款类型 1在线退款 2线下打款 ")
	private java.lang.Integer refund_type;
	
	@ApiModelProperty(value = "创建时间(订单日期) ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_user;
	
	
	// 扩展属性 
	@ApiModelProperty(value = "会员昵称")
	private java.lang.String nickname;
	
	@ApiModelProperty(value = "会员真实姓名")
	private java.lang.String real_name;
	
	@ApiModelProperty(value = "更新人名称")
	private java.lang.String user_name;
	
	
	@ApiModelProperty(value = "车牌号")
	private java.lang.String car_number;
	@ApiModelProperty(value = "监测站名称")
	private java.lang.String station_name;
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public java.lang.Long getStation_id() {
		return station_id;
	}
	public void setStation_id(java.lang.Long station_id) {
		this.station_id = station_id;
	}
	public java.lang.String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(java.lang.String order_no) {
		this.order_no = order_no;
	}
	public java.lang.Long getCar_id() {
		return car_id;
	}
	public void setCar_id(java.lang.Long car_id) {
		this.car_id = car_id;
	}
	public void setCheck_fee(java.math.BigDecimal check_fee){
		this.check_fee=check_fee;
	}
	public java.math.BigDecimal getCheck_fee(){
		return this.check_fee;
	}
	public void setLevel_fee(java.math.BigDecimal level_fee){
		this.level_fee=level_fee;
	}
	public java.math.BigDecimal getLevel_fee(){
		return this.level_fee;
	}
	public void setAll_round_check_fee(java.math.BigDecimal all_round_check_fee){
		this.all_round_check_fee=all_round_check_fee;
	}
	public java.math.BigDecimal getAll_round_check_fee(){
		return this.all_round_check_fee;
	}
	public java.math.BigDecimal getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(java.math.BigDecimal discount_fee) {
		this.discount_fee = discount_fee;
	}
	public java.math.BigDecimal getCoupon_fee() {
		return coupon_fee;
	}
	public void setCoupon_fee(java.math.BigDecimal coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public void setTotal_fee(java.math.BigDecimal total_fee){
		this.total_fee=total_fee;
	}
	public java.math.BigDecimal getTotal_fee(){
		return this.total_fee;
	}
	public void setCoupon_id(java.lang.Long coupon_id){
		this.coupon_id=coupon_id;
	}
	public java.lang.Long getCoupon_id(){
		return this.coupon_id;
	}
	public void setMember_id(java.lang.Long member_id){
		this.member_id=member_id;
	}
	public java.lang.Long getMember_id(){
		return this.member_id;
	}
	public void setTelephone(java.lang.String telephone){
		this.telephone=telephone;
	}
	public java.lang.String getTelephone(){
		return this.telephone;
	}
	public void setService_type(java.lang.Integer service_type){
		this.service_type=service_type;
	}
	public java.lang.Integer getService_type(){
		return this.service_type;
	}
	public void setPay_type(java.lang.Integer pay_type){
		this.pay_type=pay_type;
	}
	public java.lang.Integer getPay_type(){
		return this.pay_type;
	}
	public void setPay_status(java.lang.Integer pay_status){
		this.pay_status=pay_status;
	}
	public java.lang.Integer getPay_status(){
		return this.pay_status;
	}
	public java.sql.Timestamp getPay_date() {
		return pay_date;
	}
	public void setPay_date(java.sql.Timestamp pay_date) {
		this.pay_date = pay_date;
	}
	public void setOut_pay_no(java.lang.String out_pay_no){
		this.out_pay_no=out_pay_no;
	}
	public java.lang.String getOut_pay_no(){
		return this.out_pay_no;
	}
	public void setPay_seller_id(java.lang.String pay_seller_id){
		this.pay_seller_id=pay_seller_id;
	}
	public java.lang.String getPay_seller_id(){
		return this.pay_seller_id;
	}
	public void setPay_buyer_id(java.lang.String pay_buyer_id){
		this.pay_buyer_id=pay_buyer_id;
	}
	public java.lang.String getPay_buyer_id(){
		return this.pay_buyer_id;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setOrder_date(java.sql.Timestamp order_date){
		this.order_date=order_date;
	}
	public java.sql.Timestamp getOrder_date(){
		return this.order_date;
	}
	public void setCheck_result_img(java.lang.String check_result_img){
		this.check_result_img=check_result_img;
	}
	public java.lang.String getCheck_result_img(){
		return this.check_result_img;
	}
	public void setRefund_type(java.lang.Integer refund_type){
		this.refund_type=refund_type;
	}
	public java.lang.Integer getRefund_type(){
		return this.refund_type;
	}
	public void setGmt_create(java.sql.Timestamp gmt_create){
		this.gmt_create=gmt_create;
	}
	public java.sql.Timestamp getGmt_create(){
		return this.gmt_create;
	}
	public void setGmt_modify(java.sql.Timestamp gmt_modify){
		this.gmt_modify=gmt_modify;
	}
	public java.sql.Timestamp getGmt_modify(){
		return this.gmt_modify;
	}
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setUpdate_user(java.lang.Long update_user){
		this.update_user=update_user;
	}
	public java.lang.Long getUpdate_user(){
		return this.update_user;
	}
	public java.lang.String getNickname() {
		return nickname;
	}
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}
	public java.lang.String getReal_name() {
		return real_name;
	}
	public void setReal_name(java.lang.String real_name) {
		this.real_name = real_name;
	}
	public java.math.BigDecimal getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(java.math.BigDecimal refund_fee) {
		this.refund_fee = refund_fee;
	}
	public java.sql.Timestamp getRefund_date() {
		return refund_date;
	}
	public void setRefund_date(java.sql.Timestamp refund_date) {
		this.refund_date = refund_date;
	}
	public java.lang.String getUser_name() {
		return user_name;
	}
	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}
	public java.lang.String getCar_number() {
		return car_number;
	}
	public void setCar_number(java.lang.String car_number) {
		this.car_number = car_number;
	}
	public java.lang.String getStation_name() {
		return station_name;
	}
	public void setStation_name(java.lang.String station_name) {
		this.station_name = station_name;
	}
}
