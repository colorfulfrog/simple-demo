package com.yxcoach.common.base.util;

import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;


public class PerssionUtil {
	
	public static Map<String,Object> setPersession(Map<String,Object> map,RedisTemplate<String, Object> redisTemplate,String token){
//		SysUser user=(SysUser)redisTemplate.opsForValue().get("SYS_USER_TOKEN:"+token);
		//动态设置权限数据
		return map;
	}
	
}
