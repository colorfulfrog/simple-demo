package com.yxcoach.common.base.util.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author lic@polysoft.com.cn
 * 测试类
 */
public class ExcelUtils {

	private static Logger logger = Logger.getLogger(ExcelUtils.class);

	public static void main(String[] args) {
		List<String> s = new ArrayList<String>();
		s.add("A");
		s.add("B");
		s.add("C");
		ExcelWrite write = new ExcelWrite("data", "D:/error.xls", s);
		ReadData data = new ReadData();
		Map<String, String> ss = new HashMap<String, String>();
		ss.put("A", "a");
		ss.put("B", "b");
		ss.put("C", "C");
		data.setData(ss);
		write.writeRow(data);
		ss = new HashMap<String, String>();
		ss.put("A", "a1");
		ss.put("B", "b1");
		data.setData(ss);
		write.writeRow(data);
		write.close();
		logger.info("完成");
	}
}
