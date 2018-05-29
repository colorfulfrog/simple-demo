package com.yxcoach.controller.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.easypoi.excel.ExcelContext;
import com.yxcoach.common.base.entity.PageDataGird;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.SysUser;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.request.BsCarQueryRequest;
import com.yxcoach.common.request.BsCarRequest;
import com.yxcoach.common.response.BaseResponse;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.controller.BaseController;

/**
 *	
 *  车辆表控制器
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@Controller
@Api(value = "bsCarController", description ="车辆表控制器:liwei")
@RequestMapping(value = "/m/manager/bsCar/")
public class BsCarController extends BaseController{
	private static final Log log = LogFactory.getLog(BsCarController.class);
	
    @Resource(name = "bsCarService")
    private BsCarService bsCarService;
    
    
    /**
	 * 车辆表分页
	 */
	@ApiOperation(value = "获得车辆表列表", notes = "车辆表列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public PageDataGird list(HttpServletRequest request,
			@RequestBody BsCarQueryRequest bsCarQueryRequest) throws Exception {
		PageDataGird pageInfo = new PageDataGird(bsCarService.selectPage(bsCarQueryRequest));
		return pageInfo;
	}

	/**
	 * 新增车辆表
	 */
	@ApiOperation(value = "新增车辆表", notes = "新增车辆表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "add",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(HttpServletRequest request,
			@RequestBody BsCarRequest bsCarRequest) throws Exception {
		SysUser user = getCurrentUser(bsCarRequest.getToken());
		BsCar bsCar = bsCarRequest.getBsCar();	
		bsCar.setGmt_user(user.getId());
		boolean result = bsCarService.add(bsCar);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}		
	}

	/**
	 * 修改车辆表
	 */
	@ApiOperation(value = "修改车辆表", notes = "修改车辆表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "update",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(HttpServletRequest request,
			@RequestBody BsCarRequest bsCarRequest) throws Exception {
		BsCar bsCar = bsCarRequest.getBsCar();
		boolean result = bsCarService.update(bsCar);
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
		
	}

	/**
	 * 删除车辆表
	 */
	@ApiOperation(value = "删除车辆表", notes = "删除车辆表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "delete",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(HttpServletRequest request,
			@RequestBody BaseDeleteRequest baseDeleteRequest) throws Exception {
		boolean result = bsCarService.delete(baseDeleteRequest.getId());
		if (result) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,"操作成功");			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	/**
	 * 查看详情
	 */
	@ApiOperation(value = "查看车辆表详情", notes = "查看车辆表详情信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "info",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse info(HttpServletRequest request,
			@RequestBody BaseViewRequest baseViewRequest) throws Exception {
		BsCar bsCar = bsCarService.get(baseViewRequest.getId());
		if (bsCar!=null) {
			return BaseResponse.response(Constants.Msg.SUC_MSG,bsCar);			
		} else {
			return BaseResponse.response(Constants.Msg.ERR_MSG,"操作失败");			
		}	
	}
	
	/**
	 * 导入
	 */
	/*@ApiOperation(value = "导入", notes = "导入", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "import",method=RequestMethod.GET)
	@ResponseBody
	public void carImport(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(  
                request.getSession().getServletContext());  
        InputStream inExcelFile = null;  
        // 判断 request 是否有文件上传,即多部分请求importDailyResult  
        if (multipartResolver.isMultipart(request)) {  
            // 转换成多部分request  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;  
  
            // 取得request中的所有文件名  
            MultipartFile file = multiRequest.getFile("file");
            inExcelFile = file.getInputStream();
        }  
        inExcelFile = new FileInputStream(new File("D:/car.xlsx"));
  		ExcelContext context = ExcelContext.newInstance("excel/BsCar-config.xml");
  		ExcelImportResult result = context.readExcel("BsCarImport", inExcelFile);
  		//查看学生集合导入结果
  		List<BsCar> cars = result.getListBean();
  		for(BsCar stu:cars){
  			System.out.println(stu);
  		}
	}*/
	
	/**
	 * 导入
	 */
	/*@ApiOperation(value = "导入", notes = "导入", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "import2",method=RequestMethod.POST)
	@ResponseBody
	public void carImport2(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
		long size = file.getSize();
		String originalFilename = file.getOriginalFilename();
		InputStream inExcelFile = file.getInputStream();
  		ExcelContext context = ExcelContext.newInstance("excel/BsCar-config.xml");
  		ExcelImportResult result = context.readExcel("BsCarImport", inExcelFile);
  		//打印导入结果,查看标题之前不规则的数据
  		List<List<Object>> header = result.getHeader();
  		System.out.println(header.get(0));
  		System.out.println(header.get(1));
  		//查看学生集合导入结果
  		List<BsCar> cars = result.getListBean();
  		for(BsCar stu:cars){
  			System.out.println(stu);
  		}
	}*/
	
	/**
	 * 导入
	 */
	/*@ApiOperation(value = "导入", notes = "导入", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "import3",method=RequestMethod.POST)
	@ResponseBody
	public void carImport3(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
		long size = file.getSize();
		String originalFilename = file.getOriginalFilename();
		InputStream inExcelFile = file.getInputStream();
  		ExcelContext context = ExcelContext.newInstance("excel/BsCar-config.xml");
  		ExcelImportResult result = context.readExcel("BsCarImport", inExcelFile);
  		//打印导入结果,查看标题之前不规则的数据
  		List<List<Object>> header = result.getHeader();
  		System.out.println(header.get(0));
  		System.out.println(header.get(1));
  		//查看学生集合导入结果
  		List<BsCar> cars = result.getListBean();
  		for(BsCar stu:cars){
  			System.out.println(stu);
  		}
	}*/
	
	/**
	 * 导出
	 */
	@ApiOperation(value = "导出", notes = "导出", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "export",method=RequestMethod.GET)
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="car_number",required=false) String car_number,
			@RequestParam(value="car_type",required=false) Integer car_type,
			@RequestParam(value="owner_name",required=false) String owner_name) throws Exception {
		BsCar param = new BsCar();
		param.setCar_number(car_number);
		param.setType(car_type);
		param.setOwner_name(owner_name);
		List<BsCar> list = bsCarService.export(param);
		
		OutputStream out = null;
		try {
			String fileName = "车辆导出.xlsx";
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
			ExcelContext context = ExcelContext.newInstance("excel/BsCar-config.xml");
			Workbook workbook = context.createExcel("BsCarExport",list);
			workbook.write(out); //写入流
		    out.flush();
	    } catch (final IOException e) {
	        throw e;
	    } finally {
	        if(out !=null)
	        	out.close();
	    }
	}
}
