package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.service.BsCouponService;
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
import com.yxcoach.common.request.BsCouponRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCouponQueryRequest;

/**
 *	
 *  优惠券表控制器
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@Controller
@Api(value = "bsCouponController", description ="优惠券表控制器:liwei")
@RequestMapping(value = "/m/manager/bsCoupon/")
public class BsCouponController extends BaseController{
	private static final Log log = LogFactory.getLog(BsCouponController.class);
	
    @Resource(name = "bsCouponService")
    private BsCouponService bsCouponService;
    
    
    /**
	 * 优惠券表分页
	 */
	@ApiOperation(value = "获得优惠券表列表", notes = "优惠券表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsCouponQueryRequest bsCouponQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCouponService.selectPage(bsCouponQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增优惠券表
	 */
	@ApiOperation(value = "新增优惠券表", notes = "新增优惠券表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCouponRequest bsCouponRequest) throws Exception {
		//SysUser user = getCurrentUser(bsCouponRequest.getToken());
		BsCoupon bsCoupon = bsCouponRequest.getBsCoupon();		
		boolean result = bsCouponService.add(bsCoupon);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改优惠券表
	 */
	@ApiOperation(value = "修改优惠券表", notes = "修改优惠券表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsCouponRequest bsCouponRequest) throws Exception {
		//SysUser user = getCurrentUser(bsCouponRequest.getToken());
		BsCoupon bsCoupon = bsCouponRequest.getBsCoupon();
		boolean result = bsCouponService.update(bsCoupon);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除优惠券表
	 */
	@ApiOperation(value = "删除优惠券表", notes = "删除优惠券表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsCouponService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看优惠券表详情", notes = "查看优惠券表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsCoupon bsCoupon = bsCouponService.get(baseViewRequest.getId());
		if (bsCoupon!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsCoupon);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
	@ApiOperation(value = "优惠券表明细列表", notes = "优惠券表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "detailed", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird detailed(HttpServletRequest request,
			@RequestBody BsCouponQueryRequest bsCouponQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCouponService.selectDetailedPage(bsCouponQueryRequest));
		return pageInfo;
	}
}
