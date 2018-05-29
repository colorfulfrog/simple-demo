package com.yxcoach.common.service;

import java.util.List;
import java.util.Map;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.request.BsCarQueryRequest;
import com.yxcoach.common.request.BsMemberQueryRequest;
/**
 *  BsCarService
 *  注释:车辆表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface BsCarService {
	
	/***
	 * 车辆表列表分页
	 * @param bsCarRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsCarQueryRequest bsCarQueryRequest) throws Exception;
	
	/***
	 * 查询车辆表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsCar get(Long id) throws Exception;
    
    /***
     * 车辆表添加
     * @param bsCar
     * @return
     * @throws Exception
     */
    public boolean add(BsCar bsCar) throws Exception;
    
    /***
     * 车辆表修改
     * @param bsCar
     * @return
     * @throws Exception
     */
    public boolean update(BsCar bsCar) throws Exception;
	/***
	 * 删除车辆表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /**
     * 查询会员所有车辆
     * @param memberID 会员ID
     * @return
     * @throws Exception
     */
    public List<BsCar> getAllCarsByOwner(Long memberID) throws Exception;

    /**
     * 查询当天+ days 要发短信的车辆(需要通知检测的会员用户车辆)
     * @return
     */
	public List<BsCar> selectBsCarCheckDate(Map<String, Object>map) throws Exception;

	/**
	 * 我的车辆
	 * @param id
	 * @return
	 */
	public PageInfo selectMeCar(BsCarQueryRequest bsMemberQueryRequest)throws Exception;

	public List<BsCar> export(BsCar bsCar) throws Exception;
}
