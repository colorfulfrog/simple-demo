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
import com.yxcoach.common.base.util.SnowFlake;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.BsCouponDAO;
import com.yxcoach.common.dao.BsCouponTypeDAO;
import com.yxcoach.common.entity.BsCoupon;
import com.yxcoach.common.entity.BsCouponType;
import com.yxcoach.common.service.BsCouponTypeService;
import com.yxcoach.common.request.BsCouponTypeQueryRequest;

/**
 * @ClassName: BsCouponTypeServiceImpl
 * @Description: 优惠券类型表 serviceImpl
 * @author liwei
 * @date 2018-05-15
 */
@Transactional(readOnly = true)
@Service("bsCouponTypeService")
public class BsCouponTypeServiceImpl implements BsCouponTypeService {
	private static final Log log = LogFactory.getLog(BsCouponTypeServiceImpl.class);

	@Resource(name = "bsCouponTypeDAO")
	private BsCouponTypeDAO bsCouponTypeDAO;
	@Resource(name = "bsCouponDAO")
	private BsCouponDAO bsCouponDAO;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsCouponTypeQueryRequest.getPageOption();
		if (bsCouponTypeQueryRequest.getPageOption().getRows() == null)
			bsCouponTypeQueryRequest.getPageOption().setRows(20);
		if (bsCouponTypeQueryRequest.getPageOption().getPage() == null)
			bsCouponTypeQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCouponTypeQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCouponTypeQueryRequest.getPageOption().getPage() - 1)
				* bsCouponTypeQueryRequest.getPageOption().getRows());

		if (Util.isNotNull(bsCouponTypeQueryRequest.getType())) //
			map.put("type", bsCouponTypeQueryRequest.getType());
		if (Util.isNotNull(bsCouponTypeQueryRequest.getStatus())) //
			map.put("status", bsCouponTypeQueryRequest.getStatus());
		if (Util.isNotNull(bsCouponTypeQueryRequest.getStart_time())) //
			map.put("start_time", bsCouponTypeQueryRequest.getStart_time());
		if (Util.isNotNull(bsCouponTypeQueryRequest.getEnd_time())) //
			map.put("end_time", bsCouponTypeQueryRequest.getEnd_time());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsCouponTypeDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCouponTypeQueryRequest.getPageOption().getRows(),
					bsCouponTypeQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCouponType>());
		}
		List<BsCouponType> list = this.bsCouponTypeDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsCouponTypeQueryRequest.getPageOption().getRows(),
				bsCouponTypeQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsCouponType get(Long id) throws Exception {
		return bsCouponTypeDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsCouponType bsCouponType) throws Exception {
		int z = 0;
		bsCouponTypeDAO.add(bsCouponType);
		// 保存优惠券
		SnowFlake worker = new SnowFlake(1, 1, 1);
		List<BsCoupon> bss = new ArrayList<BsCoupon>();
		for (int i = 1; i <= bsCouponType.getNum(); i++) {
			BsCoupon bs = new BsCoupon();
			bs.setCoupon_type_id(bsCouponType.getId());
			bs.setCoupon_code(worker.nextId() + "");
			bs.setStatus(4L);//未领取
			bss.add(bs);
		}
		z = bsCouponDAO.addBatch(bss);
		return z > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsCouponType bsCouponType) throws Exception {
		Integer result = bsCouponTypeDAO.update(bsCouponType);
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsCouponTypeDAO.deleteById(id);
		return result > 0 ? true : false;
	}
	   
	/**
	 * 车主查询-代金劵
	 * 
	 * @return
	 */
	@Override
	public List<BsCouponType> selectCoupon() {
		return bsCouponTypeDAO.selectCoupon();
	}

	/**
	 * 活动 -优惠券列表
	 * @throws Exception 
	 */
	@Override
	public PageInfo selectActivityCouponPage(BsCouponTypeQueryRequest bsCouponTypeQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = bsCouponTypeQueryRequest.getPageOption();
		if (bsCouponTypeQueryRequest.getPageOption().getRows() == null)
			bsCouponTypeQueryRequest.getPageOption().setRows(20);
		if (bsCouponTypeQueryRequest.getPageOption().getPage() == null)
			bsCouponTypeQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCouponTypeQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCouponTypeQueryRequest.getPageOption().getPage() - 1)
				* bsCouponTypeQueryRequest.getPageOption().getRows());

		if (Util.isNotNull(bsCouponTypeQueryRequest.getActivity_id())) //
			map.put("activity_id", bsCouponTypeQueryRequest.getType());
		if (Util.isNotNull(bsCouponTypeQueryRequest.getId())) //
			map.put("id", bsCouponTypeQueryRequest.getId());
		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.bsCouponTypeDAO.selectActivityCouponPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCouponTypeQueryRequest.getPageOption().getRows(),
					bsCouponTypeQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCouponType>());
		}
		List<BsCouponType> list = this.bsCouponTypeDAO.selectActivityCouponPage(map);
		PageInfo pageInfo = new PageInfo(bsCouponTypeQueryRequest.getPageOption().getRows(),
				bsCouponTypeQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
}
