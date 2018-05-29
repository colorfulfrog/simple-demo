package com.yxcoach.common.base.util;

/*
 * 消息模板类
 */
public class MessageTemplet {


	public static String getOrderTypes(Integer type){
		//1、拼车2、包车 3、快件 4、已售车票
		switch(type){
		case 1:
			return "拼车";
		case 2:
			return "包车";
		case 3:
			return "快件";
		case 4:
			return "已售车票";
		}
		return "";
	}
	/**
	 * 新订单(调度端 Web/调度端 APP) 账号手机实时短信提醒
	 */
	
	public static  String DISPATCH_NEW_ORDER="您有Start到End的Type订单等待派车,请登录走么调度端处理!";
	public static String getDispatchNewOrder(String start,String end,Integer type){
		String orderType=getOrderTypes(type);
		return DISPATCH_NEW_ORDER
				.replace("Start", start)
				.replace("End", end)
				.replace("Type", orderType);
	}
	
	/**
	 * 新订单(调度端 Web/调度端 APP) 发短信 /电呼  系统有新订单,实时系统语音+弹窗提醒
	 */
	public static  String DISPATCH_NEW_ORDER_NUM="您有Start到End的Type订单Num个等待配客,请及时处理!";
	public static String getDispatchNewOrderNum(String start,String end,Integer type,Integer num){
		String orderType=getOrderTypes(type);
		return DISPATCH_NEW_ORDER_NUM
				.replace("Start", start)
				.replace("End", end)
				.replace("Type", orderType)
				.replace("Num", num+"");
	}
	/**
	 * 新订单待配客(调度端 Web/调度端 APP)  短信提醒调度
	 */
	public static  String DISPATCH_NOT_READ="您有Start到End的订单Num个等待配客,请及时查看!";
	
	
	/**
	 * 待配客(调度端 Web/调度端 APP)  系统语音+弹窗提醒
	 */
	
	public static String DISPATH_WITE_ORDER="您有Start到End订单Num个未配车,请尽快处理!";
	
	/**
	 * 待配客,实时系统语音+弹窗提醒      调度APP(新订单)
	 */
	
	public static  String DISPATCHAPP_WORK_NEW_ORDER="您有Start到End电呼Type订单未配车,请尽快处理!";
	public static String getDispatchAppWorkNewOrder(String start,String end,Integer types){
		System.err.println(DISPATCHAPP_WORK_NEW_ORDER+"--------type----------"+types);
		String orderType=getOrderTypes(types);
		return DISPATCHAPP_WORK_NEW_ORDER
				.replace("Start", start)
				.replace("End", end)
				.replace("Type", orderType);
		
	}
	/**
	 * 司机端取消订单,调度后台实时收到语音+弹窗提醒
	 */
	
	public static  String DISPATCH_QUXIAO_ORDER="Depargear档车,License取消乘客订单,请及时审核";
	public static String getDispatchQxiaoOrder(String depargear,String license){
		return DISPATCH_QUXIAO_ORDER
				.replace("Depargear", depargear)
				.replace("License", license);
	}
	
	/**
	 * 控收端减乘客数,调度端后台系统语音+弹窗提醒: WEB  / APP
	 */
	
	public static  String DISPATCH_QUXIAO_KONGSHOU="控收员Name取消Num位乘客订单,如有疑问请联系控收员核实:Mobile,查看更多待配客";
	
	/**
	 * 调度给司机配客30分钟之后,司机未接到乘客或司机未确认上车则提醒调度进行处理,系统语音+弹窗提醒
	 */
	
	public static  String DISPATCH_CHEKE_NOTSHANGCHE="Depargear档车,License的配客有乘客未上车,请提醒司机按时接客!";
	public static String getDispatchChekeNotShangChe(String depargear,String license){
		return DISPATCH_CHEKE_NOTSHANGCHE
				.replace("Depargear", depargear)
				.replace("License", license);
	}
	/**
	 * 司机端取消订单,2分钟后调度若无处理,每隔2分钟,调度手机循环收到电呼提醒
	 */
	public static  String DISPATCH_CHENKE_QUXIAO="Start到End乘客已取消订单,请及时处理!";
	
