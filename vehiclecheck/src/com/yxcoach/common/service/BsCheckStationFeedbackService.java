package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsCheckStationFeedback;
import com.yxcoach.common.request.BsCheckStationFeedbackQueryRequest;
/**
 *  BsCheckStationFeedbackService
 *  注释:检测站评价表Service
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
public interface BsCheckStationFeedbackService {
	
	/***
	 * 检测站评价表列表分页
	 * @param bsCheckStationFeedbackRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception;
	
	/***
	 * 查询检测站评价表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsCheckStationFeedback get(Long id) throws Exception;
    
    /***
     * 检测站评价表添加
     * @param bsCheckStationFeedback
     * @return
     * @throws Exception
     */
    public boolean add(BsCheckStationFeedback bsCheckStationFeedback) throws Exception;
    
    /***
     * 检测站评价表修改
     * @param bsCheckStationFeedback
     * @return
     * @throws Exception
     */
    public boolean update(BsCheckStationFeedback bsCheckStationFeedback) throws Exception;
	/***
	 * 删除检测站评价表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

	public PageInfo selectDetailListPage(BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception;
}
