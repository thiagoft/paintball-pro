package br.com.paintball;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.junit.Assert;
import org.junit.Test;

import br.com.paintball.model.entity.Room;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
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

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/paintball-pro/api").build();
		//return UriBuilder.fromUri("http://www.thiagoft.com.br/paintball-pro/rest").build();
	}
	
}
