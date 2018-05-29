package com.yxcoach.common.entity;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:sys_menu
 *  注释:菜单表
 *  创建人: yangzhipeng
 *  创建日期:2018-03-24
 */
@ApiModel(value = "SysMenu", description = "菜单表")
public class SysMenu implements Serializable{


	@ApiModelProperty(value = " ")
	private java.lang.Long id;
	
	/**菜单名称   菜单名称   */	
	@ApiModelProperty(value = "菜单名称长度(1-50)")
	private java.lang.String menuName;
	
	@ApiModelProperty(value = "菜单地址 长度(200) 必填")
	private java.lang.String menu_url;
	
	@ApiModelProperty(value = "功能类型 1、平台  2、企业  3、政府  4、通用 ")
	private java.lang.Integer function_type;
	
	@ApiModelProperty(value = "父级菜单 0、表示 一级 ")
	private java.lang.Long pid;
	
	@ApiModelProperty(value = "排序 ")
	private java.lang.Integer sort_num;
	
	@ApiModelProperty(value = "备注 长度(200)")
	private java.lang.String remake;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "更新时间 ")
	private java.sql.Timestamp gmt_modify;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long modify_user;
	
	@ApiModelProperty(value = "版本号 ")
	private java.lang.Long vision;
	
	@ApiModelProperty(value = "是否显示 1.显示 0.不显示 ")
	private java.lang.Integer is_show;
	
	private List<SysMenu> children=null;
	
	/**前端跳转路由地址*/
	@ApiModelProperty(value = "前端路由地址")
	private String href;
	
	public String getHref() {	
		try {
			String[] hs=this.menu_url.split("/");
			this.href=hs[2]+"_"+hs[3];
		} catch (Exception e) {
			return id+"";
		}	
		
		return href.replace("/", "");
	}
	public void setHref(String href) {
		
		this.href = href;
	}
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setMenu_url(java.lang.String menu_url){
		this.menu_url=menu_url;
	}
	public java.lang.String getMenu_url(){
		return this.menu_url;
	}
	public void setFunction_type(java.lang.Integer function_type){
		this.function_type=function_type;
	}
	public java.lang.Integer getFunction_type(){
		return this.function_type;
	}
	public void setPid(java.lang.Long pid){
		this.pid=pid;
	}
	public java.lang.Long getPid(){
		return this.pid;
	}
	public void setSort_num(java.lang.Integer sort_num){
		this.sort_num=sort_num;
	}
	public java.lang.Integer getSort_num(){
		return this.sort_num;
	}
	public void setRemake(java.lang.String remake){
		this.remake=remake;
	}
	public java.lang.String getRemake(){
		return this.remake;
	}
	public void setGmt_create(java.sql.Timestamp gmt_create){
		this.gmt_create=gmt_create;
	}
	public java.sql.Timestamp getGmt_create(){
		return this.gmt_create;
	}
	public void setGmt_modify(java.sql.Timestamp gmt_modify){
		this.gmt_modify=gmt_modify;
	}
	public java.sql.Timestamp getGmt_modify(){
		return this.gmt_modify;
	}
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setModify_user(java.lang.Long modify_user){
		this.modify_user=modify_user;
	}
	public java.lang.Long getModify_user(){
		return this.modify_user;
	}
	public void setVision(java.lang.Long vision){
		this.vision=vision;
	}
	public java.lang.Long getVision(){
		return this.vision;
	}
	public void setIs_show(java.lang.Integer is_show){
		this.is_show=is_show;
	}
	public java.lang.Integer getIs_show(){
		return this.is_show;
	}
	public List<SysMenu> getChildren() {
		return children;
	}
	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}
	@Override
	public int hashCode() {
		 String str = menuName + id;  
	     return str.hashCode();  
	}
	@Override
	public boolean equals(Object obj) {
		SysMenu s= (SysMenu) obj;
		return menuName.equals(s.menuName) && id.equals(s.id);  
	}
	public java.lang.String getMenuName() {
		return menuName;
	}
	public void setMenuName(java.lang.String menuName) {
		this.menuName = menuName;
	}
	
}
