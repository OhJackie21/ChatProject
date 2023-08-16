package com.jackie.FriendChat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackie.FriendChat.models.Message;
import com.jackie.FriendChat.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messRepo;

//Find all Messages
	public List<Message> findAll(){
		return messRepo.findAll();
	}
	
//Send a message
	public Message sendMessage(Message message) {
		return messRepo.save(message);
	}
}
