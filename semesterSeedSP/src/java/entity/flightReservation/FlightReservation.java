
package entity.flightReservation;

import entity.Passenger;
import entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FlightReservation implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String ReserveeName;
    private String ReserveeEmail;
    private String ReserveePhone;
    
    @OneToMany(mappedBy = "flightReservation", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList();
    
    private String flightId;
    private String airline;
    private String flightDate;
    private int flightTime;
    private String origin;
    private String destination;
    private double totalPrice;
    private int numberOfSeats;
    
//    @ManyToOne
//    private User user;

    public FlightReservation() {
    }

    public FlightReservation(String ReserveeName, String ReserveeEmail, String ReserveePhone, String flightId, String airline, String flightDate, int flightTime, String origin, String destination, double totalPrice, int numberOfSeats) {
        this.ReserveeName = ReserveeName;
        this.ReserveeEmail = ReserveeEmail;
        this.ReserveePhone = ReserveePhone;
        this.flightId = flightId;
        this.airline = airline;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.origin = origin;
        this.destination = destination;
        this.totalPrice = totalPrice;
        this.numberOfSeats = numberOfSeats;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
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

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getReserveeEmail() {
        return ReserveeEmail;
    }

    public void setReserveeEmail(String ReserveeEmail) {
        this.ReserveeEmail = ReserveeEmail;
    }

    public String getReserveePhone() {
        return ReserveePhone;
    }

    public void setReserveePhone(String ReserveePhone) {
        this.ReserveePhone = ReserveePhone;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setFlightReservation(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
