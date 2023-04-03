package com.project.lms.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String requestURI = request.getRequestURI();
		String paramId = request.getParameter("id") == null ? "" : "?id=" + request.getParameter("id");
		log.info("requestURI: {}", requestURI);
		log.info("인터셉터 사용자 로그인 인증");
		if (session == null || session.getAttribute("loginMember") == null) {
			log.info("인터셉터 로그인 인증 실패");
			response.sendRedirect("/member/loginForm?redirectURL=" + requestURI + paramId);
			return false;
		}
		return true;
	}
}
