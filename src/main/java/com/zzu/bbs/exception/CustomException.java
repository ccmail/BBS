package com.zzu.bbs.exception;
/*
 * User:程成
 * Date:2021/5/16
 * Time:17:11
 * Description:
 */

public class CustomException extends RuntimeException {
    private String message;
    private Integer code;




    public CustomException(ICustomErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }


    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
