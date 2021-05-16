package com.zzu.bbs.dto;
/*
 * User:程成
 * Date:2021/5/16
 * Time:22:47
 * Description:
 */

import com.zzu.bbs.exception.CustomErrorCode;
import lombok.Data;

@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;

    }

    public static ResultDTO errorOf(CustomErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());

    }

}
