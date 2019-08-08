package com.example.other.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wxq
 * @date 2018-11-19
 */
@ControllerAdvice
@Slf4j
public class ControlAdvice {

    @ResponseBody
    @ExceptionHandler
    public Result handleThrowable(Exception e) {
        return ResultGenerator.genFailResult(e.getMessage());
    }

}