	/**
	 * 司机端点报班,出发地调度端后台系统语音+弹窗提醒
	 */
	public static String DISPATCH_DRIVER_BAOBAN="Time,Depargear档车,License已报班!";
	
	/**
	 * 司机端点报班,出发地调度端 APP 系统语音和推送提醒 
	 */
	public static String DISPATCHAPP_DRIVER_BAOBAN="Depargear档车,License已报班!";
	
	/**
	 * 司机端点发班,出发地调度端后台系统语音+弹窗提醒
	 */
	public static String DISPATCH_DRIVER_FABAN="Time,Depargear档车,License已发班!";
	
	/**
	 * 司机端点发班,出发地调度APP语音+弹窗提醒
	 */
	public static String DISPATCHAPP_DRIVER_FABAN="Depargear档车,License已发班!";
	
	/**
	 * 司机端点到达,出发地调度端后台系统语音+弹窗提醒
	 */
	public static String DISPATCH_DRIVER_SONGDA="Time,Depargear档车,License已送达!";
	
	/**
	 * 司机端点到达,调度端APP系统语音+弹窗提醒
	 */
	public static String DISPATCHAPP_DRIVER_SONGDA="Depargear档车,License已送达!";
	
	/**
	 * 司机端点到达,目的地调度端后台系统语音+弹窗提醒:
	 */
	public static String DISPATCH_DRIVER_DAODA="Time,Depargear档车,License已到达!";
	
	/**
	 * 司机端点到达,调度App语音+弹窗提醒:
	 */
	public static String DISPATCHAPP_DRIVER_DAODA="Depargear档车,License已到达!";
	
	/***
	 * 系统有新订单,实时短信提醒  司机端 APP
	 * 
	 */
	public static String DRIVER_NEW_ORDER="您有Start到End的Type订单等待接客,请在走么司机端查看!";
	public static String getDriverNewOrder(String start,String end,int type){
		String orderType=getOrderTypes(type);
		return DRIVER_NEW_ORDER
				.replace("Start", start)
				.replace("End", end)
				.replace("Type", orderType);
	}
	/***
	 * 系统收到调度配客信息,实时系统语音+推送提醒  司机端 APP
	 * 
	 */
	public static String DRIVER_DISPATCH_PEIKE="您有Start到End的Type订单,请查收!";
	public static String DriverNewOrder(String Start,String End,Integer Type){
		String ordertype=getOrderTypes(Type);
		return DRIVER_DISPATCH_PEIKE.replace("Start", Start)
				.replace("End", End)
				.replace("Type",ordertype );
	}
	
	/***
	 * 司机端接收新订单1分钟后,如订单状态是未读,收到短信提醒  司机端 APP
	 * 
	 */
	public static String DRIVER_ORDER_NUM="您有Num条新订单等待接客,请在走么司机APP查看!";
	
	/***
	 * 司机收到新订单第2分钟起,如果仍旧是未读状态,收到电呼提醒:司机端 APP
	 * 
	 */
	public static String DRIVER_ORDER_NUMFORCHEKE="您有Num条走么新订单,请及时联系乘客!";
	
	/***
	 * 司机查看订单后,订单状态变为”待接客”,系统每隔30分钟系统检测一次订单状态是否为改变,如一直是”待接客”状态,则收到电呼+推送提醒    司机端 APP
	 * 
	 */
	public static String DRIVER_ORDER_SHANGCHE="您有Num条待接客订单,请及时联系乘客上车!";
	
	/***
	 * 司机查看订单后,订单状态变为”待接客”,系统每隔30分钟系统检测一次订单状态是否为改变,如一直是”待接客”状态,则收到电呼+推送提醒    司机端 APP
	 * 
	 */
	public static String DRIVER_ORDER_QUXIAO="您有订单已被取消,有疑问请致电调度员Mobile";
	public static String orderQuxiao(String Mobile){
		return DRIVER_ORDER_QUXIAO.replace("Mobile", Mobile);
				
	}
	
