package com.telusko.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution(* com.telusko.service.JobService.getJob(..)) && args(postId)")
	public Object validateAndUpdate(ProceedingJoinPoint jp , int postId) throws Throwable {
		
		  if(postId < 0) {
			  postId = -postId;
		  }    
		  
//		  changes the value by passing args
		  
		  Object obj = jp.proceed(new Object[] {postId});
		  
		  return obj;
		
	}
	
}
