package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsActivity;

/**
 *	
 *  bs_activityDao
 *  注释:活动表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsActivityDAO")
public interface BsActivityDAO{
	/**
	 * 获取活动表分页数据
	 */
	public List<BsActivity> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取活动表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询活动表
	 */
	public BsActivity getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改活动表
	 */
	public Integer update(BsActivity bsActivity) throws Exception;
	/**
	 * 添加活动表
	 */
	public Integer add(BsActivity bsActivity)throws Exception;
	/**
	 * 根据ID删除活动表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
}