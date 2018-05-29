package com.yxcoach.controller;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.exception.CredentialsException;
import com.yxcoach.common.base.exception.ExpiredCredentialsException;
import com.yxcoach.common.base.exception.UnauthenticatedException;
import com.yxcoach.common.base.exception.YxBizException;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.dao.BsMemberDAO;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.response.BaseResponse;
public abstract class BaseController {
	private static final Log log = LogFactory.getLog(BaseController.class);
	
	@Resource(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate;
	@Value("${redis.token.key}")
	public String SYS_USER_TOKEN;
	@Value("${redis.token.expire}")
	public Long SYS_USER_TOKEN_EXPIRE;
	
	/**
	 * 综合调度app key
	 */
	@Value("${redis.token.keyapp}")
	private String APP_USER_TOKEN;
	
	@Resource(name = "bsMemberDAO")
	private BsMemberDAO bsMemberDAO;

	/*
	 * UnknownAccountException（账号不存在）
	 * IncorrectCredentialsException（密码错误）
	 * DisabledAccountException（帐号被禁用）
	 * LockedAccountException（帐号被锁定）
	 * ExcessiveAttemptsException（登录失败次数过多）
	 * ExpiredCredentialsException（凭证过期）
	 * UnsupportedTokenException（身份令牌异常，不支持的身份令牌）
	 * DisabledAccountException（用户禁用 ）
	 * ExcessiveAttemptsException （登录重试次数，超限。只允许在一段时间内允许有一定数量的认证尝试）
	 * ConcurrentAccessException（一个用户多次登录异常：不允许多次登录，只能登录一次 。即不允许多处登录）
	 * AccountException（账户异常 ）
	 * ExpiredCredentialsException（过期的凭据异常 ）
	 * IncorrectCredentialsException（错误的凭据异常 ）
	 * CredentialsException（凭据异常 ）
	 * AuthenticationException（凭据异常 ）
	 * UnauthenticatedException（授权异常 ）
	 * UnauthorizedException（没有访问权限，访问异常）
	 * HostUnauthorizedException（没有访问权限，访问异常）
	 * AuthorizationException（授权异常 ）
	 * ShiroException （shiro全局异常）
	 */

  
    /**
     * 其他异常
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object otherException(HttpServletResponse response,Exception e) {
    	log.error("操作异常，",e);    	
    	return BaseResponse.response(2, "操作异常，请稍后再试");
    }
    /**
     * 业务异常
     */
    @ExceptionHandler({YxBizException.class})
    @ResponseBody
    public Object yxBizException(HttpServletResponse response,Exception e) {
    	log.error(e.getMessage(),e);
    	return BaseResponse.response(2, e.getMessage());
    }

    /**
     * 未登录，请登录
     */
    @ExceptionHandler({CredentialsException.class})
    @ResponseBody
    public Object credentialsException(HttpServletResponse response,Exception e) {
    	log.error(e.getMessage(),e);
    	return BaseResponse.response(3, e.getMessage());
    }
    /**
     * token过期异常，登录过期
     */
    @ExceptionHandler({ExpiredCredentialsException.class})
    @ResponseBody
    public Object expiredCredentialsException(HttpServletResponse response,Exception e) {
    	log.error(e.getMessage(),e);
    	return BaseResponse.response(3, e.getMessage());
    	
    }
    /**
     * 没权限异常
     */
    @ExceptionHandler({UnauthenticatedException.class})
    @ResponseBody
    public Object nauthenticatedException(HttpServletResponse response,Exception e) {
    	System.out.println(1);
    	log.error(e.getMessage(),e);
    	return BaseResponse.response(2, e.getMessage());
    	
    }
    /**
     * 根据token获取当前登录的用户
     */
    public SysUser getCurrentUser(String token){
    	return (SysUser) redisTemplate.opsForValue().get(SYS_USER_TOKEN+":"+token); 
    }
    
    /**
     * 用于综合调度app端
     * 根据token获取App当前登录的用户
     * 
     */
    public BsMember getAppCurrentUser(String token){
    	BsMember loginUser = null; 
    	try {
    		BsMember bsMember = new BsMember();
    		bsMember.setOpen_id(token);
			loginUser = bsMemberDAO.getByCon(bsMember);
		} catch (Exception e) {
			log.error("获取会员信息失败",e);
		}
    	return loginUser; 
    }
    
    /**
     * 根据token获取当前登录的用户的操作权限
     */
    @SuppressWarnings("unchecked")
	public List<Map<String, Integer>> getCurrentUserPermission(Long rid){
    	
    	String key = Constants.ROLE_PERSION_KEY +":"+ rid;
    	List<Map<String, Integer>> list=(List<Map<String, Integer>>) redisTemplate.opsForValue().get(key);
    	return list; 
    }
    
    public static <T> T checkNotNull(T reference,  Object errorMessage) {
        if (Util.isNull(reference)) {
          throw new YxBizException(String.valueOf(errorMessage));
        }
        return reference;
    }
    
    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
          throw new YxBizException(String.valueOf(errorMessage));
        }
    }
    
    /** 
     * 获取请求Body 
     * 
     * @param request 
     * @return Map<String,Object>
     */  
    public static Map<String,String> getBodyString(final ServletRequest request) {
    	Map<String ,String> result=new HashMap<String,String>();
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
            if(Util.isNotNull(sb)&&Util.isNotNull(sb.toString())){
            	String requestStr=sb.toString();
            	String[] bodyArray= requestStr.split("&");
            	if(Util.isNotNull(bodyArray)){
            		 for(int i=0;i<bodyArray.length;i++){
                     	String keyValue= bodyArray[i];
                     	if(Util.isNotNull(keyValue)){
                     	 	String[] array=keyValue.split("=");
                     	 	if(array.length==2){
                     	 		String key=array[0];
                         	 	String value=array[1];
                         	 	if(Util.isNotNull(key)){
                         	 		result.put(key, value);
                         	 	}
                     	 	}else if(array.length==1){
                     	 		String key=array[0];
                     	 		result.put(key, "");
                     	 	}
                     	}
                     }
            	}
               
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
        return result;  
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