package com.yxcoach.controller.manager;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.request.TokenRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.SysLoginService;
import com.yxcoach.controller.BaseController;



/**
 * 登录控制类
 */
@Controller
@Api(value = "后台登录", description ="后台登录")
@RequestMapping(value = "/m/system/loginController/")	
public class SysLoginController extends BaseController{
	private static final Log log = LogFactory.getLog(SysLoginController.class);

	@Resource(name = "SysLoginServiceImpl")
	private SysLoginService loginService;

	
	
	
	// 1、请求成功 2、请求失败 3、登录失效 4、无权限
	
	/*
	 * 用户登录，username,password
	 */
	@ApiOperation(value = "后台登录接口", notes = "后台登录接口",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "login",method=RequestMethod.POST) 	
	@ResponseBody
	public BaseResponse loginPost(HttpServletRequest request,
			@RequestBody LoginRequest loginRequest) throws Exception{	
		
		BaseResponse result = loginService.userLogin(loginRequest);
		return result;
		
	}	
	
	/*
	 * 根据token注销用户
	 */
	@ApiOperation(value = "后台注销接口", notes = "后台注销方法",httpMethod = "POST")
	@RequestMapping(value = "logout",method=RequestMethod.POST) 
	@ResponseBody
	public Object loginOut(HttpServletRequest request,
			@RequestBody TokenRequest tokenRequest) throws Exception{	
		Object result = loginService.userLogout(tokenRequest.getToken());
		return result;
	}	

}
