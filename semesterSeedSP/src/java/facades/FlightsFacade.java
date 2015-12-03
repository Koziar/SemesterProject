package facades;

import engine.MetaEngine;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author terziev
 */
public class FlightsFacade {
    
    //get a JSON list of all flights from origin
    public String getAllFlightsFrom(String from, String to, String date, int numTickets){
        
        //get all flights from
        //MetaEngine.getFlightsFrom(from, date, numTickets);
        return "";
    }
    public String getAllFlightsFromTo(String from, String to, String date, int numTickets){
        
        //get all flights to
        return "";
    }
    
    
    
}
