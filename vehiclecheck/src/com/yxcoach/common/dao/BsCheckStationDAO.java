package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsCheckStation;

/**
 *	
 *  bs_check_stationDao
 *  注释:检测站表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsCheckStationDAO")
public interface BsCheckStationDAO{
	/**
	 * 获取检测站表分页数据
	 */
	public List<BsCheckStation> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取检测站表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询检测站表
	 */
	public BsCheckStation getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改检测站表
	 */
	public Integer update(BsCheckStation bsCheckStation) throws Exception;
	/**
	 * 添加检测站表
	 */
	public Integer add(BsCheckStation bsCheckStation)throws Exception;
	/**
	 * 根据ID删除检测站表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	/**
	 * 查询所有检测站
	 */
	public List<BsCheckStation> all();
}