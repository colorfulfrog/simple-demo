package com.yxcoach.common.service.excel;

import com.yxcoach.common.base.easypoi.excel.config.FieldValue;
import com.yxcoach.common.base.easypoi.excel.parsing.CellValueConverter;

public class BsMemberTypeConverter implements CellValueConverter{

	@Override
	public Object convert(Object bean, Object value, FieldValue fieldValue,
			Type type, int rowNum) throws Exception {
		String sType = "未知用户类型";
		if("1".equals(value.toString())){ //1：车主
			sType = "车主";
		}else if("3".equals(value.toString())){ // 3：经纪人
			sType = "经纪人";
		}
		return sType;
	}

}
