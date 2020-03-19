package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvice {

	public MyAdvice() {
	}
	
	@Before("execution(public * *(..))")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇입니까?");
	}

	@AfterReturning(pointcut="execution(public String sayName(..))", returning="name")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요.");
	}
	
	@After("execution(public * *(..))")
	public void afterReturnSaying(JoinPoint join) {
		System.out.println("직업이 무엇입니까?");
	}
}
