package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");

		Developer hong = (Developer) factory.getBean("hong");
		System.out.println(hong);

		Engineer lee = (Engineer) factory.getBean("lee");
		System.out.println(lee);
	}
}
