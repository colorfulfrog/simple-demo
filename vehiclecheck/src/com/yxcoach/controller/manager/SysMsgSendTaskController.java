package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.service.SysMsgSendTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.yxcoach.common.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.yxcoach.common.request.SysMsgSendTaskRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMsgSendTaskQueryRequest;

/**
 *	
 *  短信定时任务表控制器
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@Controller
@Api(value = "sysMsgSendTaskController", description ="短信定时任务表控制器:liwei")
@RequestMapping(value = "/m/manager/sysMsgSendTask/")
public class SysMsgSendTaskController extends BaseController{
	private static final Log log = LogFactory.getLog(SysMsgSendTaskController.class);
	
    @Resource(name = "sysMsgSendTaskService")
    private SysMsgSendTaskService sysMsgSendTaskService;
    
    
    /**
	 * 短信定时任务表分页
	 */
	@ApiOperation(value = "获得短信定时任务表列表", notes = "短信定时任务表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysMsgSendTaskQueryRequest sysMsgSendTaskQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysMsgSendTaskService.selectPage(sysMsgSendTaskQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增短信定时任务表
	 */
	@ApiOperation(value = "新增短信定时任务表", notes = "新增短信定时任务表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysMsgSendTaskRequest sysMsgSendTaskRequest) throws Exception {
		//SysUser user = getCurrentUser(sysMsgSendTaskRequest.getToken());
		SysMsgSendTask sysMsgSendTask = sysMsgSendTaskRequest.getSysMsgSendTask();		
		boolean result = sysMsgSendTaskService.add(sysMsgSendTask);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改短信定时任务表
	 */
	@ApiOperation(value = "修改短信定时任务表", notes = "修改短信定时任务表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysMsgSendTaskRequest sysMsgSendTaskRequest) throws Exception {
		//SysUser user = getCurrentUser(sysMsgSendTaskRequest.getToken());
		SysMsgSendTask sysMsgSendTask = sysMsgSendTaskRequest.getSysMsgSendTask();
		boolean result = sysMsgSendTaskService.update(sysMsgSendTask);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除短信定时任务表
	 */
	@ApiOperation(value = "删除短信定时任务表", notes = "删除短信定时任务表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = sysMsgSendTaskService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看短信定时任务表详情", notes = "查看短信定时任务表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysMsgSendTask sysMsgSendTask = sysMsgSendTaskService.get(baseViewRequest.getId());
		if (sysMsgSendTask!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysMsgSendTask);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
	
	/**
	 * 启用/停用短信定时任务表
	 */
	@ApiOperation(value = "启用/停用短信定时任务表", notes = "启用/停用短信定时任务表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "enableOrDisable",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse enableOrDisable(HttpServletRequest request,
			@RequestBody SysMsgSendTaskRequest sysMsgSendTaskRequest) throws Exception {
		//SysUser user = getCurrentUser(sysMsgSendTaskRequest.getToken());
		SysMsgSendTask sysMsgSendTask = sysMsgSendTaskRequest.getSysMsgSendTask();
		boolean result = sysMsgSendTaskService.updatEenableOrDisable(sysMsgSendTask);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
}
