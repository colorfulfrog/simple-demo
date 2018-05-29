package com.yxcoach.common.base.pay.wechat.refundquery;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alan on 16/1/16.
 * 用来存放退款订单数据
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class RefundOrderData {

    private String outRefundNo = "";//商户退款单号
    private String refundID = "";//微信退款单号
    private String refundChannel = "";//退款渠道
    //    IGINAL--原路退款
    //    BALANCE--退回到余额
    private int refundFee = 0;//退款金额
    private int couponRefundFee = 0;//企业红包退款金额
    private String refundStatus = "";//退款状态

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public RefundOrderData setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
        return this;
    }

    public String getRefundID() {
        return refundID;
    }

    public RefundOrderData setRefundID(String refundID) {
        this.refundID = refundID;
        return this;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public RefundOrderData setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
        return this;
    }

    public int getRefundFee() {
        return refundFee;
    }

    public RefundOrderData setRefundFee(int refundFee) {
        this.refundFee = refundFee;
        return this;
    }

    public int getCouponRefundFee() {
        return couponRefundFee;
    }

    public RefundOrderData setCouponRefundFee(int couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
        return this;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public RefundOrderData setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public String toMap() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder s = new StringBuilder("{");

        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    if (s.length() > 0) {
                        s.append(" ");
                    }
                    s.append(field.getName());
                    s.append("=");
                    s.append(obj.toString());
//                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        s.append("}");
        return s.toString();
    }

}
