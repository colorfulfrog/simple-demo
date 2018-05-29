package com.yxcoach.common.base.pay.wechat.refundquery;



import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.yxcoach.common.base.constant.ConstantsKey;
import com.yxcoach.common.base.constant.YXContants;
import com.yxcoach.common.base.util.RandomUtil;
import com.yxcoach.common.response.Signature;

/**
 * Created by alan on 16/1/16.
 * 退款查询请求数据
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class RefundQueryReqData {
    //每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no;
    private String refund_id;

    /**
     * 请求退款查询服务
     *
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo    商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @param deviceInfo    微信支付分配的终端设备号，与下单一致
     * @param outRefundNo   商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     * @param refundID      来自退款API的成功返回，微信退款单号refund_id、out_refund_no、out_trade_no 、transaction_id 四个参数必填一个，如果同事存在优先级为：refund_id>out_refund_no>transaction_id>out_trade_no
     */

    public RefundQueryReqData(String transactionID, String outTradeNo, String deviceInfo, String outRefundNo, String refundID) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        this.setAppid(YXContants.getConfigValue(ConstantsKey.WechatConfig.WECHAT_ZOUME_APPID))

                //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
                .setMch_id(YXContants.getConfigValue(ConstantsKey.WechatConfig.WECHAT_ZOUME_MERCHANTID))

                //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
                .setTransaction_id(transactionID)

                //商户系统自己生成的唯一的订单号
                .setOut_trade_no(outTradeNo)

                //微信支付分配的终端设备号，与下单一致
                .setDevice_info(deviceInfo)
                .setOut_refund_no(outRefundNo)

                //商户系统自己管理的退款号，商户自身必须保证这个号在系统内唯一
                .setRefund_id(refundID)

                //随机字符串，不长于32 位
                .setNonce_str(RandomUtil.generateRandomCode(32))

                //根据API给的签名规则进行签名
                .setSign(Signature.getSign(toMap()));//把签名数据设置到Sign这个属性中

    }

    public String getAppid() {
        return appid;
    }

    public RefundQueryReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public RefundQueryReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getDevice_info() {
        return device_info;
    }

    public RefundQueryReqData setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public RefundQueryReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public RefundQueryReqData setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public RefundQueryReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public RefundQueryReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public RefundQueryReqData setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
        return this;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public RefundQueryReqData setRefund_id(String refund_id) {
        this.refund_id = refund_id;
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