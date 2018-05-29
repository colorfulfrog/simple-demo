package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsBulletin;
import com.yxcoach.common.service.BsBulletinService;
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
import com.yxcoach.common.request.BsBulletinRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsBulletinQueryRequest;

/**
 *	
 *  车检动态表控制器
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@Controller
@Api(value = "bsBulletinController", description ="车检动态表控制器:liwei")
@RequestMapping(value = "/m/manager/bsBulletin/")
public class BsBulletinController extends BaseController{
	private static final Log log = LogFactory.getLog(BsBulletinController.class);
	
    @Resource(name = "bsBulletinService")
    private BsBulletinService bsBulletinService;
    
    
    /**
	 * 车检动态表分页
	 */
	@ApiOperation(value = "获得车检动态表列表", notes = "车检动态表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsBulletinQueryRequest bsBulletinQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsBulletinService.selectPage(bsBulletinQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增车检动态表
	 */
	@ApiOperation(value = "新增车检动态表", notes = "新增车检动态表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsBulletinRequest bsBulletinRequest) throws Exception {
		//SysUser user = getCurrentUser(bsBulletinRequest.getToken());
		BsBulletin bsBulletin = bsBulletinRequest.getBsBulletin();		
		boolean result = bsBulletinService.add(bsBulletin);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改车检动态表
	 */
	@ApiOperation(value = "修改车检动态表", notes = "修改车检动态表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsBulletinRequest bsBulletinRequest) throws Exception {
		//SysUser user = getCurrentUser(bsBulletinRequest.getToken());
		BsBulletin bsBulletin = bsBulletinRequest.getBsBulletin();
		boolean result = bsBulletinService.update(bsBulletin);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除车检动态表
	 */
	@ApiOperation(value = "删除车检动态表", notes = "删除车检动态表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsBulletinService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看车检动态表详情", notes = "查看车检动态表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsBulletin bsBulletin = bsBulletinService.get(baseViewRequest.getId());
		if (bsBulletin!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsBulletin);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
