package com.yxcoach.common.service;

import java.util.List;

import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.request.BsCouponTypeQueryRequest;
/**
 *  BsCouponTypeService
 *  注释:优惠券类型表Service
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
public interface BsCouponTypeService {
	
	/***
	 * 优惠券类型表列表分页
	 * @param bsCouponTypeRequest 
	 * @return
	 * @throws Exception
	 */
	public PageInfo selectPage(BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception;
	
	/***
	 * 查询优惠券类型表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public BsCouponType get(Long id) throws Exception;
    
    /***
     * 优惠券类型表添加
     * @param bsCouponType
     * @return
     * @throws Exception
     */
    public boolean add(BsCouponType bsCouponType) throws Exception;
    
    /***
     * 优惠券类型表修改
     * @param bsCouponType
     * @return
     * @throws Exception
     */
    public boolean update(BsCouponType bsCouponType) throws Exception;
	/***
	 * 删除优惠券类型表
	 * @param id
	 * @return
	 * @throws Exception
	 */
    public boolean delete(Long id) throws Exception;

    /**
     * 车主查询-代金劵
     * @return
     */
	public List<BsCouponType> selectCoupon();

	
	/**
	 * 活动 -优惠券列表
	 * @param bsCouponTypeQueryRequest
	 * @return
	 */
	public PageInfo selectActivityCouponPage(BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception;

}
