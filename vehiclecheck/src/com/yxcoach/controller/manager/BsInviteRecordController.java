package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsInviteRecord;
import com.yxcoach.common.service.BsInviteRecordService;
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
import com.yxcoach.common.request.BsInviteRecordRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsInviteRecordQueryRequest;

/**
 *	
 *  好友推荐邀请表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsInviteRecordController", description ="好友推荐邀请表控制器:liwei")
@RequestMapping(value = "/m/manager/bsInviteRecord/")
public class BsInviteRecordController extends BaseController{
	private static final Log log = LogFactory.getLog(BsInviteRecordController.class);
	
    @Resource(name = "bsInviteRecordService")
    private BsInviteRecordService bsInviteRecordService;
    
    
    /**
	 * 好友推荐邀请表分页
	 */
	@ApiOperation(value = "获得好友推荐邀请表列表", notes = "好友推荐邀请表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsInviteRecordQueryRequest bsInviteRecordQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsInviteRecordService.selectPage(bsInviteRecordQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增好友推荐邀请表
	 */
	@ApiOperation(value = "新增好友推荐邀请表", notes = "新增好友推荐邀请表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsInviteRecordRequest bsInviteRecordRequest) throws Exception {
		BsInviteRecord bsInviteRecord = bsInviteRecordRequest.getBsInviteRecord();		
		boolean result = bsInviteRecordService.add(bsInviteRecord);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改好友推荐邀请表
	 */
	@ApiOperation(value = "修改好友推荐邀请表", notes = "修改好友推荐邀请表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsInviteRecordRequest bsInviteRecordRequest) throws Exception {
		BsInviteRecord bsInviteRecord = bsInviteRecordRequest.getBsInviteRecord();
		boolean result = bsInviteRecordService.update(bsInviteRecord);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除好友推荐邀请表
	 */
	@ApiOperation(value = "删除好友推荐邀请表", notes = "删除好友推荐邀请表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsInviteRecordService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看好友推荐邀请表详情", notes = "查看好友推荐邀请表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsInviteRecord bsInviteRecord = bsInviteRecordService.get(baseViewRequest.getId());
		if (bsInviteRecord!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsInviteRecord);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
