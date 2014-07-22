package org.jellydiss.singlechat.message.chat.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jellydiss.singlechat.message.chat.service.ChatService;
import org.jellydiss.singlechat.message.entity.ChatStatus;
import org.jellydiss.singlechat.message.entity.ChatUser;
import org.jellydiss.singlechat.message.entity.Message;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	private String chatMain(HttpServletRequest request,HttpSession session){
		if(ChatStatus.lastSequenceNumber == 0) chatService.setLastMessageNumber();
		return "chatMain";
	
	}
	
	@RequestMapping(value = "getLastSequence", method = RequestMethod.GET)
	@ResponseBody
	private JSONObject getLastSequence (HttpServletRequest request, HttpServletResponse response){
		
		return chatService.getLastSequence();
	}
	

	@RequestMapping(value = "insertChat", method = RequestMethod.POST)
	private void insertChat(@ModelAttribute ChatUser chatUser, @ModelAttribute Message message)	{
		chatService.insertMessage(chatUser, message);
		chatService.setLastMessageNumber();
	}
	
	
	
	@RequestMapping(value = "getLastMessage", method = RequestMethod.GET)
	@ResponseBody
	private JSONObject getLastMessage(HttpServletRequest request, HttpServletResponse response) {
     	return chatService.getLastMessageJson();
	}
	
	
}
