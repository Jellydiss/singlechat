package org.jellydiss.singlechat.message.chat.service;

import org.jellydiss.singlechat.message.chat.repository.ChatRepository;
import org.jellydiss.singlechat.message.entity.Chat;
import org.jellydiss.singlechat.message.entity.ChatStatus;
import org.jellydiss.singlechat.message.entity.ChatUser;
import org.jellydiss.singlechat.message.entity.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatService {
	@Autowired
	private ChatRepository chatRepository;

	@Transactional
	public void setLastMessageNumber() {
		ChatStatus.lastSequenceNumber = chatRepository.getLastMessageNumber();
	}

	@Transactional
	public void insertMessage(ChatUser chatUser, Message message) {
		Chat chat = new Chat();
		chat.setMessage(message);
		chat.setChatUser(chatUser);
		chatRepository.insertMessage(chat);
		setLastMessageNumber();
	}

	@Transactional
	public Chat getLastMessage() {
		return chatRepository.getMessage(ChatStatus.lastSequenceNumber);
	}

	public JSONObject getLastMessageJson() {
		Chat lastChat = getLastMessage();
		JSONObject object = new JSONObject();
		object.put("userName", lastChat.getChatUser().getUserId());
		object.put("message", lastChat.getMessage());
		return object;
	}
	
	public JSONObject getLastSequence() {
		JSONObject object = new JSONObject();
		object.put("lastSeq", ChatStatus.lastSequenceNumber);
		return object;
	}

}
