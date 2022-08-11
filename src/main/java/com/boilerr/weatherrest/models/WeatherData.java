package com.boilerr.weatherrest.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "weather")
public class WeatherData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "temperatures")
    private float[] temperatures;


    public WeatherData(Date date, double lat, double lon, String city, String state, float[] temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

}
