package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsInviteRecord;

/**
 *	
 *  bs_invite_recordDao
 *  注释:好友推荐邀请表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsInviteRecordDAO")
public interface BsInviteRecordDAO{
	/**
	 * 获取好友推荐邀请表分页数据
	 */
	public List<BsInviteRecord> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取好友推荐邀请表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询好友推荐邀请表
	 */
	public BsInviteRecord getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改好友推荐邀请表
	 */
	public Integer update(BsInviteRecord bsInviteRecord) throws Exception;
	/**
	 * 添加好友推荐邀请表
	 */
	public Integer add(BsInviteRecord bsInviteRecord)throws Exception;
	/**
	 * 根据ID删除好友推荐邀请表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
}