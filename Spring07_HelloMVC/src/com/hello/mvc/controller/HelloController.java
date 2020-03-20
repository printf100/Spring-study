package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.biz.HelloBiz;

@Controller
public class HelloController {

	// TODO : 05. Biz(@Service) 호출
	@Autowired
	private HelloBiz biz;

	// TODO : 04. Handler Mapping(/hello.do)를 통해 controller의 메소드를 찾아옴
	@RequestMapping("/hello.do")
	public ModelAndView getHello() {

		ModelAndView mav = new ModelAndView();

		String msg = biz.getHello();

		// TODO : 09. 리턴받은 값을 model 객체에 담아서 전달
		mav.addObject("message", msg);
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}
}
