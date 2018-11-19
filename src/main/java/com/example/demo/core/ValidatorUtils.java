package com.example.demo.core;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author wxq
 * @date 2018-11-19
 */
public class ValidatorUtils {
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 手动验证参数，抛出异常给controllerAdvice解析
     *
     * @param obj
     * @param <T>
     */
    public static <T> void validateEntity(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        if (constraintViolations != null && !constraintViolations.isEmpty()) {
            ConstraintViolation<T> next = constraintViolations.iterator().next();
            throw new ServiceException("参数{" + next.getPropertyPath() + "}校验失败：" + next.getMessage());
        }
    }
}
