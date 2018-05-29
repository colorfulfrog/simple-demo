package com.yxcoach.common.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树 结构
 */
public class TreeNode implements Serializable{
	private String id;
	private String text;
	//节点状态，'open' or 'closed'，默认为'open'。当设置为'closed'时，拥有子节点的节点将会从远程站点载入它们
	private String state;
	private Boolean checked;
	private Object attributes;
	
	private List<TreeNode> children =new ArrayList<TreeNode>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}
	
	
}
