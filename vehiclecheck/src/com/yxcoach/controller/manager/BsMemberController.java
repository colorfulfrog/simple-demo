package com.yxcoach.controller.manager;

import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.easypoi.excel.ExcelContext;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.base.util.excel.DownloadExcelUtil;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.common.service.BsCouponTypeService;
import com.yxcoach.common.service.BsMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yxcoach.common.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Workbook;

import com.yxcoach.common.request.BsMemberRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.controller.BaseController;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCarQueryRequest;
import com.yxcoach.common.request.BsMemberQueryRequest;

/**
 *	
 *  会员表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsMemberController", description ="会员表控制器:liwei")
@RequestMapping(value = "/m/manager/bsMember/")
public class BsMemberController extends BaseController{
	private static final Log log = LogFactory.getLog(BsMemberController.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    @Resource(name = "bsMemberService")
    private BsMemberService bsMemberService;
    
    @Resource(name = "bsCarService")
    private BsCarService bsCarService;
    
    @Resource(name = "bsCouponTypeService")
    private BsCouponTypeService bsCouponTypeService;
    
    /**
	 * 会员表分页
	 */
	@ApiOperation(value = "获得会员表列表", notes = "会员表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsMemberQueryRequest bsMemberQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsMemberService.selectPage(bsMemberQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增会员表
	 */
	@ApiOperation(value = "新增会员表", notes = "新增会员表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsMemberRequest bsMemberRequest) throws Exception {
		BsMember bsMember = bsMemberRequest.getBsMember();		
		boolean result = bsMemberService.add(bsMember);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改会员表
	 */
	@ApiOperation(value = "修改会员表", notes = "修改会员表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsMemberRequest bsMemberRequest) throws Exception {
		BsMember bsMember = bsMemberRequest.getBsMember();
		boolean result = bsMemberService.update(bsMember);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除会员表
	 */
	@ApiOperation(value = "删除会员表", notes = "删除会员表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsMemberService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看会员表详情", notes = "查看会员表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsMember bsMember = bsMemberService.get(baseViewRequest.getId());
		if (bsMember!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsMember);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
	/**
	 * 我的VIP
	 */
	@ApiOperation(value = "我的VIP列表", notes = "我的VIP信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "meVip", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird meVip(HttpServletRequest request,
			@RequestBody BsMemberQueryRequest bsMemberQueryRequest) throws Exception {
//		return bsMemberService.selectMeVip(bsMemberQueryRequest.getWechat_id());
		PageDataGird pageInfo = new PageDataGird(bsMemberService.selectMeVip(bsMemberQueryRequest));
		return pageInfo;
	}
	
	/**
	 * 我的车辆
	 */
	@ApiOperation(value = "我的车辆列表", notes = "我的车辆信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "meCar", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird meCar(HttpServletRequest request,
			@RequestBody BsCarQueryRequest bsCarQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCarService.selectMeCar(bsCarQueryRequest));
		return pageInfo;
	}
	
	@ApiOperation(value = "车主查询-代金劵", notes = "车主查询-代金劵", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "coupon", method = RequestMethod.POST)
	@ResponseBody
	public List<BsCouponType> coupon(HttpServletRequest request, @RequestBody BsMemberRequest bsMemberRequest)
			throws Exception {
//		SysUser user = getCurrentUser(bsMemberRequest.getToken());
		return bsCouponTypeService.selectCoupon();
	}
	
	/**
	 * 车主导出
	 */
	@ApiOperation(value = "车主导出", notes = "车主导出", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "export",method=RequestMethod.GET)
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="nickname",required=false) String nickname,
			@RequestParam(value="member_type",required=false) Integer member_type,
			@RequestParam(value="telphone",required=false) String telphone,
			@RequestParam(value="source",required=false) Integer source) throws Exception {
		BsMember param = new BsMember();
		param.setNickname(nickname);
		param.setTypex(member_type);
		param.setTelphone(telphone);
		param.setSource(source);
		List<Map<String, Object>> list = bsMemberService.export(param);
		
		OutputStream out = null;
		try {
			String fileName = "车主导出.xlsx";
	        String header = request.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                fileName = URLEncoder.encode(fileName, "utf-8");
                fileName = fileName.replace("+", "%20");    //IE下载文件名空格变+号问题
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
		    // 设置response参数，可以打开下载页面
		    response.setContentType("application/x-msdownload;charset=utf-8");
		    response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			//创建一个字节输出流
			out = response.getOutputStream();
			ExcelContext context = ExcelContext.newInstance("excel/BsMember-config.xml");
			Workbook workbook = context.createExcel("BsMemberExport",list);
			workbook.write(out); //写入流
		    out.flush();
	    } catch (final IOException e) {
	        throw e;
	    } finally {
	        if(out !=null)
	        	out.close();
	    }
	}
	
	@ApiOperation(value = "车主导出", notes = "车主导出")
	@RequestMapping(value = "/exportData")
	public void exportData(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="nickname",required=false) String nickname,
			@RequestParam(value="member_type",required=false) Integer member_type,
			@RequestParam(value="telphone",required=false) String telphone,
			@RequestParam(value="source",required=false) Integer source) {
		try {
			BsMember param = new BsMember();
			param.setNickname(nickname);
			param.setTypex(member_type);
			param.setTelphone(telphone);
			param.setSource(source);
			String fileName = sdf.format(new Date()) + System.nanoTime() + ".xls";
			String createPath = request.getRealPath("") + File.separator + "excelmember" + File.separator;// 上传目录
			// 创建目录
			if (!new File(createPath).isDirectory()) {
				new File(createPath).mkdirs();
			}
			createPath += fileName;
			String returnPath = bsMemberService.exportDataMember(param, createPath);
			log.info("导出的路径：" + returnPath);
			DownloadExcelUtil downloadExcel = new DownloadExcelUtil();
			downloadExcel.downLoad(request, response, "excelmember_" + System.nanoTime(), null, returnPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
