package com.torres.exception;

/**
 * 自定义param异常类
 * Created by Torres
 * 2018-05-27 17:53
 */
public class ParamException extends RuntimeException{

//    重写RuntimeException的五个方法
    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
