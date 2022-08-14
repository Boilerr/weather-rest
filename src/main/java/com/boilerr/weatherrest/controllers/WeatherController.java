package com.boilerr.weatherrest.controllers;

import com.boilerr.weatherrest.exceptions.ResourceNotFoundException;
import com.boilerr.weatherrest.models.WeatherData;
import com.boilerr.weatherrest.repositorys.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RestController
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @PostMapping("/weather")
    public String returnString() {
        System.out.println(new Timestamp(new Date().getTime()) + "    POST request to: /weather");
        return "POST request to: /weather";
    }


    @GetMapping("/weather")
    public String returnString2() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather");
        WeatherData weatherData = new WeatherData("1985-01-01", 36.1189, -86.6892, "Nashville", "Tennessee", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f});
        weatherRepository.save(weatherData);
        return "GET request to: /weather";
    }

    @PostMapping("/")
    public String createByData() {
        System.out.println(new Timestamp(new Date().getTime()) + "    POST request to: /weather");
        WeatherData weatherData = new WeatherData();
        weatherRepository.save(weatherData);

        return "POST request to: /weather";
    }

    @GetMapping("/")
    public String returnString2() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather");
        weatherRepository.getById();
        return "GET request to: /weather";
    }


    @GetMapping("/{id}")
    public WeatherData showWeatherDateById(@PathVariable long id) {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather/" + id);

        return weatherRepository.findById(id)
                .map(weatherData -> {
                    weatherRepository.getById(id);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException(" " + id));

    }

    @GetMapping("/{Id}")
    public Optional<WeatherData> getTask(@PathVariable Long Id) {

        return weatherRepository.findById(Id):
    }


}