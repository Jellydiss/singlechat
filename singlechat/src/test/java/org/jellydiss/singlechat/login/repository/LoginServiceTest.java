package org.jellydiss.singlechat.login.repository;

import static org.junit.Assert.*;

import org.jellydiss.singlechat.common.config.MvcConfiguration;
import org.jellydiss.singlechat.common.config.WebAppInitializer;
import org.jellydiss.singlechat.common.config.hibernate.HibernateConfig;
import org.jellydiss.singlechat.common.config.hibernate.RepositoryConfig;
import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes ={
	HibernateConfig.class,
	RepositoryConfig.class,
	WebAppInitializer.class,
	MvcConfiguration.class
})
public class LoginServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private LoginService loginService;

	@Test
	@Rollback(true)
	public void createUser(){
		
		User user = new User();
		
		user.setUserId("createTest");
		user.setUserpw("asdf");
		
	    loginService.createUser(user);
		
		assertTrue(true);
	}
	
	@Test
	@Rollback(true)
	public void getUser(){

		User user = new User();
		user.setUserId("test2");
		
	    loginService.getUser(user);
		
	    
		assertTrue(true);
	}
	
	
	
}
