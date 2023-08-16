package com.jackie.FriendChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jackie.FriendChat.models.Message;
import com.jackie.FriendChat.services.MessageService;
import com.jackie.FriendChat.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MessageController {
	@Autowired
	private UserService userServ;
	@Autowired
	private MessageService messServ;

//Takes us to the dashboard
	@GetMapping("/chat")
	public String dashboard(
			Model model,
			HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userServ.findbyID((Long)session.getAttribute("userId")));
		model.addAttribute("message", messServ.findAll());
		model.addAttribute("messages", new Message());
		return "chat.jsp";
	}
	
//Add messages to the chat
	@PostMapping("/chat/send")
	public String addMessage(
			@Valid
			@ModelAttribute("messages") Message newMessage,
			BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "redirect:/chat";
		}
		messServ.sendMessage(newMessage);
		return "redirect:/chat";
	}
	
}
