package com.yxcoach.common.base.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个时间相差多少分钟
 * @author Administrator
 *
 */
public class TimeDifference {
	public static Long timeDifference(Timestamp day1,String day2){
		DateFormat df = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date d1;
		Date d2;
		long diff;
		try {
			d1 = df.parse(day1.toString());
			d2= df.parse(day2);
			diff= (d1.getTime() - d2.getTime());// 这样得到的差值是微秒级别
			long days = diff / (1000 * 60 * 60 * 24);

			long hours = (diff - days * (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60);
			long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
						* (1000 * 60 * 60))
						/ (1000 * 60);
			long difference = days * 24 * 60 + hours * 60 + minutes;
			return difference;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
