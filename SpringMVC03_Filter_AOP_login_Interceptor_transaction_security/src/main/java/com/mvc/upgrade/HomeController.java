package com.mvc.upgrade;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDTO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardBiz biz;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	// transaction
	@RequestMapping(value = "/test.do")
	public String test() {
		
		logger.info("TRANSACTION");
		biz.test();
		
		return "redirect:list.do";
	}

	// 게시물 리스트
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String boardList(Model model) {

		logger.info("SELECT LIST");

		model.addAttribute("list", biz.selectList());

		return "boardList";
	}

	// 게시물 내용
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String boardDetail(int MYNO, Model model) {

		logger.info("SELECT ONE");

		model.addAttribute("dto", biz.selectOne(MYNO));

		return "boardDetail";
	}

	// 글 작성 화면
	@RequestMapping(value = "/writepage.do", method = RequestMethod.GET)
	public String boardWritepage() {

		return "boardWrite";
	}

	// 글 작성하기
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public void boardWrite(BoardDTO dto, HttpServletResponse response) throws IOException {

		logger.info("INSERT");

		int res = biz.insert(dto);

		if (res > 0) {
			jsResponse("글이 작성되었습니다.", "list.do", response);
		} else {
			jsResponse("글 작성을 실패하였습니다.", "write.do", response);
		}
	}

	// 글 수정 화면
	@RequestMapping(value = "/updatepage.do", method = RequestMethod.GET)
	public String boardUpdatepage(int MYNO, Model model) {

		model.addAttribute("dto", biz.selectOne(MYNO));

		return "boardUpdate";
	}

	// 글 수정하기
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public void boardUpdate(BoardDTO dto, HttpServletResponse response) throws IOException {

		logger.info("UPDATE");

		int res = biz.update(dto);

		if (res > 0) {
			jsResponse("글이 수정되었습니다.", "list.do", response);
		} else {
			jsResponse("글 수정을 실패하였습니다.", "update.do?MYNO=" + dto.getMYNO(), response);
		}
	}

	// 글 삭제하기
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public void boardDelete(int MYNO, HttpServletResponse response) throws IOException {

		logger.info("DELETE");

		int res = biz.delete(MYNO);
		
		if (res > 0) {
			jsResponse("글이 삭제되었습니다.", "list.do", response);
		} else {
			jsResponse("글 삭제를 실패하였습니다.", "detail.do?MYNO=" + MYNO, response);
		}
	}

	// 알러트 창 띄우기
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");

		out.flush();
	}
}
