package com.example.demo.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

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
        if (e instanceof ConstraintViolationException) {
            log.warn(e.getMessage(), e);
            return ResultGenerator.genFailResult(e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            return ResultGenerator.genFailResult(e.getMessage());
        } else if (e instanceof BindException) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genFailResult("系统忙");
    }

}
