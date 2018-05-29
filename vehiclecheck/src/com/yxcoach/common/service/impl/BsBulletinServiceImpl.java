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
import com.yxcoach.common.dao.BsBulletinDAO;
import com.yxcoach.common.entity.BsBulletin;
import com.yxcoach.common.service.BsBulletinService;
import com.yxcoach.common.request.BsBulletinQueryRequest;
/**
 * @ClassName: BsBulletinServiceImpl
 * @Description: 车检动态表 serviceImpl
 * @author liwei
 * @date 2018-05-11
 */
@Transactional(readOnly = true)
@Service("bsBulletinService")
public class BsBulletinServiceImpl implements BsBulletinService{
	private static final Log log = LogFactory.getLog(BsBulletinServiceImpl.class);
	
	@Resource(name = "bsBulletinDAO")
	private BsBulletinDAO bsBulletinDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsBulletinQueryRequest bsBulletinQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsBulletinQueryRequest.getPageOption();
		if(bsBulletinQueryRequest.getPageOption().getRows()==null) bsBulletinQueryRequest.getPageOption().setRows(20);
		if(bsBulletinQueryRequest.getPageOption().getPage()==null) bsBulletinQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsBulletinQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsBulletinQueryRequest.getPageOption().getPage() - 1) * bsBulletinQueryRequest.getPageOption().getRows());
		if (Util.isNotNull(bsBulletinQueryRequest.getTitle())) {
			map.put("title", bsBulletinQueryRequest.getTitle());
		}
		if (Util.isNotNull(bsBulletinQueryRequest.getPublisher())) {
			map.put("publisher", bsBulletinQueryRequest.getPublisher());
		}
		if(Util.isNotNull(bsBulletinQueryRequest.getBeginTime())) {
			map.put("beginTime", bsBulletinQueryRequest.getBeginTime()+" 00:00:00");
		}
		if(Util.isNotNull(bsBulletinQueryRequest.getEndTime())) {
			map.put("endTime", bsBulletinQueryRequest.getEndTime()+" 23:59:59");
		}
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsBulletinDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsBulletinQueryRequest.getPageOption().getRows(), bsBulletinQueryRequest.getPageOption().getPage(), count, new ArrayList<BsBulletin>());
		}
		List<BsBulletin> list = this.bsBulletinDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsBulletinQueryRequest.getPageOption().getRows(), bsBulletinQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsBulletin get(Long id) throws Exception {
		return bsBulletinDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsBulletin bsBulletin) throws Exception {
		Integer result = bsBulletinDAO.add(bsBulletin);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsBulletin bsBulletin) throws Exception {
		Integer result = bsBulletinDAO.update(bsBulletin);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsBulletinDAO.deleteById(id);
		return result>0?true:false;
	}
}
