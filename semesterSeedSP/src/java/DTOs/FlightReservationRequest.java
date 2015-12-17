package DTOs;

import java.util.ArrayList;
import java.util.List;

public class FlightReservationRequest {
    
    private String flightID;
    private String airline;
    private String flightDate;
    private int numberOfSeats;
    private double totalPrice;
    private int travelTime;
    private String origin;
    private String destination;
    private String ReserveeName;
    private String ReserveePhone;
    private String ReserveeEmail;
    
    private List<PassengerContainer> Passengers;

    public FlightReservationRequest(String flightId, String airline, String flightDate, int numberOfSeats, double totalPrice, int travelTime, String origin, String destination, String ReserveeName, String ReserveePhone, String ReserveeEmail, List<PassengerContainer> Passengers) {
        this.flightID = flightId;
        this.airline = airline;
        this.flightDate = flightDate;
        this.numberOfSeats = numberOfSeats;
        this.totalPrice = totalPrice;
        this.travelTime = travelTime;
        this.origin = origin;
        this.destination = destination;
        this.ReserveeName = ReserveeName;
        this.ReserveePhone = ReserveePhone;
        this.ReserveeEmail = ReserveeEmail;
        this.Passengers = Passengers;
    }

    public String getFlightId() {
        return flightID;
    }

    public String getReserveePhone() {
        return ReserveePhone;
    }

    public void setReserveePhone(String ReserveePhone) {
        this.ReserveePhone = ReserveePhone;
    }

    public void setFlightId(String flightId) {
        this.flightID = flightId;
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

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
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

    public String getReserveeName() {
        return ReserveeName;
    }

    public void setReserveeName(String ReserveeName) {
        this.ReserveeName = ReserveeName;
    }

    public String getReserveeEmail() {
        return ReserveeEmail;
    }

    public void setReserveeEmail(String ReserveeEmail) {
        this.ReserveeEmail = ReserveeEmail;
    }

    public List<PassengerContainer> getPassengers() {
        return Passengers;
    }

    public void setPassengers(List<PassengerContainer> Passengers) {
        this.Passengers = Passengers;
    }

    
    
}
