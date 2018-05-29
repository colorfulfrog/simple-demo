package com.yxcoach.common.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 公共请求类,扩展字段
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="BaseViewRequest", description="详情请求对象")
public class BaseViewRequest implements Serializable{

    private static final long serialVersionUID = -7279227158845533268L;
    
    @ApiModelProperty(value = "客户端登陆后操作必传")
    private String token;
    
    @ApiModelProperty(value = "id")
    private Long id;
    
	private Double lat;

	private Double lng;
	
	private String fileUrl;

	private Integer coordinate_deviation;//范围匹配偏差
	
	private Long uid;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getCoordinate_deviation() {
		return coordinate_deviation;
	}

	public void setCoordinate_deviation(Integer coordinate_deviation) {
		this.coordinate_deviation = coordinate_deviation;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}


}
