package com.test02;

public class Address {

	private String name;
	private String addr;
	private String phone;

	public Address() {
		this.name = "백승아";
		this.addr = "경기도 성남시";
		this.phone = "010-1234-5678";
	}

	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t주소 : " + addr + "\t핸드폰번호 : " + phone;
	}

}
