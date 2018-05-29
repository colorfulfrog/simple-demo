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
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.SysDiscountDAO;
import com.yxcoach.common.entity.SysDiscount;
import com.yxcoach.common.service.SysDiscountService;
import com.yxcoach.common.request.SysDiscountQueryRequest;
/**
 * @ClassName: SysDiscountServiceImpl
 * @Description: 预约折扣表 serviceImpl
 * @author liwei
 * @date 2018-05-15
 */
@Transactional(readOnly = true)
@Service("sysDiscountService")
public class SysDiscountServiceImpl implements SysDiscountService{
	private static final Log log = LogFactory.getLog(SysDiscountServiceImpl.class);
	
	@Resource(name = "sysDiscountDAO")
	private SysDiscountDAO sysDiscountDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysDiscountQueryRequest sysDiscountQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=sysDiscountQueryRequest.getPageOption();
		if(sysDiscountQueryRequest.getPageOption().getRows()==null) sysDiscountQueryRequest.getPageOption().setRows(20);
		if(sysDiscountQueryRequest.getPageOption().getPage()==null) sysDiscountQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysDiscountQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysDiscountQueryRequest.getPageOption().getPage() - 1) * sysDiscountQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.sysDiscountDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysDiscountQueryRequest.getPageOption().getRows(), sysDiscountQueryRequest.getPageOption().getPage(), count, new ArrayList<SysDiscount>());
		}
		List<SysDiscount> list = this.sysDiscountDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysDiscountQueryRequest.getPageOption().getRows(), sysDiscountQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public SysDiscount get(Long id) throws Exception {
		return sysDiscountDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysDiscount sysDiscount) throws Exception {
		Integer result = sysDiscountDAO.add(sysDiscount);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysDiscount sysDiscount) throws Exception {
		Integer result = sysDiscountDAO.update(sysDiscount);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = sysDiscountDAO.deleteById(id);
		return result>0?true:false;
	}

	@Override
	public String getAllDiscountShow() {
		StringBuffer result = new StringBuffer();
		List<SysDiscount> allDiscounts = sysDiscountDAO.getAllDiscounts();
		for (SysDiscount sysDiscount : allDiscounts) {
			result.append("提前"+sysDiscount.getPre_order_days()+"天"+sysDiscount.getDiscount()+"折，");
		}
		return result.toString().substring(0, result.toString().length()-1);
	}
}
