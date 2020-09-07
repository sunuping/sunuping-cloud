package com.sunuping.annotation;

import java.lang.annotation.*;

/**
 * @author lime
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
    String RESPONSE_RESULT_ANNOTATION = "RESPONSE_RESULT_ANNOTATION";
}
