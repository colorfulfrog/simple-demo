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
import com.yxcoach.common.dao.BsCheckStationDAO;
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.service.BsCheckStationService;
import com.yxcoach.common.request.BsCheckStationQueryRequest;
/**
 * @ClassName: BsCheckStationServiceImpl
 * @Description: 检测站表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsCheckStationService")
public class BsCheckStationServiceImpl implements BsCheckStationService{
	private static final Log log = LogFactory.getLog(BsCheckStationServiceImpl.class);
	
	@Resource(name = "bsCheckStationDAO")
	private BsCheckStationDAO bsCheckStationDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsCheckStationQueryRequest bsCheckStationQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsCheckStationQueryRequest.getPageOption();
		if(bsCheckStationQueryRequest.getPageOption().getRows()==null) bsCheckStationQueryRequest.getPageOption().setRows(20);
		if(bsCheckStationQueryRequest.getPageOption().getPage()==null) bsCheckStationQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsCheckStationQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsCheckStationQueryRequest.getPageOption().getPage() - 1) * bsCheckStationQueryRequest.getPageOption().getRows());
		
		if (Util.isNotNull(bsCheckStationQueryRequest.getId())) {
			map.put("id", bsCheckStationQueryRequest.getId());
		}
		if (Util.isNotNull(bsCheckStationQueryRequest.getStation_name())) {
			map.put("station_name", bsCheckStationQueryRequest.getStation_name());
		}
		if (Util.isNotNull(bsCheckStationQueryRequest.getIsenable())) {
			map.put("isenable", bsCheckStationQueryRequest.getIsenable());
		}
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsCheckStationDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsCheckStationQueryRequest.getPageOption().getRows(), bsCheckStationQueryRequest.getPageOption().getPage(), count, new ArrayList<BsCheckStation>());
		}
		List<BsCheckStation> list = this.bsCheckStationDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsCheckStationQueryRequest.getPageOption().getRows(), bsCheckStationQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsCheckStation get(Long id) throws Exception {
		return bsCheckStationDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsCheckStation bsCheckStation) throws Exception {
		Integer result = bsCheckStationDAO.add(bsCheckStation);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsCheckStation bsCheckStation) throws Exception {
		Integer result = bsCheckStationDAO.update(bsCheckStation);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsCheckStationDAO.deleteById(id);
		return result>0?true:false;
	}

	@Override
	public List<BsCheckStation> all() throws Exception {
		return bsCheckStationDAO.all();
	}
}
