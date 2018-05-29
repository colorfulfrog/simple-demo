package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsCheckStationFeedback;
import com.yxcoach.common.service.BsCheckStationFeedbackService;
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
import com.yxcoach.common.request.BsCheckStationFeedbackRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCheckStationFeedbackQueryRequest;

/**
 *	
 *  检测站评价表控制器
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@Controller
@Api(value = "bsCheckStationFeedbackController", description ="检测站评价表控制器:liwei")
@RequestMapping(value = "/m/manager/bsCheckStationFeedback/")
public class BsCheckStationFeedbackController extends BaseController{
	private static final Log log = LogFactory.getLog(BsCheckStationFeedbackController.class);
	
    @Resource(name = "bsCheckStationFeedbackService")
    private BsCheckStationFeedbackService bsCheckStationFeedbackService;
    
    
    /**
	 * 检测站评价统计分页
	 */
	@ApiOperation(value = "检测站评价统计分页", notes = "检测站评价统计分页", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCheckStationFeedbackService.selectPage(bsCheckStationFeedbackQueryRequest));
		return pageInfo;
	}
	
	/**
	 * 检测站评价详情表分页
	 */
	@ApiOperation(value = "检测站评价详情列表", notes = "检测站评价详情列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "detailList", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird detailList(HttpServletRequest request,
			@RequestBody BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCheckStationFeedbackService.selectDetailListPage(bsCheckStationFeedbackQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增检测站评价表
	 */
	@ApiOperation(value = "新增检测站评价表", notes = "新增检测站评价表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCheckStationFeedbackRequest bsCheckStationFeedbackRequest) throws Exception {
		//SysUser user = getCurrentUser(bsCheckStationFeedbackRequest.getToken());
		BsCheckStationFeedback bsCheckStationFeedback = bsCheckStationFeedbackRequest.getBsCheckStationFeedback();		
		boolean result = bsCheckStationFeedbackService.add(bsCheckStationFeedback);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改检测站评价表
	 */
	@ApiOperation(value = "修改检测站评价表", notes = "修改检测站评价表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsCheckStationFeedbackRequest bsCheckStationFeedbackRequest) throws Exception {
		//SysUser user = getCurrentUser(bsCheckStationFeedbackRequest.getToken());
		BsCheckStationFeedback bsCheckStationFeedback = bsCheckStationFeedbackRequest.getBsCheckStationFeedback();
		boolean result = bsCheckStationFeedbackService.update(bsCheckStationFeedback);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除检测站评价表
	 */
	@ApiOperation(value = "删除检测站评价表", notes = "删除检测站评价表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsCheckStationFeedbackService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看检测站评价表详情", notes = "查看检测站评价表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsCheckStationFeedback bsCheckStationFeedback = bsCheckStationFeedbackService.get(baseViewRequest.getId());
		if (bsCheckStationFeedback!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsCheckStationFeedback);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
