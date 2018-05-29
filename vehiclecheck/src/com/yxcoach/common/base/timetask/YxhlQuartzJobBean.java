package com.yxcoach.common.base.timetask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

/**
 * 使用集群的 quartz 配置,自己实现对应的调度任务
 */
public class YxhlQuartzJobBean extends QuartzJobBean {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String targetObject;
    private String targetMethod;
    private ApplicationContext ctx;

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        try {
            logger.info("-------------------");
            // 获取对应的service 任务
            Object otargetObject = ctx.getBean(targetObject);
            Method m = null;

            try {
                // 获取需要执行的方法,并运行
                m = otargetObject.getClass().getMethod(targetMethod);
                m.invoke(otargetObject);
            } catch (SecurityException | NoSuchMethodException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JobExecutionException(e);
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.ctx = applicationContext;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }
}

