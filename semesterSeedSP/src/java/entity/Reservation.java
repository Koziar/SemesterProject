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
@Table(name = "Reservation")
public class Reservation implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flightInstance", referencedColumnName = "id")
    private FlightInstance flightInstance;

    public Reservation()
    {
    }

    public Reservation(double price, FlightInstance flightInstance)
    {
        this.price = price;
        this.flightInstance = flightInstance;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public FlightInstance getFlightInstance()
    {
        return flightInstance;
    }

    public void setFlightInstance(FlightInstance flightInstance)
    {
        this.flightInstance = flightInstance;
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
