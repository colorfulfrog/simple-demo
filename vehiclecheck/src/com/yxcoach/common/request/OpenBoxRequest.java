package com.yxcoach.common.request;


import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *app开启宝箱请求数据
 */
@ApiModel(value = "OpenBoxRequest", description = "app开启宝箱请求数据")
public class OpenBoxRequest implements Serializable{

	
	@ApiModelProperty(value = "客户端登陆后操作必传")
    private String token;
	
	private Long [] boxid;
	
	private String location;
	
	private Long uid;
	
	private Double lat;

	private Double lng;
	
	public Long[] getBoxid() {
		return boxid;
	}

	public void setBoxid(Long[] boxid) {
		this.boxid = boxid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	
}
