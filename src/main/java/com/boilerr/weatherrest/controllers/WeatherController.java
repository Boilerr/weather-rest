package com.boilerr.weatherrest.controllers;

import com.boilerr.weatherrest.exceptions.ResourceNotFoundException;
import com.boilerr.weatherrest.models.WeatherData;
import com.boilerr.weatherrest.repositorys.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("weather")
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherData postNewWeatherData(@RequestBody WeatherData weatherData) {
        System.out.println(new Timestamp(new Date().getTime()) + "    POST request to: /weather");

        return weatherRepository.save(weatherData);
    }

    @GetMapping("/")
    public String query(@RequestParam("data") String data, @RequestParam("city") String city, @RequestParam("sort") String sort) {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather");
        return "GET request to: /weather";
    }


    @GetMapping("/{id}")
    public Optional<WeatherData> showWeatherDateById(@PathVariable long id) {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather/" + id);

        Optional<WeatherData> weatherData = weatherRepository.findById(id);
        if (weatherData.isPresent()) {
            return weatherData;
        } else throw new ResourceNotFoundException("not found " + id);

    }
}