package facades;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import engine.Flight;
import engine.FlightInfo;
import engine.MetaEngine;
import entity.Url;
import errorHandling.FlightException;
import errorHandling.FlightReservationException;
import errorHandling.InternalServerException;

public class FlightFacade implements FlightFacadeInterface {

    private EntityManagerFactory emf;
    private UrlFacade airlineFacade;
    private FlightReservationFacade flightReservationFacade;

    public FlightFacade(EntityManagerFactory emf) {
        this.emf = emf;
        airlineFacade = new UrlFacade(emf);
        flightReservationFacade = new FlightReservationFacade(emf);
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

    @Override
    public FlightReservationResponse bookFlight(FlightReservationRequest flightReservationRequest) throws InternalServerException, FlightReservationException {

        //get all airlines
        List<Url> airlines = airlineFacade.getUrls();
        //pass the airlines to the engine        MetaEngine engine = new MetaEngine(airlines);

        MetaEngine engine = new MetaEngine(airlines);
        //get the flight reservation response
        FlightReservationResponse flightReservationResponse = engine.bookFlight(flightReservationRequest);
        //save the booking in the database
        if (flightReservationResponse != null) {
            flightReservationFacade.saveFlightReservationa(flightReservationRequest, flightReservationResponse);
        }else{
            throw new InternalServerException("We are sorry for the inconvinience!Please try again :) ");
        }
        return flightReservationResponse;

    }

}
