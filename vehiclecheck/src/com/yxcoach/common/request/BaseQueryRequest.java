package com.yxcoach.common.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.entity.BaseModel;
import com.yxcoach.common.base.util.PageOption;
/**
 * 公共请求类,扩展字段
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "BaseQueryRequest", description = "公共查询分页请求对象")
public class BaseQueryRequest extends BaseModel {
    private static final long serialVersionUID = -7279227158845533368L;

    /**
     * token 客户端登陆后操作必传
     */
    @ApiModelProperty(value = "登录后操作必传字段")
    private String token;
    /***
     * 分页信息
     */
    @ApiModelProperty(value = "分页对象")
    private PageOption pageOption;
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public PageOption getPageOption() {
		return pageOption;
	}
	public void setPageOption(PageOption pageOption) {
		this.pageOption = pageOption;
	}
    
    
}
