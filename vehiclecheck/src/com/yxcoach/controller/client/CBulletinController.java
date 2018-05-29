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
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.request.BsBulletinQueryRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsBulletinService;
import com.yxcoach.controller.BaseController;

/**
 * 
 *APP端车检动态控制器
 */
@Controller
@Api(value = "APP端车检动态", description ="车检动态相关App端服务接口")
@RequestMapping(value = "/c/app/bsBulletin/")
public class CBulletinController extends BaseController {
	@Resource(name = "bsBulletinService")
    private BsBulletinService bsBulletinService;
	
	/**
	 * 查询最近5条动态
	 */
	@ApiOperation(value = "查询最近5条动态", notes = "查询最近5条动态", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "news",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse news(HttpServletRequest request,
			@RequestBody BsBulletinQueryRequest bsBulletinQueryRequest) throws Exception {
		PageOption pageOption = new PageOption();
		pageOption.setRows(5);
		pageOption.setPage(1);
		bsBulletinQueryRequest.setPageOption(pageOption);
		PageDataGird pageInfo = new PageDataGird(bsBulletinService.selectPage(bsBulletinQueryRequest));
		return BaseResponse.response(Constants.Msg.SUC_MSG,pageInfo.getRows());	
	}
}
