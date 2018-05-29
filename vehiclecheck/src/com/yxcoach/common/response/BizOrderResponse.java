package com.yxcoach.common.response;


import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Maps;
import com.yxcoach.common.base.constant.NonConfigYxConstants;

/**
 * Created by alan on 15/9/28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BizOrderResponse extends BaseResponse {

    private static final long serialVersionUID = -1635327849144398631L;
    /**
     * 操作是否成功,默认置为true
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String isSucc = "true";
    
    /**
     * 结果返回码,当 isSucc 为 true ,则可不传
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String resultCode = NonConfigYxConstants.OK_RET_CODE;
    
    /**
     * 返回结果信息
     */
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private String resultMessage = NonConfigYxConstants.OK_RET_MSG;
    
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("bizOrders")
    // 签名,支付宝和微信支付可共用,不过生成方式不同
    private String sign;
    // request中原来的sign
    private String oldSign;
    /**
     * 支付宝回调url
     */
    private String callBackUrl;

    /**
     * 微信支付 appId
     */
    private String appid;

    /**
     * 微信支付 商户号
     */
    private String partnerid;

    /**
     * 微信支付预支付 ID
     */
    private String prepayid;

    /**
     * 微信支付 随机数
     */
    private String noncestr;

    /**
     * 微信支付时间戳
     */
    private String timestamp;
    /**
     * H5端返回默认错误信息
     */
    private String errorMsg = "";

    /**
     * 预计行驶里程数
     */
    private String runKm;

    /**
     * 预计行驶分钟数
     */
    private String runMin;

    /**
     * 描述信息
     */
    private String desc;

    /**
     * 预计总费用
     */
    private String totalFee;


    /**
     * 司机平均评价
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Double driverJudgePoint = 0.0d;

    private Long lineId;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机手机号
     */
    private String driverTel;

    /**
     * 车型编号
     */
    private String vehicleNo;

    /**
     * 车系
     */
    private String vehicleSeries;

    /**
     * 行驶时间
     */
    private String runTime;

    /**
     * 行驶里程
     */
    private String runDistance;

    /**
     * 车与人的距离
     */
    private String distance;



    public Long getLineId() {
        return lineId;
    }

    public BizOrderResponse setLineId(Long lineId) {
        this.lineId = lineId;
        return this;
    }

    public BizOrderResponse() {
    }

   

    public String getSign() {
        return sign;
    }

    public BizOrderResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }

    
    public Double getDriverJudgePoint() {
        return driverJudgePoint;
    }

    public BizOrderResponse setDriverJudgePoint(Double driverJudgePoint) {
        this.driverJudgePoint = driverJudgePoint;
        return this;
    }

  

    public String getAppid() {
        return appid;
    }

    public BizOrderResponse setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public BizOrderResponse setPartnerid(String partnerid) {
        this.partnerid = partnerid;
        return this;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public BizOrderResponse setPrepayid(String prepayid) {
        this.prepayid = prepayid;
        return this;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public BizOrderResponse setNoncestr(String noncestr) {
        this.noncestr = noncestr;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public BizOrderResponse setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public BizOrderResponse setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
        return this;
    }

    /**
     * 构造客户端调起微信支付的参数签名数据
     *
     * @return
     */
    public String genWechatPaySign() throws IllegalAccessException {

        Map<String, Object> signSrcMap = Maps.newHashMap();

        signSrcMap.put("appid", appid);
        signSrcMap.put("noncestr", noncestr);
        signSrcMap.put("package", "Sign=WXPay");
        signSrcMap.put("partnerid", partnerid);
        signSrcMap.put("prepayid", prepayid);
        signSrcMap.put("timestamp", timestamp);


        return Signature.getSign(signSrcMap);
    }

    /**
     * 微信公众账号 H5调起微信支付需要的签名参数
     * @return
     * @throws IllegalAccessException
     */
    public String genGZHWechatPaySign() throws IllegalAccessException {

        Map<String, Object> signSrcMap = Maps.newHashMap();

        signSrcMap.put("appId", appid);
        signSrcMap.put("timeStamp", timestamp);
        signSrcMap.put("nonceStr", noncestr);
        signSrcMap.put("package", "prepay_id=" + prepayid);
        signSrcMap.put("signType","MD5");


        return Signature.getSign(signSrcMap);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public BizOrderResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getOldSign() {
        return oldSign;
    }

    public BizOrderResponse setOldSign(String oldSign) {
        this.oldSign = oldSign;
        return this;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public BizOrderResponse setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getRunKm() {
        return runKm;
    }

    public BizOrderResponse setRunKm(String runKm) {
        this.runKm = runKm;
        return this;
    }

    public String getRunMin() {
        return runMin;
    }

    public BizOrderResponse setRunMin(String runMin) {
        this.runMin = runMin;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public BizOrderResponse setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public BizOrderResponse setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public BizOrderResponse setDriverTel(String driverTel) {
        this.driverTel = driverTel;
        return this;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public BizOrderResponse setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        return this;
    }

    public String getVehicleSeries() {
        return vehicleSeries;
    }

    public BizOrderResponse setVehicleSeries(String vehicleSeries) {
        this.vehicleSeries = vehicleSeries;
        return this;
    }

    public String getRunDistance() {
        return runDistance;
    }

    public BizOrderResponse setRunDistance(String runDistance) {
        this.runDistance = runDistance;
        return this;
    }

    public String getRunTime() {
        return runTime;
    }

    public BizOrderResponse setRunTime(String runTime) {
        this.runTime = runTime;
        return this;
    }

    public String getDistance() {
        return distance;
    }

    public BizOrderResponse setDistance(String distance) {
        this.distance = distance;
        return this;
    }

	public String getIsSucc() {
		return isSucc;
	}

	public BaseResponse setIsSucc(String isSucc) {
		 this.isSucc = isSucc;
	     return this;
	}

	public String getResultCode() {
		return resultCode;
	}

	public BaseResponse setResultCode(String resultCode) {
		this.resultCode = resultCode;
		return this;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public BaseResponse setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
		return this;
	}

	
}
