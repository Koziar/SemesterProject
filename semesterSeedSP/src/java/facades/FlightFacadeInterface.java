package facades;

import java.util.Date;
import java.util.List;
import metaEngine.Flight;
import metaEngine.FlightInfo;

public interface FlightFacadeInterface {
    
    
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo);
    
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo);
    
}
