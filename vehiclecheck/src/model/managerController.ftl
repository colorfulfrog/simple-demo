package ${controlPackage};

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.PageDataGird;
import ${entityPackage}.${entityName};
import ${servicePackage}.${serviceName};
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
import ${requestManagerPackage}.${requestManagerEntityName};
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import ${requestManagerPackage}.${entityName}QueryRequest;

/**
 *	
 *  ${tableComment}控制器
 *  创建人: ${auth}
 *  创建日期:${date}
 */
@Controller
@Api(value = "${controllerReName}", description ="${tableComment}控制器:${auth}")
@RequestMapping(value = "/${controlType}/${module}/${entityReName}/")
public class ${controllerName} extends BaseController{
	private static final Log log = LogFactory.getLog(${controllerName}.class);
	
    @Resource(name = "${serviceReName}")
    private ${serviceName} ${serviceReName};
    
    
    /**
	 * ${tableComment}分页
	 */
	@ApiOperation(value = "获得${tableComment}列表", notes = "${tableComment}列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody ${entityName}QueryRequest ${entityReName}QueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(${serviceReName}.selectPage(${entityReName}QueryRequest));
		return pageInfo;
	}

	/**
	 * 新增${tableComment}
	 */
	@ApiOperation(value = "新增${tableComment}", notes = "新增${tableComment}信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody ${requestManagerEntityName} ${requestManagerEntityReName}) throws Exception {
		//SysUser user = getCurrentUser(${requestManagerEntityReName}.getToken());
		${entityName} ${entityReName} = ${requestManagerEntityReName}.get${entityName}();		
		boolean result = ${serviceReName}.add(${entityReName});
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改${tableComment}
	 */
	@ApiOperation(value = "修改${tableComment}", notes = "修改${tableComment}信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody ${requestManagerEntityName} ${requestManagerEntityReName}) throws Exception {
		//SysUser user = getCurrentUser(${requestManagerEntityReName}.getToken());
		${entityName} ${entityReName} = ${requestManagerEntityReName}.get${entityName}();
		boolean result = ${serviceReName}.update(${entityReName});
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除${tableComment}
	 */
	@ApiOperation(value = "删除${tableComment}", notes = "删除${tableComment}信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = ${serviceReName}.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看${tableComment}详情", notes = "查看${tableComment}详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		${entityName} ${entityReName} = ${serviceReName}.get(baseViewRequest.getId());
		if (${entityReName}!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,${entityReName});			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
}
