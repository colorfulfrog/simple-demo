package com.yxcoach.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.yxcoach.common.base.constant.Constants;
import com.yxcoach.common.base.entity.BaseModel;
import com.yxcoach.common.entity.ConfigDO;

/**
 * 
 * @author yangzhipeng
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "BaseResponse", description = "返回对象")
public class BaseResponse extends BaseModel {
	private static final long serialVersionUID = -8360494373049378798L;

	/**
	 * 结果返回码 1、请求成功 2、请求失败 3、登录失效 4、无权限
	 */
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@ApiModelProperty(value = "结果返回码  1、请求成功 2、请求失败 3、登录失效 4、无权限")
	private int code; // NonConfigYxConstants.OK_RET_CODE;
	/**
	 * 返回结果消息
	 */
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@ApiModelProperty(value = "返回结果消息")
	private String msg = ""; // NonConfigYxConstants.OK_RET_MSG;
	/***
	 * 返回数据
	 */
	@ApiModelProperty(value = "返回数据")
	private Object data;

	public BaseResponse() {

	}
	/**
	 * 成功
	 * @return
	 */
	public static BaseResponse success(){
		BaseResponse response=response(Constants.Msg.SUC_MSG);
		return response;
	}
	
	/**
	 * 失败
	 * @return
	 */
	public static BaseResponse fail(){
		BaseResponse response=response(Constants.Msg.ERR_MSG);
		return response;
	}
	
	/**
	 * 成功，并返回数据
	 * @param data 数据
	 * @return
	 */
	public static BaseResponse success(Object data){
		BaseResponse response=response(Constants.Msg.SUC_MSG,data);
		return response;
	}
	
	/**
	 * 失败，并设置提示信息
	 * @param msg 提示信息
	 * @return
	 */
	public static BaseResponse fail(String msg){
		BaseResponse response=response(Constants.Msg.ERR_MSG);
		response.setMsg(msg);
		return response;
	}
	
	
	public static BaseResponse response(int code){
		BaseResponse response=new BaseResponse(code);
		return response;
	}
	public static BaseResponse response(int code,String msg){
		BaseResponse response=response(code);
		response.setMsg(msg);
		return response;
	}
	public static BaseResponse response(int code,Object data){
		BaseResponse response=response(code);
		response.setData(data);
		return response;
	}
	public static BaseResponse response(int code,String msg,Object data){
		BaseResponse response=response(code,msg);
		response.setData(data);
		return response;
	}
	public BaseResponse(int code) {
		// 1、请求成功 2、请求失败 3、登录失效 4、无权限
		this.setCode(code);
		
		switch (code) {
			case 1:
				this.setMsg("请求成功");
				break;
	
			case 2:
				this.setMsg("请求失败");
				break;
	
			case 3:
				this.setMsg("登录失效");
				break;
	
			case 4:
				this.setMsg("无权限");
				break;
	
			default:
				this.setCode(2);
				this.setMsg("请求失败");
				break;
		}
		System.err.println("response: code=" + this.code+", msg="+ this.msg);
	}

	/**
	 * 错误信息提示构造函数
	 * 
	 * @param configDO
	 */
	public BaseResponse(ConfigDO configDO) {
		if (null == configDO) {
			this.setCode(2);
			this.setMsg("请求失败");
		} else {
			this.setCode(1);
			this.setMsg("请求成功");
		}
	}

	// /**
	// * 错误信息提示构造函数
	// *
	// * @param configDO
	// */
	// public BaseResponse(ConfigDO configDO) {
	// // this.isSucc = YXContants.getConfigValue(ConfigKey.YXConstants.FALSE);
	// if (null == configDO) {
	// this.setResultCode(ResultCodeEnum.UNKNOWN_ERROR.getType());
	// this.setResultMessage(ResultCodeEnum.UNKNOWN_ERROR.getDesc());
	// } else {
	// this.setResultCode(configDO.getConfigKey());
	// this.setResultMessage(configDO.getValue());
	// }
	// }
	// /**
	// * 错误信息提示构造函数,2
	// * @param configDO
	// * @param ex
	// */
	// public BaseResponse(ConfigDO configDO, Exception ex) {
	// // this.isSucc = YXContants.getConfigValue(ConfigKey.YXConstants.FALSE);
	// if (null == configDO) {
	// if (ResultCodeEnum.isIn(ex.getMessage())) { //包含在配置信息中, add by xiongzhe
	// this.setResultCode(ResultCodeEnum.getEnum(ex.getMessage()).getType());
	// this.setResultMessage(ResultCodeEnum.getEnum(ex.getMessage()).getDesc());
	// } else { //默认提示
	// this.setResultCode(ResultCodeEnum.UNKNOWN_ERROR.getType());
	// this.setResultMessage(ResultCodeEnum.UNKNOWN_ERROR.getDesc());
	// }
	// } else {
	// if (null != configDO) {
	// this.setResultCode(configDO.getConfigKey());
	// this.setResultMessage(configDO.getValue());
	// } else {
	// this.setResultCode(ResultCodeEnum.UNKNOWN_ERROR.getType());
	// this.setResultMessage(ResultCodeEnum.UNKNOWN_ERROR.getDesc());
	// }
	// }
	// }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
