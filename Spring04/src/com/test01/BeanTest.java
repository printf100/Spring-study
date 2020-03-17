package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {

	private MyClass myClass;

	public BeanTest() {
		System.out.println("기본 생성자!");
	}

	public BeanTest(Date date) {
		System.out.println("파라미터 1개 생성자(Date date) : " + date);
		System.out.println();
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass(MyClass myClass) 호출");
	}

	public void setDate(Date date) {
		System.out.println();
		System.out.println("setDate(Date date) 호출 - 오늘 날짜 : " + date);
	}

	public void setNumber(int i) {
		System.out.println();
		System.out.println("setNumber(int i) 호출 : " + i);
	}

	public void setArray(String[] arr) {
		System.out.println();
		System.out.println("setArray(String[] arr) 호출 : ");

		for (String str : arr) {
			System.out.println(str);
		}
	}

	public void setList(List<String> list) {
		System.out.println();
		System.out.println("setList(List<String> list) 호출");

		for (String str : list) {
			System.out.println(str);
		}
	}

	public void setMySet(Set<String> set) {
		System.out.println();
		System.out.println("setMySet(Set<String> set) 호출");

		for (String str : set) {
			System.out.println(str);
		}
	}

	public void setMap(Map<String, String> map) {
		System.out.println();
		System.out.println("setMap(Map<String, String> map) 호출");

		Collection<String> keys = map.keySet();
		Collection<String> values = map.values();

		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	public void setScore(List<Score> score) {
		System.out.println();
		System.out.println("setScore(List<Score> score) 호출");

		for (Score sc : score) {
			System.out.println(sc);
		}
	}

}
