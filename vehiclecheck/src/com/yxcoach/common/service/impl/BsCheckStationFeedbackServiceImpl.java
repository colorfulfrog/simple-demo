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
import com.yxcoach.common.dao.BsCheckStationFeedbackDAO;
import com.yxcoach.common.entity.BsCheckStationFeedback;
import com.yxcoach.common.service.BsCheckStationFeedbackService;
import com.yxcoach.common.request.BsCheckStationFeedbackQueryRequest;
/**
 * @ClassName: BsCheckStationFeedbackServiceImpl
 * @Description: 检测站评价表 serviceImpl
 * @author liwei
 * @date 2018-05-11
 */
@Transactional(readOnly = true)
@Service("bsCheckStationFeedbackService")
public class BsCheckStationFeedbackServiceImpl implements BsCheckStationFeedbackService{
	private static final Log log = LogFactory.getLog(BsCheckStationFeedbackServiceImpl.class);
	
	@Resource(name = "bsCheckStationFeedbackDAO")
	private BsCheckStationFeedbackDAO bsCheckStationFeedbackDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsCheckStationFeedbackQueryRequest.getPageOption();
		if(bsCheckStationFeedbackQueryRequest.getPageOption().getRows()==null) bsCheckStationFeedbackQueryRequest.getPageOption().setRows(20);
		if(bsCheckStationFeedbackQueryRequest.getPageOption().getPage()==null) bsCheckStationFeedbackQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCheckStationFeedbackQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCheckStationFeedbackQueryRequest.getPageOption().getPage() - 1) * bsCheckStationFeedbackQueryRequest.getPageOption().getRows());
		
		if (Util.isNotNull(bsCheckStationFeedbackQueryRequest.getStation_id())) {
			map.put("station_id", bsCheckStationFeedbackQueryRequest.getStation_id());
		}
		if (Util.isNotNull(bsCheckStationFeedbackQueryRequest.getScore())) {
			map.put("score", bsCheckStationFeedbackQueryRequest.getScore());
		}
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsCheckStationFeedbackDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCheckStationFeedbackQueryRequest.getPageOption().getRows(), bsCheckStationFeedbackQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCheckStationFeedback>());
		}
		List<BsCheckStationFeedback> list = this.bsCheckStationFeedbackDAO.selectPage(map);
		for (BsCheckStationFeedback bsCheckStationFeedback : list) {
			List<BsCheckStationFeedback> labelList = bsCheckStationFeedbackDAO.statisticStationFeedbackLabel(bsCheckStationFeedback);
			StringBuffer feedBackLabel = new StringBuffer();
			for (BsCheckStationFeedback feecBack : labelList) {
				feedBackLabel.append(feecBack.getFeedback_label()).append("(").append(feecBack.getOrder_count()).append(") ");
			}
			bsCheckStationFeedback.setFeedback_label(feedBackLabel.toString().trim());
		}
		PageInfo pageInfo = new PageInfo(bsCheckStationFeedbackQueryRequest.getPageOption().getRows(), bsCheckStationFeedbackQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}
	
	/**
	 * 分页查询
	 */
	public PageInfo selectDetailListPage(BsCheckStationFeedbackQueryRequest bsCheckStationFeedbackQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsCheckStationFeedbackQueryRequest.getPageOption();
		if(bsCheckStationFeedbackQueryRequest.getPageOption().getRows()==null) bsCheckStationFeedbackQueryRequest.getPageOption().setRows(20);
		if(bsCheckStationFeedbackQueryRequest.getPageOption().getPage()==null) bsCheckStationFeedbackQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCheckStationFeedbackQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCheckStationFeedbackQueryRequest.getPageOption().getPage() - 1) * bsCheckStationFeedbackQueryRequest.getPageOption().getRows());
		
		if (Util.isNotNull(bsCheckStationFeedbackQueryRequest.getScore())) {
			map.put("score", bsCheckStationFeedbackQueryRequest.getScore());
		}
		if (Util.isNotNull(bsCheckStationFeedbackQueryRequest.getOrder_no())) {
			map.put("order_no", bsCheckStationFeedbackQueryRequest.getOrder_no());
		}
		if(Util.isNotNull(bsCheckStationFeedbackQueryRequest.getBeginTime())) {
			map.put("beginTime", bsCheckStationFeedbackQueryRequest.getBeginTime()+" 00:00:00");
		}
		if(Util.isNotNull(bsCheckStationFeedbackQueryRequest.getEndTime())) {
			map.put("endTime", bsCheckStationFeedbackQueryRequest.getEndTime()+" 23:59:59");
		}
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsCheckStationFeedbackDAO.selectFeedBackDetailPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCheckStationFeedbackQueryRequest.getPageOption().getRows(), bsCheckStationFeedbackQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCheckStationFeedback>());
		}
		List<BsCheckStationFeedback> list = this.bsCheckStationFeedbackDAO.selectFeedBackDetailPage(map);
		PageInfo pageInfo = new PageInfo(bsCheckStationFeedbackQueryRequest.getPageOption().getRows(), bsCheckStationFeedbackQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsCheckStationFeedback get(Long id) throws Exception {
		return bsCheckStationFeedbackDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsCheckStationFeedback bsCheckStationFeedback) throws Exception {
		Integer result = bsCheckStationFeedbackDAO.add(bsCheckStationFeedback);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsCheckStationFeedback bsCheckStationFeedback) throws Exception {
		Integer result = bsCheckStationFeedbackDAO.update(bsCheckStationFeedback);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsCheckStationFeedbackDAO.deleteById(id);
		return result>0?true:false;
	}
}
