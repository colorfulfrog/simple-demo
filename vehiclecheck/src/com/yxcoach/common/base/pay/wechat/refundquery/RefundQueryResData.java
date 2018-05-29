package com.yxcoach.common.base.pay.wechat.refundquery;

/**
 * Created by alan on 16/1/16.
 * 退款响应数据
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class RefundQueryResData {
    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String sign = "";


    private String device_info = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private int refund_count = 0;

    private String out_refund_no = "";
    private String refund_id = "";
    private String refund_channel = "";
    private String refund_fee = "";
    private String coupon_refund_fee = "";
    private String refund_status = "";


    public String getReturn_code() {
        return return_code;
    }

    public RefundQueryResData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public RefundQueryResData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public RefundQueryResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public RefundQueryResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public RefundQueryResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public RefundQueryResData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public RefundQueryResData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public RefundQueryResData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public RefundQueryResData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public RefundQueryResData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public RefundQueryResData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public RefundQueryResData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public int getRefund_count() {
        return refund_count;
    }

    public RefundQueryResData setRefund_count(int refund_count) {
        this.refund_count = refund_count;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public RefundQueryResData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public RefundQueryResData setRefund_id(String refund_id) {
        this.refund_id = refund_id;
        return this;
    }

    public String getRefund_channel() {
        return refund_channel;
    }

    public RefundQueryResData setRefund_channel(String refund_channel) {
        this.refund_channel = refund_channel;
        return this;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public RefundQueryResData setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
        return this;
    }

    public String getCoupon_refund_fee() {
        return coupon_refund_fee;
    }

    public RefundQueryResData setCoupon_refund_fee(String coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
        return this;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public RefundQueryResData setRefund_status(String refund_status) {
        this.refund_status = refund_status;
        return this;
    }
}
