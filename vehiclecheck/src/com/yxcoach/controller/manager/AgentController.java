package com.yxcoach.controller.manager;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.easypoi.excel.ExcelContext;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.util.excel.DownloadExcelUtil;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsActivityQueryRequest;
import com.yxcoach.common.request.BsMemberQueryRequest;
import com.yxcoach.common.request.BsMemberRequest;
import com.yxcoach.common.request.SysMsgRecordRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsActivityService;
import com.yxcoach.common.service.BsMemberService;
import com.yxcoach.common.service.SysUserService;
import com.yxcoach.controller.BaseController;

/**
 * 经纪人认证
 */
@Controller
@Api(value = "agentController", description = "经纪人认证控制器:lic")
@RequestMapping(value = "/m/manager/agent/")
public class AgentController extends BaseController {
	private static final Log log = LogFactory.getLog(AgentController.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	@Resource(name = "bsMemberService")
	private BsMemberService bsMemberService;
	@Resource(name = "SysUserServiceImpl")
	private SysUserService sysUserService;

	/**
	 * 经纪人认证分页
	 */
	@ApiOperation(value = "获得经纪人认证列表", notes = "经纪人认证信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request, @RequestBody BsMemberQueryRequest bsMemberQueryRequest)
			throws Exception {
		// 经纪人type =3
		// BsMember bsMember = bsMemberQueryRequest.getBsMember();
		// bsMember.setType(3);
		// bsMemberQueryRequest.setBsMember(bsMember);
		bsMemberQueryRequest.setTypex(3);
		PageDataGird pageInfo = new PageDataGird(bsMemberService.selectPage(bsMemberQueryRequest));
		return pageInfo;
	}

	/**
	 * 审核
	 */
	@ApiOperation(value = "经纪人审核", notes = "经纪人审核", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "examine", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse examine(HttpServletRequest request, @RequestBody BsMemberRequest bsMemberRequest)
			throws Exception {
		SysUser user = getCurrentUser(bsMemberRequest.getToken());
		BsMember bsMember = bsMemberRequest.getBsMember();
		bsMember.setAudit_user(user.getId());
		boolean result = bsMemberService.updateExamine(bsMember);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, "操作成功");
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}

	}

	@ApiOperation(value = "经纪人审核人", notes = "经纪人审核人", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "examinePerson", method = RequestMethod.POST)
	@ResponseBody
	public List<SysUser> examinePerson(HttpServletRequest request, @RequestBody BsMemberRequest bsMemberRequest)
			throws Exception {
		// SysUser user = getCurrentUser(bsMemberRequest.getToken());
		return sysUserService.examinePerson();
	}

	/**
	 * 查看详情
	 */
	@ApiOperation(value = "经纪人表详情", notes = "经纪人表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request, @RequestBody BaseViewRequest baseViewRequest)
			throws Exception {
		BsMember bsMember = bsMemberService.get(baseViewRequest.getId());
		if (bsMember != null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG, bsMember);
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG, "操作失败");
		}
	}

	/**
	 * 导出
	 * 
	 * @return
	 */
	@ApiOperation(value = "经纪人导出", notes = "经纪人导出", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "export", method = RequestMethod.GET)
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "real_name", required = false) String real_name,
			@RequestParam(value = "audit_user", required = false) Long audit_user,
			@RequestParam(value = "status", required = false) Integer status) throws Exception {
		BsMember param = new BsMember();
		param.setTypex(3);// 经纪人
		param.setNickname(nickname);
		param.setReal_name(real_name);
		param.setAudit_user(audit_user);
		param.setStatus(status);
		List<Map<String, Object>> list = bsMemberService.export(param);
		if (list.size() == 0) {
			Map<String, Object> errMap = new HashMap<String, Object>();
			errMap.put("code", 2);
			errMap.put("msg", "没有查询到数据可以导出");
			response.getWriter().println(JSON.toJSONString(errMap));
		} else {
			OutputStream out = null;
			try {
				String fileName = "经纪人导出.xlsx";
				String header = request.getHeader("User-Agent").toUpperCase();
				if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
					fileName = URLEncoder.encode(fileName, "utf-8");
					fileName = fileName.replace("+", "%20"); // IE下载文件名空格变+号问题
				} else {
					fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				}
				// 设置response参数，可以打开下载页面
				response.setContentType("application/x-msdownload;charset=utf-8");
				response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				// 创建一个字节输出流
				out = response.getOutputStream();
				ExcelContext context = ExcelContext.newInstance("excel/Agent-config.xml");
				Workbook workbook = context.createExcel("AgentExport", list);
				workbook.write(out); // 写入流
				out.flush();
			} catch (final IOException e) {
				throw e;
			} finally {
				if (out != null)
					out.close();
			}
		}
	}

	@ApiOperation(value = "经纪人导出", notes = "经纪人导出")
	@RequestMapping(value = "/exportData")
	public void exportData(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "nickname", required = false) String nickname,
			@RequestParam(value = "real_name", required = false) String real_name,
			@RequestParam(value = "audit_user", required = false) Long audit_user,
			@RequestParam(value = "status", required = false) Integer status) {
		try {
			BsMember param = new BsMember();
			param.setTypex(3);// 经纪人
			param.setNickname(nickname);
			param.setReal_name(real_name);
			param.setAudit_user(audit_user);
			param.setStatus(status);
			String fileName = sdf.format(new Date()) + System.nanoTime() + ".xls";
			String createPath = request.getRealPath("") + File.separator + "excelagent" + File.separator;// 上传目录
			// 创建目录
			if (!new File(createPath).isDirectory()) {
				new File(createPath).mkdirs();
			}
			createPath += fileName;
			String returnPath = bsMemberService.exportDataAgent(param, createPath);
			log.info("导出的路径：" + returnPath);
			DownloadExcelUtil downloadExcel = new DownloadExcelUtil();
			downloadExcel.downLoad(request, response, "excelagent_" + System.nanoTime(), null, returnPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
