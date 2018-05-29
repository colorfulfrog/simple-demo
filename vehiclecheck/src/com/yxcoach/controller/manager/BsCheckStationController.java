package com.yxcoach.controller.manager;

import java.util.List;

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
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCheckStationQueryRequest;
import com.yxcoach.common.request.BsCheckStationRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsCheckStationService;
import com.yxcoach.controller.BaseController;

/**
 *	
 *  检测站表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsCheckStationController", description ="检测站表控制器:liwei")
@RequestMapping(value = "/m/manager/bsCheckStation/")
public class BsCheckStationController extends BaseController{
	private static final Log log = LogFactory.getLog(BsCheckStationController.class);
	
    @Resource(name = "bsCheckStationService")
    private BsCheckStationService bsCheckStationService;
    
    
    /**
	 * 检测站表分页
	 */
	@ApiOperation(value = "获得检测站表列表", notes = "检测站表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsCheckStationQueryRequest bsCheckStationQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCheckStationService.selectPage(bsCheckStationQueryRequest));
		return pageInfo;
	}
	
	/**
	 * 查询所有检测站
	 */
	@ApiOperation(value = "查询所有检测站", notes = "查询所有检测站", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "all", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse all(HttpServletRequest request,
			@RequestBody BsCheckStationQueryRequest bsCheckStationQueryRequest) throws Exception {
		List<BsCheckStation> list = bsCheckStationService.all();
		return BaseResponse.response(Constants.Msg.SUC_MSG,list);
	}

	/**
	 * 新增检测站表
	 */
	@ApiOperation(value = "新增检测站表", notes = "新增检测站表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCheckStationRequest bsCheckStationRequest) throws Exception {
		SysUser user = getCurrentUser(bsCheckStationRequest.getToken());
		BsCheckStation bsCheckStation = bsCheckStationRequest.getBsCheckStation();	
		bsCheckStation.setGmt_user(user.getId());
		boolean result = bsCheckStationService.add(bsCheckStation);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改检测站表
	 */
	@ApiOperation(value = "修改检测站表", notes = "修改检测站表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsCheckStationRequest bsCheckStationRequest) throws Exception {
		BsCheckStation bsCheckStation = bsCheckStationRequest.getBsCheckStation();
		boolean result = bsCheckStationService.update(bsCheckStation);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除检测站表
	 */
	@ApiOperation(value = "删除检测站表", notes = "删除检测站表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsCheckStationService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看检测站表详情", notes = "查看检测站表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsCheckStation bsCheckStation = bsCheckStationService.get(baseViewRequest.getId());
		if (bsCheckStation!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsCheckStation);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
