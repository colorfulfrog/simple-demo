package com.yxcoach.common.base.util;

import java.util.Map;

import com.alibaba.druid.util.StringUtils;

/**
 * @ClassName: 分页封装到Map查询参数

 * @Description: TODO

 * @author nizhi

 * @date 2017年7月5日 下午9:25:54
 */
public class PageUtil {
	/***
	 * 处理 排序方法
	 * @param page
	 * @param map
	 * @return
	 */
	public static Map<String,Object> orderParam(PageOption page,Map<String,Object> map){
		if(!StringUtils.isEmpty(page.getSort())){
//			map.put("sortColumn", page.getSort());
			StringBuffer sb=new StringBuffer();
			sb.append(" order by ").append(page.getSort()).append(" ").append(page.getOrder().equals("desc")?"DESC":"ASC");
			map.put("orderSql", sb.toString());
		}
		return map;
	}
}
