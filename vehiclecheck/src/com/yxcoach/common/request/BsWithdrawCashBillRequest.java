package com.yxcoach.common.request;


import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.entity.BsWithdrawCashBill;
import com.yxcoach.common.request.BaseRequest;

/**
 *	
 *  注释:提现记录表 rquest对象
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsWithdrawCashBillRequest", description = "提现记录表 rquest对象")
public class BsWithdrawCashBillRequest extends BaseRequest{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "提现记录表对象")
	private BsWithdrawCashBill bsWithdrawCashBill;
	
	public void setBsWithdrawCashBill(BsWithdrawCashBill bsWithdrawCashBill){
		this.bsWithdrawCashBill=bsWithdrawCashBill;
	}
	public BsWithdrawCashBill getBsWithdrawCashBill(){
		return this.bsWithdrawCashBill;
	}	
}
