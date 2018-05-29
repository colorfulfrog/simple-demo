package com.yxcoach.common.base.pay.wechat.prepay;


/**
 * Created by alan on 16/1/16.
 * 支付提交Post数据给到API之后，API会返回XML格式的数据，这个类用来装这些数据
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class PayResData {
    //协议层
    private String return_code = "";
    private String return_msg = "";

    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String sign = "";
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";

    private String device_info = "";

    //业务返回的具体数据（以下字段在return_code 和result_code 都为SUCCESS 的时候有返回）
    private String trade_type = "";
    private String prepay_id = "";
    private String code_url = "";

    public String getReturn_code() {
        return return_code;
    }

    public PayResData setReturn_code(String return_code) {
        this.return_code = return_code;
        return this;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public PayResData setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public PayResData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public PayResData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public PayResData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayResData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult_code() {
        return result_code;
    }

    public PayResData setResult_code(String result_code) {
        this.result_code = result_code;
        return this;
    }

    public String getErr_code() {
        return err_code;
    }

    public PayResData setErr_code(String err_code) {
        this.err_code = err_code;
        return this;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public PayResData setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public PayResData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public PayResData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public PayResData setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
        return this;
    }

    public String getCode_url() {
        return code_url;
    }

    public PayResData setCode_url(String code_url) {
        this.code_url = code_url;
        return this;
    }
}
