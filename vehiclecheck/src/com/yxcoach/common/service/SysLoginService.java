package com.yxcoach.common.service;

import com.yxcoach.common.request.LoginRequest;
import com.yxcoach.common.response.BaseResponse;






public interface SysLoginService {
	public BaseResponse userLogin(LoginRequest loginRequest) throws Exception;
	public BaseResponse userLogout(String token) throws Exception;
	public BaseResponse getUserByToken(String token) throws Exception;
}
