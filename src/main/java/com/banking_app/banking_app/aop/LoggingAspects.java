package com.banking_app.banking_app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class LoggingAspects {



	public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspects.class);

            // return type, class-name.methode-name(args)
    @Before("execution (* com.banking_app.banking_app.service.impl.AccountServiceImpl.*(..)) ")
    
	public void logMethodCall() {
    LOGGER.info("Method Called ");
}

	@After("execution (* com.banking_app.banking_app.service.impl.AccountServiceImpl.*(..))")
	public void logMethodExcuted(JoinPoint jp) {
		LOGGER.info("Method Executed " + jp.getSignature().getName());
	}


    @AfterThrowing("execution (* com.banking_app.banking_app.service.impl.AccountServiceImpl.*(..))")
	public void logMethodCrashed(JoinPoint jp) {
		LOGGER.info("Method has some issues " + jp.getSignature().getName());
	}


    @AfterReturning("execution (* com.banking_app.banking_app.service.impl.AccountServiceImpl.*(..))")
	public void logMethodExecSuccessfully(JoinPoint jp) {
		LOGGER.info("Method executed successfully! " + jp.getSignature().getName());
	}




    

}