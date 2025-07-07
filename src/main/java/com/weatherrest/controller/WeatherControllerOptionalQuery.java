package com.weatherrest.controller;

import com.weatherrest.model.WeatherData;
import com.weatherrest.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Controller for optional query parameters.
 * Approach: full enumeration of parameters was chosen for greater accuracy
 * of the requests in the business sense.
 * What exactly does this set of parameters mean in a business sense
 */
@RestController
@RequestMapping("api/v1/weather")
public class WeatherControllerOptionalQuery {

    private static final Logger log = LoggerFactory.getLogger(WeatherControllerOptionalQuery.class);

    @Autowired
    private final WeatherService weatherService;

    WeatherControllerOptionalQuery(WeatherService weatherService) {
        this.weatherService = weatherService;
    }





}
