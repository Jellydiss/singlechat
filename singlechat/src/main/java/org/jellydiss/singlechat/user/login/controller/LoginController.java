package org.jellydiss.singlechat.user.login.controller;

import org.jellydiss.singlechat.user.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String Login(){
		return "login";
	}
	
}
