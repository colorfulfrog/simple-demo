package com.yxcoach.common.base.pay.sign;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.google.common.collect.Maps;
import com.yxcoach.common.base.entity.BaseModel;

/**
 * Created by alan on 15/9/5.
 * 订单 DO
 */
public class BizOrderDO extends BaseModel {
    private static final long serialVersionUID = 2121379921816716454L;
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 父订单 ID若为大车订单,则此 ID为其本身的 orderSerial,若为小车订单,则此 ID 为对应的大车订单的 orderSerial
     */
    private String parentId;

    /**
     * 订单流水号
     */
    private String orderSerial;

    /**
     * 司机id
     */
    private Long driverId;
    /**
     * 司机账户
     */
    private String driverName;
    /**
     * 司机手机号码
     */
    private String driverMobile;

    /**
     * 用户 ID
     */
    private Long userId;
    /**
     * 车辆id
     */
    private Long vehicleId;
    /**
     * 车牌号
     */
    private String vehicleNo;
    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 校验码
     */
    private String verifyCode;

    /**
     * 下单时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 支付时间
     */
    private Date gmtPay;

    /**
     * 订单终结时间,等于上巴士时间
     */
    private Date gmtEnd;

    /**
     * 订单失效时间,等于巴士发车时间
     */
    private Date gmtInvalid;
    /**
     * 不允许支付的时间,预约订单-开车前120分钟,实时订单-下单后10分钟
     */
    private Date gmtStopPay;

    /**
     * 发车时间
     */
    private Date gmtDepart;


    /**
     * 出发地点
     */
    private String start;

    /**
     * 到达地点
     */
    private String destination;


    /**
     * 订单总费用
     */
    private Long totalFee;

    /**
     * 优惠费用
     */
    private Long discountFee;

    /**
     * 订单名称 title
     */
    private String title;

    /**
     * 买票的张数
     */
    private Integer amount;

    /**
     * 单张价格
     */
    private Long price;

    /**
     * 业务类型
     * 1-预约
     * 2-实时
     * 3-拼车(专车)
     */
    private Integer bizType;

    /**
     * 订单来源, online\offline
     */
    private String src;

    /**
     * 订单支付状态
     */
    private Integer payStatus;

    /**
     * 订单乘坐状态
     */
    private Integer rideStatus;

    /**
     * 订单失败原因
     */
    private String failReason;

    /**
     * 乐观锁控制用
     */
    private Integer version;
    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 出发城市
     */
    private String startCity;

    /**
     * 到达城市
     */
    private String endCity;

    /**
     * 外部交易号,比如支付宝交易号
     */
    private String outPayNo;

    /**
     * 外部交易类型,比如支付宝\微信等
     */
    private String outPayType;

    /**
     * 支付中的收款账号 ID
     */
    private String paySellerId;

    /**
     * 支付中的付款账号 ID
     */
    private String payBuyerId;

    /**
     * 实际退款费用
     */
    private Long refundFee;

    /**
     * 最大可退费用
     */
    private Long maxRefundFee;

    /**
     * 退款状态
     * 1-已提交
     * 2-已退款
     */
    private Integer refundStatus;

    /**
     * 调度的时候生成的任务ID
     */
    private Long taskId;

    /**
     * 益阳售票订单号/大巴网系统订单号
     */
    private String orderTradeNo;
    /**
     * 备注
     */
    private String remark;

    /**
     * 订单生成人员
     */
    private String userName;
    /**
     * 订单所属单位
     */
    private String org;
    /**
     * 班次ID
     */
    private String scheduleId;
    /**
     * 线路ID
     * 160525 add by quzefei
     */
    private Long lineId;

    /**
     * 上车时间
     * 161215 added by wangxl
     */
    private Date gmtStart;

   

    public Long getLineId() {
        return lineId;
    }

