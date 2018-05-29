package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsActivity;
import com.yxcoach.common.request.BaseQueryRequest;

/**
 *	
 *  注释:活动表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsActivityQueryRequest", description = "活动表 rquest分页查询对象")
public class BsActivityQueryRequest extends BaseQueryRequest{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "活动对象")
	private BsActivity bsActivity;

	public BsActivity getBsActivity() {
		return bsActivity;
	}

	public void setBsActivity(BsActivity bsActivity) {
		this.bsActivity = bsActivity;
	}
}
