package com.yxcoach.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.request.SysMsgRecordQueryRequest;

/**
 * SysMsgRecordService 注释:短信发送记录表Service 创建人: liwei 创建日期:2018-05-11
 */
public interface SysMsgRecordService {

	/***
	 * 短信发送记录表列表分页
	 * 
	 * @param sysMsgRecordRequest
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysMsgRecordQueryRequest sysMsgRecordQueryRequest) throws Exception;

	/***
	 * 查询短信发送记录表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysMsgRecord get(Long id) throws Exception;

	/***
	 * 短信发送记录表添加
	 * 
	 * @param sysMsgRecord
	 * @param sysMsgRecordService
	 * @return
	 * @throws Exception
	 */
	public boolean insertBatch(SysMsgRecord sysMsgRecord, List<BsMember> bsms, String[] receivers,
			ThreadPoolTaskExecutor messageExecutor, SysMsgRecordService sysMsgRecordService) throws Exception;

	/***
	 * 短信发送记录表修改
	 * 
	 * @param sysMsgRecord
	 * @return
	 * @throws Exception
	 */
	public boolean update(SysMsgRecord sysMsgRecord) throws Exception;

	/***
	 * 删除短信发送记录表
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Long id) throws Exception;

	/**
	 * 批量更新发送状态
	 * 
	 * @param maps
	 */
	public int updateBatch(Map<String, Object> maps);

}
