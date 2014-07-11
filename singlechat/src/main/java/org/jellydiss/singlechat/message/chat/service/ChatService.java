package org.jellydiss.singlechat.message.chat.service;

import org.jellydiss.singlechat.message.chat.repository.ChatRepository;
import org.jellydiss.singlechat.message.entity.Chat;
import org.jellydiss.singlechat.message.entity.Message;
import org.jellydiss.singlechat.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	@Autowired
	private ChatRepository chatRepository;
	
	public void insertMessage(User user, Message message){
		Chat chat = new Chat();
		chat.setMessage(message);
		chat.setUser(user);
		chatRepository.insertMessage(chat);
		
	}
	
	public Chat getLastMessage(){
		return chatRepository.getMessage(chatRepository.getLastChatNumber());
		
	}
}
