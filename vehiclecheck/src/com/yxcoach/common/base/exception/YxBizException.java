package com.yxcoach.common.base.exception;

/**
 * 
 * @Description 业务异常
 * Created by yangzhipeng on 2017年7月5日
 */
public class YxBizException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public YxBizException() {
        super();
    }

    public YxBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public YxBizException(String message) {
        super(message);
    }

    public YxBizException(Throwable cause) {
        super(cause);
    }


}
