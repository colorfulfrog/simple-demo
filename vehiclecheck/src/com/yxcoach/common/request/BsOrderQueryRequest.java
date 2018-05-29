package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:订单表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-10
 */
@ApiModel(value = "BsOrderQueryRequest", description = "订单表 rquest分页查询对象")
public class BsOrderQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	
	/**订单编号**/
	private String order_no;
	
	/**状态   用于账务流水状态查询
	 *  全部       0   [2待检测 3检测中  4已完成  5退款待审核 6待退款（退款审核通过） 7退款审核不通过 8已退款]
	 *	已支付   1   [2待检测 3检测中  4已完成  5退款待审核 7退款审核不通过]
	 *	退款中   2   [6待退款（退款审核通过）]
	 *	已退款   3   [8已退款]
	 * **/
	private Integer query_status;
	
	/**开始时间**/
	private String startDate;
	
	/**结束时间**/
	private String endDate;
	
	
	/**状态   用于退款单列表状态查询
	 *  全部               0     [5退款待审核 6待退款（退款审核通过） 7退款审核不通过 8已退款]
	 *	待审核           1     5 退款待审核
	 *	审核不通过   2     7 退款审核不通过
	 *	待退款           3     6 待退款（退款审核通过）
	 *  已退款           4     8 已退款
	 * **/
	private Integer refund_status;
	
	/** 退款类型 1在线退款 2线下打款 **/	
	private Integer refund_type;
	
	/** 更新人姓名  **/	
	private String gmt_user;
	
	
	//针对后台订单查询接口参数 begin
	  
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "检测站ID")
	private java.lang.Long station_id;
	@ApiModelProperty(value = "检测站名称")
	private java.lang.Integer  station_name;
	
//	@ApiModelProperty(value = "订单号 长度(45) 必填")
//	private java.lang.String order_no;
	//联系电话
	@ApiModelProperty(value = "预约用户手机号")
	private java.lang.String telephone;
	//车牌号
	private String car_number;
	//预约时间
	
	private java.sql.Timestamp order_start_date;
	private java.sql.Timestamp order_end_date;

	//订单状态
	@ApiModelProperty(value = "订单状态 1待支付2待检测 3检测中 4已完成 5退款待审核 6待退款（退款审核通过）7退款审核不通过 8已退款 9关闭 ")
	private java.lang.Integer status;
	//针对后台订单查询接口参数 end
	
	
	//后台(订单查询后台 修改 /取消 / 上传检测结果)
	@ApiModelProperty(value = " 1修改 2取消  3上传检测结果 ")
	private java.lang.String operation_type;
	
	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	
	public Integer getQuery_status() {
		return query_status;
	}

	public void setQuery_status(Integer query_status) {
		this.query_status = query_status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getRefund_status() {
		return refund_status;
	}

	public void setRefund_status(Integer refund_status) {
		this.refund_status = refund_status;
	}

	public Integer getRefund_type() {
		return refund_type;
	}

	public void setRefund_type(Integer refund_type) {
		this.refund_type = refund_type;
	}

	public String getGmt_user() {
		return gmt_user;
	}

	public void setGmt_user(String gmt_user) {
		this.gmt_user = gmt_user;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getStation_id() {
		return station_id;
	}

	public void setStation_id(java.lang.Long station_id) {
		this.station_id = station_id;
	}

	public java.lang.Integer getStation_name() {
		return station_name;
	}

	public void setStation_name(java.lang.Integer station_name) {
		this.station_name = station_name;
	}

	public java.lang.String getTelephone() {
		return telephone;
	}

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	public java.sql.Timestamp getOrder_start_date() {
		return order_start_date;
	}

	public void setOrder_start_date(java.sql.Timestamp order_start_date) {
		this.order_start_date = order_start_date;
	}

	public java.sql.Timestamp getOrder_end_date() {
		return order_end_date;
	}

	public void setOrder_end_date(java.sql.Timestamp order_end_date) {
		this.order_end_date = order_end_date;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public java.lang.String getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(java.lang.String operation_type) {
		this.operation_type = operation_type;
	}
}
