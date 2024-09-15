package com.project.team3.interceptor;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.project.team3.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("LoginInterceptor.preHandler()");
		// session에서 userId가 있는지 확인 -> 로그인 했는지 체크
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userId");
		
		if(user == null || user.userId.length() == 0) {
			response.sendRedirect("/login.do");
			return false;
		}
		
		return true;
	}

}
