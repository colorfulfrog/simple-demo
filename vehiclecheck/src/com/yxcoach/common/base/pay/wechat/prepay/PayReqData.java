package com.yxcoach.common.base.pay.wechat.prepay;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.yxcoach.common.base.util.RandomUtil;
import com.yxcoach.common.response.Signature;

/**
 * Created by alan on 16/1/16.
 * 请求支付API需要提交的数据
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class PayReqData {

    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "";
    private String product_id = "";
    private String limit_pay = "";
    private String openid = "";


    /**
     * @param body           要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
     * @param detail         商品详细信息
     * @param attach         支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
     * @param outTradeNo     商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
     * @param feeType        符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     * @param totalFee       订单总金额，单位为“分”，只能整数
     * @param deviceInfo     商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * @param spBillCreateIP 订单生成的机器IP
     * @param timeStart      订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
     * @param timeExpire     订单失效时间，格式同上
     * @param goodsTag       商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
     * @param notifyUrl      异步回调地址
     * @param tradeType      取值如下：JSAPI，NATIVE，APP
     * @param productId      trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
     * @param limitPay       no_credit--指定不能使用信用卡支付
     * @param openId         trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
     */
    public PayReqData(
                      String appid,
                      String mchId,
                      String body,
                      String detail,
                      String attach,
                      String outTradeNo,
                      String feeType,
                      int totalFee,
                      String deviceInfo,
                      String spBillCreateIP,
                      String timeStart,
                      String timeExpire,
                      String goodsTag,
                      String notifyUrl,
                      String tradeType,
                      String productId,
                      String limitPay,
                      String openId) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        this.setAppid(appid)

                //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
                .setMch_id(mchId)

                //要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
                .setBody(body)
                .setDetail(detail)

                //支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回，有助于商户自己可以注明该笔消费的具体内容，方便后续的运营和记录
                .setAttach(attach)

                //商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
                .setOut_trade_no(outTradeNo)

                .setFee_type(feeType)

                //订单总金额，单位为“分”，只能整
                .setTotal_fee(totalFee)

                //商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
                .setDevice_info(deviceInfo)

                //订单生成的机器IP
                .setSpbill_create_ip(spBillCreateIP)

                //订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
                .setTime_start(timeStart)

                //订单失效时间，格式同上
                .setTime_expire(timeExpire)

                //商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
                .setGoods_tag(goodsTag)
                .setNotify_url(notifyUrl)
                .setTrade_type(tradeType)
                .setProduct_id(productId)
                .setLimit_pay(limitPay)
                .setOpenid(openId)

                //随机字符串，不长于32 位
                .setNonce_str(RandomUtil.generateRandomCode(32))

                //把签名数据设置到Sign这个属性中
                .setSign(Signature.getSign(toMap()));

    }

    public String getAppid() {
        return appid;
    }

    public PayReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public PayReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public PayReqData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public PayReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getBody() {
        return body;
    }

    public PayReqData setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public PayReqData setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public PayReqData setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public PayReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public PayReqData setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public PayReqData setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public PayReqData setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
        return this;
    }

    public String getTime_start() {
        return time_start;
    }

    public PayReqData setTime_start(String time_start) {
        this.time_start = time_start;
        return this;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public PayReqData setTime_expire(String time_expire) {
        this.time_expire = time_expire;
        return this;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public PayReqData setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
        return this;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public PayReqData setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public PayReqData setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getProduct_id() {
        return product_id;
    }

    public PayReqData setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public PayReqData setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public PayReqData setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
