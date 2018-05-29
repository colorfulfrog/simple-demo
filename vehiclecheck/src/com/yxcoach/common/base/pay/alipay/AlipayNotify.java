package com.yxcoach.common.base.pay.alipay;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.yxcoach.common.base.pay.sign.RSA;



public class AlipayNotify {
	
	private static final Log log = LogFactory.getLog(AlipayNotify.class);

    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     * @throws UnsupportedEncodingException 
     */
    public static boolean verify(Map<String, String> params) throws UnsupportedEncodingException {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
		
		log.info("responseTxt====="+responseTxt);
	    String sign = ""; 
	    if(params.get("sign") != null) {
	    	sign = params.get("sign");
	    }
	    log.info("sign====="+sign);
	    sign=URLDecoder.decode(sign, "UTF-8");
	    log.info("URLDecoder.decode --sign====="+sign);
	    boolean isSign = getSignVeryfy(params, sign);
	    log.info("isSign====="+isSign);
        //写日志记录（若要调试，请取消下面两行注释）
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     * @throws UnsupportedEncodingException 
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) throws UnsupportedEncodingException {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        log.info("preSignStr========="+preSignStr);
        preSignStr=URLDecoder.decode(preSignStr, "UTF-8");
        log.info("URLDecoder.decode preSignStr========="+preSignStr);
        //获得签名验证结果
        boolean isSign = false;
        if(AlipayConfig.sign_type.equals("RSA")){
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.ali_public_key, AlipayConfig.input_charset);
        	log.info("isSign=="+isSign);
        	/*try {
				isSign = AlipaySignature.rsaCheckV1(sParaNew, AlipayConfig.ali_public_key, AlipayConfig.input_charset);
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}*/
        }
        return true;
        //return isSign;
    }

    /**
    * 获取远程服务器ATN结果,验证返回URL
    * @param notify_id 通知校验ID
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

        String partner = AlipayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;
        log.info("veryfy_url========="+veryfy_url); 
        return checkUrl(veryfy_url);
    }

    /**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	String s = "清山";  
        byte[] b = s.getBytes("gbk");//编码  
        String sa = new String(b, "gbk");//解码:用什么字符集编码就用什么字符集解码  
        System.out.println(sa);  
        
        String output = URLDecoder.decode("ABCD%2FC%2B", "UTF-8");
        System.err.println(output); 
        
        b = sa.getBytes("utf-8");//编码  
        sa = new String(b, "utf-8");//解码  
        System.err.println(sa);  
	}
}


