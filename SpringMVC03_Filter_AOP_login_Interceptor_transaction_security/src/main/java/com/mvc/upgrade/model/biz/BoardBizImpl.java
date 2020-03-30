package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDAO;
import com.mvc.upgrade.model.dto.BoardDTO;

@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardDTO> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDTO selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	//@Transactional
	@Override
	public String test() {

		// dummy insert
		dao.insert(new BoardDTO(1000, "test", "test", "test", null));

		// exception 발생 !! -> 위의 dummy insert는 rollback 되어야함!
		String test = dao.test();
		int length = test.length();

		return null;
	}

}
