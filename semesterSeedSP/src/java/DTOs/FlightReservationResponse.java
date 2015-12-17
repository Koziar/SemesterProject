package DTOs;

import java.util.List;

public class FlightReservationResponse {
    
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private int travelTime;
    private int numberOfSeats;
    private String ReserveeName;
    private List<PassengerContainer> passengers;

    public FlightReservationResponse(String flightId, String origin, String destination, String date, int travelTime, int numberOfSeats, String ReserveeName, List<PassengerContainer> passengers) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.travelTime = travelTime;
        this.numberOfSeats = numberOfSeats;
        this.ReserveeName = ReserveeName;
        this.passengers = passengers;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName() {
        return ReserveeName;
    }

    public void setReserveeName(String ReserveeName) {
        this.ReserveeName = ReserveeName;
    }

    public List<PassengerContainer> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerContainer> passengers) {
        this.passengers = passengers;
    }

    
    
    
    
}
