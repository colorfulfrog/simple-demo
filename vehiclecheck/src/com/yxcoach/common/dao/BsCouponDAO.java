package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.entity.SysMsgRecord;

/**
 *	
 *  bs_couponDao
 *  注释:优惠券表
 *  创建人: liwei
 *  创建日期:2018-05-15
 */
@MyBatisDao
@Component("bsCouponDAO")
public interface BsCouponDAO{
	/**
	 * 获取优惠券表分页数据
	 */
	public List<BsCoupon> selectPage(Map<String,Object> map) throws Exception;
	/**
	 * 获取优惠券表分页数据条数
	 */
	public Integer selectPageCount(Map<String,Object> map) throws Exception;
	/**
	 * 根据ID查询优惠券表
	 */
	public BsCoupon getById(java.lang.Long id) throws Exception;
	/**
	 * 根据ID修改优惠券表
	 */
	public Integer update(BsCoupon bsCoupon) throws Exception;
	/**
	 * 添加优惠券表
	 */
	public Integer add(BsCoupon bsCoupon)throws Exception;
	/**
	 * 根据ID删除优惠券表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;
	
	/**
	 * 批量添加优惠券表
	 */
	public int addBatch(List<BsCoupon> list);
	
	/**
	 * 优惠券明细
	 * @param map
	 * @return
	 */
	public Integer selectDetailedPageCount(Map<String, Object> map);
	public List<BsCoupon> selectDetailedPage(Map<String, Object> map);
	
	/**
	 * 查询当前Coupon_type_id 未领取的优惠券
	 * @param coupon_type_id
	 */
	public List<BsCoupon> selectCouponStatusUnreceived(Map<String, Object> map);
	
	/**
	 * 更新一条优惠券状态为未使用 发给当前车主
	 * @param bsCoupon
	 */
	public Integer updateStatus(BsCoupon bsCoupon);
	
}