package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.BsActivity;
import com.yxcoach.common.request.BsActivityQueryRequest;
/**
 *  BsActivityService
 *  注释:活动表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface BsActivityService {
	
	/***
	 * 活动表列表分页
	 * @param bsActivityRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsActivityQueryRequest bsActivityQueryRequest) throws Exception;
	
	/***
	 * 查询活动表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsActivity get(Long id) throws Exception;
    
    /***
     * 活动表添加
     * @param bsActivity
     * @return
     * @throws Exception
     */
    public boolean add(BsActivity bsActivity) throws Exception;
    
    /***
     * 活动表修改
     * @param bsActivity
     * @return
     * @throws Exception
     */
    public boolean update(BsActivity bsActivity) throws Exception;
	/***
	 * 删除活动表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
