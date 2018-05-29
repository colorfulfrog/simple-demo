package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsActivity;
import com.yxcoach.common.service.BsActivityService;
import com.yxcoach.common.service.BsCouponTypeService;

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
import com.yxcoach.common.request.BsActivityRequest;
import com.yxcoach.common.request.BsCouponTypeQueryRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsActivityQueryRequest;

/**
 *	
 *  活动表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsActivityController", description ="活动表控制器:liwei")
@RequestMapping(value = "/m/manager/bsActivity/")
public class BsActivityController extends BaseController{
	private static final Log log = LogFactory.getLog(BsActivityController.class);
	
    @Resource(name = "bsActivityService")
    private BsActivityService bsActivityService;
    
    @Resource(name = "bsCouponTypeService")
    private BsCouponTypeService bsCouponTypeService;
    
    
    /**
	 * 活动表分页
	 */
	@ApiOperation(value = "获得活动表列表", notes = "活动表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsActivityQueryRequest bsActivityQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsActivityService.selectPage(bsActivityQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增活动表
	 */
	@ApiOperation(value = "新增活动表", notes = "新增活动表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsActivityRequest bsActivityRequest) throws Exception {
		BsActivity bsActivity = bsActivityRequest.getBsActivity();		
		boolean result = bsActivityService.add(bsActivity);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改活动表
	 */
	@ApiOperation(value = "修改活动表", notes = "修改活动表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsActivityRequest bsActivityRequest) throws Exception {
		BsActivity bsActivity = bsActivityRequest.getBsActivity();
		boolean result = bsActivityService.update(bsActivity);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除活动表
	 */
	@ApiOperation(value = "删除活动表", notes = "删除活动表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsActivityService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看活动表详情", notes = "查看活动表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsActivity bsActivity = bsActivityService.get(baseViewRequest.getId());
		if (bsActivity!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsActivity);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
	@ApiOperation(value = "活动表列表-优惠券", notes = "活动表列表-优惠券", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "conpon", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird conpon(HttpServletRequest request,
			@RequestBody BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception {
		bsCouponTypeQueryRequest.setStatus(1);//正常的优惠券类型
		PageDataGird pageInfo = new PageDataGird(bsCouponTypeService.selectActivityCouponPage(bsCouponTypeQueryRequest));
		return pageInfo;
	}

}
