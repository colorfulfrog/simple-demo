package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.BsInviteRecord;
import com.yxcoach.common.request.BsInviteRecordQueryRequest;
/**
 *  BsInviteRecordService
 *  注释:好友推荐邀请表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface BsInviteRecordService {
	
	/***
	 * 好友推荐邀请表列表分页
	 * @param bsInviteRecordRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsInviteRecordQueryRequest bsInviteRecordQueryRequest) throws Exception;
	
	/***
	 * 查询好友推荐邀请表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsInviteRecord get(Long id) throws Exception;
    
    /***
     * 好友推荐邀请表添加
     * @param bsInviteRecord
     * @return
     * @throws Exception
     */
    public boolean add(BsInviteRecord bsInviteRecord) throws Exception;
    
    /***
     * 好友推荐邀请表修改
     * @param bsInviteRecord
     * @return
     * @throws Exception
     */
    public boolean update(BsInviteRecord bsInviteRecord) throws Exception;
	/***
	 * 删除好友推荐邀请表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
