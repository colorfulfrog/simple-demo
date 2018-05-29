package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.request.SysPriceQueryRequest;
/**
 *  SysPriceService
 *  注释:计价管理表Service
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
public interface SysPriceService {
	
	/***
	 * 计价管理表列表分页
	 * @param sysPriceRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysPriceQueryRequest sysPriceQueryRequest) throws Exception;
	
	/***
	 * 查询计价管理表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public SysPrice get(Long id) throws Exception;
    
    /***
     * 计价管理表添加
     * @param sysPrice
     * @return
     * @throws Exception
     */
    public boolean add(SysPrice sysPrice) throws Exception;
    
    /***
     * 计价管理表修改
     * @param sysPrice
     * @return
     * @throws Exception
     */
    public boolean update(SysPrice sysPrice) throws Exception;
	/***
	 * 删除计价管理表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

}
