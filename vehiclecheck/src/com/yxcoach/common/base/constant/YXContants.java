package com.yxcoach.common.base.constant;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.yxcoach.common.base.enums.ResultCodeEnum;
import com.yxcoach.common.entity.ConfigDO;

/**
 * 
 * @Description  TODO
 * Created by yangzhipeng on 2017年6月22日
 */
public class YXContants {

    /**
     * 所有的配置集合
     * 需要变动的配置,放在这个集合里面
     */
    public static final Map<String, ConfigDO> configMap = Maps.newConcurrentMap();

    /**
     * 当前服务器的本身私有数据,不与配置项放到一起,防止出现串的问题
     */
    public static final Map<String, String> localServerMap = Maps.newConcurrentMap();

    /**
     * @param key
     * @return
     */
    public static String getConfigValue(String key) {
        ConfigDO configDO = configMap.get(key);
        Preconditions.checkNotNull(configDO, ResultCodeEnum.CONFIG_INFO_NOT_EXIST.getType());

        return configDO.getValue();
    }
}
