package com.flipkart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.business.GymOwnerBusiness;
import com.flipkart.business.UserBusiness;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.utils.IdGenerator;

@Path("/v1/gymowners")
@Produces(MediaType.APPLICATION_JSON)
public class GymOwnerGMSRESTService {
	GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();

	@POST
	@Path("/registration")
	@Timed
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerGymOwner(GymOwner gymOwner) {
		UserBusiness userBusiness = new UserBusiness();
		try {
			userBusiness.registerGymOwner(gymOwner);
			return Response.ok("Gym Owner registered successfully!").build();
		} catch (UserAlreadyExistsException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("/{email}/profile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProfile(@PathParam("email") String email, GymOwner gymOwner) {
		try {
			gymOwnerBusiness.editProfile(gymOwner);
			return Response.ok("Edited your profile successfully!").build();
		} catch (GymOwnerNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/{email}/profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewProfile(@PathParam("email") String email) {
		try {
			return Response.ok(gymOwnerBusiness.getProfile(email)).build();
		} catch (GymOwnerNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/{email}/addGym")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGym(@PathParam("email") String email, Gym gym) {
		gym.setGymId(IdGenerator.generateId("Gym"));
		gymOwnerBusiness.addGym(gym);
		return Response.ok("Added Gym Successfully").build();
	}
	
	@PUT
    @Path("/{email}/editGym")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editGym(@PathParam("email") String email, Gym gym) {
        try {
            gymOwnerBusiness.editGym(gym);
            return Response.ok("Gym edited successfully!").build();
        } catch (GymNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
	
	@GET
	@Path("/{email}/gyms")
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGymDetails(@PathParam("email") String email) {
	        return Response.ok(gymOwnerBusiness.getGymDetail(email)).build();
	}
	
	@POST
    @Path("/{email}/addSlot")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSlot(Slot slot, @PathParam("email") String email) {
        try {
        	slot.setSlotId(IdGenerator.generateId("Slot"));
            gymOwnerBusiness.addSlot(slot, email);
            return Response.ok("Slot added successfully!").build();
        } catch (GymNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (UnauthorizedAccessException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }
}
