package com.yxcoach.common.base.interceptor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yxcoach.common.base.util.CheckLogin;
import com.yxcoach.common.base.util.JsonMapperCache;
import com.yxcoach.common.request.TokenRequest;

public class AppUserAccessApiInterceptor extends
		HandlerInterceptorAdapter {
private static final Log log = LogFactory.getLog(AppUserAccessApiInterceptor.class);
	
	@Resource(name = "CheckLogin")
	public CheckLogin checkLogin;

    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
    	
    	String bodyParam = getBodyString(request);
    	log.info(bodyParam);
    	TokenRequest token=JsonMapperCache.getInstance().fromJson(bodyParam, TokenRequest.class);    
    	
    	String servletPath=request.getServletPath();
    	log.info(servletPath);
    	if(servletPath.equals("/c/app/loginController/login") || servletPath.equals("/c/app/loginController/foryzm") || servletPath.equals("/c/app/cUserController/add") || servletPath.equals("/c/app/cUserController/updateForyzm") || servletPath.equals("/c/client/bsHomePageController/selectHomePage") || servletPath.equals("/c/app/cUserController/addUser")){
    		return super.preHandle(request, response, handler);
    	}
    	
    	// body中前台传入的参数  
		if (token != null) {
			boolean flag = checkLogin.APPLogin(token.getToken(), request,
					response);
			if (!flag) {
				return false;
			}

		}
		return super.preHandle(request, response, handler);
    }  
  
  
  
    /** 
     * 获取请求Body 
     * 
     * @param request 
     * @return 
     */  
    public static String getBodyString(final ServletRequest request) {
    	
        StringBuilder sb = new StringBuilder();  
        InputStream inputStream = null;  
        BufferedReader reader = null;  
        try {  
            inputStream = cloneInputStream(request.getInputStream());  
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));  
            String line = "";  
            while ((line = reader.readLine()) != null) {  
                sb.append(line);  
            }  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  
        finally {  
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                }  
                catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (reader != null) {  
                try {  
                    reader.close();  
                }  
                catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return sb.toString();  
    }  
  
    /** 
     * Description: 复制输入流</br> 
     *  
     * @param inputStream 
     * @return</br> 
     */  
    public static InputStream cloneInputStream(ServletInputStream inputStream) {  
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len;  
        try {  
            while ((len = inputStream.read(buffer)) > -1) {  
                byteArrayOutputStream.write(buffer, 0, len);  
            }  
            byteArrayOutputStream.flush();  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());  
        return byteArrayInputStream;  
    }  

}
