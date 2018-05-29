package com.yxcoach.common.service;

/**
 *  BsMsglogService
 *  注释:短信发送记录Service
 *  创建人: yipengfei
 *  创建日期:2017-08-22
 */
public interface BsMsglogService {
	
	/**
	 * 语音提醒
	 */
	public static final int CALL=1;
	
	/**
	 * 短信提醒
	 */
	public static final int MESSAGE=2;
   /***
    * 
    * @param types 1 短信提醒  2 语音提醒
    * @param mobile 电话号码
    * @param content 内容
    * @return
    * @throws Exception
    */
    public boolean send(Integer types,String mobile,String content) throws Exception;
    

}
