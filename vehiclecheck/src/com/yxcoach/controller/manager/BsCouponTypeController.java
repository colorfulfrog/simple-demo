package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.entity.SysUser;
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
import com.yxcoach.common.request.BsCouponTypeRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCouponQueryRequest;
import com.yxcoach.common.request.BsCouponTypeQueryRequest;

/**
 *	
 *  优惠券类型表控制器
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@Controller
@Api(value = "bsCouponTypeController", description ="优惠券类型表控制器:liwei")
@RequestMapping(value = "/m/manager/bsCouponType/")
public class BsCouponTypeController extends BaseController{
	private static final Log log = LogFactory.getLog(BsCouponTypeController.class);
	
    @Resource(name = "bsCouponTypeService")
    private BsCouponTypeService bsCouponTypeService;
    
    
    /**
	 * 优惠券类型表分页
	 */
	@ApiOperation(value = "获得优惠券类型表列表", notes = "优惠券类型表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCouponTypeService.selectPage(bsCouponTypeQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增优惠券类型表
	 */
	@ApiOperation(value = "新增优惠券类型表", notes = "新增优惠券类型表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCouponTypeRequest bsCouponTypeRequest) throws Exception {
		SysUser user = getCurrentUser(bsCouponTypeRequest.getToken());
		BsCouponType bsCouponType = bsCouponTypeRequest.getBsCouponType();	
//		bsCouponType.setGmt_user(user.getId());
		bsCouponType.setStatus(1);//状态 1正常 2过期 3停用
		bsCouponType.setVision(1L);//版本号
		boolean result = bsCouponTypeService.add(bsCouponType);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改优惠券类型表
	 */
	@ApiOperation(value = "修改优惠券类型表", notes = "修改优惠券类型表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsCouponTypeRequest bsCouponTypeRequest) throws Exception {
		SysUser user = getCurrentUser(bsCouponTypeRequest.getToken());
		BsCouponType bsCouponType = bsCouponTypeRequest.getBsCouponType();
//		 bsCouponType.setGmt_user(user.getId());
		boolean result = bsCouponTypeService.update(bsCouponType);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除优惠券类型表
	 */
	@ApiOperation(value = "删除优惠券类型表", notes = "删除优惠券类型表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsCouponTypeService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看优惠券类型表详情", notes = "查看优惠券类型表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsCouponType bsCouponType = bsCouponTypeService.get(baseViewRequest.getId());
		if (bsCouponType!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsCouponType);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
