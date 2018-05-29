package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.util.FileUtils;
import com.yxcoach.common.base.util.Util;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class Model {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://192.168.1.234:3306/vehiclecheckdb?useUnicode=true&characterEncoding=UTF-8";
		String username="yxdbadmin";
		String password="yxdb+admin123";
		String basePath="D:\\02Code\\vehiclecheck\\vehiclecheck\\";//工程 路径
//		String basePath="D:\\projects\\treasure\\treasure\\";//工程 路径


		String tableName="bs_coupon";//表名
		String modelName="manager";//模块名称 orderinfo memberinfo
		String controlType="m";//m 或者p 或者 d  controller 中@RequestMapping(value = "/{controlType}/${xxx}/${xxxx}/")
		
		String auth="liwei";
		
		boolean isCEntity=true;//是否生成实体 
		boolean isRequestManager=true;//生成请求对象
		boolean isQueryRequestManager=true;//生成请求对象
		boolean isCDao=true;//是否生成dao
		boolean isCService=true;//是否生成服务 
		boolean isCServiceImpl=true; //是否生成服务实现
		boolean isCController=true;//是否生成控制器 
		
		
		
		String entityName=rename(tableName);
		String daoName=entityName+"DAO";
		String controllerName=entityName+"Controller";
		String controllerReName=reEntityName(controllerName);
		String voName=entityName+"VO";

		//实体类
		String entityPackage="com.yxcoach.common.entity";
		String entityPath=basePath+"src/com/yxcoach/common/entity/";
		//管理端
		String requestManagerPackage="com.yxcoach.common.request";
		String requestManagerPath=basePath+"src/com/yxcoach/common/request/";
		String requestManagerEntityName=entityName+"Request";
		String requestQueryManagerEntityName=entityName+"QueryRequest";
		String requestManagerEntityReName=reEntityName(requestManagerEntityName);
		
		//dao
		String daoPackage="com.yxcoach.common.dao";
		String daoPath=basePath+"src/com/yxcoach/common/dao/";
		
		//Service
		String serviceName=entityName+"Service";
		String servicePackage="com.yxcoach.common.service";
		String servicePath=basePath+"src/com/yxcoach/common/service/";
		
		String serviceNameImpl=entityName+"ServiceImpl";
		String serviceImplPackage="com.yxcoach.common.service.impl";
		String serviceImplPath=basePath+"src/com/yxcoach/common/service/impl/";
		
		
		//controller
		String controlPackage="com.yxcoach.controller."+modelName;
		String controlPath=basePath+"src/com/yxcoach/controller/"+modelName+"/";
		if(!modelName.equals("system")){
			controlPackage="com.yxcoach.controller."+modelName;
			controlPath=basePath+"src/com/yxcoach/controller/"+modelName+"/";
		}
		
		//String jspPath=basePath+"WebRoot/WEB-INF/views/modules/"+modelName+"/";
		
		String mybatisPath = basePath + "resources/mapper/";
        String mybatisNameSpace = "com.yxcoach.common.dao."+ daoName;
        
		String tableComment="";//表注解
		List<String[]> fields=new ArrayList<String[]>();//字段集合
		String priField=null;//主键 
		String priFieldType=null;//主键类型
		String priFieldParameterType="long";//主键类型
		
		Class.forName(driver);
		Connection connection=DriverManager.getConnection(url,username,password);
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from "+tableName+" where 1=2");
		ResultSetMetaData metaData=resultSet.getMetaData();
		int count=metaData.getColumnCount();
		for(int i=1;i<=count;i++){
			String name=metaData.getColumnName(i);
			String type=metaData.getColumnClassName(i);
			String[]field=new String[6];
			field[0]=type;
			field[1]=name;
			fields.add(field);
		}
		resultSet.close();
		
		resultSet=statement.executeQuery(" SHOW FULL FIELDS FROM "+tableName);
		while(resultSet.next()){
			String name=resultSet.getString("FIELD");
			String comment=resultSet.getString("COMMENT");
			String key=resultSet.getString("KEY");
			String isnull=resultSet.getString("NULL");
			String type=resultSet.getString("TYPE");
			String length="";
			String labflag="";
			
			if(isnull.equals("YES")){
				labflag="";
			}else{
				labflag="<font color='red'>*</font>";
			}
			if(type.indexOf("varchar")>-1){//
				length=type.substring(8, type.length()-1);
			}
			
			for (int i=0;i<fields.size();i++) {
				String[]temp=fields.get(i);
				if(temp[1].equals(name)){
					if(key.equals("PRI")){
						priField=name;
						priFieldType=temp[0];
					}
					temp[2]=comment;
					temp[3]=labflag;
					temp[4]=length;
					temp[5]=isnull;
					fields.set(i, temp);
					break;
				}
			}
		}
		resultSet.close();
		
		
		if(tableComment.equals("")){
			resultSet=statement.executeQuery("SHOW TABLE STATUS WHERE NAME='"+tableName+"'");
			if(resultSet.next()){
				String name=resultSet.getString("NAME");
				if(name.equalsIgnoreCase(tableName)){
					tableComment=resultSet.getString("COMMENT");
					tableComment=tableComment.replaceAll("\r\n|\r|\n|\n\r|<br>|</br>", " ");
				}
			}
			resultSet.close();
		}
		
		statement.close();
		connection.close();
		
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(basePath+"src/model/"));
		
		
		Map<String, Object> modelParam = new HashMap<String, Object>();
		//表名等基础信息
		modelParam.put("tableName", tableName);
		modelParam.put("tableComment", tableComment);
		modelParam.put("auth", auth);
		modelParam.put("date", Util.getCurrentDateStr());
		modelParam.put("controlType", controlType);
		
		//数据库字段
		modelParam.put("fields", fields);
		//实体类需要数据
		modelParam.put("entityName", entityName);
		modelParam.put("entityPackage", entityPackage);
		modelParam.put("entityReName", reEntityName(entityName));
		//后台添加请求对象
		modelParam.put("requestManagerPackage", requestManagerPackage);
		modelParam.put("requestManagerEntityName", requestManagerEntityName);
		modelParam.put("requestManagerEntityReName", requestManagerEntityReName);
		
		modelParam.put("daoName", daoName);
		modelParam.put("daoReName", reEntityName(daoName));
		modelParam.put("daoPackage", daoPackage);
		modelParam.put("mybatisNameSpace", mybatisNameSpace);
		
		modelParam.put("priFieldType", priFieldType);
		modelParam.put("priField", priField);
		modelParam.put("priFieldParameterType", priFieldParameterType);
		
		modelParam.put("serviceName", serviceName);
		modelParam.put("servicePackage", servicePackage);
		
		modelParam.put("serviceReName", reEntityName(serviceName));
		modelParam.put("serviceImplPackage", serviceImplPackage);
		modelParam.put("serviceNameImpl", serviceNameImpl);
		
		//modelParam.put("voPackage", voPackage);
		modelParam.put("voName", voName);
		
		modelParam.put("controllerName", controllerName);
		modelParam.put("controllerReName", controllerReName);
		modelParam.put("controlPackage", controlPackage);
		
		modelParam.put("module", modelName);
		
		modelParam.put("dollar", "$");
		if(isCEntity){
			createFile(cfg, "entity.ftl", modelParam, entityPath+entityName+".java");
		}
		if(isRequestManager){
			createFile(cfg, "managerRequest.ftl", modelParam, requestManagerPath+requestManagerEntityName+".java");
		}
		if(isQueryRequestManager){
			createFile(cfg, "queryRequest.ftl", modelParam, requestManagerPath+requestQueryManagerEntityName+".java");
		}
		if(isCDao){
			createFile(cfg, "dao.ftl", modelParam, daoPath+daoName+".java");
            createFile(cfg, "mybatis.ftl", modelParam, mybatisPath + tableName.toUpperCase() + ".xml");
		}
		if(isCService){
			createFile(cfg, "service.ftl", modelParam, servicePath+serviceName+".java");
		}
		if(isCServiceImpl){
			createFile(cfg, "serviceimpl.ftl", modelParam, serviceImplPath+serviceNameImpl+".java");
		}
		if(isCController){
			createFile(cfg, "managerController.ftl", modelParam, controlPath+controllerName+".java");
		}
		
		System.out.println("已经生成完成.....");
	}
	
	public static void createFile(Configuration cfg,String moduleName,Map<String, Object> modelParam,String filePath)throws Exception{
		Template template = cfg.getTemplate(moduleName,"utf-8");
		StringWriter result = new StringWriter();
		template.process(modelParam, result);
		String content = result.toString();
		writeFile(content, filePath);
	}
	/**
	 * 将内容写入文件
	 * @param content
	 * @param filePath
	 */
	public static void writeFile(String content, String filePath) {
		try {
			FileUtils.deleteFile(filePath);
			if (FileUtils.createFile(filePath)){
				OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//				System.err.println(content);
				bufferedWriter.write(content);
				bufferedWriter.close();
				outputStreamWriter.close();
			}else{
				System.out.println("生成失败，文件已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * 驼峰命名
	 * @param tableName
	 * @return
	 */
	public static String rename(String tableName){
		String[] temp=tableName.split("_");
		StringBuffer entityName=new StringBuffer();
		for (String str : temp) {
			entityName.append(str.substring(0, 1).toUpperCase()).append(str.substring(1, str.length()));
		}
		return entityName.toString();
	}
	/***
	 * 将对象名称 第一个字母小写
	 * @param entityName
	 * @return
	 */
	public static String reEntityName(String entityName){
		entityName=entityName.substring(0, 1).toLowerCase()+entityName.substring(1, entityName.length());
		return entityName.toString();
	}
}
