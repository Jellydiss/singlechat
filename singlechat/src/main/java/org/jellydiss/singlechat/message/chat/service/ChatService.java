package org.jellydiss.singlechat.message.chat.service;

import org.jellydiss.singlechat.common.util.DateUtil;
import org.jellydiss.singlechat.message.chat.repository.ChatRepository;
import org.jellydiss.singlechat.message.entity.Chat;
import org.jellydiss.singlechat.message.entity.ChatStatus;
import org.jellydiss.singlechat.message.entity.ChatUser;
import org.jellydiss.singlechat.message.entity.Message;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;

	public void setLastMessageNumber() {
		ChatStatus.lastSequenceNumber = chatRepository.getLastMessageNumber();
	}

	public void insertMessage(ChatUser chatUser, Message message) {
		Chat chat = new Chat();
		chat.setMessage(message);
		chat.getMessage().setRegDateTime(DateUtil.getCurrentTime());
		chat.setChatUser(chatUser);
		chatRepository.insertMessage(chat);
		setLastMessageNumber();
	}

	public Chat getLastMessage() {
		return chatRepository.getMessage(ChatStatus.lastSequenceNumber);
	}

	
	@SuppressWarnings("unchecked")
	public JSONObject getLastMessageJson() {
		Chat lastChat = getLastMessage();
		JSONObject object = new JSONObject();
		object.put("userName", lastChat.getChatUser().getUserId());
		object.put("message", lastChat.getMessage());
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getLastSequence() {
		JSONObject object = new JSONObject();
		object.put("lastSeq", ChatStatus.lastSequenceNumber);
		return object;
	}

}
