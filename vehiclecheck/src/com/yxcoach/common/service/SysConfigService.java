package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.SysConfig;
import com.yxcoach.common.request.SysConfigQueryRequest;
/**
 *  SysConfigService
 *  注释:参数配置表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface SysConfigService {
	
	/***
	 * 参数配置表列表分页
	 * @param sysConfigRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysConfigQueryRequest sysConfigQueryRequest) throws Exception;
	

	/**
	 * 统计总条数
	 * @return
	 * @throws Exception
	 */
	public int countSum() throws Exception;
	
	/***
	 * 查询参数配置表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public SysConfig get(Long id) throws Exception;
    
    /***
     * 参数配置表添加
     * @param sysConfig
     * @return
     * @throws Exception
     */
    public boolean add(SysConfig sysConfig) throws Exception;
    
    /***
     * 参数配置表修改
     * @param sysConfig
     * @return
     * @throws Exception
     */
    public boolean update(SysConfig sysConfig) throws Exception;
	/***
	 * 删除参数配置表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
