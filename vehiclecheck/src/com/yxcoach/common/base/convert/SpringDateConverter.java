package com.yxcoach.common.base.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * spring string -->date 类型转换
 * 数据格式 yyyy-MM-dd HH:mm:ss
 * 
 */
public class SpringDateConverter implements Converter<String, Date>{

	//@Override 
	public Date convert(String source) {
		if(source==null || "".equals(source.trim())){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);//严格解析
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }        
        return null;
	}

}
