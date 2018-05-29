package com.yxcoach.common.service;

import com.yxcoach.common.base.easypoi.excel.config.FieldValue;
import com.yxcoach.common.base.easypoi.excel.parsing.CellValueConverter;

public class CarTypeConverter implements CellValueConverter{

	@Override
	public Object convert(Object bean, Object value, FieldValue fieldValue,
			Type type, int rowNum) throws Exception {
		String carType = "未知车型";
		if("1".equals(value.toString())){ //小型车
			carType = "小型车";
		}else if("2".equals(value.toString())){ //中型车
			carType = "中型车";
		}else if("3".equals(value.toString())){ //大型车
			carType = "大型车";
		}
		return carType;
	}

}
