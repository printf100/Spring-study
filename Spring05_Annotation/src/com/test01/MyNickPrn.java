package com.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickPrn {
// myNickPrn 이라는 bean이 된다.

	@Autowired
	private Nickname nickname;
	// Nickname과 같은 타입의 객체를 찾아서 nickname에 넣어줌

	public Nickname getNickname() {
		return nickname;
	}

	public void setNickname(Nickname nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "내 별명은 " + nickname + "입니다.";
	}

}
