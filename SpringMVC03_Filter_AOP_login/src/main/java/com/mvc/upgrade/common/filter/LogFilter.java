package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;		// HttpServletRequest가 ServletRequest를 상속받고 있음
		
		String remoteAddr = req.getRemoteAddr();	// Spring 서버로 접속한 클라이언트의 IP (IPv6 형식)
		String uri = req.getRequestURI();	// 요청에 사용된 URL로부터 얻어온 URI
		String url = req.getRequestURL().toString();	// 호출된 full 주소 (프로토콜과 포트번호 추가)
		String queryString = req.getQueryString();	// 요청에 사용된 queryString을 리턴
		
		// 웹 서버로 요청 시, HTTP 요청 헤더(header)의 헤더 이름인 name에 해당하는 속성값을 리턴한다. 
		String referer = req.getHeader("referer");	// 이전 페이지의 URL
		String agent = req.getHeader("User-Agent");		// 사용자 정보 (브라우저, OS 등)
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n")
			.append("* uri : " + uri + "\n")
			.append("* url : " + url + "\n")
			.append("* queryString : " + queryString + "\n")
			.append("* referer : " + referer + "\n")
			.append("* agent : " + agent + "\n");

		logger.info("LOG FILTER\n" + sb);

		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
	}

}
