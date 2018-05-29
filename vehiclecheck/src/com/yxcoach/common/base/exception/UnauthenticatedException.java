package com.yxcoach.common.base.exception;

/*
 * 没有权限异常
 */
public class UnauthenticatedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthenticatedException(String mes){
		super(mes);
	}
}
