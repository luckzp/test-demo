package com.example.demo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一封装对外请求
 * @author pengzhang34
 * @date 2020/9/24 15:44
 */
@Data
public class RestResponse<T> implements Serializable {
    private static final long serialVersionUID = -8209853144735356505L;
    private static final String SUCCESS_CODE = "200";

    private static final String ERROR_CODE = "500";

    private String code;

    private  T result;

    private RestResponse(String code, T data){
        this.result = data;
        this.code = code;
    }

    public static <T> RestResponse<T> success(T result){
        return new RestResponse<>(SUCCESS_CODE, result);
    }
}
