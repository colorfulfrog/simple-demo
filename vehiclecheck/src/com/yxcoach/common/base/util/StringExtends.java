package com.yxcoach.common.base.util;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by alan on 15/9/11.
 * 扩展 GUAVA 中的 Strings
 */
public class StringExtends {

    /**
     * 判断是否修改原始数据
     *
     * @param newStr
     * @param oldStr
     * @return
     */
    public static String chooseNotNullString(String newStr, String oldStr) {
        if (!Strings.isNullOrEmpty(newStr)) {
            return newStr;
        }
        return oldStr;
    }

    /**
     * 从 map 获取 value
     *
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringFromMap(Map<String, String> map, String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return defaultValue;
        }
        String result = map.get(key);
        if (StringUtils.isBlank(result)) {
            return defaultValue;
        } else {
            return result;
        }
    }

    /**
     * String to stream
     *
     * @param sInputString
     * @return
     */
    public static InputStream getStringStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }
}
