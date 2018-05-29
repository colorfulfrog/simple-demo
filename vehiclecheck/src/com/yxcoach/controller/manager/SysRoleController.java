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
import com.yxcoach.common.entity.SysRole;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysRoleQueryRequest;
import com.yxcoach.common.request.SysRoleRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.SysRoleService;
import com.yxcoach.controller.BaseController;

/**
 *	
 *  角色表控制器
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@Controller
@Api(value = "sysRoleController", description ="角色表控制器:yangzhipeng")
@RequestMapping(value = "/m/manager/sysRole/")
public class SysRoleController extends BaseController{

	private static final Log log = LogFactory.getLog(SysRoleController.class);
	
    @Resource(name = "SysRoleServiceImpl")
    private SysRoleService sysRoleService;
    
    
    /**
	 * 角色表分页
	 */
	@ApiOperation(value = "获得角色表列表", notes = "角色表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysRoleQueryRequest sysRoleQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysRoleService.selectPage(sysRoleQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增角色表
	 */
	@ApiOperation(value = "新增角色表", notes = "新增角色表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysRoleRequest sysRoleRequest) throws Exception {
		SysUser user = getCurrentUser(sysRoleRequest.getToken());
		sysRoleRequest.getSysRole().setGmt_user(user.getId());
    	boolean result=sysRoleService.add(sysRoleRequest);
    	if (result) {
			return BaseResponse.response(1,"操作成功");			
		} else {
			return BaseResponse.response(2,"操作失败");			
		}
	}

	/**
	 * 修改角色表
	 */
	@ApiOperation(value = "修改角色表", notes = "修改角色表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysRoleRequest sysRoleRequest) throws Exception {
			
		boolean result = sysRoleService.update(sysRoleRequest);
    	if (result) {
			return BaseResponse.response(1,"操作成功");			
		} else {
			return BaseResponse.response(2,"操作失败");			
		}
		
	}

	/**
	 * 删除角色表
	 */
	@ApiOperation(value = "删除角色表", notes = "删除角色表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = sysRoleService.delete(baseDeleteRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看角色表详情", notes = "查看角色表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysRole sysRole = sysRoleService.get(baseViewRequest);
		if (sysRole!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysRole);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}
    
    
}
