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
import com.yxcoach.common.dao.BsActivityDAO;
import com.yxcoach.common.entity.BsActivity;
import com.yxcoach.common.service.BsActivityService;
import com.yxcoach.common.request.BsActivityQueryRequest;
/**
 * @ClassName: BsActivityServiceImpl
 * @Description: 活动表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsActivityService")
public class BsActivityServiceImpl implements BsActivityService{
	private static final Log log = LogFactory.getLog(BsActivityServiceImpl.class);
	
	@Resource(name = "bsActivityDAO")
	private BsActivityDAO bsActivityDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsActivityQueryRequest bsActivityQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsActivityQueryRequest.getPageOption();
		if(bsActivityQueryRequest.getPageOption().getRows()==null) bsActivityQueryRequest.getPageOption().setRows(20);
		if(bsActivityQueryRequest.getPageOption().getPage()==null) bsActivityQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsActivityQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsActivityQueryRequest.getPageOption().getPage() - 1) * bsActivityQueryRequest.getPageOption().getRows());
		

		if (Util.isNotNull(bsActivityQueryRequest.getBsActivity().getId())) //
			map.put("id", bsActivityQueryRequest.getBsActivity().getId());
		if (Util.isNotNull(bsActivityQueryRequest.getBsActivity().getStart_time()))//
			map.put("start_time", bsActivityQueryRequest.getBsActivity().getStart_time());
		if (Util.isNotNull(bsActivityQueryRequest.getBsActivity().getEnd_time())) //
			map.put("end_time", bsActivityQueryRequest.getBsActivity().getEnd_time());
		if (Util.isNotNull(bsActivityQueryRequest.getBsActivity().getStatus())) //
			map.put("status", bsActivityQueryRequest.getBsActivity().getStatus());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsActivityDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsActivityQueryRequest.getPageOption().getRows(), bsActivityQueryRequest.getPageOption().getPage(), count, new ArrayList<BsActivity>());
		}
		List<BsActivity> list = this.bsActivityDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsActivityQueryRequest.getPageOption().getRows(), bsActivityQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsActivity get(Long id) throws Exception {
		return bsActivityDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsActivity bsActivity) throws Exception {
		Integer result = bsActivityDAO.add(bsActivity);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsActivity bsActivity) throws Exception {
		Integer result = bsActivityDAO.update(bsActivity);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsActivityDAO.deleteById(id);
		return result>0?true:false;
	}
}
