package com.yxcoach.common.base.entity;

import java.io.Serializable;

import com.yxcoach.common.base.constant.Constants;



/**
 * 查询bean
 */
public abstract class BaseVO implements Serializable{
	/**当前页码*/
	private Integer page;
	/**每页多少条*/
	private Integer rows=Constants.PAGESIZE ;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
}
