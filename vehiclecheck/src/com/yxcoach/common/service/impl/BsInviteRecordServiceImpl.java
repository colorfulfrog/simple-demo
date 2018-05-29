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
import com.yxcoach.common.dao.BsInviteRecordDAO;
import com.yxcoach.common.entity.BsInviteRecord;
import com.yxcoach.common.service.BsInviteRecordService;
import com.yxcoach.common.request.BsInviteRecordQueryRequest;
/**
 * @ClassName: BsInviteRecordServiceImpl
 * @Description: 好友推荐邀请表 serviceImpl
 * @author liwei
 * @date 2018-05-09
 */
@Transactional(readOnly = true)
@Service("bsInviteRecordService")
public class BsInviteRecordServiceImpl implements BsInviteRecordService{
	private static final Log log = LogFactory.getLog(BsInviteRecordServiceImpl.class);
	
	@Resource(name = "bsInviteRecordDAO")
	private BsInviteRecordDAO bsInviteRecordDAO;
		
	/**
	 * 分页查询
	 */
	public PageInfo selectPage(BsInviteRecordQueryRequest bsInviteRecordQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption=bsInviteRecordQueryRequest.getPageOption();
		if(bsInviteRecordQueryRequest.getPageOption().getRows()==null) bsInviteRecordQueryRequest.getPageOption().setRows(20);
		if(bsInviteRecordQueryRequest.getPageOption().getPage()==null) bsInviteRecordQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", bsInviteRecordQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (bsInviteRecordQueryRequest.getPageOption().getPage() - 1) * bsInviteRecordQueryRequest.getPageOption().getRows());
		
		PageUtil.orderParam(pageOption, map);
		//自定义其他条件 
		Integer count = this.bsInviteRecordDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(bsInviteRecordQueryRequest.getPageOption().getRows(), bsInviteRecordQueryRequest.getPageOption().getPage(), count, new ArrayList<BsInviteRecord>());
		}
		List<BsInviteRecord> list = this.bsInviteRecordDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(bsInviteRecordQueryRequest.getPageOption().getRows(), bsInviteRecordQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public BsInviteRecord get(Long id) throws Exception {
		return bsInviteRecordDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(BsInviteRecord bsInviteRecord) throws Exception {
		Integer result = bsInviteRecordDAO.add(bsInviteRecord);
		return result>0?true:false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(BsInviteRecord bsInviteRecord) throws Exception {
		Integer result = bsInviteRecordDAO.update(bsInviteRecord);
		return result>0?true:false;
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = bsInviteRecordDAO.deleteById(id);
		return result>0?true:false;
	}
}
