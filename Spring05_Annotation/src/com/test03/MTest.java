package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");

		TV samsongTV = (TV) factory.getBean("samsong");
		TV igTV = (TV) factory.getBean("igTV");

		samsongTV.powerOn();
		samsongTV.volumeUp();
		samsongTV.volumeDown();
		samsongTV.powerOff();

		igTV.powerOn();
		igTV.volumeUp();
		igTV.volumeDown();
		igTV.powerOff();
	}
}
