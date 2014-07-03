package org.jellydiss.singlechat.login.repository;


import org.hibernate.SessionFactory;
import org.jellydiss.singlechat.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("loginRepository")
public class LoginRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer createUser(Login user) {
		Login mergeUser = (Login) sessionFactory.getCurrentSession().merge(user);
		
		return mergeUser.getUserSeq();
	}

	public Login getUser(Login user) {
		return null;
	}

}
