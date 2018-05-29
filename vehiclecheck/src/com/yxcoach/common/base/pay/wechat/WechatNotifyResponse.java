package com.yxcoach.common.base.pay.wechat;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by alan on 16/1/16.
 */
@XStreamAlias("xml")
public class WechatNotifyResponse {

    /**
     * SUCCESS/FAIL
     */
    @XStreamAlias("return_code")
    private String returnCode;

    /**
     * 返回信息，如非空，为错误原因
     */
    @XStreamAlias("return_msg")
    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public WechatNotifyResponse setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public WechatNotifyResponse setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }
}
