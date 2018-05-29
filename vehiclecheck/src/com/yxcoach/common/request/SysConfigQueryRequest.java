package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:参数配置表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "SysConfigQueryRequest", description = "参数配置表 rquest分页查询对象")
public class SysConfigQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	
}
