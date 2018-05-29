package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;

/**
 *	
 *  sys_msg_recordDao
 *  注释:短信发送记录表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@MyBatisDao
@Component("sysMsgRecordDAO")
public interface SysMsgRecordDAO{
	/**
	 * 获取短信发送记录表分页数据
	 */
	public List<SysMsgRecord> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取短信发送记录表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询短信发送记录表
	 */
	public SysMsgRecord getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改短信发送记录表
	 */
	public Integer update(SysMsgRecord sysMsgRecord) throws Exception;
	/**
	 * 添加短信发送记录表
	 */
	public Integer add(SysMsgRecord sysMsgRecord)throws Exception;
	/**
	 * 根据ID删除短信发送记录表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 批量保存
	 * @param bsMembers
	 * @return
	 */
	public int addBatch(List<SysMsgRecord> list);
	

	/**
	 * 批量更新发送状态
	 */
	public int updateBatch(Map<String, Object> map);
	
}