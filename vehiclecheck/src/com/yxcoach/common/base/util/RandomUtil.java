package com.yxcoach.common.base.util;


import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.yxcoach.common.base.constant.ConstantsKey;
import com.yxcoach.common.base.constant.YXContants;

/**
 * Created by alan on 15/9/11.
 */
public class RandomUtil {

    /**
     * 获取4位随机数字
     *
     * @return
     */
    public static String gen4NumbericRandom() {
        return ThreadLocalRandom.current().nextLong(999, 9999) + "";
    }

    /**
     * 获取8位随机数字
     */
    public static String gen8NumbericRandom() {
        return ThreadLocalRandom.current().nextLong(9999999, 99999999) + "";
    }


    /**
     * 获取指定位数的随机字符串
     */
    /**
     * 生成指定长度的随机串
     *
     * @param codeLength
     * @return String 生成的随机数字
     * 其实r.nextInt(maxInt)就可以得到一个随机的小于maxInt的整数
     */
    public static String generateRandomCode(int codeLength) {
        // 44个字符
        final int maxNum = 56;
        int i; // 生成的随机数
        int count = 0; // 当前生成字符串的长度

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < codeLength) {
            // 生成随机数，取绝对值，防止生成负数
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    /**
     * 随机数取值范围
     */
    private static char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'T', 'Y', 'Q', 'R',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 根据当前时间和用户ID生成订单ID
     */
    public static String genOrderSerial(Long userId) {
        return DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmssSSS")
                + RandomUtil.gen4NumbericRandom()
                + fillOrSplitUserId(userId);
    }

    /**
     * 填充或截取用户 ID
     *
     * @param userId
     * @return
     */
    private static String fillOrSplitUserId(Long userId) {
        if (null == userId) {
            return "";
        }

        String userIdStr = userId + "";
        int length = StringUtils.length(userIdStr);
        if (length < 4) {
            return StringUtils.leftPad(userIdStr, 4, "0");
        } else {
            return StringUtils.substring(userIdStr, length - 4, length);
        }

    }
}
