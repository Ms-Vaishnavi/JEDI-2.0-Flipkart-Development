/**
 * 
 */
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
import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.business.UserBusiness;
import com.flipkart.exception.*;
import com.flipkart.utils.IdGenerator;
/**
 * API Calls to User service
 */
@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserGMSRESTService {
    UserBusiness userBusiness = new UserBusiness();
    @POST
    @Path("/customerRegistration")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomer(Customer customer) {
        try {
            userBusiness.registerCustomer(customer);
            return Response.ok("Customer registered successfully!").build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/gymOwnerRegistration")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        try {
            userBusiness.registerGymOwner(gymOwner);
            return Response.ok("Gym Owner registered successfully!").build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/profile/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authorizeUser(@PathParam("email") String email, User user) {
        try {
            userBusiness.authenticateUser(user);
            return Response.ok("Authenticated the user successfully!").build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/profile/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response LogOut(@PathParam("email") String email, User user) {
         userBusiness.logout(user);
            return Response.ok("Authenticated the user successfully!").build();
    }
}
