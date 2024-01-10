package com.fangit.exception;

import com.fangit.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Yifang
 * @version 1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//get all exceptions
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("sorry, operation fails.");
    }
}
