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
import com.yxcoach.common.dao.SysMsgSendTaskDAO;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.service.SysMsgSendTaskService;
import com.yxcoach.common.request.SysMsgSendTaskQueryRequest;

/**
 * @ClassName: SysMsgSendTaskServiceImpl
 * @Description: 短信定时任务表 serviceImpl
 * @author liwei
 * @date 2018-05-11
 */
@Transactional(readOnly = true)
@Service("sysMsgSendTaskService")
public class SysMsgSendTaskServiceImpl implements SysMsgSendTaskService {
	private static final Log log = LogFactory.getLog(SysMsgSendTaskServiceImpl.class);

	@Resource(name = "sysMsgSendTaskDAO")
	private SysMsgSendTaskDAO sysMsgSendTaskDAO;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysMsgSendTaskQueryRequest sysMsgSendTaskQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = sysMsgSendTaskQueryRequest.getPageOption();
		if (sysMsgSendTaskQueryRequest.getPageOption().getRows() == null)
			sysMsgSendTaskQueryRequest.getPageOption().setRows(20);
		if (sysMsgSendTaskQueryRequest.getPageOption().getPage() == null)
			sysMsgSendTaskQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysMsgSendTaskQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysMsgSendTaskQueryRequest.getPageOption().getPage() - 1)
				* sysMsgSendTaskQueryRequest.getPageOption().getRows());

		if (Util.isNotNull(sysMsgSendTaskQueryRequest.getContent())) //
			map.put("content", sysMsgSendTaskQueryRequest.getContent());
		if (Util.isNotNull(sysMsgSendTaskQueryRequest.getStatus())) //
			map.put("status", sysMsgSendTaskQueryRequest.getStatus());
		if (Util.isNotNull(sysMsgSendTaskQueryRequest.getStart_time())) //
			map.put("start_time", sysMsgSendTaskQueryRequest.getStart_time());
		if (Util.isNotNull(sysMsgSendTaskQueryRequest.getEnd_time())) //
			map.put("end_time", sysMsgSendTaskQueryRequest.getEnd_time());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.sysMsgSendTaskDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysMsgSendTaskQueryRequest.getPageOption().getRows(),
					sysMsgSendTaskQueryRequest.getPageOption().getPage(), count, new ArrayList<SysMsgSendTask>());
		}
		List<SysMsgSendTask> list = this.sysMsgSendTaskDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysMsgSendTaskQueryRequest.getPageOption().getRows(),
				sysMsgSendTaskQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public SysMsgSendTask get(Long id) throws Exception {
		return sysMsgSendTaskDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean add(SysMsgSendTask sysMsgSendTask) throws Exception {
		Integer result = sysMsgSendTaskDAO.add(sysMsgSendTask);
		return result > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysMsgSendTask sysMsgSendTask) throws Exception {
		Integer result = sysMsgSendTaskDAO.update(sysMsgSendTask);
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = sysMsgSendTaskDAO.deleteById(id);
		return result > 0 ? true : false;
	}

	/**
	 * 启用或者停用
	 * 
	 * @param sysMsgSendTask
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updatEenableOrDisable(SysMsgSendTask sysMsgSendTask) {
		Integer result = sysMsgSendTaskDAO.updatEenableOrDisable(sysMsgSendTask);
		return result > 0 ? true : false;
	}

	/**
	 * 查询所有启用的定时任务
	 */
	@Override
	public List<SysMsgSendTask> selectByEnableData() {
		return sysMsgSendTaskDAO.selectByEnableData();
	}
}
