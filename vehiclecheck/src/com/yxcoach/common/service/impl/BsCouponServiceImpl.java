package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.BsCouponDAO;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.service.BsCouponService;
import com.yxcoach.common.request.BsCouponQueryRequest;

/**
 * @ClassName: BsCouponServiceImpl
 * @Description: 优惠券表 serviceImpl
 * @author liwei
 * @date 2018-05-15
 */
@Transactional(readOnly = true)
@Service("bsCouponService")
public class BsCouponServiceImpl implements BsCouponService {
	private static final Log log = LogFactory.getLog(BsCouponServiceImpl.class);

	@Resource(name = "bsCouponDAO")
	private BsCouponDAO bsCouponDAO;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsCouponQueryRequest bsCouponQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsCouponQueryRequest.getPageOption();
		if (bsCouponQueryRequest.getPageOption().getRows() == null)
			bsCouponQueryRequest.getPageOption().setRows(20);
		if (bsCouponQueryRequest.getPageOption().getPage() == null)
			bsCouponQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCouponQueryRequest.getPageOption().getRows());
		map.put("BEGIN",
				(bsCouponQueryRequest.getPageOption().getPage() - 1) * bsCouponQueryRequest.getPageOption().getRows());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsCouponDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCouponQueryRequest.getPageOption().getRows(),
					bsCouponQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCoupon>());
		}
		List<BsCoupon> list = this.bsCouponDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsCouponQueryRequest.getPageOption().getRows(),
				bsCouponQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsCoupon get(Long id) throws Exception {
		return bsCouponDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsCoupon bsCoupon) throws Exception {
		Integer result = bsCouponDAO.add(bsCoupon);
		return result > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsCoupon bsCoupon) throws Exception {
		Integer result = bsCouponDAO.update(bsCoupon);
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsCouponDAO.deleteById(id);
		return result > 0 ? true : false;
	}

	/**
	 * 优惠券明细
	 */
	@Override
	public PageInfo selectDetailedPage(BsCouponQueryRequest bsCouponQueryRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsCouponQueryRequest.getPageOption();
		if (bsCouponQueryRequest.getPageOption().getRows() == null)
			bsCouponQueryRequest.getPageOption().setRows(20);
		if (bsCouponQueryRequest.getPageOption().getPage() == null)
			bsCouponQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCouponQueryRequest.getPageOption().getRows());
		map.put("BEGIN",
				(bsCouponQueryRequest.getPageOption().getPage() - 1) * bsCouponQueryRequest.getPageOption().getRows());
		map.put("coupon_type_id", bsCouponQueryRequest.getCoupon_type_id());
		if (Util.isNotNull(bsCouponQueryRequest.getStatus())) //
			map.put("telphone", bsCouponQueryRequest.getStatus());
		if (Util.isNotNull(bsCouponQueryRequest.getCoupon_code())) //
			map.put("coupon_code", bsCouponQueryRequest.getCoupon_code());
		if (Util.isNotNull(bsCouponQueryRequest.getStatus())) //
			map.put("status", bsCouponQueryRequest.getStatus());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsCouponDAO.selectDetailedPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCouponQueryRequest.getPageOption().getRows(),
					bsCouponQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCoupon>());
		}
		List<BsCoupon> list = this.bsCouponDAO.selectDetailedPage(map);
		PageInfo pageInfo = new PageInfo(bsCouponQueryRequest.getPageOption().getRows(),
				bsCouponQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
}
