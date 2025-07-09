package com.weatherrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.weatherrest.model.WeatherData;
import com.weatherrest.service.WeatherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private final WeatherService weatherService;

    WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

   
    @GetMapping(path = "",
            produces = "application/json")
    List<WeatherData> getAllWeather() {
        List<WeatherData> weatherData = weatherService.getAllWeather();
        log.info("GET to /weather, find: {} weather data and send", weatherData.size());
        return weatherData;
    }


   
    @GetMapping(path = "",
            params = {"page", "size"},
            produces = "application/json")
    Page<WeatherData> getAllWeatherWithPageable(@RequestParam("page") int pageNumber,
                                                @RequestParam("size") int pageSize) {
        log.info("GET /weather with Pageable: page number={} page size={}", pageNumber, pageSize);

        return weatherService.getAllWeatherWithPageable(pageNumber, pageSize);
    }


}