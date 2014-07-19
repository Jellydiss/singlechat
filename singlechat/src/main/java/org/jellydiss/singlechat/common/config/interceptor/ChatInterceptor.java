package org.jellydiss.singlechat.common.config.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jellydiss.singlechat.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ChatInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);

		
		if( sessionExist(session, response)
				&& userNameExistsInSession(session, response))
			return true;
		
		response.sendRedirect("");
		return false; 
	}

	private boolean sessionExist(HttpSession session,
			HttpServletResponse response) throws IOException {
		if (session == null) 			
			return false;
		return true;
	}

	private boolean userNameExistsInSession(HttpSession session,
			HttpServletResponse response) throws IOException {
		User userName = (User) session.getAttribute("user");

		if (userName == null) 
			return false;
		return true;
	}
}
