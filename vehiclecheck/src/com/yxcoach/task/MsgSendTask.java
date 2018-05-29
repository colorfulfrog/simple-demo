package com.yxcoach.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.yxcoach.common.base.util.DateUtil;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.common.service.SysMsgRecordService;
import com.yxcoach.common.service.SysMsgSendTaskService;

/**
 * 短信定时发送（针对车辆检测到期提醒）
 * 
 * @author lic
 *
 */
@Component("msgSendTask")
public class MsgSendTask {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// 短信定时任务表
	@Resource(name = "sysMsgSendTaskService")
	private SysMsgSendTaskService sysMsgSendTaskService;

	// 车辆表
	@Resource(name = "bsCarService")
	private BsCarService bsCarService;

	// 短信发送记录表
	@Resource(name = "sysMsgRecordService")
	private SysMsgRecordService sysMsgRecordService;

	@Autowired
	@Qualifier(value = "messageExecutor")
	ThreadPoolTaskExecutor messageExecutor;

	/**
	 * 10秒执行一次(测试)
	 * 
	 * @throws Exception
	 */
	// @Scheduled(cron = "0/10 * * * * ?")
	public void run() throws Exception {
		logger.info("短信群发请求开始...");
		// 查询所有启用的定时任务
		List<SysMsgSendTask> smsts = sysMsgSendTaskService.selectByEnableData();
		// 接受人 集合
		StringBuffer receivers = null;
		for (SysMsgSendTask sysMsgSendTask : smsts) {
			if (sysMsgSendTask.getDays() == null)
				continue;
			String dateStr = DateUtil.getDayToDay(sysMsgSendTask.getDays());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start_time", dateStr + " 00:00:00");
			map.put("end_time", dateStr + " 23:59:59");
			// 查询当天+ days 要发短信的车辆(需要通知检测的会员用户车辆)
			List<BsCar> bs = bsCarService.selectBsCarCheckDate(map);
			if (bs == null || bs.size() == 0)
				continue;
			int i = 0;
			receivers = new StringBuffer();
			for (BsCar bsCar : bs) {
				i++;
				if (i == bs.size())
					receivers.append(bsCar.getTelphone());
				else
					receivers.append(bsCar.getTelphone() + ",");
			}

			// 存储发送记录 发送状态问题待处理
			SysMsgRecord sysMsgRecord = new SysMsgRecord();
			sysMsgRecord.setMsg_type(2);// 定时发送
			sysMsgRecord.setUserGroup("4");// 指定手机号发送
			sysMsgRecord.setMsg_content(sysMsgSendTask.getContent());
			sysMsgRecord.setStatus(3);// 待等待
			// sysMsgRecord.setSender(sender);// 发送人
			// 保存发送记录并发送短信
			sysMsgRecordService.insertBatch(sysMsgRecord, null, receivers.toString().split(","), messageExecutor,
					sysMsgRecordService);
		}

	}
}
