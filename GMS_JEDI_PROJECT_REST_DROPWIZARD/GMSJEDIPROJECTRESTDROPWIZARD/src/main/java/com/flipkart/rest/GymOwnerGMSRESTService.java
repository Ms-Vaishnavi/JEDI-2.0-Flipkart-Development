package com.flipkart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.business.GymOwnerBusinessInterface;
import com.flipkart.business.UserBusiness;
import com.flipkart.exception.UserAlreadyExistsException;

@Path("/v1/gymowners")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerGMSRESTService {
	
	@POST
    @Path("/registration")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        GymOwnerBusinessInterface gymOwnerBusiness = new GymOwnerBusiness();
        UserBusiness userBusiness = new UserBusiness();

        try {
            userBusiness.registerGymOwner(gymOwner);
            return Response.ok("Gym Owner registered successfully!").build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
