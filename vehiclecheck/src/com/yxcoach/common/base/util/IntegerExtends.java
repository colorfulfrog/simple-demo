package com.yxcoach.common.base.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by alan on 15/9/11.
 */
public class IntegerExtends {

    /**
     * 判断是否修改原始数据
     *
     * @param newInt
     * @param oldInt
     * @return
     */
    public static Integer chooseNotNullInteger(Integer newInt, Integer oldInt) {
        if (null != newInt) {
            return newInt;
        }
        return oldInt;
    }

    public static int getIntFromMap(Map<String, String> map, String key) {
        if (StringUtils.isBlank(key)) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt(map.get(key));
    }
}
