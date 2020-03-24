package com.mvc.ex01.model.biz;

import java.util.List;

import com.mvc.ex01.model.dto.MyBoardDTO;

public interface MyBoardBiz {

	public List<MyBoardDTO> list();

	public MyBoardDTO detail(int MYNO);

	public int write(MyBoardDTO dto);

	public int update(MyBoardDTO dto);

	public int delete(int MYNO);
}
