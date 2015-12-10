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
@Table(name = "Flight")
public class Flight implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    private String flightNumber;
    @Column(name = "numberOfSeats")
    private int numberOfSeats;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline", referencedColumnName = "name")
    private Airline airline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flightNumber")
    private List<FlightInstance> flightInstances;

    public Flight()
    {
    }

    public Flight(String flightNumber, int numberOfSeats, Airline airline, List<FlightInstance> flightInstances)
    {
        this.flightNumber = flightNumber;
        this.numberOfSeats = numberOfSeats;
        this.airline = airline;
        this.flightInstances = flightInstances;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    public Airline getAirline()
    {
        return airline;
    }

    public void setAirline(Airline airline)
    {
        this.airline = airline;
    }

    public List<FlightInstance> getFlightInstances()
    {
        return flightInstances;
    }

    public void setFlightInstances(List<FlightInstance> flightInstances)
    {
        this.flightInstances = flightInstances;
    }

}
