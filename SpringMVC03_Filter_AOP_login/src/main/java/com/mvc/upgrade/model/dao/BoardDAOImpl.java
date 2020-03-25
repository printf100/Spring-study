package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDTO> selectList() {

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - BoardDAOImpl : selectList()");
		}

		return list;
	}

	@Override
	public BoardDTO selectOne(int myno) {

		BoardDTO dto = new BoardDTO();

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - BoardDAOImpl : selectOne(int myno)");
		}

		return dto;
	}

	@Override
	public int insert(BoardDTO dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - BoardDAOImpl : insert(BoardDTO dto)");
		}

		return res;
	}

	@Override
	public int update(BoardDTO dto) {

		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - BoardDAOImpl : update(BoardDTO dto)");
		}

		return res;
	}

	@Override
	public int delete(int myno) {

		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - BoardDAOImpl : delete(int myno)");
		}

		return res;
	}

}
