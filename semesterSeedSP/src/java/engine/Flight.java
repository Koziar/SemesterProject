package engine;

import java.util.Date;

public class Flight {
    
    //holds the flight information
    private String airline;
    private String flightDate;
    private int numberOfSeats;
    private double totalPrice;
    
    private String flightId;//must be string according to the API!!
    private int travelTime; //in minutes
    
    private String destination;//IATA - code
    private String origin;//IATA-code

    public Flight(String airline, String flightDate, int numberOfSeats, double totalPrice, String flightId, int travelTime, String destination, String origin) {
        this.airline = airline;
        this.flightDate = flightDate;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.flightId = flightId;
        this.travelTime = travelTime;
        this.destination = destination;
        this.origin = origin;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Flight{" + "airline=" + airline + ", flightDate=" + flightDate + ", numberOfSeats=" + numberOfSeats + ", totalPrice=" + totalPrice + ", flightId=" + flightId + ", travelTime=" + travelTime + ", destination=" + destination + ", origin=" + origin + '}';
    }
    
}
