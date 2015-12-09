package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import facades.FlightFacade;
import facades.FlightFacadeInterface;
import java.text.ParseException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import engine.Flight;
import engine.FlightInfo;
import errorHandling.FlightException;
import errorHandling.InternalServerException;
import errorHandling.InvalidInputException;

@Path("flightinfo")
public class FlightInfoResource {

    @Context
    private UriInfo context;

    private FlightFacadeInterface flightFacade;
    private EntityManagerFactory emf;
    private static Gson gson;

    public FlightInfoResource() {

        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        flightFacade = new FlightFacade(emf);
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").
                setPrettyPrinting().create();
    }

    @GET
    @Path("{from}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFrom(
            @PathParam("from") String from,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) throws InternalServerException, InvalidInputException, FlightException {

        //encapsulate the flightinfo parameters
        FlightInfo flightInfo = new FlightInfo(from, date, numTickets);
        //check if the flightInfo is valid
        if (flightInfo.getOrigin() == null || flightInfo.getOrigin() == "") {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        } else if (flightInfo.getFlightDate() == null || flightInfo.getFlightDate() == "") {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        } else if (flightInfo.getNumOfTickets() <= 0) {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        }

        //get all flights from the FlightFacade
        List<Flight> flights = flightFacade.getAllFlightsFromTo(flightInfo);

        //return the flights as a Json object
        return Response.ok(gson.toJson(flights)).build();
    }

    @GET
    @Path("{from}/{to}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFromTo(
            @PathParam("from") String from,
            @PathParam("to") String to,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) throws FlightException, InternalServerException, InvalidInputException {

        //encapsulate the flightinfo parameters
        FlightInfo flightInfo = new FlightInfo(from, to, date, numTickets);
        //check if the flightInfo is valid
        if (flightInfo.getOrigin() == null || flightInfo.getOrigin() == "") {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        }
        if (flightInfo.getDestination() == null || flightInfo.getDestination() == "") {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        } else if (flightInfo.getFlightDate() == null || flightInfo.getFlightDate() == "") {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        } else if (flightInfo.getNumOfTickets() <= 0) {
            throw new InvalidInputException("Invalid input! Please try again : ) ");
        }
        //get all flights from the FlightFacade
        List<Flight> flights = flightFacade.getAllFlightsFromTo(flightInfo);
        //return the flights as a Json object
        return Response.ok(gson.toJson(flights)).build();
    }
}
