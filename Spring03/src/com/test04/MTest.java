package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Developer hong = (Developer) factory.getBean("honggildong");
		System.out.println(hong);
		
		Engineer lee = factory.getBean("leesunsin", Engineer.class);
		System.out.println(lee);
	}
}
