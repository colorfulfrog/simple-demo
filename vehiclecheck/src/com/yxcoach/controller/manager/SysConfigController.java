package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.SysConfig;
import com.yxcoach.common.service.SysConfigService;
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
import com.yxcoach.common.request.SysConfigRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysConfigQueryRequest;

/**
 * 
 * 参数配置表控制器 创建人: liwei 创建日期:2018-05-09
 */
@Controller
@Api(value = "sysConfigController", description = "参数配置表控制器:liwei")
@RequestMapping(value = "/m/manager/sysConfig/")
public class SysConfigController extends BaseController {
	private static final Log log = LogFactory.getLog(SysConfigController.class);

	@Resource(name = "sysConfigService")
	private SysConfigService sysConfigService;

	/**
	 * 参数配置表分页
	 */
	@ApiOperation(value = "获得参数配置表列表", notes = "参数配置表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request, @RequestBody SysConfigQueryRequest sysConfigQueryRequest)
			throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysConfigService.selectPage(sysConfigQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增参数配置表
	 */
	@ApiOperation(value = "新增参数配置表", notes = "新增参数配置表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request, @RequestBody SysConfigRequest sysConfigRequest)
			throws Exception {
		if (sysConfigService.countSum() > 0)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "该参数值存在,只允许修改");
		SysConfig sysConfig = sysConfigRequest.getSysConfig();
		boolean result = sysConfigService.add(sysConfig);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 修改参数配置表
	 */
	@ApiOperation(value = "修改参数配置表", notes = "修改参数配置表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request, @RequestBody SysConfigRequest sysConfigRequest)
			throws Exception {
		SysConfig sysConfig = sysConfigRequest.getSysConfig();
		if (sysConfig.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		boolean result = sysConfigService.update(sysConfig);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}

	}

	/**
	 * 删除参数配置表
	 */
	@ApiOperation(value = "删除参数配置表", notes = "删除参数配置表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request, @RequestBody BaseDeleteRequest baseDeleteRequest)
			throws Exception {
		if (baseDeleteRequest.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		boolean result = sysConfigService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看参数配置表详情", notes = "查看参数配置表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		if (baseViewRequest.getId() == null)
			return BaseResponse.response(Constants.Msg.ERR_MSG, "Id获取作失败");
		SysConfig sysConfig = sysConfigService.get(baseViewRequest.getId());
		if (sysConfig != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, sysConfig);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}
}
