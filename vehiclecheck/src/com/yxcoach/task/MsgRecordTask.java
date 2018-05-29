package com.yxcoach.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yxcoach.common.base.util.DateUtil;
import com.yxcoach.common.base.util.Util;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.entity.BsMember;
import com.yxcoach.common.entity.SysMsgRecord;
import com.yxcoach.common.entity.SysMsgSendTask;
import com.yxcoach.common.push.SendMsgZm;
import com.yxcoach.common.service.BsCarService;
import com.yxcoach.common.service.SysMsgRecordService;
import com.yxcoach.common.service.SysMsgSendTaskService;

/**
 * 短信立即发送
 * 
 * @author lic
 *
 */
public class MsgRecordTask implements Runnable {

	private List<SysMsgRecord> sysMsgRecords;
	private SysMsgRecordService sysMsgRecordService;

	public MsgRecordTask(List<SysMsgRecord> sysMsgRecords, SysMsgRecordService sysMsgRecordService) {
		this.sysMsgRecords = sysMsgRecords;
		this.sysMsgRecordService = sysMsgRecordService;
	}

	@Override
	public void run() {
		if (sysMsgRecords != null && sysMsgRecords.size() > 0) {
			StringBuffer sbPhone = new StringBuffer();// 电话
			StringBuffer sbId = new StringBuffer();// 主键
			int i = 0;
			for (SysMsgRecord sysMsgRecord : sysMsgRecords) {
				i++;
				if (sysMsgRecord.getReceiver() != null) {
					sbPhone.append(sysMsgRecord.getReceiver() + ",");
					sbId.append(sysMsgRecord.getId() + ",");
					if (i % 200 == 0) {// 200个号码
						try {
							// 满足200个号码发送一次短信
							boolean b = true;
//							SendMsgZm.sendMsgNow(
//									sbPhone.toString().substring(0, sbPhone.toString().length() - 1),
//									sysMsgRecords.get(0).getMsg_content());
							// 批量更新发送状态
							Map<String, Object> maps = new HashMap<String, Object>();
							maps.put("status", b ? 1 : 2);
							maps.put("id", sbId.toString().substring(0, sbId.toString().length()-1));
							sysMsgRecordService.updateBatch(maps);
						} catch (Exception e) {
							e.printStackTrace();
						}
						sbPhone.setLength(0);
						sbPhone.setLength(0);
					}
				}
			}
			// 最终不满足200个
			if (sbPhone.length() != 0) {
				try {
					boolean b = true;
//					SendMsgZm.sendMsgNow(sbPhone.toString().substring(0, sbPhone.toString().length() - 1),
//							sysMsgRecords.get(0).getMsg_content());
					// 批量更新发送状态
					Map<String, Object> maps = new HashMap<String, Object>();
					maps.put("status", b ? 1 : 2);
					maps.put("id", sbId.toString().substring(0, sbId.toString().length()-1));
					sysMsgRecordService.updateBatch(maps);
				} catch (Exception e) {
					e.printStackTrace();
				}
				sbPhone.setLength(0);
				sbPhone.setLength(0);
			}
		}
	}
}
