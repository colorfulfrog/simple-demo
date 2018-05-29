/**
 * 
 */
package com.yxcoach.common.base.util;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * redis工具类
 * @ClassName: RedisUtil
 * @Description: TODO
 * @author nizhi
 * @date 2017年7月4日 下午2:26:22
 */
@Service("RedisUtil")
public class RedisUtil {
	@Resource(name = "redisTemplate")
	private RedisTemplate<Object, Object> redisTemplate;
	
	
	public void resetValue(Object key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	public void resetList(Object key, List list) {
//		redisTemplate.opsForList().remove(key, arg1, arg2)
	}
	
//	public SysUser getSysUserByToken(String token) {
//		return (SysUser) redisTemplate.opsForValue().get("SYS_USER_TOKEN"+":"+token);
//	}

}
