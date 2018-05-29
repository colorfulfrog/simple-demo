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
@ApiModel(value = "BaseRequest", description = "公共请求对象")
public class BaseRequest extends BaseModel {

    private static final long serialVersionUID = -7279227158845533268L;

    /**
     * token 客户端登陆后操作必传
     */
    @ApiModelProperty(value = "客户端登陆后操作必传")
    private String token;



    public String getToken() {
        return token;
    }

    public BaseRequest setToken(String token) {
        this.token = token;
        return this;
    }

}
