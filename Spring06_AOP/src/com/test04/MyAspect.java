package com.test04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(public void *(..))")
	public void beforeMethod() {
		System.out.println("출석카드를 찍는다.");
	}

	// 예외가 발생하면 동작
	@AfterThrowing("execution(public * *(..))")
	public void throwingMethod() {
		System.out.println("쉬는 날이었다.");
	}

	// target이 return하는 값 받음
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal")
	public void returningMethod(Object returnVal) {
		System.out.println(returnVal + " 공부하는 날이었다.");
	}

	@After("execution(public * com.test04.*.*(..))")
	public void afterMethod() {
		System.out.println("집에 간다.");
	}
}
