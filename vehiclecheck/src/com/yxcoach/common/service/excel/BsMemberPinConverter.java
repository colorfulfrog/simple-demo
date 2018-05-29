package com.yxcoach.common.service.excel;

import com.yxcoach.common.base.easypoi.excel.config.FieldValue;
import com.yxcoach.common.base.easypoi.excel.parsing.CellValueConverter;
import com.yxcoach.common.base.util.Util;

//身份证号隐藏
public class BsMemberPinConverter implements CellValueConverter {
	@Override
	public Object convert(Object bean, Object value, FieldValue fieldValue, Type type, int rowNum) throws Exception {
		if (Util.isNotNull(value) && value.toString().trim().length() == 18) {
			return value.toString().trim().replaceAll("(\\w{2})(\\w+)(\\w{2})", "$1************$3");
		}
		return value;
	}
}
