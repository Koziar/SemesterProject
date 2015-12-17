package facades;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import java.util.Date;
import java.util.List;
import engine.Flight;
import engine.FlightInfo;
import errorHandling.FlightException;
import errorHandling.FlightReservationException;
import errorHandling.InternalServerException;

public interface FlightFacadeInterface {
    
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo) throws InternalServerException, FlightException;
    
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo) throws InternalServerException, FlightException;

    public FlightReservationResponse bookFlight(FlightReservationRequest flightReservationRequest) throws InternalServerException, FlightReservationException;
    
}
