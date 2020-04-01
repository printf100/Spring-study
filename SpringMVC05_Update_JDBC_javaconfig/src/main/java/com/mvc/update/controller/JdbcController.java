package com.mvc.update.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.update.model.biz.JdbcBiz;
import com.mvc.update.model.dto.JdbcDto;

@Controller
public class JdbcController {

	private static final Logger logger = LoggerFactory.getLogger(JdbcController.class);

	@Autowired
	private JdbcBiz biz;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {

		List<JdbcDto> list = biz.selectList();
		model.addAttribute("list", list);

		return "jdbclist";
	}

	@RequestMapping("/writepage.do")
	public String writePage() {

		return "jdbcwrite";
	}

	@RequestMapping("/write.do")
	public String write(JdbcDto dto) {

		int res = biz.insert(dto);

		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:writepage.do";
		}

	}

}
