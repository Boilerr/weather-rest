package com.weatherrest.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;


@Entity
@Table(name = "weather")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "temperatures")
    private float[] temperatures;


    // Empty Constructor
    public WeatherData() {
    }

    // Constructor without `id`
    public WeatherData(LocalDate date, Double lat, Double lon, String city, String state, float[] temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }


    // Getters and Setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float[] getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(float[] temperatures) {
        this.temperatures = temperatures;
    }


    // equals(), hashCode() and toString()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(lat, that.lat) && Objects.equals(lon, that.lon) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Arrays.equals(temperatures, that.temperatures);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, date, lat, lon, city, state);
        result = 31 * result + Arrays.hashCode(temperatures);
        return result;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", temperatures=" + Arrays.toString(temperatures) +
                '}';
    }
}
