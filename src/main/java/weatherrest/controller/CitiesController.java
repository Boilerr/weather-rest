package weatherrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import weatherrest.exception.ResourceNotFoundException;
import weatherrest.model.City;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;
import weatherrest.service.WeatherService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/cities")
public class CitiesController {

    private static final Logger log = LoggerFactory.getLogger(CitiesController.class);

    @Autowired
    private final WeatherService weatherService;

    CitiesController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("")
    List<WeatherData> getAllCities() {
        return weatherService.findAll();
    }


    @PostMapping("")
    City saveNewCities(@RequestBody City city) {
        return weatherService.saveNewCity(city);
    }


    @PutMapping("/{citiesId}")
    WeatherData putCities(@RequestBody City city, @PathVariable Long id) {
        return weatherService.saveNewWeatherData(city);
    }


    @DeleteMapping("/{weatherId}")
    void deleteOneCityById(@PathVariable Long citiesId) {
        weatherService.deleteOneCityById(citiesId);

    }
}