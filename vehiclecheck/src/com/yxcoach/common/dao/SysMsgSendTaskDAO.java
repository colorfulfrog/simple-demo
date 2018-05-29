package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.SysMsgSendTask;

/**
 *	
 *  sys_msg_send_taskDao
 *  注释:短信定时任务表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@MyBatisDao
@Component("sysMsgSendTaskDAO")
public interface SysMsgSendTaskDAO{
	/**
	 * 获取短信定时任务表分页数据
	 */
	public List<SysMsgSendTask> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取短信定时任务表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询短信定时任务表
	 */
	public SysMsgSendTask getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改短信定时任务表
	 */
	public Integer update(SysMsgSendTask sysMsgSendTask) throws Exception;
	/**
	 * 添加短信定时任务表
	 */
	public Integer add(SysMsgSendTask sysMsgSendTask)throws Exception;
	/**
	 * 根据ID删除短信定时任务表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	 /**
     * 启用或者停用
     * @param sysMsgSendTask
     * @return
     */
	public Integer updatEenableOrDisable(SysMsgSendTask sysMsgSendTask);
	
	/**
	 * 查询所有启用的定时任务
	 */
	public List<SysMsgSendTask> selectByEnableData();
	
}