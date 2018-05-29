package com.yxcoach.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.entity.PageInfo;
import com.yxcoach.common.base.util.PageOption;
import com.yxcoach.common.base.util.PageUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.request.BaseDeleteRequest;
import com.yxcoach.common.request.BaseViewRequest;
import com.yxcoach.common.dao.SysMsgRecordDAO;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.service.SysMsgRecordService;
import com.yxcoach.task.MsgRecordTask;
import com.yxcoach.common.request.SysMsgRecordQueryRequest;

/**
 * @ClassName: SysMsgRecordServiceImpl
 * @Description: 短信发送记录表 serviceImpl
 * @author liwei
 * @date 2018-05-11
 */
@Transactional(readOnly = true)
@Service("sysMsgRecordService")
public class SysMsgRecordServiceImpl implements SysMsgRecordService {
	private static final Log log = LogFactory.getLog(SysMsgRecordServiceImpl.class);

	@Resource(name = "sysMsgRecordDAO")
	private SysMsgRecordDAO sysMsgRecordDAO;

	/**
	 * 分页查询
	 */
	public PageInfo selectPage(SysMsgRecordQueryRequest sysMsgRecordQueryRequest) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageOption pageOption = sysMsgRecordQueryRequest.getPageOption();
		if (sysMsgRecordQueryRequest.getPageOption().getRows() == null)
			sysMsgRecordQueryRequest.getPageOption().setRows(20);
		if (sysMsgRecordQueryRequest.getPageOption().getPage() == null)
			sysMsgRecordQueryRequest.getPageOption().setPage(1);
		map.put("PSIZE", sysMsgRecordQueryRequest.getPageOption().getRows());
		map.put("BEGIN", (sysMsgRecordQueryRequest.getPageOption().getPage() - 1)
				* sysMsgRecordQueryRequest.getPageOption().getRows());

		if (Util.isNotNull(sysMsgRecordQueryRequest.getSender())) //
			map.put("sender", sysMsgRecordQueryRequest.getSender());
		if (Util.isNotNull(sysMsgRecordQueryRequest.getReceiver()))//
			map.put("receiver", sysMsgRecordQueryRequest.getReceiver());
		if (Util.isNotNull(sysMsgRecordQueryRequest.getMsg_content())) //
			map.put("msg_content", sysMsgRecordQueryRequest.getMsg_content());
		if (Util.isNotNull(sysMsgRecordQueryRequest.getStatus())) //
			map.put("status", sysMsgRecordQueryRequest.getStatus());
		if (Util.isNotNull(sysMsgRecordQueryRequest.getSend_time())) //
			map.put("send_time", sysMsgRecordQueryRequest.getSend_time());

		if (Util.isNotNull(sysMsgRecordQueryRequest.getStart_time())) //
			map.put("start_time", sysMsgRecordQueryRequest.getStart_time());
		if (Util.isNotNull(sysMsgRecordQueryRequest.getEnd_time())) //
			map.put("ends_time", sysMsgRecordQueryRequest.getEnd_time());

		PageUtil.orderParam(pageOption, map);
		// 自定义其他条件
		Integer count = this.sysMsgRecordDAO.selectPageCount(map);
		if (count == 0) {
			return new PageInfo(sysMsgRecordQueryRequest.getPageOption().getRows(),
					sysMsgRecordQueryRequest.getPageOption().getPage(), count, new ArrayList<SysMsgRecord>());
		}
		List<SysMsgRecord> list = this.sysMsgRecordDAO.selectPage(map);
		PageInfo pageInfo = new PageInfo(sysMsgRecordQueryRequest.getPageOption().getRows(),
				sysMsgRecordQueryRequest.getPageOption().getPage(), count, list);
		return pageInfo;
	}

	/**
	 * 查询一条记录
	 */
	public SysMsgRecord get(Long id) throws Exception {
		return sysMsgRecordDAO.getById(id);
	}

	/**
	 * 新增
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean insertBatch(SysMsgRecord sysMsgRecord, List<BsMember> bsms, String[] receivers,
			ThreadPoolTaskExecutor messageExecutor, SysMsgRecordService sysMsgRecordService) throws Exception {
		List<SysMsgRecord> sysMsgRecords = new ArrayList<SysMsgRecord>();
		SysMsgRecord msgRecord = null;

		if (bsms != null && bsms.size() > 0) {
			for (BsMember smr : bsms) {
				if (!Util.isNotNull(smr.getTelphone()))
					continue;
				msgRecord = new SysMsgRecord();
				msgRecord.setReceiver(smr.getTelphone());

				msgRecord.setSender(sysMsgRecord.getSender());
				msgRecord.setMsg_content(sysMsgRecord.getMsg_content());
				msgRecord.setStatus(3);// 待发送
				msgRecord.setMsg_type(sysMsgRecord.getMsg_type());// 

				sysMsgRecords.add(msgRecord);
			}
		} else if (receivers != null && receivers.length > 0) {
			for (String re : receivers) {
				msgRecord = new SysMsgRecord();
				msgRecord.setReceiver(re);

				msgRecord.setSender(sysMsgRecord.getSender());
				msgRecord.setMsg_content(sysMsgRecord.getMsg_content());
				msgRecord.setStatus(3);// 待发送
				msgRecord.setMsg_type(sysMsgRecord.getMsg_type());// 

				sysMsgRecords.add(msgRecord);
			}
		} else
			return false;
		if (sysMsgRecords.size() == 0)
			return false;
		int b = sysMsgRecordDAO.addBatch(sysMsgRecords);
		// 异步线程去发送短信
		messageExecutor.execute(new MsgRecordTask(sysMsgRecords, sysMsgRecordService));
		return b > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(SysMsgRecord sysMsgRecord) throws Exception {
		Integer result = sysMsgRecordDAO.update(sysMsgRecord);
		return result > 0 ? true : false;
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) throws Exception {
		Integer result = sysMsgRecordDAO.deleteById(id);
		return result > 0 ? true : false;
	}

	/**
	 * 批量更新发送状态
	 */
	@Override
	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateBatch(Map<String, Object> maps) {
		return sysMsgRecordDAO.updateBatch(maps);
	}

}
