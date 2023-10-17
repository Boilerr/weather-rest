package weatherrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weatherrest.exception.ResourceNotFoundException;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;


    /**
     * POST request to `/weather`:
     * Crates a new weather data record
     * the response code is 201, and the response body is the created record, including its unique id
     */
    @PostMapping("")
    //@ResponseStatus(HttpStatus.CREATED)
    public WeatherData saveNewWeatherData(@RequestBody WeatherData weatherData) {
        System.out.println(new Timestamp(new Date().getTime()) + "    POST request to: /weather");

        return weatherRepository.save(weatherData);
    }


    /**
     * GET request to `/weather`:
     * Get weather data with response code is 200, the response body is an array of records, ordered by their ids in increasing order
     * accepts an optional query string parameter,
     * - `date`, for example `/weather/?date=2014-06-11`, only the records with the matching date are returned.
     * - `city`,for example `/weather/?city=London`, only the records with the matching city are returned. It might contain several values, e.g., `city=london,Moscow`, meaning that records with a city matching any of these values must be returned.
     * - `sort`, either "date" or "-date", for example `/weather/?sort=-date.` If the value is "date", then the ordering is by date in ascending order.If it is "-date", then the ordering is by date in descending order.If there are two records with the same date, the one with the smaller id must come first.
     */
    @GetMapping("")
    public List<WeatherData> getAllWeatherOnly() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET getAllWeatherOnly request to: /weather");
        List<WeatherData> weatherData = weatherRepository.findAll();
        System.out.println(new Timestamp(new Date().getTime()) + "    GET getAllWeatherOnly request to: /weather" + weatherData.size());
        return weatherData;
    }


    /**
     * GET request to `/weather/id`:
     * Get record with the given id
     * if the matching record exists, the response code is 200 and the response body is the matching object
     * if there is no record in the collection with the given id, the response code is 404
     */
    @GetMapping("/{weatherId}")
    public Optional<WeatherData> getOneById(@PathVariable Long weatherId) {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather/" + weatherId);

        Optional<WeatherData> weatherData = weatherRepository.findById(weatherId);
        if (weatherData.isPresent()) {
            return weatherData;
        } else throw new ResourceNotFoundException("not found getOneById" + weatherId);
    }


    /**
     * DELETE request to `/weather/<id>`:
     * Deletes the record with the given id from the database and return status code 200
     * if there was no record in the database with the given id, the response code is 404
     */
    @DeleteMapping("/{weatherId}")
    public ResponseEntity<?> deleteOneWeatherById(@PathVariable Long weatherId) {
        System.out.println(new Timestamp(new Date().getTime()) + "    DeleteMapping to: /weather" + weatherId);

        if (!weatherRepository.existsById(weatherId)) {
            throw new ResourceNotFoundException("Weather not found with id " + weatherId);
        }
        weatherRepository.deleteById(weatherId);
        return ResponseEntity.status(HttpStatus.OK).build();
        // TODO: 17.10.23  weatherRepository.deleteById(weatherId); .orElseThrow ResourceNotFoundException. When resource delete between operation


    }
}