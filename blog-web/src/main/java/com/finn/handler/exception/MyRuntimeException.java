package com.finn.handler.exception;

import com.finn.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * @description:
 * @author: Finn
 * @create: 2022-01-10-14-11
 */
@Getter
@Setter
@AllArgsConstructor

public class MyRuntimeException extends RuntimeException {

    private String code;
    private String message;

    public MyRuntimeException(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
    }

}
