/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wookash
 */
@Entity
@Table(name = "FlightInstance")
public class FlightInstance implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departureTime")
    private String departureTime;
    @Column(name = "departureDate")
    private String departureDate;
    @Column(name = "flightTime")
    private int flightTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flightNumber", referencedColumnName = "flightNumber")
    private Flight flightNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination", referencedColumnName = "IATACode")
    private Airport destination;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin", referencedColumnName = "IATACode")
    private Airport origin;
    @Column(name = "availableSeats")
    private int availableSeats;
    @Column(name = "price")
    private int price;
    @OneToMany(mappedBy = "flightInstance", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public FlightInstance()
    {
    }

    public FlightInstance(Long id, String departureTime, String departureDate, int flightTime, Flight flightNumber, Airport destination, Airport origin, int availableSeats, int price, List<Reservation> reservations)
    {
        this.id = id;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.price = price;
        this.reservations = reservations;
    }

    public FlightInstance(String departureTime, String departureDate, int flightTime, Flight flightNumber, Airport destination, Airport origin, int availableSeats, int price, List<Reservation> reservations)
    {
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getDepartureDate()
    {
        return departureDate;
    }

    public void setDepartureDate(String departureDate)
    {
        this.departureDate = departureDate;
    }

    public int getFlightTime()
    {
        return flightTime;
    }

    public void setFlightTime(int flightTime)
    {
        this.flightTime = flightTime;
    }

    public Flight getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(Flight flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public Airport getDestination()
    {
        return destination;
    }

    public void setDestination(Airport destination)
    {
        this.destination = destination;
    }

    public Airport getOrigin()
    {
        return origin;
    }

    public void setOrigin(Airport origin)
    {
        this.origin = origin;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats)
    {
        this.availableSeats = availableSeats;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public List<Reservation> getReservations()
    {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}
