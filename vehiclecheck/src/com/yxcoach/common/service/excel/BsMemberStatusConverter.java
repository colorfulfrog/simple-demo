package com.yxcoach.common.service.excel;

import com.yxcoach.common.base.easypoi.excel.config.FieldValue;
import com.yxcoach.common.base.easypoi.excel.parsing.CellValueConverter;
//状态 1、待审核  2、认证通过  3、认证失败
public class BsMemberStatusConverter implements CellValueConverter{

	@Override
	public Object convert(Object bean, Object value, FieldValue fieldValue,
			Type type, int rowNum) throws Exception {
		String sType = "未知状态";
		if("1".equals(value.toString())){ //1：
			sType = "待审核";
		}else if("2".equals(value.toString())){ // 3：
			sType = "认证通过";
		}else if("3".equals(value.toString())){ // 3：
			sType = "认证失败";
		}
		return sType;
	}


}
