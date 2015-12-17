package rest;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import DTOs.PassengerContainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import errorHandling.FlightReservationException;
import errorHandling.InternalServerException;
import errorHandling.InvalidInputException;
import facades.FlightFacade;
import facades.FlightFacadeInterface;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("flightreservation")
public class FlightReservationResource {

    @Context
    private UriInfo context;
    
    private FlightFacadeInterface flightFacade;
    private EntityManagerFactory emf;
    private static Gson gson;

    public FlightReservationResource() {
        
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        flightFacade = new FlightFacade(emf);
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").
                setPrettyPrinting().create();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookFlight(String bookingInfo) throws InternalServerException, InvalidInputException, FlightReservationException {
        
        FlightReservationRequest flightReservationRequest = new Gson().fromJson(bookingInfo, FlightReservationRequest.class); 
        
        System.out.println("========================================================");
        for (PassengerContainer passengerContainer : flightReservationRequest.getPassengers()) {
            System.out.println(passengerContainer.getFirstname() + "||" + passengerContainer.getLastname());
        }
        System.out.println("========================================================");
        
        if(flightReservationRequest == null)throw new InvalidInputException("Invalid input! Please try again : ) ");
        else if(flightReservationRequest.getFlightId() == null)throw new InvalidInputException("Invalid input! Please try again : ) ");
        else if(flightReservationRequest.getAirline() == null)throw new InvalidInputException("Invalid input! Please try again : ) ");
        else if(flightReservationRequest.getNumberOfSeats() <= 0)throw new InvalidInputException("Invalid input! Please try again : ) ");
        else if(flightReservationRequest.getPassengers() == null)throw new InvalidInputException("Invalid input! Please try again : ) ");
        else if(flightReservationRequest.getPassengers().size() == 0)throw new InvalidInputException("Invalid input! Please try again : ) ");
        
        FlightReservationResponse flightReservationResponse = flightFacade.bookFlight(flightReservationRequest);
        
        return Response.ok(gson.toJson(flightReservationResponse)).build();
        
    }
}
