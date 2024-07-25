package com.banking_app.banking_app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class PerformanceMonitorAspect {
   
public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);


@Around("execution(* com.banking_app.banking_app.service.impl.AccountServiceImpl.*(..))")
public Object monitorTime(ProceedingJoinPoint jp) throws Throwable{

Long startTime = System.currentTimeMillis();

Object obj =jp.proceed();

Long endTime = System.currentTimeMillis();


LOGGER.info("*** Time taken to execute: " + jp.getSignature().getName() + " is " +(endTime - startTime));


return obj; 

}


    
}
