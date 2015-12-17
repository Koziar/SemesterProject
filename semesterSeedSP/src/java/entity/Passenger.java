/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import entity.flightReservation.FlightReservation;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author wookash
 */
@Entity
@Table(name = "Passenger")
public class Passenger implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private FlightReservation flightReservation;

    public Passenger()
    {
    }

    public Passenger(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public FlightReservation getFlightReservation() {
        return flightReservation;
    }

    public void setFlightReservation(FlightReservation flightReservation) {
        this.flightReservation = flightReservation;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