	/***
	 * 调度审批司机的"取消订单申请"审核结果提醒,系统语音+推送提醒:  司机端 APP
	 * 
	 */
	public static String DRIVER_ORDER_QUXIAOSHENGHE="您的“取消订单”审核通过,有疑问请致电调度员Mobile!";
	
	/***
	 * 调度员配客,控收端 APP实时收到系统语音+推送提醒:  控收端 APP
	 * 
	 */
	public static String KONGSHOU_APP_PEIKE="配客提醒:Name调度员已配客Num人,Drivername司机,车牌License,如有疑问,请联系调度Name:Mobile";
	public static String dispatchPeike(String Name,Integer Num,String Drivername, String License,String Mobile){
		return KONGSHOU_APP_PEIKE.replace("Name", Name).replace("Num", Num.toString()).replace("Drivername", Drivername).replace("License", License).replace("Mobile", Mobile);
	}
	
	/***
	 * 司机取消订单,调度审核后,控收端收到语音+推送提醒  控收端 APP
	 * 
	 */
	public static String KONGSHOU_APP_QUXIAO="Name司机,License取消乘客订单,有疑问可联系司机:Mobile";
	public static String driverQuxiaoorder(String Name,String License,String Mobile){
		return KONGSHOU_APP_QUXIAO.replace("Name", Name).replace("License", License).replace("Mobile", Mobile);
	}
	
	/***
	 * 电呼中心录入系统,乘客实时收到短信  乘客
	 * 
	 */
	public static String CHENGKE_ORDER="您的订单已成功提交,调度员会尽快给您调派车辆,请耐心等待![益阳湘运统一约车电话:96308]";
	
	/***
	 * 调度员给乘客配车,乘客实时收到短信:   乘客
	 * 
	 */
	public static String CHENGKE_PEICHE="您预约到End的车已派出,接驾人Name师傅,License,Mobile[益阳湘运统一约车电话:96308]";
	public static String getChenglePeicke(String End,String Name,String License,String Mobile){
		return CHENGKE_PEICHE
				.replace("End", End)
				.replace("Name", Name)
				.replace("License", License)
				.replace("Mobile", Mobile);
	}
	
	/***
	 * 调度员取消乘客订单或审核司机取消订单成功后,乘客即时收到短信   乘客
	 * 
	 */
	public static String CHENGKE_DRIVER_QUXIAO="您到End的订单已取消,有疑问请联系调度:Mobile.[益阳湘运统一约车电话:96308]";
	public static String repChengkequxiao(String End,String Mobile){
		return CHENGKE_DRIVER_QUXIAO.replace("End", End).replace("Mobile", Mobile);
	}
	
	/***
	 * 乘客在走么 APP 和公众号取消订单,乘客实时收到短信    乘客
	 * 
	 */
	public static String CHENGKE_QUXIAO="您到End的订单已取消,欢迎您下次再预约本公司车![益阳湘运统一约车电话:96308]";
	
	/***
	 * 乘客在走么 APP 和公众号取消订单,乘客实时收到短信    乘客
	 * 
	 */
	public static String DIANHU_UPDATE="Start到End线路目前可接订单类型为:拼车+包车![查看]";
	
	public static String repStartEndNum(String content,String start,String end,String num){
		return content
				.replace("Start", start)
				.replace("End", end)
				.replace("Num", num);
				
	}
	public static String repNameNumMobile(String content,String Mobile,String Name,String num){
		return content
				.replace("Mobile", Mobile)
				.replace("Name", Name)
				.replace("Num", num);
	}
	public static String repDrivername(String content,String Name,String Drivername,String num,String License,String Mobile){
		return content
				.replace("Mobile", Mobile)
				.replace("Name", Name)
				.replace("Num", num)	
				.replace("License", License);
	}
	public static String repDepargear(String content,String Time,String License,String Depargear){

		return content
				.replace("Time", Time)
				.replace("License", License)
				.replace("Depargear", Depargear);
	}
	public static void main(String[] args) {

		System.out.println(getDispatchNewOrder("长沙","益阳",0));
	}
}
