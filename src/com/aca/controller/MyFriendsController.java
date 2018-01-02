package com.aca.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aca.model.Friend;
import com.aca.service.FriendsService;

@Path("/friends")
public class MyFriendsController {
	
	@GET
	@Produces( { MediaType.APPLICATION_JSON } )
	public List<Friend> getAllFriends() {
		System.out.println("getting all friends...");	
		
		FriendsService service = new FriendsService();		
		List<Friend> friends = service.getAllFriends();
		
		return friends;		
	}
	
	@GET
	@Path("{id}")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
	public Friend getFriendById(@PathParam("id") String id) {
		System.out.println("getting friend by id: "+id+" ...");		
		
		FriendsService service = new FriendsService();
		Friend friend = service.getFriendById(id);
		
		return friend;
	}
	
	@GET
	@Path("/lastname/{lastname}")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
	public List<Friend> getFriendByLastName(@PathParam("lastname") String lastname) {
		System.out.println("getting friend by lastname: "+lastname+" ...");				
		
		FriendsService service = new FriendsService();
		List<Friend> friends = service.getFriendByLastName(lastname);
		
		return friends;
	}
	
	@DELETE
	@Path("{id}")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
	public Friend deleteFriendById( @PathParam("id") String id) {		
		System.out.println("deleting friend by id: "+id+" ...");		
		
		FriendsService service = new FriendsService();
		Friend friend = service.deleteFriendById(id);		
		
		return friend;		
	}
	
	@PUT
	@Path("{id}")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
	public Friend updateFriend( @PathParam("id") String id, Friend updatedFriend) {		
		System.out.println("friend to update: " + updatedFriend.toString());
		
		FriendsService service = new FriendsService();
		Friend friend = service.updateFriend(updatedFriend);		
		
		return friend;		
	}

}
