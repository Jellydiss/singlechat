package org.jellydiss.singlechat.login.service;

import org.jellydiss.singlechat.login.entity.Login;
import org.jellydiss.singlechat.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public Login getUser(Login user) {
		// 추후 소스 수정 필요
		
		return this.getUser(user);
	}
	
	@Transactional
	public Integer createUser(Login user) {
		
		
		return loginRepository.createUser(user);
	}
	
}
