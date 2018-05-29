package com.yxcoach.common.push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;

public class YdSendMsg {

	public static boolean norSubmit(String content,String mobiles) throws UnsupportedEncodingException{

		SubmitReq submitReq = new SubmitReq();
		submitReq.setApId("zssdra");
		submitReq.setEcName("政企分公司测试");
		submitReq.setSecretKey("passwd@1234");
		submitReq.setContent(content);
		submitReq.setMobiles(mobiles);
		submitReq.setAddSerial("");
		submitReq.setSign("DWItALe3A");
		StringBuffer str= new StringBuffer();
		str.append(submitReq.getEcName());
		str.append(submitReq.getApId());
		str.append(submitReq.getSecretKey());
		str.append(submitReq.getMobiles());
		str.append(submitReq.getContent());
		str.append(submitReq.getSign());
		str.append(submitReq.getAddSerial());
		try {
			submitReq.setMac(xxmd5(str.toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("手机手机号码========"+mobiles);  
		String reqText=JSON.toJSONString(submitReq);
		System.out.println(reqText);
		String encode=Base64.encodeBase64String(reqText.getBytes("UTF-8"));
		System.out.println(encode);
		String result=sendPost("http://112.35.1.155:1992/sms/norsubmit",encode);
		YdResp rs=JSON.parseObject(result, YdResp.class);
		return rs.getSuccess().equals("true")?true:false;
	}
	
	public static String xxmd5(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");  
		md5.update((str).getBytes("UTF-8"));  
		byte b[] = md5.digest();  
		  
		int i;  
		StringBuffer buf = new StringBuffer("");  
		  
		for(int offset=0; offset<b.length; offset++){  
		    i = b[offset];  
		    if(i<0){  
		        i+=256;  
		    }  
		    if(i<16){  
		        buf.append("0");  
		    }  
		    buf.append(Integer.toHexString(i));  
		}  
		return buf.toString();
	}
	
	public static void main(String[] args)throws Exception {
		
		
		System.out.println(norSubmit("测试","18773919617"));
	}
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
}

