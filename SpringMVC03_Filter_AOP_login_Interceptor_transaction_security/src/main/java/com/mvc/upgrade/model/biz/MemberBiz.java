package com.mvc.upgrade.model.biz;

import com.mvc.upgrade.model.dto.MemberDTO;

public interface MemberBiz {

	public MemberDTO login(MemberDTO dto);
	
	public int idChk(String MEMBERID);
	
	public int join(MemberDTO dto);
}
