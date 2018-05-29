package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.service.SysPriceService;
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
import com.yxcoach.common.request.SysPriceRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysPriceQueryRequest;

/**
 * 
 * 计价管理表控制器 创建人: liwei 创建日期:2018-05-09
 */
@Controller
@Api(value = "sysPriceController", description = "计价管理表控制器:liwei")
@RequestMapping(value = "/m/manager/sysPrice/")
public class SysPriceController extends BaseController {
	private static final Log log = LogFactory.getLog(SysPriceController.class);

	@Resource(name = "sysPriceService")
	private SysPriceService sysPriceService;

	/**
	 * 计价管理表分页
	 */
	@ApiOperation(value = "获得计价管理表列表", notes = "计价管理表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request, @RequestBody SysPriceQueryRequest sysPriceQueryRequest)
			throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysPriceService.selectPage(sysPriceQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增计价管理表
	 */
	@ApiOperation(value = "新增计价管理表", notes = "新增计价管理表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request, @RequestBody SysPriceRequest sysPriceRequest) throws Exception {
		SysPrice sysPrice = sysPriceRequest.getSysPrice();
		boolean result = sysPriceService.add(sysPrice);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 修改计价管理表
	 */
	@ApiOperation(value = "修改计价管理表", notes = "修改计价管理表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request, @RequestBody SysPriceRequest sysPriceRequest)
			throws Exception {
		SysPrice sysPrice = sysPriceRequest.getSysPrice();
		if (sysPrice.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		boolean result = sysPriceService.update(sysPrice);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}

	}

	/**
	 * 删除计价管理表
	 */
	@ApiOperation(value = "删除计价管理表", notes = "删除计价管理表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request, @RequestBody BaseDeleteRequest baseDeleteRequest)
			throws Exception {
		if (baseDeleteRequest.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		boolean result = sysPriceService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看计价管理表详情", notes = "查看计价管理表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		if (baseViewRequest.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		SysPrice sysPrice = sysPriceService.get(baseViewRequest.getId());
		if (sysPrice != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, sysPrice);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}
}
