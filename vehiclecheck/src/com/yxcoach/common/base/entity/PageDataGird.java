package com.yxcoach.common.base.entity;

import java.io.Serializable;
import java.util.Collection;

import com.wordnik.swagger.annotations.ApiParam;


public class PageDataGird implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 本页数据
	 */
	@ApiParam
	private Collection rows;
	/***
	 * 页码
	 */
	private Integer pages;
	/***
	 * 总条数
	 */
	private Integer total;
	
	private int code=1;
	
	
	public PageDataGird(){}
	public PageDataGird(PageInfo pageInfo){
		this.rows=pageInfo.getData();
		this.pages=pageInfo.getCurrentPageNo();
		this.total=pageInfo.getTotalCount();
	}
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Collection getRows() {
		return rows;
	}
	public void setRows(Collection rows) {
		this.rows = rows;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
