package org.jellydiss.singlechat.message.chat.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.jellydiss.singlechat.common.config.MvcConfiguration;
import org.jellydiss.singlechat.common.config.WebAppInitializer;
import org.jellydiss.singlechat.common.config.hibernate.HibernateConfig;
import org.jellydiss.singlechat.common.config.hibernate.RepositoryConfig;
import org.jellydiss.singlechat.message.entity.Chat;
import org.jellydiss.singlechat.message.entity.ChatUser;
import org.jellydiss.singlechat.message.entity.Message;
import org.junit.Before;
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
public class ChatServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private ChatService chatService;
	
	@Before
	public void setUp(){
		chatService.setLastMessageNumber();
	}
	
	@Test
	@Rollback(true)
	public void insertMessageSuccess(){
		ChatUser chatUser = new ChatUser();
		Message message = new Message();
		
		chatUser.setUserSeq(5);
		
		message.setMessageContent("test");
		try{
			chatService.insertMessage(chatUser, message);
			assertTrue("Insert message success" , true);
		}catch(Exception e){
			e.printStackTrace();
			assertTrue("Insert message fail", false); // When throw Exception
		}
				
	}
	
	@Test
	public void getLastMessageSuccess(){
		Chat chat = null;
		try {
			chat = chatService.getLastMessage();
			assertNotNull("Success get last message", chat);
		} catch (Exception e) {
			assertTrue("Throw exception", false );
		}
		
				
	}
}
