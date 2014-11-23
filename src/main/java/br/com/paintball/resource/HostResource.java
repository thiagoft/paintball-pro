package br.com.paintball.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.paintball.model.business.ClientBusiness;
import br.com.paintball.model.business.HostBusiness;
import br.com.paintball.model.entity.Coordinate;
import br.com.paintball.model.entity.Room;
import br.com.paintball.model.entity.User;

import com.google.gson.Gson;

@Component
@Path("host")
public class HostResource {
	
	private HostBusiness hostBusiness;
	private ClientBusiness clientBusiness;
	
	@Autowired
	public void setHostBusiness(HostBusiness hostBusiness, ClientBusiness clientBusiness) {
		this.hostBusiness = hostBusiness;
		this.clientBusiness = clientBusiness;
	}
	
	@Path("get/createRoom")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String createRoom() {
		return new Gson().toJson(hostBusiness.createRoom());
	}
	
	@POST
	@Path("post/start")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String startRoom(String obj) {
		User user = new Gson().fromJson(obj, User.class);
		return new Gson().toJson(this.clientBusiness.insertUser(user));
	}
	
	@POST
	@Path("post/saveObjective")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveObjective(String room) {
		Room roomFromJson = new Gson().fromJson(room, Room.class);
		Coordinate coordinateFromJson = roomFromJson.getCoordinate();
		if (this.hostBusiness.updateObjectiveCoordinate(roomFromJson.getRoomKey(), coordinateFromJson)) {
			return Response.ok().build();
		} else{
			return Response.serverError().build();
		}

	}
}
