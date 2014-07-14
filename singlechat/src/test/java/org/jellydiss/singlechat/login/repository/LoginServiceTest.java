package org.jellydiss.singlechat.login.repository;

import static org.junit.Assert.*;

import org.jellydiss.singlechat.common.config.MvcConfiguration;
import org.jellydiss.singlechat.common.config.WebAppInitializer;
import org.jellydiss.singlechat.common.config.hibernate.HibernateConfig;
import org.jellydiss.singlechat.common.config.hibernate.RepositoryConfig;
import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.enums.LoginCheckStatus;
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
@ContextConfiguration(classes = { HibernateConfig.class,
		RepositoryConfig.class, WebAppInitializer.class, MvcConfiguration.class })
public class LoginServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private LoginService loginService;

	@Test
	@Rollback(true)
	public void createUserSuccess() {
		User user = new User();

		user.setUserId("createTest");
		user.setUserpw("asdf");
		try {
			loginService.createUser(user);
			assertTrue("Create user success", true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("Create user fail", false); // When throw Exception
		}

	}

	@Test
	public void getUserSuccess() {
		User user = new User();
		user.setUserId("test2");

		User assertUser = loginService.getUser(user);

		assertNotNull("Get user success", assertUser);
	}

	@Test
	public void getUserFail() {
		User user = new User();
		user.setUserId("nullUser"); // emptyUser

		User assertUser = loginService.getUser(user);

		assertNull("Get non existent user is null", assertUser);
	}

	@Test
	public void loginSuccess() {
		User user = new User();

		user.setUserId("test2");
		user.setUserpw("asdf");

		assertSame("Success login", loginService.login(user),
				LoginCheckStatus.LOGIN_SUCCESS);
	}

	@Test
	public void loginIncorrectPassword() {
		User user = new User();

		user.setUserId("test2");
		user.setUserpw("arstarst");

		assertSame("Incorrect password", loginService.login(user),
				LoginCheckStatus.PW_INCORRECT);
	}
}
