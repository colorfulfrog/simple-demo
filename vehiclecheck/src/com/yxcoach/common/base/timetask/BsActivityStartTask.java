package com.yxcoach.common.base.timetask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 活动启动定时任务类
 */
@Service("bsActivityStartTask")
public class BsActivityStartTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(BsActivityStartTask.class);
	
	public void taskMethod() throws Exception {
		LOGGER.info("活动启动任务开始---------------------------------");
    }
}
