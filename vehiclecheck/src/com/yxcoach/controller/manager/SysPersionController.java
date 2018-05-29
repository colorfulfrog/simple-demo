package com.yxcoach.controller.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.dao.SysMenuDAO;
import com.yxcoach.common.entity.SysMenu;
import com.yxcoach.common.entity.SysPersion;
import com.yxcoach.common.service.SysPersionService;
import com.yxcoach.common.service.SysRoleService;

import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.response.SysPersionParent_resp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yxcoach.common.request.SysPersionRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.SysMenuPersionRequest;
import com.yxcoach.common.request.SysPersionQueryRequest;

/**
 *	
 *  权限表控制器
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@Controller
@Api(value = "sysPersionController", description ="权限表控制器:yangzhipeng")
@RequestMapping(value = "/m/manager/sysPersion/")
public class SysPersionController extends BaseController{

	private static final Log log = LogFactory.getLog(SysPersionController.class);
	
    @Resource(name = "SysPersionService")
    private SysPersionService SysPersionService;
    
    @Resource(name = "SysRoleServiceImpl")
    private SysRoleService sysRoleService;
    
    @Resource(name = "SysMenuDAO")
    private SysMenuDAO sysMenuDAO;
    
    
    /**
	 * 权限表分页
	 */
	@ApiOperation(value = "获得权限表列表", notes = "权限表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody SysPersionQueryRequest sysPersionQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(SysPersionService.selectPage(sysPersionQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增权限表
	 */
	@ApiOperation(value = "新增权限表", notes = "新增权限表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody SysPersionRequest sysPersionRequest) throws Exception {
		SysPersion sysPersion = sysPersionRequest.getSysPersion();		
		boolean result = SysPersionService.add(sysPersionRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改权限表
	 */
	@ApiOperation(value = "修改权限表", notes = "修改权限表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody SysPersionRequest sysPersionRequest) throws Exception {
			
		SysPersion sysPersion = sysPersionRequest.getSysPersion();
		boolean result = SysPersionService.update(sysPersionRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除权限表
	 */
	@ApiOperation(value = "删除权限表", notes = "删除权限表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = SysPersionService.delete(baseDeleteRequest);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看权限表详情", notes = "查看权限表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		SysPersion sysPersion = SysPersionService.get(baseViewRequest);
		if (sysPersion!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,sysPersion);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}
	@ApiOperation(value = "角色权限新增初始化权限信息", notes = "角色权限新增初始化权限信息")
	@RequestMapping(value = "roleinfolist", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse roleinfolist(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {

		List<SysPersionParent_resp> sysPersionParent_resp= SysPersionService.selectmenuAll(baseViewRequest.getId());
		if(sysPersionParent_resp!=null){
			return BaseResponse.response(1,sysPersionParent_resp);	
		}else{
			return BaseResponse.response(2,"操作失败");
		}
	}
	@ApiOperation(value = "根据rid新增菜单权限", notes = "根据rid新增菜单权限信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "unionAdd",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse unionAdd(HttpServletRequest request,
			@RequestBody SysMenuPersionRequest sysPersionRequest)
			throws Exception {
		boolean result = SysPersionService.uninoAdd(sysPersionRequest);
		if (result) {
			Map<String, Object> map2 = new HashMap();
			map2.put("type", 1);
			map2.put("rid", sysPersionRequest.getRid());
			List<SysMenu> sysMenuList = sysMenuDAO.selectRoleMemu(map2);
			// redisTemplate.opsForList().leftPush(Constants.ROLE_MENU_KEY+role.getId(),
			// sysMenuList);
			redisTemplate.opsForValue().set(
					Constants.ROLE_MENU_KEY + ":" + sysPersionRequest.getRid(),
					sysMenuList);
			// 2.角色-权限：key,value都为角色id_权限url
			Map persionMap = new HashMap();
			persionMap.put("rid", "" + sysPersionRequest.getRid());
			List<Map<String, Integer>> list = sysRoleService
					.selecPersion(persionMap);
			for (int k = 0; k < list.size(); k++) {
				Map pmap = list.get(k);
				String key = Constants.ROLE_PERSION_KEY + ":"
						+ sysPersionRequest.getRid() + ":"
						+ pmap.get("persion");
				redisTemplate.opsForValue().set(key, key);
			}


			return BaseResponse.response(1,"操作成功");			
		} else {
			return BaseResponse.response(2,"操作失败");			
		}	
		
	}
	/**
	 * 根据菜单id查询菜单权限列表
	 */
	@ApiOperation(value = "根据菜单id查询菜单权限列表", notes = "列表信息")
	@RequestMapping(value = "listForMenu", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird listForMenu(HttpServletRequest request,
			@RequestBody SysPersionQueryRequest sysPersionQueryRequest) throws Exception {
		List<SysPersion> listMenu = SysPersionService.listForMenu(sysPersionQueryRequest);
		PageDataGird pageInfo = new PageDataGird(new PageInfo(0, listMenu.size(), listMenu));
		return pageInfo;
	}
    
}