    public BizOrderDO setLineId(Long lineId) {
        this.lineId = lineId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public BizOrderDO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 订单属性
     */
    private Map<String, String> attributes = Maps.newHashMap();
    
    

    

    /**
     * 默认构造器
     */
    public BizOrderDO() {
    }

    /**
     * alipay 支付成功时需要的构造器
     *
     * @param bizOrderDO
     * @param payTime
     * @param params
     */
    public BizOrderDO(BizOrderDO bizOrderDO, Date payTime, Map<String, String> params) throws IOException {
        BeanUtils.copyProperties(bizOrderDO, this);

        this.setPayStatus(2)
                .setGmtPay(payTime)
                .setOutPayNo(params.get("trade_no"))
                .setOutPayType("ALIPAY")
                .setPaySellerId(params.get("seller_id"))
                .setPayBuyerId(params.get("buyer_id"))
                .setVersion(bizOrderDO.getVersion() + 1);

        //益阳售票 重置取票密码为益阳售票返回密码,不使用支付完成后的随机密码
       /* if (! OrderBizTypeEnum.isIn(bizOrderDO.getBizType(), OrderBizTypeEnum.YYSALE, OrderBizTypeEnum.OBT_DABA_TICKET)) {
            setVerifyCode(RandomUtil.gen8NumbericRandom());
        }*/

        // 如果是主订单,修改其乘车人属性数据
        //  if (bizOrderDO.isMain()) {
        //如果不空进行修改
      
    }

  

    

    /**
     * 微信支付异步消息时对应的构造器---走么支付公用此逻辑
     *
     * @param bizOrderDO
     * @param params
     * @param gmtPay
     */
    public BizOrderDO(BizOrderDO bizOrderDO, Map<String, String> params, Date gmtPay) throws IOException {
        BeanUtils.copyProperties(bizOrderDO, this);

        this.setPayStatus(2)
                .setGmtPay(gmtPay)
                .setOutPayNo(params.get("transaction_id"))
                .setOutPayType("ALIPAY")   //OutPayTypeEnum.WECHAT.getType(),微信,走么支付,公用此类型
                .setPaySellerId(params.get("mch_id"))
                .setPayBuyerId(params.get("openid"))
                .setVersion(bizOrderDO.getVersion() + 1);

    }

   

    public Long getId() {
        return id;
    }

    public BizOrderDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public BizOrderDO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getOrderSerial() {
        return orderSerial;
    }

    public BizOrderDO setOrderSerial(String orderSerial) {
        this.orderSerial = orderSerial;
        return this;
    }

    public Long getDriverId() {
        return driverId;
    }

    public BizOrderDO setDriverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    public String getOutPayNo() {
        return outPayNo;
    }

    public BizOrderDO setOutPayNo(String outPayNo) {
        this.outPayNo = outPayNo;
        return this;
    }

    public String getOutPayType() {
        return outPayType;
    }

    public BizOrderDO setOutPayType(String outPayType) {
        this.outPayType = outPayType;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public BizOrderDO setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public BizOrderDO setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
        return this;
    }

    public Date getGmtDepart() {
        return gmtDepart;
    }

    public BizOrderDO setGmtDepart(Date gmtDepart) {
        this.gmtDepart = gmtDepart;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public BizOrderDO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public BizOrderDO setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public BizOrderDO setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public BizOrderDO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public BizOrderDO setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public BizOrderDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public BizOrderDO setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
        return this;
    }

    public Date getGmtPay() {
        return gmtPay;
    }

    public BizOrderDO setGmtPay(Date gmtPay) {
        this.gmtPay = gmtPay;
        return this;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public BizOrderDO setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
        return this;
    }

    public String getOrderTradeNo() {
        return orderTradeNo;
    }

    public BizOrderDO setOrderTradeNo(String orderTradeNo) {
        this.orderTradeNo = orderTradeNo;
        return this;
    }

    public Date getGmtInvalid() {
        return gmtInvalid;
    }

    public BizOrderDO setGmtInvalid(Date gmtInvalid) {
        this.gmtInvalid = gmtInvalid;
        return this;
    }

    public Date getGmtStopPay() {
        return gmtStopPay;
    }

    public BizOrderDO setGmtStopPay(Date gmtStopPay) {
        this.gmtStopPay = gmtStopPay;
        return this;
    }

    public String getStart() {
        return start;
    }

    public BizOrderDO setStart(String start) {
        this.start = start;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public BizOrderDO setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public BizOrderDO setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public Long getDiscountFee() {
        return discountFee;
    }

    public BizOrderDO setDiscountFee(Long discountFee) {
        this.discountFee = discountFee;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BizOrderDO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public BizOrderDO setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public BizOrderDO setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Integer getBizType() {
        return bizType;
    }

    public BizOrderDO setBizType(Integer bizType) {
        this.bizType = bizType;
        return this;
    }

    public String getSrc() {
        return src;
    }

    public BizOrderDO setSrc(String src) {
        this.src = src;
        return this;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public BizOrderDO setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public Integer getRideStatus() {
        return rideStatus;
    }

    public BizOrderDO setRideStatus(Integer rideStatus) {
        this.rideStatus = rideStatus;
        return this;
    }

    public String getFailReason() {
        return failReason;
    }

    public BizOrderDO setFailReason(String failReason) {
        this.failReason = failReason;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public BizOrderDO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public BizOrderDO setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public BizOrderDO setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getStartCity() {
        return startCity;
    }

    public BizOrderDO setStartCity(String startCity) {
        this.startCity = startCity;
        return this;
    }

    public String getEndCity() {
        return endCity;
    }

    public BizOrderDO setEndCity(String endCity) {
        this.endCity = endCity;
        return this;
    }

    public String getPaySellerId() {
        return paySellerId;
    }

    public BizOrderDO setPaySellerId(String paySellerId) {
        this.paySellerId = paySellerId;
        return this;
    }

    public String getPayBuyerId() {
        return payBuyerId;
    }

    public BizOrderDO setPayBuyerId(String payBuyerId) {
        this.payBuyerId = payBuyerId;
        return this;
    }

    public Long getRefundFee() {
        return refundFee;
    }

    public BizOrderDO setRefundFee(Long refundFee) {
        this.refundFee = refundFee;
        return this;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public BizOrderDO setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public BizOrderDO setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * 获取单个属性
     *
     * @param name
     * @return
     */
    public String getAttribute(String name) {
        return this.attributes.get(name);
    }

    /**
     * 增加单个属性
     *
     * @param name
     * @param value
     */
    public void addAttribute(String name, String value) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("attribute name is null");
        }

        if (null == this.attributes) {
            this.attributes = Maps.newHashMap();
        }
        this.attributes.put(name, value);
    }

    /**
     * 增加批量属性
     *
     * @param attributes
     */
    public void addAttributes(Map<String, String> attributes) {
        if (null == attributes) {
            return;
        }

        if (null == this.attributes) {
            this.attributes = Maps.newHashMap();
        }

        this.attributes.putAll(attributes);
    }

    /**
     * 获取所有的属性 key
     *
     * @return
     */
    public Set<String> getAttributesKeys() {
        if (null == this.attributes) {
            this.attributes = Maps.newHashMap();
        }
        return this.attributes.keySet();
    }




    public Long getMaxRefundFee() {
        return maxRefundFee;
    }

    public BizOrderDO setMaxRefundFee(Long maxRefundFee) {
        this.maxRefundFee = maxRefundFee;
        return this;
    }

    public Long getTaskId() {
        return taskId;
    }

    public BizOrderDO setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    

   

    /**
     * 判断是否包含这个属性
     *
     * @param key
     * @return
     */
    public boolean containAttr(String key) {
        return attributes.containsKey(key);
    }

    

    public String getOrg() {
        return org;
    }

    public BizOrderDO setOrg(String org) {
        this.org = org;
        return this;
    }


    






    public Date getGmtStart() {
        return gmtStart;
    }

    public BizOrderDO setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
        return this;
    }
}
