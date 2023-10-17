package weatherrest.model;

import jakarta.persistence.*;


@Entity
@Table(name = "weather")
public class WeatherData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date")
    private String date;

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

    // Constructors

    // Constructor without id
    public WeatherData(String date, double lat, double lon, String city, String state, float[] temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public WeatherData() {
    }

    // Getters and Setters for all fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
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


}
