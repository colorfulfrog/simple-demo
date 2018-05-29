package com.yxcoach.common.dao.base.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.yxcoach.common.dao.base.ConstantDao;
import com.yxcoach.common.entity.ConfigDO;


/**
 * redis 缓存 dao
 * @author yangzhipeng
 *
 */

public class ConstantDaoImpl implements ConstantDao {
    private static final Logger logger = LoggerFactory.getLogger(ConstantDaoImpl.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
   

    @Override
    public String getConfigByKey(String key)  {
        ConfigDO configDO = null;
        configDO = queryConfigByKey(key);
        return configDO.getValue();
    }

    @Override
    public ConfigDO queryConfigByKey(String key) {
        ConfigDO configDO = null;
//        //判断redis中是否有值
//        if (redisTemplate.hasKey(ConfigKey..Y_CONFIG + key)) {
//            logger.debug("get config from redis:" + NonConfigYxConstants.Y_CONFIG + key);
//            configDO = (ConfigDO) redisTemplate.opsForValue().get(NonConfigYxConstants.Y_CONFIG + key);
//
//        }
        return configDO;
    }

	@Override
	public void addConfig(ConfigDO configDO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConfig(ConfigDO configDO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConfig(ConfigDO configDO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String queryStringByKey(String key) {
		String value="";
		if(redisTemplate.hasKey(key)){
			value=(String) redisTemplate.opsForValue().get(key);
		}
		return value;
	}

	
	@Override
	public void addStringByKey(String key, String value,long minutes) {
		redisTemplate.opsForValue().set(key, value); 
		redisTemplate.expire(key, minutes, TimeUnit.MINUTES);
	}

  


   
}

