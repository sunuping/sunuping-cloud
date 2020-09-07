package com.sunuping.annotation.handler;

import com.sunuping.annotation.ResponseResult;
import com.sunuping.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lime
 */

@RestControllerAdvice
@Slf4j
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> c) {
        if (mp.getMethod() != null) {
            return mp.getMethod().isAnnotationPresent(ResponseResult.class);
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return Result.ok(body);
    }
}
