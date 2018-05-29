package com.yxcoach.common.service;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.request.BsCouponQueryRequest;
/**
 *  BsCouponService
 *  注释:优惠券表Service
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
public interface BsCouponService {
	
	/***
	 * 优惠券表列表分页
	 * @param bsCouponRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsCouponQueryRequest bsCouponQueryRequest) throws Exception;
	
	/***
	 * 查询优惠券表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsCoupon get(Long id) throws Exception;
    
    /***
     * 优惠券表添加
     * @param bsCoupon
     * @return
     * @throws Exception
     */
    public boolean add(BsCoupon bsCoupon) throws Exception;
    
    /***
     * 优惠券表修改
     * @param bsCoupon
     * @return
     * @throws Exception
     */
    public boolean update(BsCoupon bsCoupon) throws Exception;
	/***
	 * 删除优惠券表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /***
	 * 优惠券明细列表分页
	 * @param bsCouponRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectDetailedPage(BsCouponQueryRequest bsCouponQueryRequest);

}
