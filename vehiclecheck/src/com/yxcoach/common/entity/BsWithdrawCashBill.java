package com.yxcoach.common.entity;

import java.io.Serializable;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 *	
 *  表名:bs_withdraw_cash_bill
 *  注释:提现记录表
 *  创建人: liwei
 *  创建日期:2018-05-09
 */
@ApiModel(value = "BsWithdrawCashBill", description = "提现记录表")
public class BsWithdrawCashBill implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@ApiModelProperty(value = "编号 ")
	private java.lang.Long id;
	
	@ApiModelProperty(value = "提现用户 ")
	private java.lang.Long member_id;
	
	@ApiModelProperty(value = "银行 长度(30) 必填")
	private java.lang.String bank;
	
	@ApiModelProperty(value = "银行卡用户 长度(20) 必填")
	private java.lang.String bank_user_name;
	
	@ApiModelProperty(value = "银行账号 长度(20)")
	private java.lang.String bank_account;
	
	@ApiModelProperty(value = "提现金额 ")
	private java.lang.Float withdraw_cash;
	
	@ApiModelProperty(value = "提现手续费 ")
	private java.lang.Float withdraw_cash_fee;
	
	@ApiModelProperty(value = "出账金额 ")
	private java.lang.Float total;
	
	@ApiModelProperty(value = "状态 1待审核 2待支付 3审核不通过 4已支付 ")
	private java.lang.Integer status;
	
	@ApiModelProperty(value = "创建时间 ")
	private java.sql.Timestamp gmt_create;
	
	@ApiModelProperty(value = "创建用户 ")
	private java.lang.Long gmt_user;
	
	@ApiModelProperty(value = "更新人 ")
	private java.lang.Long modify_user;
	
	
	public void setId(java.lang.Long id){
		this.id=id;
	}
	public java.lang.Long getId(){
		return this.id;
	}
	public void setMember_id(java.lang.Long member_id){
		this.member_id=member_id;
	}
	public java.lang.Long getMember_id(){
		return this.member_id;
	}
	public void setBank(java.lang.String bank){
		this.bank=bank;
	}
	public java.lang.String getBank(){
		return this.bank;
	}
	public void setBank_user_name(java.lang.String bank_user_name){
		this.bank_user_name=bank_user_name;
	}
	public java.lang.String getBank_user_name(){
		return this.bank_user_name;
	}
	public void setBank_account(java.lang.String bank_account){
		this.bank_account=bank_account;
	}
	public java.lang.String getBank_account(){
		return this.bank_account;
	}
	public void setWithdraw_cash(java.lang.Float withdraw_cash){
		this.withdraw_cash=withdraw_cash;
	}
	public java.lang.Float getWithdraw_cash(){
		return this.withdraw_cash;
	}
	public void setWithdraw_cash_fee(java.lang.Float withdraw_cash_fee){
		this.withdraw_cash_fee=withdraw_cash_fee;
	}
	public java.lang.Float getWithdraw_cash_fee(){
		return this.withdraw_cash_fee;
	}
	public void setTotal(java.lang.Float total){
		this.total=total;
	}
	public java.lang.Float getTotal(){
		return this.total;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	public java.lang.Integer getStatus(){
		return this.status;
	}
	public void setGmt_create(java.sql.Timestamp gmt_create){
		this.gmt_create=gmt_create;
	}
	public java.sql.Timestamp getGmt_create(){
		return this.gmt_create;
	}
	public void setGmt_user(java.lang.Long gmt_user){
		this.gmt_user=gmt_user;
	}
	public java.lang.Long getGmt_user(){
		return this.gmt_user;
	}
	public void setModify_user(java.lang.Long modify_user){
		this.modify_user=modify_user;
	}
	public java.lang.Long getModify_user(){
		return this.modify_user;
	}
}
