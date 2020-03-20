package com.hello.mvc.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDAO {

	// TODO : 07. DAO에서 return
	public String getHello() {
		return "Spring";
	}
}
