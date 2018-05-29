package com.yxcoach.common.base.exception;

/*
 * 登录过期
 */
public class ExpiredCredentialsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpiredCredentialsException(String mes){
		super(mes);
	}
}
