package com.yxcoach.common.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alan on 15/9/28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BizOrderRequest extends BaseRequest {

    private static final long serialVersionUID = -4214752739933819385L;
    /**
     * 登陆账号
     */
    private String mobile;

    

    /**
     * 出发地名称,接驳车/快车使用
     */
    @JsonProperty("start")
    private String startLocation;

    /**
     * 到达地名称,快车使用
     */
    @JsonProperty("end")
    private String endLocation;

    /**
     * 出发地经度,接驳车时使用
     */
    private String lng;
    /**
     * 目的地经度,快车使用
     */
    private String elng;

    /**
     * 出发地纬度,接驳车使用
     */
    private String lat;
    /**
     * 目的地纬度,快车使用
     */
    private String elat;
    /**
     * 出发站点,同时也是接驳车的终点
     */
    private String startStation;

    /**
     * 目的站点
     */
    private String endStation;

    /**
     * 出发城市
     */
    private String startCity;
    /**
     * 出发城市编码
     */
    @JsonProperty("areaCode")
    private String startCityCode;

    /**
     * 到达城市编码
     */
    private String endCityCode;

    /**
     * 到达城市
     */
    private String endCity;

    /**
     * 业务类型
     * 1-预约
     * 2-实时
     */
    private Integer bizType;

    /**
     * 订单来源,如果是 app下单,则传递为 online
     * 如果是线下,则传 offline
     */
    private String src;

    /**
     * 发车时间 yyyy-MM-dd HH:mm
     */
    private String departTime;

    /**
     * 发车开始时间
     */
    private Date departTimeStart;

    /**
     * 发车结束时间
     */
    private Date departTimeEnd;

    /**
     * 票数
     */
    private Integer amount;

    /**
     * 订单支付状态
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("payStatus")
    private Integer[] payStatuses;

    /**
     * 订单乘坐状态
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("rideStatus")
    private Integer[] rideStatuses;

    /**
     * 签名源数据,供支付宝支付使用
     */
    private String signSrc;

    /**
     * 订单流水号,选填,在后续的查询\更新时用得到,而且展示订单信息可以展示这个
     */

    private String orderSerial;

    /**
     * 订单总金额,后台会再计算一次作为校验
     */
    private Double totalFee;




    /**
     * TaskId, 用于实时巴士订单下单时传递
     */
    private Long taskId;

    /**
     * driverId,对应task中的司机 ID, 用于实时巴士订单下单时传递
     */
    private Long driverId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 下单人员
     */
    private String userName;

    /**
     * 用户优惠券记录ID
     */
    private Long couponUserRelId;

    /**
     * 优惠金额
     */
    private Double disCountFee;

    /**
     * 所选车型
     */
    private String vhlType;

    /**
     * 替他人叫车
     */
    private boolean callForOther;

    /**
     * 发送短信给他人标志
     */
    private boolean sendMsgFlag;

    /**
     * 他人手机号
     */
    private String otherMobile;

    /**
     * 租车时长
     */
    private String rentCarTm;

    /**
     * 预计行驶里程
     */
    private String runKm;

    /**
     * 预计行驶分钟
     */
    private String runMin;


    public Integer getType() {
        return type;
    }

    public BizOrderRequest setType(Integer type) {
        this.type = type;
        return this;
    }

    /**
     * 类型,行程管理中,是历史还是当前,当前 now,历史 history
     */

    private Integer type;

    private Long lineId;


    public Long getLineId() {
        return lineId;
    }

    public BizOrderRequest setLineId(Long lineId) {
        this.lineId = lineId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public BizOrderRequest setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public BizOrderRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

   

    public String getLng() {
        return lng;
    }

    public BizOrderRequest setLng(String lng) {
        this.lng = lng;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public BizOrderRequest setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getStartStation() {
        return startStation;
    }

    public BizOrderRequest setStartStation(String startStation) {
        this.startStation = startStation;
        return this;
    }

    public String getEndStation() {
        return endStation;
    }

    public BizOrderRequest setEndStation(String endStation) {
        this.endStation = endStation;
        return this;
    }

    public String getStartCity() {
        return startCity;
    }

    public BizOrderRequest setStartCity(String startCity) {
        this.startCity = startCity;
        return this;
    }

    public String getEndCity() {
        return endCity;
    }

    public BizOrderRequest setEndCity(String endCity) {
        this.endCity = endCity;
        return this;
    }

    public Integer getBizType() {
        return bizType;
    }

    public BizOrderRequest setBizType(Integer bizType) {
        this.bizType = bizType;
        return this;
    }

    public String getSrc() {
        return src;
    }

    public BizOrderRequest setSrc(String src) {
        this.src = src;
        return this;
    }

    public String getDepartTime() {
        return departTime;
    }

    public BizOrderRequest setDepartTime(String departTime) {
        this.departTime = departTime;
        return this;
    }

    public Date getDepartTimeStart() {
        return departTimeStart;
    }

    public BizOrderRequest setDepartTimeStart(Date departTimeStart) {
        this.departTimeStart = departTimeStart;
        return this;
    }

    public Date getDepartTimeEnd() {
        return departTimeEnd;
    }

    public BizOrderRequest setDepartTimeEnd(Date departTimeEnd) {
        this.departTimeEnd = departTimeEnd;
        return this;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public BizOrderRequest setStartLocation(String startLocation) {
        this.startLocation = startLocation;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public BizOrderRequest setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Integer[] getPayStatuses() {
        return payStatuses;
    }

    public BizOrderRequest setPayStatuses(Integer[] payStatuses) {
        this.payStatuses = payStatuses;
        return this;
    }

    public Integer[] getRideStatuses() {
        return rideStatuses;
    }

    public BizOrderRequest setRideStatuses(Integer[] rideStatuses) {
        this.rideStatuses = rideStatuses;
        return this;
    }

    

    public String getSignSrc() {
        return signSrc;
    }

    public BizOrderRequest setSignSrc(String signSrc) {
        this.signSrc = signSrc;
        return this;
    }

    public String getOrderSerial() {
        return orderSerial;
    }

    public BizOrderRequest setOrderSerial(String orderSerial) {
        this.orderSerial = orderSerial;
        return this;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public BizOrderRequest setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
        return this;
    }

   

    public String getStartCityCode() {
        return startCityCode;
    }

    public BizOrderRequest setStartCityCode(String startCityCode) {
        this.startCityCode = startCityCode;
        return this;
    }

    public String getEndCityCode() {
        return endCityCode;
    }

    public BizOrderRequest setEndCityCode(String endCityCode) {
        this.endCityCode = endCityCode;
        return this;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public BizOrderRequest setEndLocation(String endLocation) {
        this.endLocation = endLocation;
        return this;
    }

    public Long getTaskId() {
        return taskId;
    }

    public BizOrderRequest setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public Long getDriverId() {
        return driverId;
    }

    public BizOrderRequest setDriverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    public String getElng() {
        return elng;
    }

    public BizOrderRequest setElng(String elng) {
        this.elng = elng;
        return this;
    }

    public String getElat() {
        return elat;
    }

    public BizOrderRequest setElat(String elat) {
        this.elat = elat;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public BizOrderRequest setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Long getCouponUserRelId() {
        return couponUserRelId;
    }

    public BizOrderRequest setCouponUserRelId(Long couponUserRelId) {
        this.couponUserRelId = couponUserRelId;
        return this;
    }

    public Double getDisCountFee() {
        return disCountFee;
    }

    public BizOrderRequest setDisCountFee(Double disCountFee) {
        this.disCountFee = disCountFee;
        return this;
    }

    public String getVhlType() {
        return vhlType;
    }

    public BizOrderRequest setVhlType(String vhlType) {
        this.vhlType = vhlType;
        return this;
    }

    public boolean isCallForOther() {
        return callForOther;
    }

    public BizOrderRequest setCallForOther(boolean callForOther) {
        this.callForOther = callForOther;
        return this;
    }

    public String getOtherMobile() {
        return otherMobile;
    }

    public BizOrderRequest setOtherMobile(String otherMobile) {
        this.otherMobile = otherMobile;
        return this;
    }

    public String getRentCarTm() {
        return rentCarTm;
    }

    public BizOrderRequest setRentCarTm(String rentCarTm) {
        this.rentCarTm = rentCarTm;
        return this;
    }

    public boolean isSendMsgFlag() {
        return sendMsgFlag;
    }

    public BizOrderRequest setSendMsgFlag(boolean sendMsgFlag) {
        this.sendMsgFlag = sendMsgFlag;
        return this;
    }

    public String getRunMin() {
        return runMin;
    }

    public BizOrderRequest setRunMin(String runMin) {
        this.runMin = runMin;
        return this;
    }

    public String getRunKm() {
        return runKm;
    }

    public BizOrderRequest setRunKm(String runKm) {
        this.runKm = runKm;
        return this;
    }
    
}
