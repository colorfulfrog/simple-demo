package com.yxcoach.common.base.util;

import com.google.common.base.Preconditions;
import com.yxcoach.common.base.constant.NonConfigYxConstants;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alan on 15/9/11.
 * 补充 apache commons-lang3中 DateUtils 之外的时间处理方法
 */
public class DateExtendUtils {

    /**
     * 回退部分时间
     *
     * @param date
     * @param calendarField
     * @param amount
     * @return
     */
    public static Date sub(Date date, int calendarField, int amount) {
        Preconditions.checkNotNull(date, "The date must not be null");

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, -amount);
        return c.getTime();
    }

    /**
     * 返回两个时间之间的秒数
     *
     * @param begin
     * @param end
     * @return
     */
    public static long getTimeIntervalInSeconds(Date begin, Date end) {
        Preconditions.checkNotNull(begin);
        Preconditions.checkNotNull(end);

        long tempTime = Math.abs(end.getTime() - begin.getTime());

        return tempTime / 1000;
    }

    /**
     * 根据时间获取 HH:mm 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getHourAndMins(Date date) {
        Preconditions.checkNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String hours = calendar.get(Calendar.HOUR_OF_DAY) + "";
        String mins = calendar.get(Calendar.MINUTE) + "";

        if (StringUtils.length(hours) < 2) {
            hours = "0" + hours;
        }

        if (StringUtils.length(mins) < 2) {
            mins = "0" + mins;
        }

        return hours + NonConfigYxConstants.SEP_COLON + mins;
    }

    /**
     * 指定小时 获取 时间
     *
     * @param date
     * @param hours
     * @param mins
     * @return
     */
    public static Date getTimeByDate(Date date, Integer hours, Integer mins) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, mins);

        return calendar.getTime();
    }

    /**
     * 获取秒级时间戳
     *
     * @return
     */
    public static String getTimeStampInSeconds() {
        long time = Calendar.getInstance().getTimeInMillis();

        //精确到秒级
        String dateline = time + "";
        return dateline.substring(0, 10);
    }

    /**
     * 获取日历时间
     *
     * @return
     */
    public static Calendar calendar() {
        Calendar c = Calendar.getInstance();
        return c;
    }

    /**
     * 日期年月日
     *
     * @return
     */
    public static SimpleDateFormat sdf_ymd() {
        return new SimpleDateFormat(NonConfigYxConstants.SDF_YMD);
    }

    /**
     * 日期年月日时分秒
     *
     * @return
     */
    public static SimpleDateFormat sdf_ymdhms() {
        return new SimpleDateFormat(NonConfigYxConstants.SDF_YMDHMS);
    }

    /**
     * 日期年月日时分
     *
     * @return
     */
    public static SimpleDateFormat sdf_no_ss() {
        return new SimpleDateFormat(NonConfigYxConstants.DATE_NO_SS);
    }

    public static String getDateStr(Date date, String fmt) {
        return new SimpleDateFormat(fmt).format(date);
    }

    public static Date getStr2Date(String str, String fmt) {
        try {
            return new SimpleDateFormat(fmt).parse(str);
        } catch (Exception e) {
            return null;
        }
    }

}
