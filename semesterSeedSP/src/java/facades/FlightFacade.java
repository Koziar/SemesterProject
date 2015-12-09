
package facades;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import engine.Flight;
import engine.FlightInfo;
import engine.MetaEngine;
import entity.Url;
import errorHandling.FlightException;
import errorHandling.InternalServerException;

public class FlightFacade implements FlightFacadeInterface{
    
    private EntityManagerFactory emf;
    private UrlFacade airlineFacade;

    public FlightFacade(EntityManagerFactory emf) {
        this.emf = emf;
        airlineFacade = new UrlFacade(emf);
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo) throws InternalServerException, FlightException {
        //get all airlines
        List<Url> airlines = airlineFacade.getUrls();
        //pass the airlines to the engine
        MetaEngine engine = new MetaEngine(airlines);
        //get all flights
        List<Flight> flights = engine.getAllFlightsFrom(flightInfo);
        
        return flights;
    }

    @Override
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo) throws InternalServerException, FlightException {
        
        //get all airlines
        List<Url> airlines = airlineFacade.getUrls();
        //pass the airlines to the engine
        MetaEngine engine = new MetaEngine(airlines);
        //get all flights
        List<Flight> flights = engine.getAllFlightsFromTo(flightInfo);
        
        return flights;
    }
    
    
}
