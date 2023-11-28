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
	@Path("/getGyms")
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response getGym(){
        try{
            return Response.ok(adminBusiness.getGym()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@GET
	@Path("/getGymsOwners")
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response getGymOwners(){
        try{
            return Response.ok(adminBusiness.getGymOwners()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@GET
	@Path("/viewAllPendingGymOwnerRequests")
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
	@Path("/viewAllPendingGymRequests")
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
	@Path("/approveSingleGymOwnerRequest/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveSingleGymOwnerRequest(@PathParam("email") String emai){
        try{
            return Response.ok(adminBusiness.approveSingleGymOwnerRequest(email)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveAllPendingGymOwnerRequests")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveAllPendingGymOwnerRequests(){
        try{
            return Response.ok(adminBusiness.approveAllPendingGymOwnerRequests()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveSingleGymRequest//{gymId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveSingleGymRequest(@PathParam("gymId") String gymId){
        try{
            return Response.ok(adminBusiness.approveSingleGymRequest(gymId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
	
	@PUT
	@Path("/approveAllPendingGymRequest")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveAllPendingGymRequest(){
        try{
            return Response.ok(adminBusiness.approveAllPendingGymRequest()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

}
