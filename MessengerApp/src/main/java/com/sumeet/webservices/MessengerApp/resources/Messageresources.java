package com.sumeet.webservices.MessengerApp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sumeet.webservices.MessengerApp.model.Message;
import com.sumeet.webservices.MessengerApp.service.MessageService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Messageresources {
	
	MessageService messageService = new MessageService();
	
	// get all the message from the server 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	// To add new content on to the server 
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	// This method and the annotation is to update the message//
	@PUT
	public Message updateMessage(@PathParam("messageId") long Id, Message message){
		message.setId(Id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageid") long Id){
		 messageService.deleteMessages(Id);
	}
	
	// Get the nested queries like a message with specific ID
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId){
		return messageService.getMessages(messageId);
	}
	
}
