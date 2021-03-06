package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

		Emp my = (Emp) factory.getBean("my");
		System.out.println(my);

		Emp f1 = (Emp) factory.getBean("f1");
		System.out.println(f1);

		Emp f2 = (Emp) factory.getBean("f2");
		System.out.println(f2);
	}
}
