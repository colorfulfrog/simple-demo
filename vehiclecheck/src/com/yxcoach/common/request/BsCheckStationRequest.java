package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsCheckStation;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:检测站表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsCheckStationRequest", description = "检测站表 rquest对象")
public class BsCheckStationRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "检测站表对象")
	private BsCheckStation bsCheckStation;
	
	public void setBsCheckStation(BsCheckStation bsCheckStation){
		this.bsCheckStation=bsCheckStation;
	}
	public BsCheckStation getBsCheckStation(){
		return this.bsCheckStation;
	}	
}
