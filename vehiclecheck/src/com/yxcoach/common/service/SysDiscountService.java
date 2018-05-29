package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.SysDiscount;
import com.yxcoach.common.request.SysDiscountQueryRequest;
/**
 *  SysDiscountService
 *  注释:预约折扣表Service
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
public interface SysDiscountService {
	
	/***
	 * 预约折扣表列表分页
	 * @param sysDiscountRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(SysDiscountQueryRequest sysDiscountQueryRequest) throws Exception;
	
	/***
	 * 查询预约折扣表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public SysDiscount get(Long id) throws Exception;
    
    /***
     * 预约折扣表添加
     * @param sysDiscount
     * @return
     * @throws Exception
     */
    public boolean add(SysDiscount sysDiscount) throws Exception;
    
    /***
     * 预约折扣表修改
     * @param sysDiscount
     * @return
     * @throws Exception
     */
    public boolean update(SysDiscount sysDiscount) throws Exception;
	/***
	 * 删除预约折扣表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /**
     * 获得所有折扣优惠文案
     * @return
     */
	public String getAllDiscountShow();

}
