package com.banking_app.banking_app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.banking_app.banking_app.service.impl.AccountServiceImpl.getAccountByID(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, Long id) throws Throwable {
        LOGGER.info("Intercepted call to getAccountByID with id: " + id);

        if (id < 0) {
            LOGGER.info("Account ID is negative, updating it");
            id = -id;
            LOGGER.info("New Value: " + id);
        }

        Object obj = jp.proceed(new Object[]{id});
        LOGGER.info("After proceeding the call with id: " + id);

        return obj;
    }
}
