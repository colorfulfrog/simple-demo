package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsCar;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:车辆表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCarRequest", description = "车辆表 rquest对象")
public class BsCarRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "车辆表对象")
	private BsCar bsCar;
	
	public void setBsCar(BsCar bsCar){
		this.bsCar=bsCar;
	}
	public BsCar getBsCar(){
		return this.bsCar;
	}	
}
