package com.yxcoach.common.base.exception;

/*
 * 没有token登录异常
 */
public class CredentialsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CredentialsException(String mes){
		super(mes);
	}
}
