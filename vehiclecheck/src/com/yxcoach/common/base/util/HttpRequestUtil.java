package com.yxcoach.common.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * http请求帮助类
 */
public class HttpRequestUtil {
	private static final Log log = LogFactory.getLog(HttpRequestUtil.class);
	/**
	 * get请求 
	 * @param requestUrl 请求的url
	 * @param map 请求参数
	 * @return
	 */
	public static String doGet(String requestUrl,Map<String, String> map){
	
		String param="";
		if(map!=null && map.size()!=0){
			Iterator<Map.Entry<String, String>> it=map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, String> me=it.next();
				param=param+"&"+me.getKey()+"="+me.getValue();
			}
			param=param.substring(1);
		}
		if(requestUrl.indexOf("?")!=-1){
			requestUrl=requestUrl+"&"+param;
		}else{
			requestUrl=requestUrl+"?"+param;
		}
		URL url;
		InputStream inputStream = null;
		InputStreamReader isr=null;
		BufferedReader in=null;
		try {
			url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			httpconn.setRequestMethod("GET");
			httpconn.setDoOutput(true);
			httpconn.setDoInput(true);
			httpconn.setUseCaches(false);
			httpconn.setConnectTimeout(30000);
			httpconn.setReadTimeout(30000);
			httpconn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;");

			inputStream = httpconn.getInputStream();
			isr = new InputStreamReader(inputStream,"UTF-8");
			in = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer("");
			while (null != (inputLine = in.readLine())) {
				buffer.append(inputLine);
			}
			log.info("api返回："+buffer);
			return buffer.toString();
		} catch (Exception e) {
			log.error("api返回错误："+e);
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * get请求 
	 * @param requestUrl 请求的url
	 * @param map 请求参数
	 * @return
	 */
	public static String doGet(String requestUrl){
	
		URL url;
		InputStream inputStream = null;
		InputStreamReader isr=null;
		BufferedReader in=null;
		try {
			url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			httpconn.setRequestMethod("GET");
			httpconn.setDoOutput(true);
			httpconn.setDoInput(true);
			httpconn.setUseCaches(false);
			httpconn.setConnectTimeout(30000);
			httpconn.setReadTimeout(30000);
			httpconn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;");

			inputStream = httpconn.getInputStream();
			isr = new InputStreamReader(inputStream,"UTF-8");
			in = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer("");
			while (null != (inputLine = in.readLine())) {
				buffer.append(inputLine);
			}
			log.info("api返回："+buffer);
			return buffer.toString();
		} catch (Exception e) {
			log.error("api返回错误："+e);
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * post请求 
	 * @param requestUrl 请求的url
	 * @param map 请求参数
	 * @return
	 */
	public static String doPost(String requestUrl,Map<String, String> map){
		String param="";
		if(map!=null && map.size()!=0){
			Iterator<Map.Entry<String, String>> it=map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, String> me=it.next();
				param=param+"&"+me.getKey()+"="+me.getValue();
			}
			param=param.substring(1);
		}
		URL url;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		InputStreamReader isr=null;
		BufferedReader in=null;
		log.info("请求参数："+param);
		try {
			url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			httpconn.setRequestMethod("POST");
			httpconn.setDoOutput(true);
			httpconn.setDoInput(true);
			httpconn.setUseCaches(false);
			httpconn.setConnectTimeout(30000);
			httpconn.setReadTimeout(30000);
			httpconn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;");

			outputStream = httpconn.getOutputStream();
			OutputStreamWriter outer = new OutputStreamWriter(outputStream,"UTF-8");
			outer.write(param);
			outer.flush();

			inputStream = httpconn.getInputStream();
			isr = new InputStreamReader(inputStream,"UTF-8");
			in = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer("");
			while (null != (inputLine = in.readLine())) {
				buffer.append(inputLine);
			}
			
			log.info("api返回："+buffer);
			return buffer.toString();
		} catch (Exception e) {
			log.error("api返回错误："+e);
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * post请求 
	 * @param requestUrl 请求的url
	 * @param map 请求参数
	 * @return
	 */
	public static String doPost(String requestUrl,String param){
		String paramStr="";
		if(param!=null){
			paramStr=param;
		}
		URL url;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		InputStreamReader isr=null;
		BufferedReader in=null;
		try {
			url = new URL(requestUrl);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			httpconn.setRequestMethod("POST");
			httpconn.setDoOutput(true);
			httpconn.setDoInput(true);
			httpconn.setUseCaches(false);
			httpconn.setConnectTimeout(30000);
			httpconn.setReadTimeout(30000);
			httpconn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;");

			outputStream = httpconn.getOutputStream();
			OutputStreamWriter outer = new OutputStreamWriter(outputStream,"UTF-8");
			outer.write(paramStr);
			outer.flush();

			inputStream = httpconn.getInputStream();
			isr = new InputStreamReader(inputStream,"UTF-8");
			in = new BufferedReader(isr);
			String inputLine;
			StringBuffer buffer = new StringBuffer("");
			while (null != (inputLine = in.readLine())) {
				buffer.append(inputLine);
			}
			
			log.info("api返回："+buffer);
			return buffer.toString();
		} catch (Exception e) {
			log.error("api返回错误："+e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
