package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDTO;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz biz;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// 회원가입 화면
	@RequestMapping(value = "/joinpage.do")
	public String joinPage() {

		logger.info("JOIN PAGE");

		return "mvcjoin";
	}

	// 아이디 중복체크
	@RequestMapping(value = "/ajaxidchk.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxIdChk(@RequestBody MemberDTO dto) {

		logger.info("AJAX IDCHK");

		int res = biz.idChk(dto.getMEMBERID());

		boolean check = false;

		if (res > 0) {
			check = true;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", check);

		return map;
	}

	// 회원가입 처리
	@RequestMapping(value = "/ajaxjoin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxJoin(@RequestBody MemberDTO dto) {

		logger.info("AJAX JOIN");
		
		// 비밀번호 암호화
		dto.setMEMBERPW(passwordEncoder.encode(dto.getMEMBERPW()));
		System.out.println("------------" + dto.getMEMBERPW());

		int res = biz.join(dto);

		boolean check = false;

		if (res > 0) {
			check = true;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", check);

		return map;
	}

	// 로그인 화면
	@RequestMapping(value = "/loginpage.do")
	public String loginPage() {

		logger.info("LOGIN PAGE");

		return "mvclogin";
	}

	// 로그인 처리
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDTO dto) {

		logger.info("AJAX LOGIN");

		MemberDTO res = biz.login(dto);

		boolean check = false;

		if (res != null) {
			
			// DB의 비밀번호와 입력한 비밀번호 비교
			if(passwordEncoder.matches(dto.getMEMBERPW(), res.getMEMBERPW())) {
				
				session.setAttribute("login", res);
				check = true;
			}
			
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);

		return map;
	}
	
}
