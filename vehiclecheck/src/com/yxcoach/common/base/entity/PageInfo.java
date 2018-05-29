package com.yxcoach.common.base.entity;

import java.io.Serializable;
import java.util.Collection;

/**
 * 分页实体
 */
public class PageInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 本页数据
	 */
	private Collection data;
	/**
	 * 当前第几页
	 */
	private int currentPageNo;

	/**
	 * 总页数
	 */
	private int totalPageCount;

	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 每页的记录数
	 */
	private int pageSize=20;
	
	

	
	public PageInfo(int pageSize, int currentPageNo,int totalCount,Collection data){
		this.data=data;
		this.pageSize=pageSize;
		this.currentPageNo=currentPageNo;
		this.totalCount=totalCount;
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/this.pageSize;
		}else{
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}
	}
	public PageInfo(int currentPageNo,int totalCount,Collection data){
		this.data=data;
		this.currentPageNo=currentPageNo;
		this.totalCount=totalCount;
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/this.pageSize;
		}else{
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}
	}
	public PageInfo(int pageSize, int currentPageNo,int totalCount,Collection data,int sum){
		this.data=data;
		this.pageSize=pageSize;
		this.currentPageNo=currentPageNo;
		this.totalCount=totalCount;
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/this.pageSize;
		}else{
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}
	}
	public Collection getData() {
		return data;
	}
	public void setData(Collection data) {
		this.data = data;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
