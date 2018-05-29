package com.yxcoach.common.dao;

import java.util.List;
import java.util.Map;
import com.yxcoach.common.base.annotation.MyBatisDao;
import org.springframework.stereotype.Component;
import com.yxcoach.common.entity.BsCouponType;

/**
 * 
 * bs_coupon_typeDao 注释:优惠券类型表 创建人: liwei 创建日期:2018-05-15
 */
@MyBatisDao
@Component("bsCouponTypeDAO")
public interface BsCouponTypeDAO {
	/**
	 * 获取优惠券类型表分页数据
	 */
	public List<BsCouponType> selectPage(Map<String, Object> map) throws Exception;

	/**
	 * 获取优惠券类型表分页数据条数
	 */
	public Integer selectPageCount(Map<String, Object> map) throws Exception;

	/**
	 * 根据ID查询优惠券类型表
	 */
	public BsCouponType getById(java.lang.Long id) throws Exception;

	/**
	 * 根据ID修改优惠券类型表
	 */
	public Integer update(BsCouponType bsCouponType) throws Exception;

	/**
	 * 添加优惠券类型表
	 */
	public Integer add(BsCouponType bsCouponType) throws Exception;

	/**
	 * 根据ID删除优惠券类型表
	 */
	public Integer deleteById(java.lang.Long id) throws Exception;

	/**
	 * 车主查询-代金劵
	 * 
	 * @return
	 */
	public List<BsCouponType> selectCoupon();

	/**
	 * 获取活动管理 -优惠券类型表分页数据
	 */
	public Integer selectActivityCouponPageCount(Map<String, Object> map);
	public List<BsCouponType> selectActivityCouponPage(Map<String, Object> map);
}