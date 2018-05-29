package com.yxcoach.common.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 公共请求类,扩展字段
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="BaseDeleteRequest", description="删除请求对象")
public class BaseDeleteRequest implements Serializable {

    private static final long serialVersionUID = -7279227158845533268L;
    
    @ApiModelProperty(value = "客户端登陆后操作必传")
    private String token;
    
    @ApiModelProperty(value = "id")
    private Long id;
    
    private Long recid;
    
    private Integer msgtype;
    
    private Integer chetype;

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

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Integer getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	public Integer getChetype() {
		return chetype;
	}

	public void setChetype(Integer chetype) {
		this.chetype = chetype;
	}
	
}
