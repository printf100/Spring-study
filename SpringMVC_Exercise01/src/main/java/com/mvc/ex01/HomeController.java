package com.mvc.ex01;

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

import com.mvc.ex01.model.biz.MyBoardBiz;
import com.mvc.ex01.model.dto.MyBoardDTO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MyBoardBiz biz;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 게시물 목록
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String boardList(Model model) {

		model.addAttribute("list", biz.list());

		return "boardList";
	}

	// 게시물 내용
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, int MYNO) {

		model.addAttribute("dto", biz.detail(MYNO));

		return "boardDetail";
	}

	// 게시물 작성화면
	@RequestMapping(value = "/writepage.do", method = RequestMethod.GET)
	public String boardWritepage() {

		return "boardWrite";
	}

	// 게시물 작성하기
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public void boardWrite(MyBoardDTO dto, HttpServletResponse response) throws IOException {

		int res = biz.write(dto);

		if (res > 0) {
			jsResponse("글이 작성되었습니다.", "list.do", response);
		} else {
			jsResponse("글 작성을 실패하였습니다.", "writepage.do", response);
		}
	}

	// 게시물 수정화면
	@RequestMapping(value = "/updatepage.do", method = RequestMethod.GET)
	public String boardUpdatepage(Model model, int MYNO) {

		model.addAttribute("dto", biz.detail(MYNO));

		return "boardUpdate";
	}

	// 게시물 수정하기
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public void boardUpdate(MyBoardDTO dto, HttpServletResponse response) throws IOException {

		int res = biz.update(dto);

		if (res > 0) {
			jsResponse("글이 수정되었습니다.", "list.do", response);
		} else {
			jsResponse("글 수정을 실패하였습니다.", "updatepage.do?" + dto.getMYNO(), response);
		}
	}

	// 게시물 삭제하기
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public void boardDelete(int MYNO, HttpServletResponse response) throws IOException {

		int res = biz.delete(MYNO);

		if (res > 0) {
			jsResponse("글이 삭제되었습니다.", "list.do", response);
		} else {
			jsResponse("글 삭제를 실패하였습니다.", "detail.do?" + MYNO, response);
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
