package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.annotation.MyBatisDao;

import org.springframework.stereotype.Component;

import com.yxcoach.common.entity.BsCheckStationFeedback;

/**
 *	
 *  bs_check_station_feedbackDao
 *  注释:检测站评价表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@MyBatisDao
@Component("bsCheckStationFeedbackDAO")
public interface BsCheckStationFeedbackDAO{
	/**
	 * 获取检测站评价表分页数据
	 */
	public List<BsCheckStationFeedback> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取检测站评价表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询检测站评价表
	 */
	public BsCheckStationFeedback getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改检测站评价表
	 */
	public Integer update(BsCheckStationFeedback bsCheckStationFeedback) throws Exception;
	/**
	 * 添加检测站评价表
	 */
	public Integer add(BsCheckStationFeedback bsCheckStationFeedback)throws Exception;
	/**
	 * 根据ID删除检测站评价表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 统计检测站评价标签
	 */
	public List<BsCheckStationFeedback> statisticStationFeedbackLabel(BsCheckStationFeedback bsCheckStationFeedback) throws Exception;
	public List<BsCheckStationFeedback> selectFeedBackDetailPage(Map<String, Object> map) throws Exception;
	public Integer selectFeedBackDetailPageCount(Map<String,Object> map) throws Exception;
}