package br.com.paintball.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.model.business.ClientBusiness;
import br.com.paintball.model.business.HostBusiness;
import br.com.paintball.model.entity.User;

import com.google.gson.Gson;

@Component
@Path("client")
public class ClientResource {

	private ClientBusiness clientBusiness;
	private HostBusiness hostBusiness;
	
	@Autowired
	public void setHostBusiness(ClientBusiness clientBusiness, HostBusiness hostBusiness) {
		this.clientBusiness = clientBusiness;
		this.hostBusiness = hostBusiness;
	}
	
	@Path("get/findRoom/{roomKey}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findRoom(@PathParam("roomKey") Long roomKey) {
		return new Gson().toJson(hostBusiness.findRoom(roomKey));
	}
	
	@POST
	@Path("post/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateUser(String obj) {
		User user = new Gson().fromJson(obj, User.class);
		return new Gson().toJson(this.clientBusiness.addUser(user));
	}
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(String obj) {
		UserTest userTest = new Gson().fromJson(obj, UserTest.class);
		new GenericDao().addUser(userTest);
		URI uri = URI.create("/"+userTest.getUserId());
		return Response.created(uri).build();
	}
	
	@Path("get/{user}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String find(@PathParam("user") String obj) {
		Set<UserTest> userList = new GenericDao().findUserList(new Long(obj));
		if (userList != null) {
			return new Gson().toJson(userList);
		} else {
			return new Gson().toJson("Invalid User.");
		}
	}*/

}
