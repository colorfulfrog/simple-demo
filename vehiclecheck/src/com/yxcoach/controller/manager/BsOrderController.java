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
import com.yxcoach.common.entity.BsOrder;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsOrderQueryRequest;
import com.yxcoach.common.request.BsOrderRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsOrderService;
import com.yxcoach.controller.BaseController;

/**
 * 
 * 订单表控制器 创建人: liwei 创建日期:2018-05-10
 */
@Controller
@Api(value = "bsOrderController", description = "订单表控制器:liwei")
@RequestMapping(value = "/m/manager/bsOrder/")
public class BsOrderController extends BaseController {
	private static final Log log = LogFactory.getLog(BsOrderController.class);

	@Resource(name = "bsOrderService")
	private BsOrderService bsOrderService;

	/**
	 * 财务流水 分页
	 */
	@ApiOperation(value = "财务流水列表", notes = "财务流水信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "accountflowList", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird accountflowList(HttpServletRequest request,
			@RequestBody BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsOrderService.accountflowPage(bsOrderQueryRequest));
		return pageInfo;
	}

	/**
	 * 退款单分页
	 */
	@ApiOperation(value = "退款单列表", notes = "退款单信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "refundList", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird refundList(HttpServletRequest request, @RequestBody BsOrderQueryRequest bsOrderQueryRequest)
			throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsOrderService.refundPage(bsOrderQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增订单表
	 */
	@ApiOperation(value = "新增订单表", notes = "新增订单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request, @RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		// SysUser user = getCurrentUser(bsOrderRequest.getToken());
		BsOrder bsOrder = bsOrderRequest.getBsOrder();
		Integer verification_code = (Integer) redisTemplate.opsForValue().get("YZM:" + bsOrder.getTelephone());
		if (verification_code == null) {
			log.info("验证码已过期");
			return BaseResponse.response(2, "验证码已过期");
		}
		if (!verification_code.equals(bsOrderRequest.getVerification_code())) {
			log.info("验证码错误");
			return BaseResponse.response(2, "验证码错误");
		}
		BsOrder result = bsOrderService.add(bsOrder);
		if (result != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, result);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 修改订单表
	 */
	@ApiOperation(value = "修改订单表", notes = "修改订单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request, @RequestBody BsOrderRequest bsOrderRequest)
			throws Exception {
		// SysUser user = getCurrentUser(bsOrderRequest.getToken());
		BsOrder bsOrder = bsOrderRequest.getBsOrder();
		boolean result = bsOrderService.update(bsOrder);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}

	}

	/**
	 * 删除订单表
	 */
	@ApiOperation(value = "删除订单表", notes = "删除订单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request, @RequestBody BaseDeleteRequest baseDeleteRequest)
			throws Exception {
		boolean result = bsOrderService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看订单表详情", notes = "查看订单表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		BsOrder bsOrder = bsOrderService.get(baseViewRequest.getId());
		if (bsOrder != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, bsOrder);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 订单查询后台分页
	 */
	@ApiOperation(value = "订单查询后台列表", notes = "订单查询后台信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "backstageOrderList", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird backstageOrderList(HttpServletRequest request,
			@RequestBody BsOrderQueryRequest bsOrderQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsOrderService.selectBackstagePage(bsOrderQueryRequest));
		return pageInfo;
	}

	/**
	 * 订单查询后台 修改 /取消 / 上传检测结果 /开始检测 / 确认收款
	 */
	@ApiOperation(value = " 订单查询后台 修改 /取消 / 上传检测结果  /开始检测 / 确认收款", notes = " 订单查询后台 修改 /取消 / 上传检测结果  /开始检测 / 确认收款", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "backstageOrderOperation", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse backstageOrderOperation(HttpServletRequest request, @RequestBody BsOrderRequest bsOrderRequest)
			throws Exception {
		 SysUser user = getCurrentUser(bsOrderRequest.getToken());
		BsOrder bsOrder = bsOrderRequest.getBsOrder();
//		bsOrder.setUpdate_user(user.getGmt_user());
		//TODO 图片上传问题待处理
		boolean result = bsOrderService.updateOperation(bsOrder);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}
	
	/**
	 * 查看详情-后台
	 */
	@ApiOperation(value = "查看订单表详情-后台", notes = "查看订单表详情信息-后台", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "infoOperation", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse infoOperation(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		BsOrder bsOrder = bsOrderService.get(baseViewRequest.getId());
		if (bsOrder != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, bsOrder);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}
}
