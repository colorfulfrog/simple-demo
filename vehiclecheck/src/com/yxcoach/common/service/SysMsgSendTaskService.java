package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.request.SysMsgSendTaskQueryRequest;

/**
 * SysMsgSendTaskService 注释:短信定时任务表Service 创建人: liwei 创建日期:2018-05-11
 */
public interface SysMsgSendTaskService {

	/***
	 * 短信定时任务表列表分页
	 * 
	 * @param sysMsgSendTaskRequest
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysMsgSendTaskQueryRequest sysMsgSendTaskQueryRequest) throws Exception;

	/***
	 * 查询短信定时任务表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysMsgSendTask get(Long id) throws Exception;

	/***
	 * 短信定时任务表添加
	 * 
	 * @param sysMsgSendTask
	 * @return
	 * @throws Exception
	 */
	public boolean add(SysMsgSendTask sysMsgSendTask) throws Exception;

	/***
	 * 短信定时任务表修改
	 * 
	 * @param sysMsgSendTask
	 * @return
	 * @throws Exception
	 */
	public boolean update(SysMsgSendTask sysMsgSendTask) throws Exception;

	/***
	 * 删除短信定时任务表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Long id) throws Exception;

	/**
	 * 启用或者停用
	 * 
	 * @param sysMsgSendTask
	 * @return
	 */
	public boolean updatEenableOrDisable(SysMsgSendTask sysMsgSendTask);

	/**
	 * 查询所有启用的定时任务
	 */
	public List<SysMsgSendTask> selectByEnableData();

}
