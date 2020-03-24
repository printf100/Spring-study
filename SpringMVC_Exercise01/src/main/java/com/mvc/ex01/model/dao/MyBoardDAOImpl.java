package com.mvc.ex01.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.ex01.model.dto.MyBoardDTO;

@Repository
public class MyBoardDAOImpl implements MyBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyBoardDTO> list() {

		List<MyBoardDTO> list = new ArrayList<MyBoardDTO>();

		try {
			list = sqlSession.selectList(NAMESPACE + "list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MyBoardDAOImpl : list");
		}

		return list;
	}

	@Override
	public MyBoardDTO detail(int MYNO) {

		MyBoardDTO dto = new MyBoardDTO();

		try {
			dto = sqlSession.selectOne(NAMESPACE + "detail", MYNO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MyBoardDAOImpl : detail");
		}

		return dto;
	}

	@Override
	public int write(MyBoardDTO dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "write", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MyBoardDAOImpl : write");
		}

		return res;
	}

	@Override
	public int update(MyBoardDTO dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MyBoardDAOImpl : update");
		}

		return res;
	}

	@Override
	public int delete(int MYNO) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "delete", MYNO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MyBoardDAOImpl : delete");
		}

		return res;
	}

}
