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
import com.yxcoach.common.dao.BsWithdrawCashBillDAO;
import com.yxcoach.common.entity.BsWithdrawCashBill;
import com.yxcoach.common.service.BsWithdrawCashBillService;
import com.yxcoach.common.request.BsWithdrawCashBillQueryRequest;
/**
 * @ClassName: BsWithdrawCashBillServiceImpl
 * @Description: 提现记录表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsWithdrawCashBillService")
public class BsWithdrawCashBillServiceImpl implements BsWithdrawCashBillService{
	private static final Log log = LogFactory.getLog(BsWithdrawCashBillServiceImpl.class);
	
	@Resource(name = "bsWithdrawCashBillDAO")
	private BsWithdrawCashBillDAO bsWithdrawCashBillDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsWithdrawCashBillQueryRequest bsWithdrawCashBillQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsWithdrawCashBillQueryRequest.getPageOption();
		if(bsWithdrawCashBillQueryRequest.getPageOption().getRows()==null) bsWithdrawCashBillQueryRequest.getPageOption().setRows(20);
		if(bsWithdrawCashBillQueryRequest.getPageOption().getPage()==null) bsWithdrawCashBillQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsWithdrawCashBillQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsWithdrawCashBillQueryRequest.getPageOption().getPage() - 1) * bsWithdrawCashBillQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsWithdrawCashBillDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsWithdrawCashBillQueryRequest.getPageOption().getRows(), bsWithdrawCashBillQueryRequest.getPageOption().getPage(), count, new ArrayList<BsWithdrawCashBill>());
		}
		List<BsWithdrawCashBill> list = this.bsWithdrawCashBillDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsWithdrawCashBillQueryRequest.getPageOption().getRows(), bsWithdrawCashBillQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsWithdrawCashBill get(Long id) throws Exception {
		return bsWithdrawCashBillDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsWithdrawCashBill bsWithdrawCashBill) throws Exception {
		Integer result = bsWithdrawCashBillDAO.add(bsWithdrawCashBill);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsWithdrawCashBill bsWithdrawCashBill) throws Exception {
		Integer result = bsWithdrawCashBillDAO.update(bsWithdrawCashBill);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsWithdrawCashBillDAO.deleteById(id);
		return result>0?true:false;
	}
}
