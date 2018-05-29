package com.yxcoach.common.base.timetask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @Description  TODO 任务
 * Created by yangzhipeng 
 */
@Service("bsTask")
public class BsTask {

    private static final Logger logger = LoggerFactory.getLogger(BsTask.class);

    public void taskMethod() throws Exception {
    	logger.info("开始load---------------------------------");
    }
 
}
