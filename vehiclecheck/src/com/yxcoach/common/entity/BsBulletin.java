package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_bulletin
 *  注释:车检动态表
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsBulletin", description = "车检动态表")
public class BsBulletin implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "标题 长度(128) 必填")
	private java.lang.String title;
	
	@ApiModelProperty(value = "内容 长度() 必填")
	private java.lang.String content;
	
	@ApiModelProperty(value = "发布人 长度(64) 必填")
	private java.lang.String publisher;
	
	@ApiModelProperty(value = "发布日期 ")
	private java.sql.Timestamp publish_date;
	
	@ApiModelProperty(value = "状态 1启用 0停用 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "创建人 ")
	private java.lang.Long create_by;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp create_date;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long update_by;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp update_date;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setTitle(java.lang.String title){
		this.title=title;
	}
	public java.lang.String getTitle(){
		return this.title;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	public java.lang.String getContent(){
		return this.content;
	}
	public void setPublisher(java.lang.String publisher){
		this.publisher=publisher;
	}
	public java.lang.String getPublisher(){
		return this.publisher;
	}
	public void setPublish_date(java.sql.Timestamp publish_date){
		this.publish_date=publish_date;
	}
	public java.sql.Timestamp getPublish_date(){
		return this.publish_date;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setCreate_by(java.lang.Long create_by){
		this.create_by=create_by;
	}
	public java.lang.Long getCreate_by(){
		return this.create_by;
	}
	public void setCreate_date(java.sql.Timestamp create_date){
		this.create_date=create_date;
	}
	public java.sql.Timestamp getCreate_date(){
		return this.create_date;
	}
	public void setUpdate_by(java.lang.Long update_by){
		this.update_by=update_by;
	}
	public java.lang.Long getUpdate_by(){
		return this.update_by;
	}
	public void setUpdate_date(java.sql.Timestamp update_date){
		this.update_date=update_date;
	}
	public java.sql.Timestamp getUpdate_date(){
		return this.update_date;
	}
}
