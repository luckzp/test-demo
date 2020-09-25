package com.example.demo.base;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author pengzhang34
 * @date 2020/9/24 15:52
 */
@ControllerAdvice(annotations = RestController.class)
public class RestResponseBodyAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        if (RestResponse.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        return RestResponse.success(body);
    }
}
