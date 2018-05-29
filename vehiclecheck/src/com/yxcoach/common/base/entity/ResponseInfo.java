package com.yxcoach.common.base.entity;

import java.io.Serializable;


/**
 * 
 * @Description response 响应内容
 * Created by yangzhipeng on 2017年7月6日
 */
public class ResponseInfo implements Serializable {
	
	private static final long serialVersionUID = 2841713888137800731L;
	

	/**
	 * 结果返回码 1、请求成功 2、请求失败
	 */
	private int code; 
	/**
	 * 返回结果消息
	 */
	private String msg = ""; 
	/***
	 * 返回数据
	 */
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	


}
