/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wookash
 */
@Entity
@Table(name = "Airport")
public class Airport implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final long serialVersionUID = 1L;
    private String IATACode;
    private String name;
    private String city;
    private String timeZone;
    @OneToMany(mappedBy = "destination")
    private List<FlightInstance> incomingFlights;
    @OneToMany(mappedBy = "origin")
    private List<FlightInstance> departingFlights;
    
    public Airport()
    {
    }

    public Airport(String IATACode, String name, String city, String timeZone)
    {
        this.IATACode = IATACode;
        this.name = name;
        this.city = city;
        this.timeZone = timeZone;
    }

    public Airport(String IATACode, String name, String city, String timeZone, List<FlightInstance> incomingFlights, List<FlightInstance> departingFlights)
    {
        this.IATACode = IATACode;
        this.name = name;
        this.city = city;
        this.timeZone = timeZone;
        this.incomingFlights = incomingFlights;
        this.departingFlights = departingFlights;
    }

    public String getIATACode()
    {
        return IATACode;
    }

    public void setIATACode(String IATACode)
    {
        this.IATACode = IATACode;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
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
