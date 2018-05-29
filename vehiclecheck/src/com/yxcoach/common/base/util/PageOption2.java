package com.yxcoach.common.base.util;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.entity.BaseModel;


/**
 * 分页实体
 */
public class PageOption2 implements Serializable{
	/**
	 * 本页数据
	 */
	private Collection data;
	/**
	 * 当前第几页
	 */
	private int currentPage;

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
	/**排序字段*/
	private String sortCloumn;
	/***
	 * 排序类型
	 */
	private String sortType ="DESC";
	
	public PageOption2(int pageSize, int currentPage,int totalCount,Collection data){
		this.data=data;
		this.pageSize=pageSize;
		this.currentPage=currentPage;
		this.totalCount=totalCount;
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/this.pageSize;
		}else{
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}
	}
	public PageOption2(int currentPage,int totalCount,Collection data){
		this.data=data;
		this.currentPage=currentPage;
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
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public String getSortCloumn() {
		return sortCloumn;
	}
	public void setSortCloumn(String sortCloumn) {
		this.sortCloumn = sortCloumn;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
}