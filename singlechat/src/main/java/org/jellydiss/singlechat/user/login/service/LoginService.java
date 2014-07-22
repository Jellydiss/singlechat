package org.jellydiss.singlechat.user.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jellydiss.singlechat.common.util.DateUtil;
import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.enums.LoginCheckStatus;
import org.jellydiss.singlechat.user.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginService {
	


	@Autowired
	private LoginRepository loginRepository;

	public User getUser(User user) {
		return loginRepository.getUser(loginRepository.getUserSeq(user));
	}

	public void createUser(User user) {
		user.setRegDateTime(DateUtil.getCurrentTime());
		user.setUpdDateTime(DateUtil.getCurrentTime());

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
				registerUserToSession(selectedUser, request.getSession());
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
