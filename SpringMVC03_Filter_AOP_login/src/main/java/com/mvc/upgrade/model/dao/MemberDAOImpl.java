package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public MemberDTO login(MemberDTO dto) {
		
		MemberDTO loginMember = new MemberDTO();
		
		try {
			loginMember = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] - MemberDAOImpl : login()");
		}
		
		return loginMember;
	}

}
