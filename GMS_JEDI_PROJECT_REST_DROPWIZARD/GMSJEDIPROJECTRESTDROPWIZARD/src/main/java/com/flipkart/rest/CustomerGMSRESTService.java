/**
 * 
 */
package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.business.CustomerBusiness;
import com.flipkart.business.UserBusiness;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.*;

/**
 * API Calls to Customer service
 */
@Path("/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerGMSRESTService {
	CustomerBusiness customerBusiness = new CustomerBusiness();
	
	@POST
	@Path("/registration")
	@Timed
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerCustomer(Customer customer) {
		UserBusiness userBusiness = new UserBusiness();
		try {
			userBusiness.registerCustomer(customer);
			return Response.ok("Customer registered successfully!").build();
		}  catch (UserAlreadyExistsException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Path("/{email}/profile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProfile(@PathParam("email") String email, Customer customer) {
		try {
			customerBusiness.editProfile(customer);
			return Response.ok("Edited your profile successfully!").build();
		} catch (CustomerNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}
	
	
	@GET
	@Path("/{email}/book")
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGymDetails(@PathParam("email") String email, @QueryParam("city") String city) {
		List<Gym> gyms = customerBusiness.getGymInCity(city);
		if(gyms.size() == 0)
			return Response.status(Response.Status.BAD_REQUEST).entity("No gyms available").build();
	    return Response.ok(gyms).build();
	}
	
	@GET
	@Path("/{email}/bookings")
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewBookings(@PathParam("email") String email) {
		return Response.ok(customerBusiness.getBookings(email)).build();
	}
	
	@PUT
	@Path("/{email}/bookings/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelBooking(@PathParam("email") String email, @QueryParam("bookingId") String bookingId) {
		return Response.ok(customerBusiness.cancelBooking(bookingId, email)).build();
	}
	
	@GET
	@Path("/{email}/book/{gymId}")
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewSlots(@PathParam("email") String email, @QueryParam("city") String city, @PathParam("gymId") String gymId) {
		try {
			List<Slot> slots = customerBusiness.getSlotInGym(gymId);
			return Response.ok(slots).build();
		} catch (SlotNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
		
	}
	
	@POST
    @Path("/{email}/book")
    @Timed
    public Response bookSlot(@PathParam("email") String email,
    		@QueryParam("gymId") String gymId,
    		@QueryParam("date") String date,
    		@QueryParam("slotId") String slotId) {
        try {
            int bookingResponse = customerBusiness.bookSlot(gymId, slotId, email, date);

            String responseMessage;
            switch (bookingResponse) {
                case 0:
                    responseMessage = "You have already booked this time. Cancelling the previous one and booking this slot";
                    break;
                case 1:
                    responseMessage = "Slot is already booked, added to the waiting list";
                    break;
                case 2:
                    responseMessage = "Successfully booked the slot";
                    break;
                default:
                    responseMessage = "Booking failed";
            }

            return Response.ok(responseMessage).build();
        } catch (SlotNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
	
}
