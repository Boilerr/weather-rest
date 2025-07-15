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

    
    @GetMapping(path = "",
            params = {"page", "size", "sort", "order"},
            produces = "application/json")
    Page<WeatherData> getAllWeatherWithPageableAndSorting(@RequestParam("page") int pageNumber,
                                                          @RequestParam("size") int pageSize,
                                                          @RequestParam("sort") String sortByCity,
                                                          @RequestParam("order") boolean sortOrder) {

        log.info("GET request to /weather with PageableAndSorting: page number={}; page size={}; sort={}; order={};", pageNumber, pageSize, sortByCity, sortOrder);

        return weatherService.getAllWeatherWithPageableAndSorting(pageNumber, pageSize, sortByCity, sortOrder);
    }
 
    @GetMapping(path = "/{id}",
            produces = "application/json")
    Optional<WeatherData> getOneWeatherById(@PathVariable Long id) {
        return weatherService.getOneWeatherById(id);
 

    @PostMapping(path = "",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    WeatherData saveNewWeather(@RequestBody WeatherData newWeatherData) {
        log.info("POST request to /weather with incoming data:            {}", newWeatherData);
        return weatherService.saveNewWeather(newWeatherData);
    }

    @PutMapping(path = "/{id}",
            produces = "application/json")
    WeatherData putWeather(@RequestBody WeatherData newWeatherData, @PathVariable Long id) {
        return weatherService.putWeather(newWeatherData, id);
    }

    @DeleteMapping(path = "/{id}",
            produces = "application/json")
    WeatherData deleteOneWeatherById(@PathVariable Long id) {
        log.info("deleteOneWeatherById request to /weather with id:            {}", id);
        return weatherService.deleteOneWeatherById(id);
    }


    @DeleteMapping(path = "",
            produces = "application/json")
    Long deleteAllWeathersByCity(@RequestParam String city) {
        return weatherService.deleteAllWeathersByCity(city);
    }
}