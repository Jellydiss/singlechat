package org.jellydiss.singlechat.user.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.enums.LoginCheckStatus;
import org.jellydiss.singlechat.user.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String Login(){
		return "login";
	}
	
	@RequestMapping(value ="", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute User userInfo, HttpServletRequest request) {
	
		LoginCheckStatus status = loginService.login(userInfo, request);
	
		if (status == LoginCheckStatus.PW_INCORRECT) {
			request.setAttribute("loginMsg", "비밀번호가 일치하지 않습니다.");
			return "login";
		}

		return "redirect:/chat";
	}
}
