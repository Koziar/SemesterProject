/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("flightinfo")
public class FlightsResource {

    @Context
    private UriInfo context;
    
    //FlightsFacade flightsFacade = new FlightsFacade();

    public FlightsResource() {
    }

    //Request all available flights that matches
//the provided search criteria's
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{from}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFrom(
            @PathParam("from") String from,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) {

        //List<String> flights = flightsFacade.getAllFlights(from, date, numTickets);
        
        return Response.ok().build();
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFromTo(
            @PathParam("from") String from,
            @PathParam("to") String to,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) {

        //List<String> flights = flightsFacade.getAllFlights(from, date, numTickets);
        
        return Response.ok().build();
    }

    /**
     * PUT method for updating or creating an instance of FlightsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
