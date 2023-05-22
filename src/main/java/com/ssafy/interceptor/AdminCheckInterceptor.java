package com.ssafy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.model.dto.user.User;
import com.ssafy.model.service.user.UserService;
import com.ssafy.util.JwtUtil;

@Component
public class AdminCheckInterceptor implements HandlerInterceptor {

	private static final String HEADER_AUTH = "access-token";

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService us;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getMethod().equals("OPTIONS"))
			return true;

		String token = request.getHeader(HEADER_AUTH);
		if (token != null) {
			jwtUtil.valid(token);
			String userId = (String) jwtUtil.parseToken(token).get("id");
			User user =  us.selectById(userId);
			return user.getType().equals("A");
		}
		throw new Exception("유효하지 않은 접근이다.");

	}
}
