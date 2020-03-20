package com.hello.mvc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc.model.dao.HelloDAO;

@Service
public class HelloBiz {

	// TODO : 06. DAO(@Repository) 호출
	@Autowired
	private HelloDAO dao;

	public String getHello() {
		// TODO : 08. Biz에서 return
		return "Hello, " + dao.getHello();
	}
}
