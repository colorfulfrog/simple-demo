package com.yxcoach.common.dao.base;


import com.yxcoach.common.entity.ConfigDO;

/**
 * 缓存redis dao
 * @author yangzhipeng
 */
public interface ConstantDao {
    /**
     * 从缓存中取配置信息
     *
     * @param key
     * @return
     */
    String getConfigByKey(String key);

    /**
     * @param key
     * @return
     */
    ConfigDO queryConfigByKey(String key);

    /**
     * 添加配置到缓存中
     *
     * @param configDO
     */
    void addConfig(ConfigDO configDO);

    /**
     * 修改配置信息
     *
     * @param configDO
     */
    void updateConfig(ConfigDO configDO);

    /**
     * 删除操作
     *
     * @param configDO
     */
    void deleteConfig(ConfigDO configDO);
    
    
   /**
    * 从redis中取字符串
    * @param key
    * @return
    */
    String queryStringByKey(String key);

    /**
     * 存储字符串
     * @param key  
     * @param value
     * @param minutes 分钟 long
     */
    void addStringByKey(String key,String value,long minutes);

   
}
