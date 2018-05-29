package com.yxcoach.common.base.pay.wechat.payquery;




import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.yxcoach.common.base.constant.ConstantsKey;
import com.yxcoach.common.base.constant.YXContants;
import com.yxcoach.common.base.util.RandomUtil;
import com.yxcoach.common.response.Signature;

/**
 *  Created by yangzhipeng on 18/4/21.
 * 请求订单查询
 * 这种变量命名,只是为了适配微信支付标签,不建议,还是用驼峰式
 */
public class PayQueryReqData {

    private String appid = "";
    private String mch_id = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String nonce_str = "";
    private String sign = "";

    /**
     * 请求支付查询服务
     *
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo    商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @return API返回的XML数据
     * @throws Exception
     */
    public PayQueryReqData(String transactionID, String outTradeNo) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        this.setAppid(YXContants.getConfigValue(ConstantsKey.WechatConfig.WECHAT_ZOUME_APPID))

                //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
                .setMch_id(YXContants.getConfigValue(ConstantsKey.WechatConfig.WECHAT_ZOUME_MERCHANTID))

                //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
                .setTransaction_id(transactionID)

                //商户系统自己生成的唯一的订单号
                .setOut_trade_no(outTradeNo)

                //随机字符串，不长于32 位
                .setNonce_str(RandomUtil.generateRandomCode(32))

                //根据API给的签名规则进行签名
                //把签名数据设置到Sign这个属性中
                .setSign(Signature.getSign(toMap()));
    }

    public String getAppid() {
        return appid;
    }

    public PayQueryReqData setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMch_id() {
        return mch_id;
    }

    public PayQueryReqData setMch_id(String mch_id) {
        this.mch_id = mch_id;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public PayQueryReqData setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public PayQueryReqData setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public PayQueryReqData setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public PayQueryReqData setSign(String sign) {
        this.sign = sign;
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
