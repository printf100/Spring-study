package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDTO;

public interface MemberDAO {

	String NAMESPACE = "mymember.";
	
	public MemberDTO login(MemberDTO dto);
}
