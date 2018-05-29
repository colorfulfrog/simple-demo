package com.yxcoach.controller.client;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.entity.BsCheckStationFeedback;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.BsOrder;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.request.BsCheckStationFeedbackRequest;
import com.yxcoach.common.request.BsOrderRequest;
import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.common.service.BsCheckStationFeedbackService;
import com.yxcoach.common.service.BsCheckStationService;
import com.yxcoach.common.service.BsOrderService;
import com.yxcoach.common.service.LoginService;
import com.yxcoach.common.service.SysDiscountService;
import com.yxcoach.controller.BaseController;

/**
 * 
 *APP端预约车检
 */
@Controller
@Api(value = "APP端预约车检", description ="预约车检相关App端服务接口")
@RequestMapping(value = "/c/app/bsOrder/")
public class COrderController extends BaseController {
	@Resource(name = "bsOrderService")
    private BsOrderService bsOrderService;
	
	@Resource(name = "LoginServiceImpl")
	private LoginService loginService;
	@Resource(name = "bsCarService")
    private BsCarService bsCarService;
	@Resource(name = "sysDiscountService")
	private SysDiscountService sysDiscountService;
	@Resource(name = "bsCheckStationService")
    private BsCheckStationService bsCheckStationService;
	@Resource(name = "bsCheckStationFeedbackService")
	private BsCheckStationFeedbackService bsCheckStationFeedbackService;
	
	@ApiOperation(value = "获取验证码", notes = "获取验证码",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "foryzm",method=RequestMethod.POST) 
	@ResponseBody
	public BaseResponse foryzm(HttpServletRequest request,
			@RequestBody LoginRequest loginRequest) throws Exception{
		if(loginRequest.getTelphone().equals("")){
			return BaseResponse.response(1, "请填写您的电话号码！");
		}
		Util.isMobile(loginRequest.getTelphone());
		loginRequest.setYzm(Integer.valueOf((int)((Math.random()*9+1)*1000)));
		boolean flag= loginService.foryzm(loginRequest);
		if(flag){
			return BaseResponse.response(1, "验证码获取成功");
		}else{
			return BaseResponse.response(2, "验证码获取失败");
		}
		
	}
	
	/**
	 * 预算费用
	 */
	@ApiOperation(value = "预算费用", notes = "预算费用", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "budget",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse budget(HttpServletRequest request, @RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		//BsOrder bsOrder = bsOrderRequest.getBsOrder();	
		/*if(StringUtils.isEmpty(bsOrder.getTelephone()) || !Util.isMobile(bsOrder.getTelephone())){
			return BaseResponse.response(2, "请填写正确的手机号码！");
		}
		Integer verification_code=(Integer)redisTemplate.opsForValue().get("YZM:"+bsOrder.getTelephone());
		if(verification_code==null){
			return BaseResponse.response(2, "验证码已过期");
		}
		if(!verification_code.equals(bsOrderRequest.getVerification_code())){
			return BaseResponse.response(2, "验证码错误");
		}*/
		Map<String,Object> map = bsOrderService.budget(bsOrderRequest.getCar_id(),bsOrderRequest.getOrder_date(),false);
		//SysPrice SysPrice = (SysPrice)map.get("sys_price");
		Float result = (Float)map.get("total_fee");
		if (result != 0) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,result);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}
	
