package com.yxcoach.common.base.constant;

/**
 * 活动相关常量
 *
 */
public interface ActivityConstants {
	//启动活动
	String ACTIVITY_START = "start";
	//活动结束
	String ACTIVITY_FINISH = "finish";
	
	/** 活动状态  */
	//1 未开始
	Integer NOT_STARTED = 1;
	//2进行中
	Integer PROCESSING = 2;
	//3已结束
	Integer FINISHED = 3;
	//4停止
	Integer STOPED = 4;
	/** 活动状态  */
	
	/** 活动启用/停用  */
	//启用
	Integer ENABLE = 1;
	//停用
	Integer DISABLED = 2;
	/** 活动启用/停用  */
}
