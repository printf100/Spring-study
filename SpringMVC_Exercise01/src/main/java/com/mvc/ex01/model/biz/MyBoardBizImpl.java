package com.mvc.ex01.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.ex01.model.dao.MyBoardDAO;
import com.mvc.ex01.model.dto.MyBoardDTO;

@Service
public class MyBoardBizImpl implements MyBoardBiz {

	@Autowired
	private MyBoardDAO dao;

	@Override
	public List<MyBoardDTO> list() {
		return dao.list();
	}

	@Override
	public MyBoardDTO detail(int MYNO) {
		return dao.detail(MYNO);
	}

	@Override
	public int write(MyBoardDTO dto) {
		return dao.write(dto);
	}

	@Override
	public int update(MyBoardDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int MYNO) {
		return dao.delete(MYNO);
	}

}
