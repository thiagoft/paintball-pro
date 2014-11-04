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
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HostResourceTest {

	@Test
	public void testCreateRoom() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
		String obj = service.path("host").path("get").path("createRoom").get(String.class);
		Room room = new Gson().fromJson(obj, Room.class);
		Assert.assertTrue(room != null);
	}
	
	@Test
	public void testStart() {
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
	    String jsonRoom = service.path("host").path("get").path("createRoom").get(String.class);
		Room room = new Gson().fromJson(jsonRoom, Room.class);
	    
		User user = new User("Thiago", new Coordinate(50.0,60.0), EnumClasses.MEDIC.getClassId(), room.getRoomKey(), new Commands(0,0,0,0,0));
		String jsonUser = user.toJSON();
	
		String jsonReturnedRoom = service.path("host").path("post").path("start").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
		        .post(String.class,jsonUser);

		Assert.assertTrue(!jsonReturnedRoom.equals("null"));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/paintball-pro/api").build();
		//return UriBuilder.fromUri("http://www.thiagoft.com.br/paintball-pro/rest").build();
	}
	
}
