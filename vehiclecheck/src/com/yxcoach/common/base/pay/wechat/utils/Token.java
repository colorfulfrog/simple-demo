package com.yxcoach.common.base.pay.wechat.utils;

/**
 * 
 * @author Tim
 * @2018年4月11日 下午8:39:32
 * @desc:TOKEN
 */
public class Token {

	private String accessToken;
	private Integer expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

}
