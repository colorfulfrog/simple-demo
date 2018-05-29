package com.yxcoach.controller.manager;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.yxcoach.common.base.util.OSSManageUtil;


@Controller
@Api(value = "UploadController", description ="文件上传控制器:yangzhipeng")
@RequestMapping(value = "/file/")
public class UploadController {
	private static final Log log = LogFactory.getLog(UploadController.class);

	/**
	 * 文件上传
	 */
	
	@ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "upload")
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) throws Exception {
		//设置跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setContentType("application/json");
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String localPath = null;
		try {

			String fileName = file.getOriginalFilename();
			String hz = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = System.nanoTime() + hz.toLowerCase();
			localPath = OSSManageUtil.uploadFile(file.getInputStream(),
					file.getSize(), newFileName);
			log.info(localPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (localPath == null) {
			jsonMap.put("success", false);
			jsonMap.put("msg", "文件上传失败");
			return jsonMap;
		}
		jsonMap.put("success", true);
		jsonMap.put("msg", "文件上传成功");
		jsonMap.put("filePath", localPath);
		jsonMap.put("fileType", file.getContentType());
		return jsonMap;
	}

	public static byte[] readInputStream(InputStream inputStream)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	
	/* *//**
     * 文件上传Action
     * @param req APPLICATION_JSON_VALUE
     * @return UEDITOR 需要的json格式数据
     *//*
    @RequestMapping(value = "/remoteUpload")
    @ResponseBody
    public Map<String,Object> remoteUpload(HttpServletRequest req){
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	String localPath = null;
        MultipartHttpServletRequest mReq  =  null;
        MultipartFile file = null;
        InputStream is = null ;
        String fileName = "";
        // 原始文件名   UEDITOR创建页面元素时的alt和title属性
        String originalFileName = "";
        String filePath = "";
	        try {
	            //mReq = (MultipartHttpServletRequest)req;
	            // 从config.json中取得上传文件的ID
	            //file = mReq.getFile("upfile");
	            String url = req.getParameter("upfile");
	          //格式验证
	    		String type = getFileType(url);
				if(type.equals("")){
					//state = "图片类型不正确！";
					//continue;
					jsonMap.put("success", false);
	    			jsonMap.put("msg", "图片类型不正确！");
	    			return jsonMap;
				}
				String[] arr=url.split("/");
				
				String saveName =arr[arr.length-1];// Long.toString(new Date().getTime())+type;
	    		//大小验证
	    		HttpURLConnection.setFollowRedirects(false); 
			    HttpURLConnection   conn   = (HttpURLConnection) new URL(url).openConnection(); 
			    if(conn.getContentType().indexOf("image")==-1){
			    	//state = "请求地址头不正确";
			    	jsonMap.put("success", false);
	    			jsonMap.put("msg", "请求地址头不正确");
	    			return jsonMap;
			    }
			    if(conn.getResponseCode() != 200){
			    	//state = "请求地址不存在！";
			    	jsonMap.put("success", false);
	    			jsonMap.put("msg", "请求地址不存在！");
	    			return jsonMap;
			    }
	           // File f = new File(url);
	    		
	    		//得到输入流
	            InputStream inputStream = conn.getInputStream();  
	           // FileInputStream in_file =(FileInputStream)inputStream;
	    		
	    		// 转 MultipartFile
	    		 file = new MockMultipartFile(saveName, inputStream);
    			log.info("========================================");
    			log.info("文件长度: " + file.getSize());
    			log.info("文件类型: " + file.getContentType());
    			log.info("文件名称: " + file.getName());
    			log.info("文件原名: " + file.getOriginalFilename());
    			log.info("========================================");

    			 fileName = file.getOriginalFilename();
    			String hz = fileName.substring(fileName.lastIndexOf("."));
    			String newFileName = System.nanoTime() + hz.toLowerCase();
    			localPath = OSSManageUtil.uploadFile(file.getInputStream(),
    					file.getSize(), newFileName);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		if (localPath == null) {
    			jsonMap.put("success", false);
    			jsonMap.put("msg", "文件上传失败");
    			return jsonMap;
    		}
    		jsonMap.put("success", true);
    		jsonMap.put("msg", "文件上传成功");
    		jsonMap.put("filePath", localPath);
    		return jsonMap;
        
    }*/
    
    private String getFileType(String fileName){
    	String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
    	Iterator<String> type = Arrays.asList(fileType).iterator();
    	while(type.hasNext()){
    		String t = type.next();
    		if(fileName.endsWith(t)){
    			return t;
    		}
    	}
    	return "";
    }
}
