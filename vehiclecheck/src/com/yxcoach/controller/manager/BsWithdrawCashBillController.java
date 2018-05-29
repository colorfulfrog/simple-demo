package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsWithdrawCashBill;
import com.yxcoach.common.service.BsWithdrawCashBillService;
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
import com.yxcoach.common.request.BsWithdrawCashBillRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsWithdrawCashBillQueryRequest;

/**
 *	
 *  提现记录表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsWithdrawCashBillController", description ="提现记录表控制器:liwei")
@RequestMapping(value = "/m/manager/bsWithdrawCashBill/")
public class BsWithdrawCashBillController extends BaseController{
	private static final Log log = LogFactory.getLog(BsWithdrawCashBillController.class);
	
    @Resource(name = "bsWithdrawCashBillService")
    private BsWithdrawCashBillService bsWithdrawCashBillService;
    
    
    /**
	 * 提现记录表分页
	 */
	@ApiOperation(value = "获得提现记录表列表", notes = "提现记录表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsWithdrawCashBillQueryRequest bsWithdrawCashBillQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsWithdrawCashBillService.selectPage(bsWithdrawCashBillQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增提现记录表
	 */
	@ApiOperation(value = "新增提现记录表", notes = "新增提现记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsWithdrawCashBillRequest bsWithdrawCashBillRequest) throws Exception {
		BsWithdrawCashBill bsWithdrawCashBill = bsWithdrawCashBillRequest.getBsWithdrawCashBill();		
		boolean result = bsWithdrawCashBillService.add(bsWithdrawCashBill);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改提现记录表
	 */
	@ApiOperation(value = "修改提现记录表", notes = "修改提现记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsWithdrawCashBillRequest bsWithdrawCashBillRequest) throws Exception {
		BsWithdrawCashBill bsWithdrawCashBill = bsWithdrawCashBillRequest.getBsWithdrawCashBill();
		boolean result = bsWithdrawCashBillService.update(bsWithdrawCashBill);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除提现记录表
	 */
	@ApiOperation(value = "删除提现记录表", notes = "删除提现记录表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsWithdrawCashBillService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看提现记录表详情", notes = "查看提现记录表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsWithdrawCashBill bsWithdrawCashBill = bsWithdrawCashBillService.get(baseViewRequest.getId());
		if (bsWithdrawCashBill!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsWithdrawCashBill);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
