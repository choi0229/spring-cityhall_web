package com.project.team3.controller.chatbot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ChatbotController {

	@RequestMapping(value = {"/chatbot.do"})
	public String goChatbot() {
		return "chatbot/chatbot";
	}

	
}

