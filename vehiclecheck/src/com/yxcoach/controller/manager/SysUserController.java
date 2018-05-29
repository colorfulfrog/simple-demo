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
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysUserQueryRequest;
import com.yxcoach.common.request.SysUserRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.SysUserService;
import com.yxcoach.controller.BaseController;

/**
 *	
 *  用户表控制器
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@Controller
@Api(value = "sysUserController", description ="用户表控制器:yangzhipeng")
@RequestMapping(value = "/m/manager/sysUser/")
public class SysUserController extends BaseController{

	private static final Log log = LogFactory.getLog(SysUserController.class);
	
    @Resource(name = "SysUserServiceImpl")
    private SysUserService SysUserService;
    
    
    /**
	 * 用户表分页
	 */
	@ApiOperation(value = "获得用户表列表", notes = "用户表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysUserQueryRequest sysUserQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(SysUserService.selectPage(sysUserQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增用户表
	 */
	@ApiOperation(value = "新增用户表", notes = "新增用户表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysUserRequest sysUserRequest) throws Exception {
		sysUserRequest.getSysUser().setUser_type(1);
		sysUserRequest.getSysUser().setUser_pwd(Util.md5(sysUserRequest.getSysUser().getUser_pwd()));
		boolean result = SysUserService.add(sysUserRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改用户表
	 */
	@ApiOperation(value = "修改用户表", notes = "修改用户表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysUserRequest sysUserRequest) throws Exception {
		boolean result = SysUserService.update(sysUserRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除用户表
	 */
	@ApiOperation(value = "删除用户表", notes = "删除用户表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = SysUserService.delete(baseDeleteRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看用户表详情", notes = "查看用户表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysUser sysUser = SysUserService.get(baseViewRequest);
		if (sysUser!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysUser);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}
	
	/**
	 * 重置密码
	 */
	@ApiOperation(value = "密码重置", notes = "密码重置")
	@RequestMapping(value = "resetPassword",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse resetPassword(HttpServletRequest request,
			@RequestBody BaseViewRequest BaseViewRequest) throws Exception {
		boolean result = SysUserService.resetPassWord(BaseViewRequest);
		if (result) {
			return BaseResponse.response(1,"操作成功");			
		} else {
			return BaseResponse.response(2,"操作失败");			
		}	
	}
}
