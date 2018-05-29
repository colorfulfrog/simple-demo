package com.yxcoach.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.request.BsActivityQueryRequest;
import com.yxcoach.common.request.BsCarRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.controller.BaseController;

/**
 * 
 *APP端车辆控制器
 */
@Controller
@Api(value = "APP车辆管理", description ="活动管理相关App端服务接口")
@RequestMapping(value = "/c/app/bsCar/")
public class CCarController extends BaseController {
	@Resource(name = "bsCarService")
    private BsCarService bsCarService;
	
	/**
	 * 查询会员用户所有车辆
	 */
	@ApiOperation(value = "查询会员用户所有车辆", notes = "查询会员用户所有车辆", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "mycars",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse mycars(HttpServletRequest request,
			@RequestBody BsActivityQueryRequest bsActivityQueryRequest) throws Exception {
		String token = bsActivityQueryRequest.getToken();
		BsMember appCurrentUser = getAppCurrentUser(token);
		return BaseResponse.response(Constants.Msg.SUC_MSG,bsCarService.getAllCarsByOwner(appCurrentUser.getId()));			
	}
	
	/**
	 * 新增车辆表
	 */
	@ApiOperation(value = "新增车辆表", notes = "新增车辆表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCarRequest bsCarRequest) throws Exception {
		BsMember user = getAppCurrentUser(bsCarRequest.getToken());
		BsCar bsCar = bsCarRequest.getBsCar();	
		bsCar.setGmt_user(user.getId());
		boolean result = bsCarService.add(bsCar);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}
}
