package com.mvc.ex01.model.dao;

import java.util.List;

import com.mvc.ex01.model.dto.MyBoardDTO;

public interface MyBoardDAO {

	String NAMESPACE = "myboard.";

	public List<MyBoardDTO> list();

	public MyBoardDTO detail(int MYNO);

	public int write(MyBoardDTO dto);

	public int update(MyBoardDTO dto);

	public int delete(int MYNO);
}
