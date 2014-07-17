package org.jellydiss.singlechat.user.login.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jellydiss.singlechat.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginRepository")
public class LoginRepository   {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	
	public void createUser(User user) {
		getCurrentSession().save(user);
	}

	public User getUser(int userSeq) {

		return (User) getCurrentSession().get(User.class,
				userSeq);
	}

	public int getUserSeq(User user) {
		Query query = getCurrentSession().createQuery(
				"from User as u where u.userId = :userId");
		query.setParameter("userId", user.getUserId());

		user = (User) query.uniqueResult();

		if (user == null)
			return -1; // if user is null, return -1

		return user.getUserSeq();
	}
}
