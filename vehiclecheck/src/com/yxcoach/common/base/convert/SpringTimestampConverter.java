package com.yxcoach.common.base.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

/**
 * spring string -->Timestamp 类型转换
 * 数据格式 yyyy-MM-dd HH:mm:ss
 * 
 */
public class SpringTimestampConverter implements Converter<String, Timestamp>{

	//@Override 
	public Timestamp convert(String source) {
		if(source==null || "".equals(source.trim())){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return new Timestamp(sdf.parse(source).getTime());
        } catch (ParseException e) { }
        return null;
	}


}
