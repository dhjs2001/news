package com.naver.reservation.interceptor;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;


public class LogInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURL = request.getRequestURL().toString();
		LocalDate now = LocalDate.now();
		String clientIP = request.getRemoteAddr();
		
		logger.debug("요청 URL : {}, 시간 : {}, 클라이언트 ip주소 : {}", requestURL, now, clientIP);
		return true;
		
	}

}
