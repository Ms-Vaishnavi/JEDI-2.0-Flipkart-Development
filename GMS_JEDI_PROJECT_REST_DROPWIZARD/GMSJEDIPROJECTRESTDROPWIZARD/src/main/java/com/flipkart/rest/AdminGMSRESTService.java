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

import com.flipkart.business.AdminBusiness;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
/**
 * API Calls to Admin service
 */
@Path("/v1/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminGMSRESTService {
	AdminBusiness adminBusiness = new AdminBusiness();
	
	@GET
	@Path("/viewGyms")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getGym(){
        try{
            return Response.ok(adminBusiness.getGym()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@GET
	@Path("/viewGymOwners")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getGymOwners(){
        try{
            return Response.ok(adminBusiness.getGymOwners()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@GET
	@Path("/viewPendingGymOwners")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response viewAllPendingGymOwnerRequests(){
        try{
            return Response.ok(adminBusiness.viewAllPendingGymOwnerRequests()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@GET
	@Path("/viewPendingGyms")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response viewAllPendingGymRequests(){
        try{
            return Response.ok(adminBusiness.viewAllPendingGymRequests()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveGymOwner/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveSingleGymOwnerRequest(@PathParam("email") String email){
        try{
        	adminBusiness.approveSingleGymOwnerRequest(email);
            return Response.ok("Successfully Approved " + email + "!").build();
        }
        catch(Exception exception){
        	System.out.println(exception.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveGymOwners")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveAllPendingGymOwnerRequests(){
        try{
        	adminBusiness.approveAllPendingGymOwnerRequests();
            return Response.ok("Successfully Approved all Gym Owners!").build();
        }
        catch(Exception exception){
        	//System.out.println(exception.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveGym/{gymId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveSingleGymRequest(@PathParam("gymId") String gymId){
        try{
        	adminBusiness.approveSingleGymRequest(gymId);
            return Response.ok("Successfully Approved " + gymId + "!").build();
        }
        catch(Exception exception){
        	//System.out.println(exception.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveGyms")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveAllPendingGymRequests(){
        try{
        	adminBusiness.approveAllPendingGymRequests();
            return Response.ok("Successfully Approved all Gym!").build();
        }
        catch(Exception exception){
        	//System.out.println(exception.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

}
