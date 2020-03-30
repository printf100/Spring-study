package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	// 로그인 처리
	@Override
	public MemberDTO login(MemberDTO dto) {

		MemberDTO loginMember = null;

		try {
			loginMember = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MemberDAOImpl : login()");
		}

		return loginMember;
	}

	// 아이디 중복체크
	@Override
	public int idChk(String MEMBERID) {

		int res = 0;

		try {
			res = sqlSession.selectOne(NAMESPACE + "idchk", MEMBERID);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MemberDAOImpl : idChk()");
		}

		return res;
	}

	// 회원가입 처리
	@Override
	public int join(MemberDTO dto) {

		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "join", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MemberDAOImpl : join()");
		}

		return res;
	}

}
