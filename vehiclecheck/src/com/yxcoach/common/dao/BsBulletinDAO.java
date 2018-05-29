package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsBulletin;

/**
 *	
 *  bs_bulletinDao
 *  注释:车检动态表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@MyBatisDao
@Component("bsBulletinDAO")
public interface BsBulletinDAO{
	/**
	 * 获取车检动态表分页数据
	 */
	public List<BsBulletin> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取车检动态表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询车检动态表
	 */
	public BsBulletin getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改车检动态表
	 */
	public Integer update(BsBulletin bsBulletin) throws Exception;
	/**
	 * 添加车检动态表
	 */
	public Integer add(BsBulletin bsBulletin)throws Exception;
	/**
	 * 根据ID删除车检动态表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
}