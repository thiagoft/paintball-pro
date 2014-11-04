package br.com.paintball;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Assert;
import org.junit.Test;

import br.com.paintball.enums.EnumClasses;
import br.com.paintball.model.entity.Commands;
import br.com.paintball.model.entity.Coordinate;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientResourceTest {

	@Test
	public void testFindRoom() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String jsonCreatedRoom = service.path("host").path("get").path("createRoom").get(String.class);
		Room createdRoom = new Gson().fromJson(jsonCreatedRoom, Room.class);
		Assert.assertTrue(createdRoom != null);
		
		String jsonRoomFound = service.path("client").path("get").path("findRoom").path(createdRoom.getRoomKey().toString()).get(String.class);
		Room foundRoom = new Gson().fromJson(jsonRoomFound, Room.class);
		Assert.assertTrue(foundRoom != null);
	}
	
	@Test
	public void testInsertUser() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String jsonCreatedRoom = service.path("host").path("get").path("createRoom").get(String.class);
		Room createdRoom = new Gson().fromJson(jsonCreatedRoom, Room.class);
		Assert.assertTrue(createdRoom != null);
		
		String jsonRoomFound = service.path("client").path("get").path("findRoom").path(createdRoom.getRoomKey().toString()).get(String.class);
		Room foundRoom = new Gson().fromJson(jsonRoomFound, Room.class);
		
		User user = new User("User", new Coordinate(50.0,60.0), EnumClasses.MEDIC.getClassId(), foundRoom.getRoomKey(), new Commands(0,0,0,0,0));
		String jsonUser = user.toJSON();
	
		String jsonReturnedInsertedUser = service.path("client").path("post").path("insert").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,jsonUser);
		User userInserted = new Gson().fromJson(jsonReturnedInsertedUser, User.class);
		Assert.assertTrue(userInserted.getUserId() != null);
		userInserted = new User(userInserted.getUserId(), "Tahara", 
								userInserted.getCoordinate(), userInserted.getUserClass(), 
								userInserted.getRoomKey(), userInserted.getCommands(), userInserted.getLastSend());
		
		String jsonReturnedUpdatedUser = service.path("client").path("post").path("update").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,userInserted.toJSON());
		Room roomWithUserUpdated = new Gson().fromJson(jsonReturnedUpdatedUser, Room.class);
		for (User userInLoop : roomWithUserUpdated.getUserList()) {
			Assert.assertTrue(userInLoop.getUserName().equals("Tahara"));
		}
	}
	
	@Test
	public void testRemoveUser() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String jsonCreatedRoom = service.path("host").path("get").path("createRoom").get(String.class);
		Room createdRoom = new Gson().fromJson(jsonCreatedRoom, Room.class);
		Assert.assertTrue(createdRoom != null);
		
		String jsonRoomFound = service.path("client").path("get").path("findRoom").path(createdRoom.getRoomKey().toString()).get(String.class);
		Room foundRoom = new Gson().fromJson(jsonRoomFound, Room.class);
		
		User user = new User("User2", new Coordinate(50.0,60.0), EnumClasses.MEDIC.getClassId(), foundRoom.getRoomKey(), new Commands(0,0,0,0,0));
		String jsonUser = user.toJSON();
	
		String jsonReturnedInsertedUser = service.path("client").path("post").path("insert").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,jsonUser);
		User userInserted = new Gson().fromJson(jsonReturnedInsertedUser, User.class);
		Assert.assertTrue(userInserted.getUserId() != null);
		
		ClientResponse response = service.path("client").path("post").path("remove").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(ClientResponse.class,jsonReturnedInsertedUser);

		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testCheckUserStatus() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String jsonCreatedRoom = service.path("host").path("get").path("createRoom").get(String.class);
		Room createdRoom = new Gson().fromJson(jsonCreatedRoom, Room.class);
		Assert.assertTrue(createdRoom != null);
		
		String jsonRoomFound = service.path("client").path("get").path("findRoom").path(createdRoom.getRoomKey().toString()).get(String.class);
		Room foundRoom = new Gson().fromJson(jsonRoomFound, Room.class);
		
		User user1 = new User("User1", new Coordinate(50.0,60.0), EnumClasses.MEDIC.getClassId(), foundRoom.getRoomKey(), new Commands(0,0,0,0,0));		
		User user2 = new User("User2", new Coordinate(50.0,60.0), EnumClasses.MEDIC.getClassId(), foundRoom.getRoomKey(), new Commands(0,0,0,0,0));
		
		String jsonUser1 = service.path("client").path("post").path("insert").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,user1.toJSON());
		user1 = new Gson().fromJson(jsonUser1, User.class);
		
		String jsonUser2 = service.path("client").path("post").path("insert").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,user2.toJSON());
		user2 = new Gson().fromJson(jsonUser2, User.class);
	
	    try {  
	        Thread.sleep(12000);  
	     } catch (Exception e) {  
	        e.printStackTrace();  
	     }  
		
		String jsonReturnedUpdatedUser = service.path("client").path("post").path("update").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,user2.toJSON());
		Room roomWithUsersCheckeds = new Gson().fromJson(jsonReturnedUpdatedUser, Room.class);
		boolean isChecked = false;
		for (User userInLoop : roomWithUsersCheckeds.getUserList()) {
			if (userInLoop.getCoordinate().getLatitude() == 0 && userInLoop.getCoordinate().getLongitude() == 0) {
				isChecked = true;
			}
		}
		Assert.assertTrue(isChecked);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/paintball-pro/api").build();
		//return UriBuilder.fromUri("http://www.thiagoft.com.br/paintball-pro/rest").build();
	}
	
}
