package com.yxcoach.common.push;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;

/**
 * @author fengrx
 * @title SendMsg.java
 * @package com.yxhl.util
 * @description 提供各种方式的短信发送 
 */
public class SendMsg {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(YMRTHttpClient.class);

    /**
     * 发送即时短信操作
     *
     * @param mobile
     * @param message
     */
    public static boolean sendMsgNow(String mobile, String message) throws Exception {
    		boolean flag=false;
    		try {
    			StringBuffer param = new StringBuffer("");
                StringBuffer url = new StringBuffer("");
                String newMessage = URLEncoder.encode("【腾晟云】" + message, "UTF-8");
                long seqId = System.currentTimeMillis();
                param.append("cdkey=").append("6SDK-EMY-6688-JDXPR").append("&password=")
                .append("157698").append("&phone=").
                append(mobile).append("&message=").append(newMessage).append("&seqid=").append(seqId);
                url.append("http://sdk4rptws.eucp.b2m.cn:8080/sdkproxy/").append("sendsms.action");
                String ret = YMRTHttpClient.sendSMS(url.toString(), param.toString());

                //C发送成功保存验证码记录
                if (StringUtils.equalsIgnoreCase(ret, "0")) {
                    // 构造短信记录,并保存
                	System.out.println("send msg result"+mobile+"   :"+newMessage);
                	logger.info("send msg result=[" + ret + "]");
                }
                flag=true;
			} catch (Exception e) {
				flag=false;
			}
            return flag;
       
    }
    public static void main(String[] args) {
    	try {
			SendMsg.sendMsgNow("18773919617", "欢迎您的使用");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

    
}