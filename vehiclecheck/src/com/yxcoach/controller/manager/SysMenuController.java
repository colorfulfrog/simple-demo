package com.yxcoach.controller.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMenuQueryRequest;
import com.yxcoach.common.request.SysMenuRequest;
import com.yxcoach.common.request.TokenRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.SysMenuService;
import com.yxcoach.controller.BaseController;

/**
 *	
 *  菜单表控制器
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@Controller
@Api(value = "sysMenuController", description ="菜单表控制器:yangzhipeng")
@RequestMapping(value = "/m/manager/sysMenu/")
public class SysMenuController extends BaseController{

	private static final Log log = LogFactory.getLog(SysMenuController.class);
	
	@Resource(name = "SysMenuServiceImpl")
    private SysMenuService sysMenuService;
    
    
    /**
	 * 菜单表分页
	 */
	@ApiOperation(value = "获得菜单表列表", notes = "菜单表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysMenuQueryRequest sysMenuQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(sysMenuService.selectPage(sysMenuQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增菜单表
	 */
	@ApiOperation(value = "新增菜单表", notes = "新增菜单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysMenuRequest sysMenuRequest) throws Exception {
		SysUser user = getCurrentUser(sysMenuRequest.getToken());
    	sysMenuRequest.getSysMenu().setGmt_user(user.getId());
    	
		boolean result = sysMenuService.add(sysMenuRequest);
		if (result) {
			return BaseResponse.response(1);			
		} else {
			return BaseResponse.response(2);			
		}
	}

	/**
	 * 修改菜单表
	 */
	@ApiOperation(value = "修改菜单表", notes = "修改菜单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysMenuRequest sysMenuRequest) throws Exception {
		SysUser user = getCurrentUser(sysMenuRequest.getToken());
    	sysMenuRequest.getSysMenu().setModify_user(user.getId());
		boolean result = sysMenuService.update(sysMenuRequest);
		if (result) {
			return BaseResponse.response(1);			
		} else {
			return BaseResponse.response(2);			
		}
		
	}

	/**
	 * 删除菜单表
	 */
	@ApiOperation(value = "删除菜单表", notes = "删除菜单表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = sysMenuService.delete(baseDeleteRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看菜单表详情", notes = "查看菜单表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysMenu sysMenu = sysMenuService.get(baseViewRequest);
		if (sysMenu!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysMenu);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}
	
	 /*
     * 根据rid获取redis的菜单
     */
    @RequestMapping(value = "roleMenu", method=RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "roleMenu", notes = "根据角色ID获取菜单")
    public BaseResponse getMenuForRid(HttpServletRequest request,@RequestBody TokenRequest tokenRequest) throws Exception {
    	SysUser user = getCurrentUser(tokenRequest.getToken());   
    	
		List<SysMenu> menuList = (List<SysMenu>) redisTemplate.opsForValue().get(Constants.ROLE_MENU_KEY+":"+user.getRid());
		List<SysMenu> father=new ArrayList<SysMenu>();
		Iterator<SysMenu> iterator=menuList.iterator();
		while(iterator.hasNext()){	
			SysMenu m=iterator.next();
			if(m.getPid()==0){
				father.add(m);
				iterator.remove();
			}
		}
		for(SysMenu f:father){
			List<SysMenu> list=new ArrayList<>();
			for(SysMenu m:menuList){	
				if(f.getId()==m.getPid()){
					list.add(m);					
				}
			}			
			f.setChildren(list);
		}
		List<Map<String, Integer>> permissions=getCurrentUserPermission(user.getRid());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("permissions", permissions);
		map.put("father", father);
//		List list=new ArrayList();
//		list.add(permissions);
//		list.add(father);
    	return BaseResponse.response(1, map);
    }   
    
    /**
     * 分页
     */
	@RequestMapping(value = "listTree", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "listTree", notes = "菜单树形查询")
	public PageDataGird listTree(HttpServletRequest request, @RequestBody SysMenuQueryRequest sysMenuQueryRequest, HttpServletResponse response)
			throws Exception {
		
		List<SysMenu> menuList = sysMenuService.selectAll(sysMenuQueryRequest);
		List<SysMenu> father=new ArrayList<>();
		Iterator<SysMenu> iterator=menuList.iterator();
		while(iterator.hasNext()){	
			SysMenu m=iterator.next();
			if(m.getPid()==0){
				father.add(m);
				iterator.remove();
			}
		}
		for(SysMenu f:father){
			List<SysMenu> list=new ArrayList<>();
			for(SysMenu m:menuList){	
				if(f.getId()==m.getPid()){
					list.add(m);					
				}
			}			
			f.setChildren(list);
		}
		
		PageDataGird pageInfo = new PageDataGird(new PageInfo(1, father.size(), father));
		return pageInfo;
//		return BaseResponse.response(1, father);
		
	}
	
}
