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
import com.yxcoach.common.dao.SysPriceDAO;
import com.yxcoach.common.entity.SysPrice;
import com.yxcoach.common.service.SysPriceService;
import com.yxcoach.common.request.SysPriceQueryRequest;

/**
 * @ClassName: SysPriceServiceImpl
 * @Description: 计价管理表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("sysPriceService")
public class SysPriceServiceImpl implements SysPriceService {
	private static final Log log = LogFactory.getLog(SysPriceServiceImpl.class);

	@Resource(name = "sysPriceDAO")
	private SysPriceDAO sysPriceDAO;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysPriceQueryRequest sysPriceQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = sysPriceQueryRequest.getPageOption();
		if (sysPriceQueryRequest.getPageOption().getRows() == null)
			sysPriceQueryRequest.getPageOption().setRows(20);
		if (sysPriceQueryRequest.getPageOption().getPage() == null)
			sysPriceQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysPriceQueryRequest.getPageOption().getRows());
		map.put("BEGIN",
				(sysPriceQueryRequest.getPageOption().getPage() - 1) * sysPriceQueryRequest.getPageOption().getRows());

		// 分页条件条件
		// 车辆年限 car_year
		// 座位数 seat_num
		// 总质量 weight
		// 是否运营is_operate_car
		if (Util.isNotNull(sysPriceQueryRequest.getCar_year())) //
			map.put("car_year", sysPriceQueryRequest.getCar_year());
		if (Util.isNotNull(sysPriceQueryRequest.getSeat_num()))//
			map.put("seat_num", sysPriceQueryRequest.getSeat_num());
		if (Util.isNotNull(sysPriceQueryRequest.getWeight())) //
			map.put("weight", sysPriceQueryRequest.getWeight());
		if (Util.isNotNull(sysPriceQueryRequest.getIs_operate_car())) //
			map.put("is_operate_car", sysPriceQueryRequest.getIs_operate_car());
		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.sysPriceDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysPriceQueryRequest.getPageOption().getRows(),
					sysPriceQueryRequest.getPageOption().getPage(), count, new ArrayList<SysPrice>());
		}
		List<SysPrice> list = this.sysPriceDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysPriceQueryRequest.getPageOption().getRows(),
				sysPriceQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public SysPrice get(Long id) throws Exception {
		return sysPriceDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysPrice sysPrice) throws Exception {
		Integer result = sysPriceDAO.add(sysPrice);
		return result > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysPrice sysPrice) throws Exception {
		Integer result = sysPriceDAO.update(sysPrice);
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = sysPriceDAO.deleteById(id);
		return result > 0 ? true : false;
	}
}
