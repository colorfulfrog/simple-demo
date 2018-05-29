package com.yxcoach.common.base.util;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 * 分页实体
 */
@ApiModel(value = "PageOption", description = "请求分页对象")
public class PageOption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 每页的记录数
	 */
	 @ApiModelProperty(value = "每页的记录数")
	private Integer rows=20;
	/**
	 * 当前第几页
	 */
	 @ApiModelProperty(value = "当前第几页")
	private Integer page;

	/**排序字段*/
	 @ApiModelProperty(value = "排序字段")
	private String sort="id";
	/***
	 * 排序类型
	 */
	 @ApiModelProperty(value = "排序类型：ASC：升序，DESC:降序，默认DESC")
	private String order ="desc";
	public PageOption(){}
	public PageOption(Integer rows, Integer page,String sort,String order){
		this.rows=rows;
		this.page=page;
		this.sort=sort;
		this.order=order;
	}	
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}