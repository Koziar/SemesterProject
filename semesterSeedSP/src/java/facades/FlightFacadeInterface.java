package facades;

import java.util.Date;
import java.util.List;
import engine.Flight;
import engine.FlightInfo;

public interface FlightFacadeInterface {
    
    
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo);
    
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo);
    
}
