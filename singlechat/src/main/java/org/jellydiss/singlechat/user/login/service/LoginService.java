package org.jellydiss.singlechat.user.login.service;

import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	
	 
	
	public User getUser(User user) {
		// 추후 소스 수정 필요
		
		return this.getUser(user);
	}
	
	@Transactional
	public void createUser(User user) {
		loginRepository.createUser(user);
	}
	
}
