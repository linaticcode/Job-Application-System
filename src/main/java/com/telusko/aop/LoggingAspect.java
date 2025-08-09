package com.telusko.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER  = LoggerFactory.getLogger(LoggingAspect.class);
	
//	return type , class-name.method-name(args)
//	Advise(WHAT) ..  POINT CUT	
	@Before("execution(* com.telusko.service.JobService.getJob(..) || com.telusko.service.JobService.updateJob(..))")
	public void logMethodCall(JoinPoint jp) {
		
		LOGGER.info("Method called" + jp.getSignature().getName());
		
	}
	
	@After("execution(* com.telusko.service.JobService.getJob(..) || com.telusko.service.JobService.updateJob(..))")
	public void logMethodExecuted(JoinPoint jp) {
		
		LOGGER.info("Method executed" + jp.getSignature().getName());
		
	}
	
	
}
