package com.spring.test.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
	@Around("@annotation(com.spring.test.annotation.Auth) && @ annotation(target)")
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint, Auth target) throws Throwable {
		System.out.println("AUTH 어노테이션의 값 : " + target.check());
		Object returnPoint = joinPoint.proceed();
		return returnPoint;
	}
}
