package com.mvc.hello;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.hello.dto.AddressDTO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) throws UnsupportedEncodingException {

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home"; // "/WEB-INF/views/home.jsp" 로 만들어짐
	}

	@RequestMapping(value = "/command.do", method = RequestMethod.GET)
	public String getCommand(Model model, String name, String addr, String phone) {

		model.addAttribute("dto", new AddressDTO(name, addr, phone));

		return "getcommand"; // "/WEB-INF/views/getcommand.jsp" 로 만들어짐
	}

	@RequestMapping(value = "/command.do", method = RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDTO dto) {

		model.addAttribute("dto", dto);

		return "postcommand";
	}
	
	@RequestMapping(value = "/void.do")	// .do를 지우고 void.jsp를 알아서 찾음
	public void voidPage(Model model) {
		
		model.addAttribute("msg", "void page");
	}

}
