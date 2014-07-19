package org.jellydiss.singlechat.user.login.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.enums.LoginCheckStatus;
import org.jellydiss.singlechat.user.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginService {
	
	private static final DateFormat dateFormat = 
			new SimpleDateFormat("yyyyMMddHHmmss");

	@Autowired
	private LoginRepository loginRepository;

	public User getUser(User user) {
		return loginRepository.getUser(loginRepository.getUserSeq(user));
	}

	public void createUser(User user) {
		String currentTime = dateFormat.format(new Date());
		user.setRegDateTime(currentTime);
		user.setUpdDateTime(currentTime);

		loginRepository.createUser(user);
	}

	@Transactional
	public LoginCheckStatus login(User userQuery, HttpServletRequest request) {
		User selectedUser = getUser(userQuery);

		if (selectedUser == null) {
			createUser(userQuery);
			return login(userQuery, request);
		}else {
			if (userQuery.getUserPw().equals(selectedUser.getUserPw())){
				registerUserToSession(userQuery, request.getSession());
				return LoginCheckStatus.LOGIN_SUCCESS;
			} else {
				return LoginCheckStatus.PW_INCORRECT;
			}
		}
	}

	private void registerUserToSession(User user, HttpSession session) {
		session.setAttribute("user", user);		
	}
}
