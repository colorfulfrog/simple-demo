package com.yxcoach.common.base.constant;

/**
 * 系统常量
 */
public class Constants {
	/**验证码存储变量名称*/
	public final static String VALIDATE_CODE="VALIDATE_CODE";
	/**当前用户会话存储变量名称*/
	public final static String SESSION_KEY="SESSION_KEY";
	/**消息key*/
	public final static String MESSAGE_KEY="MESSAGE_KEY";
	/**用户加密规则*/
	public final static String PASSWORD_TYPE="MD5";
	/**分页查询数量*/
	public final static Integer PAGESIZE=20;
	
	/**文件上传大小**/
	public static final Integer FILESIZE = 10485760;
	/**文件上传目录*/
	public static final String DEFAULT_UPLOAD_FILE = "upload";
	/**系统名称*/
	public static final String SYSTEMNAME="一站式智能调度平台";
	
	/**redis角色菜单key前缀*/
	public static final String ROLE_MENU_KEY = "ROLE_MENU_";
	
	/**redis角色权限key前缀*/
	public static final String ROLE_PERSION_KEY = "ROLE_PERSION_";
	
	/**redis数据字典值key前缀*/
	public static final String DICT_TXT_KEY = "DICT_TXT_";
	
	public static class Msg{
		/**返回消息成功代码*/
		public final static Integer SUC_MSG=1;
		/**返回消息失败代码*/
		public final static Integer ERR_MSG=2;
		/**返回消息 必须登录*/
		public final static Integer NOLOGIN_MSG=3;
		/**返回消息失败代码*/
		public final static Integer NO_VIEW_MSG=4;
	}
	
	
	public static class OrderRideStatus{
		/**未派车 */
		public final static Integer NO_RIDE=1;
		


	}
	
	public static class OrderStatus{

	
		/**正在拉客*/
		public final static Integer DISPATCH=1;
		
		/**已完成*/
		public final static Integer FINASH=2;
		
		/**订单取消*/
		public final static Integer CANCLE=3;
		

	}
	
	public static class OrderType{

		/**电话*/
		public final static Integer CALL=1;
		
		/**网络*/
		public final static Integer ONLINE=2;
		
		/**售票*/
		public final static Integer SALE=3;
		
		/**中途上车*/
		public final static Integer ONTRAIN=4;
		
		/** 站内乘客 */
		public final static Integer STATE=5;
		
		/** APP */
		public final static Integer APP=6;
		
		/** WEIXIN */
		public final static Integer WEIXIN=7;
	

	}
	
	/**
	 * 查询标示
	 * @Description  TODO
	 * Created by yangzhipeng on 2017年8月23日
	 */
	public static class queryFlag{

		/**
		 * 今天
		 */
		
		public static final int TODAY =1;
		/**
		 * 明天
		 */
		public static final int TOMORROW =2;
	

	}
	
	/**阿里云OSS*/
/*	public static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
	public static final String osswebsite = "http://treasure123.oss-cn-beijing.aliyuncs.com/";
	public static final String accessKeyId = "LTAIVrykmcNc7Gxv";
	public static final String accessKeySecret = "fQkUARpDbq5DNVcxjKmY68KTsiba6R";
	public static final String bucketName="treasure123";
	public static final String testBucket = "treasure";*/
	
	public static final String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
	public static final String osswebsite = "http://tsyly.oss-cn-shenzhen.aliyuncs.com/";
	public static final String accessKeyId = "LTAI74qNL5iRxwsC";
	public static final String accessKeySecret = "JSchOF3kQ68tFEFr4Bb9XnpSduYzzQ";
	public static final String bucketName="tsyly";
	public static final String testBucket = "tsyly";
	
}
