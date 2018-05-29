package com.yxcoach.common.service.excel;

import com.yxcoach.common.base.easypoi.excel.config.FieldValue;
import com.yxcoach.common.base.easypoi.excel.parsing.CellValueConverter;
//'注册来源 1：平台 2：经纪人 3：上门客户',
public class BsMemberSourceConverter implements CellValueConverter{

	@Override
	public Object convert(Object bean, Object value, FieldValue fieldValue,
			Type type, int rowNum) throws Exception {
		String sType = "未知用户类型";
		if("1".equals(value.toString())){ //1：
			sType = "平台";
		}else if("2".equals(value.toString())){ // 3：
			sType = "经纪人";
		}else if("3".equals(value.toString())){ // 3：
			sType = "上门客户";
		}
		return sType;
	}


}
