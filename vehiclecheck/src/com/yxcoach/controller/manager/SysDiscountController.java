package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.SysDiscount;
import com.yxcoach.common.service.SysDiscountService;
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
import com.yxcoach.common.request.SysDiscountRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysDiscountQueryRequest;

/**
 *	
 *  预约折扣表控制器
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@Controller
@Api(value = "sysDiscountController", description ="预约折扣表控制器:liwei")
@RequestMapping(value = "/m/manager/sysDiscount/")
public class SysDiscountController extends BaseController{
	private static final Log log = LogFactory.getLog(SysDiscountController.class);
	
    @Resource(name = "sysDiscountService")
    private SysDiscountService sysDiscountService;
    
    
    /**
	 * 预约折扣表分页
	 */
	@ApiOperation(value = "获得预约折扣表列表", notes = "预约折扣表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysDiscountQueryRequest sysDiscountQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysDiscountService.selectPage(sysDiscountQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增预约折扣表
	 */
	@ApiOperation(value = "新增预约折扣表", notes = "新增预约折扣表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysDiscountRequest sysDiscountRequest) throws Exception {
		//SysUser user = getCurrentUser(sysDiscountRequest.getToken());
		SysDiscount sysDiscount = sysDiscountRequest.getSysDiscount();		
		boolean result = sysDiscountService.add(sysDiscount);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改预约折扣表
	 */
	@ApiOperation(value = "修改预约折扣表", notes = "修改预约折扣表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysDiscountRequest sysDiscountRequest) throws Exception {
		//SysUser user = getCurrentUser(sysDiscountRequest.getToken());
		SysDiscount sysDiscount = sysDiscountRequest.getSysDiscount();
		boolean result = sysDiscountService.update(sysDiscount);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除预约折扣表
	 */
	@ApiOperation(value = "删除预约折扣表", notes = "删除预约折扣表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = sysDiscountService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看预约折扣表详情", notes = "查看预约折扣表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysDiscount sysDiscount = sysDiscountService.get(baseViewRequest.getId());
		if (sysDiscount!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysDiscount);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
