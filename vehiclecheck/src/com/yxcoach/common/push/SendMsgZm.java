package com.yxcoach.common.push;

import java.net.URLEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
/**
 * @author fengrx
 * @title SendMsg.java
 * @package com.yxhl.util
 * @description 提供各种方式的短信发送 （SendMsgZm   Zm =走么）
 */
public class SendMsgZm {
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
	                String newMessage = URLEncoder.encode("【走么】" + message, "UTF-8");
	                long seqId = System.currentTimeMillis();
	                param.append("cdkey=").append("6SDK-EMY-6688-JDXPR").append("&password=")
	                .append("157698").append("&phone=").
	                append(mobile).append("&message=").append(newMessage).append("&seqid=").append(seqId);
	                url.append("http://sdk4rptws.eucp.b2m.cn:8080/sdkproxy/").append("sendsms.action");
	                System.out.println(url.toString());
//	                String ret = YMRTHttpClient.sendSMS(url.toString(), param.toString());
//
//	                //C发送成功保存验证码记录
//	                if (StringUtils.equalsIgnoreCase(ret, "0")) {
//	                    // 构造短信记录,并保存
//	                	flag=true;
//	                	System.out.println("send msg result"+mobile+"   :"+newMessage);
//	                	logger.info("send msg result=[" + ret + "]");
//	                }
				} catch (Exception e) {
					// TODO: handle exception
				}
	            return flag;
	       
	    }
	    public static void main(String[] args) {
	    	try {
	    		//逗号分隔, 最多每次200个 phone
				boolean ss =SendMsgZm.sendMsgNow("18670032796", "欢迎您的使用");
				System.out.println(ss+" ---------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