	@ApiOperation(value = "预约车检", notes = "预约车检", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		BsOrder bsOrder = bsOrderRequest.getBsOrder();	
		if(StringUtils.isEmpty(bsOrder.getTelephone()) || !Util.isMobile(bsOrder.getTelephone())){
			return BaseResponse.response(2, "请填写正确的手机号码！");
		}
		/*Integer verification_code=(Integer)redisTemplate.opsForValue().get("YZM:"+bsOrder.getTelephone());
		if(verification_code==null){
			return BaseResponse.response(2, "验证码已过期");
		}
		if(!verification_code.equals(bsOrderRequest.getVerification_code())){
			return BaseResponse.response(2, "验证码错误");
		}*/
		Map<String,Object> map = bsOrderService.budget(bsOrder.getCar_id(),bsOrder.getOrder_date(),true);
		SysPrice sysPrice = (SysPrice)map.get("sys_price");
		Float discount_fee = (Float)map.get("discount_fee");
		Float totle_fee = (Float)map.get("total_fee");
		bsOrder.setCheck_fee(new BigDecimal(sysPrice.getCheck_price().doubleValue()));
		bsOrder.setLevel_fee(new BigDecimal(sysPrice.getLevel_price().doubleValue()));
		bsOrder.setAll_round_check_fee(new BigDecimal(sysPrice.getAll_round_price().doubleValue()));
		bsOrder.setDiscount_fee(new BigDecimal(discount_fee.doubleValue()));
		bsOrder.setTotal_fee(new BigDecimal(totle_fee.doubleValue()));
		BsOrder order = bsOrderService.add(bsOrder);
		BsCar bsCar = bsCarService.get(bsOrder.getCar_id());
		BsCheckStation bsCheckStation = bsCheckStationService.get(bsOrder.getStation_id());
		String viewStr = sysDiscountService.getAllDiscountShow(); // 折扣文案显示
		JSONObject result = new JSONObject();
		result.put("order_id", order.getId());
		result.put("car_number", bsCar.getCar_number());
		result.put("station_name", bsCheckStation.getStation_name());
		result.put("order_date", bsOrder.getOrder_date());
		result.put("telephone", bsOrder.getTelephone());
		result.put("discount_desc", viewStr);
		return BaseResponse.response(Constants.Msg.SUC_MSG,result);			
	}
	
	@ApiOperation(value = "窗口付款", notes = "窗口付款", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "payOffline",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse payOffline(HttpServletRequest request,
			@RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		JSONObject result = bsOrderService.payOffline(bsOrderRequest.getOrder_id());
		return BaseResponse.response(Constants.Msg.SUC_MSG,result);			
	}
	
	@ApiOperation(value = "取消订单", notes = "取消订单", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "cancel",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse cancel(HttpServletRequest request,
			@RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		boolean result = bsOrderService.cancel(bsOrderRequest.getOrder_id());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}
	
	@ApiOperation(value = "订单详情", notes = "订单详情", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		JSONObject result = bsOrderService.detail(bsOrderRequest.getOrder_id());
		return BaseResponse.response(Constants.Msg.SUC_MSG,result);		
	}
	
	@ApiOperation(value = "申请退款", notes = "申请退款", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "applyRefund",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse applyRefund(HttpServletRequest request,
			@RequestBody BsOrderRequest bsOrderRequest) throws Exception {
		boolean result = bsOrderService.applyRefund(bsOrderRequest.getOrder_id(),bsOrderRequest.getRefund_type());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}
	
	@ApiOperation(value = "检测站评价", notes = "检测站评价", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "feedback",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse feedback(HttpServletRequest request,
			@RequestBody BsCheckStationFeedbackRequest bsCheckStationFeedbackRequest) throws Exception {
		String token = bsCheckStationFeedbackRequest.getToken();
		BsMember appCurrentUser = getAppCurrentUser(token);
		BsCheckStationFeedback bsCheckStationFeedback = bsCheckStationFeedbackRequest.getBsCheckStationFeedback();
		bsCheckStationFeedback.setMember_id(appCurrentUser.getId());
		Float score = bsCheckStationFeedback.getScore();
		String feedBackLabel = "";
		if(score == 1){
			feedBackLabel = "非常不满意";
		}
		else if(score == 2){
			feedBackLabel = "不满意";
		}
		else if(score == 3){
			feedBackLabel = "满意";
		}
		else if(score ==4){
			feedBackLabel = "很满意";
		}
		else if(score == 5){
			feedBackLabel = "非常满意";
		}
		bsCheckStationFeedback.setFeedback_label(feedBackLabel);
		boolean result = bsCheckStationFeedbackService.add(bsCheckStationFeedback);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}			
	}
}
