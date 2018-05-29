package com.yxcoach.common.base.pay.wechat.payquery;

/**
 * Created by yangzhipeng on 18/4/21.
 */
public class PayQueryResData {

    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String appid = "";
    private String mch_id = "";
    private String sub_mch_id = "";//新增
    private String nonce_str = "";
    private String sign = "";
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";

    //以下字段在return_code 和result_code 都为SUCCESS 的时候有返回
    private String trade_state = "";

    //trade_state的几种可能取值：
    //    SUCCESS--支付成功
    //    REFUND--转入退款
    //    NOTPAY--未支付
    //    CLOSED--已关闭
    //    REVOKED--已撤销
    //    USERPAYING--用户支付中
    //    NOPAY--未支付(确认支付超时)
    //    PAYERROR--支付失败(其他原因，
    //            如银行返回失败)

    //以下字段在trade_state 为SUCCESS 或者REFUND 的时候有返回
    private String device_info = "";
    private String openid = "";
    private String is_subscribe = "";
    private String trade_type = "";
    private String bank_type = "";
    private String total_fee = "";
    private String coupon_fee = "";
    private String fee_type = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String attach = "";
    private String time_end = "";

    public String getReturn_code() {
        return return_code;
    }

    public PayQueryResData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public PayQueryResData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public PayQueryResData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public PayQueryResData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public PayQueryResData setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public PayQueryResData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayQueryResData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public PayQueryResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public PayQueryResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public PayQueryResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public PayQueryResData setTrade_state(String trade_state) {
        this.trade_state = trade_state;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public PayQueryResData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public PayQueryResData setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public PayQueryResData setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public PayQueryResData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public PayQueryResData setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public PayQueryResData setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getCoupon_fee() {
        return coupon_fee;
    }

    public PayQueryResData setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public PayQueryResData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public PayQueryResData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public PayQueryResData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public PayQueryResData setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public PayQueryResData setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }
}
