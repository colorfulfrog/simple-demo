package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.service.BsMemberService;
import com.yxcoach.common.service.SysMsgRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.yxcoach.common.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.yxcoach.common.request.SysMsgRecordRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMsgRecordQueryRequest;

/**
 * 
 * 短信发送记录表控制器 创建人: liwei 创建日期:2018-05-11
 */
@Controller
@Api(value = "sysMsgRecordController", description = "短信发送记录表控制器:liwei")
@RequestMapping(value = "/m/manager/sysMsgRecord/")
public class SysMsgRecordController extends BaseController {
	private static final Log log = LogFactory.getLog(SysMsgRecordController.class);

	@Resource(name = "sysMsgRecordService")
	private SysMsgRecordService sysMsgRecordService;
	@Resource(name = "bsMemberService")
	private BsMemberService bsMemberService;
	
	@Resource(name = "messageExecutor")
	ThreadPoolTaskExecutor messageExecutor;

	/**
	 * 短信发送记录表分页
	 */
	@ApiOperation(value = "获得短信发送记录表列表", notes = "短信发送记录表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request, @RequestBody SysMsgRecordQueryRequest sysMsgRecordQueryRequest)
			throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysMsgRecordService.selectPage(sysMsgRecordQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增短信发送记录表
	 */
	@ApiOperation(value = "新增短信发送记录表", notes = "新增短信发送记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request, @RequestBody SysMsgRecordRequest sysMsgRecordRequest)
			throws Exception {
		// SysUser user = getCurrentUser(sysMsgRecordRequest.getToken());
		SysMsgRecord sysMsgRecord = sysMsgRecordRequest.getSysMsgRecord();
		sysMsgRecord.setMsg_type(1);//手工发送
		// 用户组传递的是 （会员类型 1：车主 3：经纪人）直接查询会员表联系电话
		// 4. 就必须得传递具体的联系电话,
		java.util.List<BsMember> bsms = null;
		String[] receivers = null;
		if (sysMsgRecord != null && Util.isNotNull(sysMsgRecord.getUserGroup())) {
			if (sysMsgRecord.getUserGroup().equals("1") || sysMsgRecord.getUserGroup().equals("3")) {
				Map<String, Object> tels = new HashMap<String, Object>();
				tels.put("type", sysMsgRecord.getUserGroup());
				bsms = bsMemberService.selectByTelphone(tels);
			} else if (sysMsgRecord.getUserGroup().equals("4")) {
				if (Util.isNotNull(sysMsgRecord.getReceiver())) {
					receivers = sysMsgRecord.getReceiver().split(",");
				} else {
					return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
				}
			} else {
				return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
			}
		}
		boolean result = sysMsgRecordService.insertBatch(sysMsgRecord, bsms, receivers,messageExecutor,sysMsgRecordService);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "立即发送成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 修改短信发送记录表
	 */
	@ApiOperation(value = "修改短信发送记录表", notes = "修改短信发送记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request, @RequestBody SysMsgRecordRequest sysMsgRecordRequest)
			throws Exception {
		// SysUser user = getCurrentUser(sysMsgRecordRequest.getToken());
		SysMsgRecord sysMsgRecord = sysMsgRecordRequest.getSysMsgRecord();
		boolean result = sysMsgRecordService.update(sysMsgRecord);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}

	}

	/**
	 * 删除短信发送记录表
	 */
	@ApiOperation(value = "删除短信发送记录表", notes = "删除短信发送记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request, @RequestBody BaseDeleteRequest baseDeleteRequest)
			throws Exception {
		boolean result = sysMsgRecordService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看短信发送记录表详情", notes = "查看短信发送记录表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		SysMsgRecord sysMsgRecord = sysMsgRecordService.get(baseViewRequest.getId());
		if (sysMsgRecord != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, sysMsgRecord);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}
}
