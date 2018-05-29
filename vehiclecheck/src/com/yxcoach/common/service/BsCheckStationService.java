package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.request.BsCheckStationQueryRequest;
/**
 *  BsCheckStationService
 *  注释:检测站表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface BsCheckStationService {
	
	/***
	 * 检测站表列表分页
	 * @param bsCheckStationRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsCheckStationQueryRequest bsCheckStationQueryRequest) throws Exception;
	
	/***
	 * 查询检测站表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsCheckStation get(Long id) throws Exception;
    
    /***
     * 检测站表添加
     * @param bsCheckStation
     * @return
     * @throws Exception
     */
    public boolean add(BsCheckStation bsCheckStation) throws Exception;
    
    /***
     * 检测站表修改
     * @param bsCheckStation
     * @return
     * @throws Exception
     */
    public boolean update(BsCheckStation bsCheckStation) throws Exception;
	/***
	 * 删除检测站表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /**
     * 查询所有检测站
     * @return
     * @throws Exception
     */
	public List<BsCheckStation> all() throws Exception;
}
