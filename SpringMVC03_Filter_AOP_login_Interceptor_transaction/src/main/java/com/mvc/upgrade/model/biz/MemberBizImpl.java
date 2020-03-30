package com.mvc.upgrade.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MemberDAO;
import com.mvc.upgrade.model.dto.MemberDTO;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDAO dao;

	@Override
	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}

	@Override
	public int idChk(String MEMBERID) {
		return dao.idChk(MEMBERID);
	}

	@Override
	public int join(MemberDTO dto) {
		return dao.join(dto);
	}

}
