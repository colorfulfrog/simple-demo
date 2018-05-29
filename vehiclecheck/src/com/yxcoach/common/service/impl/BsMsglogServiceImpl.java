package com.yxcoach.common.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxcoach.common.push.YdSendMsg;
import com.yxcoach.common.service.BsMsglogService;

/**
 * @ClassName: BsMsglogServiceImpl
 * @Description: 短信发送记录 serviceImpl
 * @author yipengfei
 * @date 2017-08-22
 */
@Transactional(readOnly = true)
@Service("BsMsglogService")
public class BsMsglogServiceImpl implements BsMsglogService {


	public boolean send(Integer types, String mobile, String content){
		try {
			return YdSendMsg.norSubmit(content, mobile);
		} catch (Exception e) {
			return false;
		}
	}

}
