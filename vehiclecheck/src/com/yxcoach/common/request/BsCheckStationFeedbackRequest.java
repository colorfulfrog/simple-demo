package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsCheckStationFeedback;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:检测站评价表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-11
 */
@ApiModel(value = "BsCheckStationFeedbackRequest", description = "检测站评价表 rquest对象")
public class BsCheckStationFeedbackRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "检测站评价表对象")
	private BsCheckStationFeedback bsCheckStationFeedback;
	
	public void setBsCheckStationFeedback(BsCheckStationFeedback bsCheckStationFeedback){
		this.bsCheckStationFeedback=bsCheckStationFeedback;
	}
	public BsCheckStationFeedback getBsCheckStationFeedback(){
		return this.bsCheckStationFeedback;
	}	
}
