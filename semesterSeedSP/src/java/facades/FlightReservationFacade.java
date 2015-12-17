/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import DTOs.PassengerContainer;
import entity.Airline;
import entity.Flight;
import entity.FlightInstance;
import entity.Passenger;
import entity.flightReservation.FlightReservation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author terziev
 */
public class FlightReservationFacade {
    
    private EntityManagerFactory emf;

    public FlightReservationFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void saveFlightReservationa(FlightReservationRequest flightReservationRequest, FlightReservationResponse flightReservationResponse) {
        
        EntityManager em = getEntityManager();
        
        try{
            String airlineName = flightReservationRequest.getAirline();
            String flightId = flightReservationRequest.getFlightId();
            String flightDate = flightReservationRequest.getFlightDate();
            int flightTime = flightReservationResponse.getTravelTime();
            String origin = flightReservationRequest.getOrigin();
            String destination = flightReservationRequest.getDestination();
            double totalPrice = flightReservationRequest.getTotalPrice();
            int numberOfSeats = flightReservationResponse.getNumberOfSeats();
            String reserveeName = flightReservationResponse.getReserveeName();
            String reserveePhone = flightReservationRequest.getReserveePhone();
            String reserveeEmail = flightReservationRequest.getReserveeEmail();
            List<PassengerContainer> passengers = flightReservationResponse.getPassengers();
            
            //get username
            
            //save this info in a database
            FlightReservation flightReservation = new FlightReservation(reserveeName, reserveeEmail,
            reserveePhone, flightId, airlineName, flightDate, flightTime, origin, destination, totalPrice, numberOfSeats);
            
            List<Passenger> entityPassengers = new ArrayList();
            //take the passengers from the DTO - PassengerContainer list and populate a new list of EntityPassengers
            for (PassengerContainer passenger : passengers) {
                entityPassengers.add(new Passenger(passenger.getFirstname(), passenger.getLastname()));
            }
            //add the entitypassengers to the FlightReservation
            for (Passenger entityPassenger : entityPassengers) {
                flightReservation.addPassenger(entityPassenger);
            }
            //insert the info in the database
            em.getTransaction().begin();
            em.persist(flightReservation);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
    
    
    
}
