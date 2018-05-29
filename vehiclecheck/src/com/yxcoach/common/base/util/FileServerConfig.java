package com.yxcoach.common.base.util;

/**
 *  
 * @Description  获取 config 配置参数
 * Created by yangzhipeng on 2017年7月3日
 */
public class FileServerConfig {
	
	
	 public static ReadConfig reader=ReadConfig.getInstance();

     
     
     public static String VIRTUAL_SERVER;
     
     public static String SERVER_PATH;
//     public static String IMAGE_SERVER_PATH;

     public static String PATH;
     
     static{
    	 //丢数据库的下载路径
    	 //VIRTUAL_SERVER=reader.getConfigItem("virtualServer").trim();
    	 //版本管理文件夹 包含temp 文件  以及 history 文件
    	 PATH=reader.getConfigItem("path").trim();
    	 //服务器文件
    	 SERVER_PATH=reader.getConfigItem("serverPath").trim();
//    	 IMAGE_SERVER_PATH=reader.getConfigItem("imageServerPath").trim();
     }
         
}
