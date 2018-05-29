package com.yxcoach.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT = "yyyy-MM-dd";
	public final static DateFormat DTF = new SimpleDateFormat(DATE_TIME_FORMAT);
	private final static String dateString = new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());;

	private DateUtil() {
	}

	// 根据指定格式，解释字符串，生成日期对象
	// @param src 日期字符串
	// @param format 格式化字符串
	// @return 不能转化时返回null
	public static Date parseDate(String src, String format) {
		Date date = null;
		if (src == null || src.equals(""))
			return null;
		try {
			date = new SimpleDateFormat(format).parse(src);
		} catch (Exception e) {
			return null;
		}
		return date;
	}

	// 把传入的日期，按指定格式返回其字符串形式
	// @param d 日期对象
	// @param format 格式字符串
	// @return 不能转换返回Null
	public static String dateToString(Date d, String format) {
		String str = null;
		if (d == null)
			return null;
		else
			try {
				str = new SimpleDateFormat(format).format(d);
			} catch (Exception e) {
				return null;
			}
		return str;
	}

	// 获取当前时间yyyy-MM-dd HH:mm:ss字符串形式
	public static String getCurrentDate() {
		return getCurrentDate(DATE_TIME_FORMAT);
	}

	// 获取当前时间指定格式的字符串形式
	// 格式错误按yyyy-MM-dd HH:mm:ss
	// @param String sFormat 日期格式字符串
	// @return String 转换成指定格式的字符串形式
	public static String getCurrentDate(String sFormat) {
		if (sFormat == null || sFormat.equals(""))
			sFormat = DATE_TIME_FORMAT;
		SimpleDateFormat formatter = null;
		formatter = new SimpleDateFormat(sFormat);
		return formatter.format(new java.util.Date());
	}

	// 计算时间差：天 /小时/分/秒
	// @param beginTime 开始时间
	// @param endTime 结束时间
	// @param type 时间差类型：1天，2小时，3分，4秒
	public static String getTimeLength(String beginTime, String endTime, String type) throws ParseException {
		String timeLength = "";
		Date begin = parseDate(beginTime, DATE_TIME_FORMAT);
		Date end = parseDate(endTime, DATE_TIME_FORMAT);
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		if ("1".equals(type)) {
			long day = between / (24 * 60 * 60);
			timeLength = day + "";
		} else if ("2".equals(type)) {
			long hour = between / (60 * 60);
			timeLength = hour + "";
		} else if ("3".equals(type)) {
			long minute = between / 60;
			timeLength = minute + "";
		} else if ("4".equals(type)) {
			long second = between;
			timeLength = second + "";
		}
		return timeLength;
	}

	// 返回年份数值
	public static int getYear() {
		return Integer.parseInt(dateString.substring(0, 4));
	}

	// 返回4位年份字符串
	public static String getStrYear() {
		return dateString.substring(0, 4);
	}

	// 返回月份数值
	public static int getMonth() {
		return Integer.parseInt(dateString.substring(5, 7));
	}

	// 返回2位月份字符串
	public static String getStrMonth() {
		return dateString.substring(5, 7);
	}

	// 返回日数值
	public static int getDay() {
		return Integer.parseInt(dateString.substring(8, 10));
	}

	// 返回2位日字符串
	public static String getStrDay() {
		return dateString.substring(8, 10);
	}

	// 返回小时值
	public static int getHour() {
		return Integer.parseInt(dateString.substring(11, 13));
	}

	// 返回2位小时字符串
	public static String getStrHour() {
		return dateString.substring(11, 13);
	}

	// 返回分钟值
	public static int getMinute() {
		return Integer.parseInt(dateString.substring(14, 16));
	}

	// 返回2位分钟字符串
	public static String getStrMinute() {
		return dateString.substring(14, 16);
	}

	// 返回秒值
	public static int getSecond() {
		return Integer.parseInt(dateString.substring(17, 19));
	}

	// 返回2位秒字符串
	public static String getStrSecond() {
		return dateString.substring(17, 19);
	}

	// 返回年月日字符串格式如 1997-07-01
	public static String getStrDate() {
		return dateString.substring(0, 10).trim();
	}

	// 返回时分秒字符串 01:01:01
	public static String getStrTime() {
		return dateString.substring(11, 19).trim();
	}

	// 将时间转换成指定格式的字符串( 将日期类型格式化成字符串)
	// @param format 格式描述:例如:yyyy-MM-dd yyyy-MM-dd HH:mm:ss
	public static String dateFormatStr(Date date, String dateStyle) throws ParseException {
		String dateStr = null;
		SimpleDateFormat sdf = null;
		if (date != null) {
			sdf = new SimpleDateFormat(dateStyle);
			dateStr = sdf.format(date);
		}
		return dateStr;
	}

	// 字符串格式化日期
	public static Date strFormatDate(String date, String dateStyle) throws ParseException {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(dateStyle);
		Date strDate = sdf.parse(date);
		return strDate;
	}

	// 判断time是否在from-to之内
	// @param from 开始日期
	// @param to 结束日期
	// @param to 当前日期
	public static boolean isTimeHoriZon(String from, String to, String stime) throws ParseException {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = sdf.parse(from);
		Date endDate = sdf.parse(to);
		Date st = sdf.parse(stime);
		if (st.before(startDate))
			// -----当前时间早于开始时间-----
			// System.out.println("-----当前时间早于开始时间-----");
			return false;
		else if (st.after(endDate))
			// -----当前时间超过结束时间-----
			// System.out.println("-----当前时间超过结束时间-----");
			return false;
		else
			return true;
	}

	// 判断time是否在from-to之内
	// @param time 指定日期
	// @param from 开始日期
	// @param to 结束日期
	public static boolean belongCalendar(Date time, Date from, Date to) {
		Calendar date = Calendar.getInstance();
		date.setTime(time);
		Calendar after = Calendar.getInstance();
		after.setTime(from);
		Calendar before = Calendar.getInstance();
		before.setTime(to);
		if (date.after(after) && date.before(before))
			return true;
		else
			return false;
	}

	// 时间加减法(单位：天)
	// btime 时间字符串 2017-11-21 09:58:18
	// btime 可以为null. 默认为当天
	// dayNum 负数返回+dayNum天,正数返回-dayNum天,0返回当天
	public static String subtractionAndPlusDate(String btime, int dayNum) {
		try {
			Date dd = null;
			if (btime == null || btime == "")
				dd = new Date();
			else
				dd = DTF.parse(btime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dd);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - dayNum);
			return DTF.format(calendar.getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	// 根据出生年月日精确计算年龄的算法
	// birthDay 出生日期为空返回0
	// birthDay 出生日期大于当前日期
	// return 年龄(满周岁)
	public static int getAge(Date birthDay) throws Exception {
		int age = 0;
		Calendar birth = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		if (birthDay != null) {
			now.setTime(new Date());
			birth.setTime(birthDay);
			if (birth.after(now))
				throw new IllegalArgumentException("年龄不能超过当前日期");
			age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
			int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
			int birthDayOfYear = birth.get(Calendar.DAY_OF_YEAR);
			if (nowDayOfYear < birthDayOfYear)
				age -= 1;
		}
		return age;
	}

	// 得到指定月的天数
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	// 获取工作日
	public static int getWorkingDay(java.util.Calendar d1, java.util.Calendar d2) {
		int result = -1;
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int charge_start_date = 0;// 开始日期的日期偏移量
		int charge_end_date = 0;// 结束日期的日期偏移量
		// 日期不在同一个日期内
		int stmp;
		int etmp;
		stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
		etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
		if (stmp != 0 && stmp != 6) // 开始日期为星期六和星期日时偏移量为0
			charge_start_date = stmp - 1;
		if (etmp != 0 && etmp != 6) // 结束日期为星期六和星期日时偏移量为0
			charge_end_date = etmp - 1;
		result = (getDaysBetween(getNextMonday(d1), getNextMonday(d2)) / 7) * 5 + charge_start_date - charge_end_date;
		return result;
	}

	// 获得日期的下一个星期一的日期
	public static Calendar getNextMonday(Calendar date) {
		Calendar result = null;
		result = date;
		do {
			result = (Calendar) result.clone();
			result.add(Calendar.DATE, 1);
		} while (result.get(Calendar.DAY_OF_WEEK) != 2);
		return result;
	}

	// 获取日期之间的天数
	public static int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
		// swap dates so that d1 is start and d2 is end
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(java.util.Calendar.DAY_OF_YEAR) - d1.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = d2.get(java.util.Calendar.YEAR);
		if (d1.get(java.util.Calendar.YEAR) != y2) {
			d1 = (java.util.Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				d1.add(java.util.Calendar.YEAR, 1);
			} while (d1.get(java.util.Calendar.YEAR) != y2);
		}
		return days;
	}

	// 获取中文日期
	public static String getChineseWeek(Calendar date) {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		// System.out.println(dayNames[dayOfWeek - 1]);
		return dayNames[dayOfWeek - 1];
	}

	// 获取休息日
	public static int getHolidays(Calendar d1, Calendar d2) {
		return getDaysBetween(d1, d2) - getWorkingDay(d1, d2);
	}
}
