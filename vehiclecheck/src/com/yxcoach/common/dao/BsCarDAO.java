package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsMember;

/**
 *	
 *  bs_carDao
 *  注释:车辆表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@MyBatisDao
@Component("bsCarDAO")
public interface BsCarDAO{
	/**
	 * 获取车辆表分页数据
	 */
	public List<BsCar> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取车辆表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询车辆表
	 */
	public BsCar getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改车辆表
	 */
	public Integer update(BsCar bsCar) throws Exception;
	/**
	 * 添加车辆表
	 */
	public Integer add(BsCar bsCar)throws Exception;
	/**
	 * 根据ID删除车辆表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 根据条件查询车辆列表
	 */
	public List<BsCar> getCarsByCon(BsCar bsCar) throws Exception;
	
	/**
	 * 查询当天+ days 要发短信的车辆(需要通知检测的会员用户车辆)
	 * @return
	 */
	public List<BsCar> selectBsCarCheckDate(Map<String, Object>map);
	
	/**
	 * 我的车辆
	 * @param id
	 * @return
	 * regist_date,frame_num,engine_num,type 
	 */
	public List<BsCar> selectMeCar(Map<String,Object> map);
	public Integer selectMeCarCount(Map<String,Object> map) throws Exception;
}