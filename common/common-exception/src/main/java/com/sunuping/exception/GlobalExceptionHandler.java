package com.sunuping.exception;

import com.sunuping.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lime
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数验证全局处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.fail();

    }

    /**
     * 全局异常捕捉处理
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) throws BindException {
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), false));
        webDataBinder.close();
    }
}
