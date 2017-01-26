package com.sumeet.webservices.MessengerApp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sumeet.webservices.MessengerApp.database.DatabaseClass;
import com.sumeet.webservices.MessengerApp.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello World", "Sumeet"));
		messages.put(2L, new Message(2, "Hi World", "Akhil"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public Message getMessages(Long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message; 
	}
	
	public Message deleteMessages(Long id){
		return messages.remove(id);
	}
	
}
