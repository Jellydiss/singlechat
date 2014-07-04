package org.jellydiss.singlechat.user.login.repository;

import org.hibernate.SessionFactory;
import org.jellydiss.singlechat.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("loginRepository")
public class LoginRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User getUser(User user) {
		
		return (User) sessionFactory.getCurrentSession().get(User.class, user.getUserSeq());
	}

}
