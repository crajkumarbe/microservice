package com.microservice.resource;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.bean.UserBean;
import com.microservice.manager.UserManager;
import com.microservice.status.Status;

@Path("/users")
@Component
public class UserResource {
	@Autowired
	private UserManager userManager;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserBeans() {
		List<UserBean> users = userManager.getAllUsers();
		return Response.status(200).entity(new Status(users)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUserBean(UserBean userBean) throws URISyntaxException {
		if (userBean.getFirstName() == null || userBean.getLastName() == null) {
			return Response.status(400).entity("Please provide all mandatory inputs").build();
		}
		userManager.addUser(userBean);
		return Response.status(200).entity(new Status("")).build();
	}

}
