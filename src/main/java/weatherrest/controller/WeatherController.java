package weatherrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import weatherrest.model.WeatherData;
import weatherrest.service.WeatherService;

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


    /**
     * GET `/weather`:
     * Get weather data with response code is 200, the response body is an array of records, ordered by their ids in increasing order
     * accepts an optional query string parameter,
     * - `date`, for example `/weather/?date=2014-06-11`, only the records with the matching date are returned.
     * - `city`,for example `/weather/?city=London`, only the records with the matching city are returned. It might contain several values, e.g., `city=london,Moscow`, meaning that records with a city matching any of these values must be returned.
     * - `sort`, either "date" or "-date", for example `/weather/?sort=-date.` If the value is "date", then the ordering is by date in ascending order.If it is "-date", then the ordering is by date in descending order.If there are two records with the same date, the one with the smaller id must come first.
     */
    @GetMapping(path = "",
            produces = "application/json")
    List<WeatherData> getAllWeather() {
        List<WeatherData> weatherData = weatherService.getAllWeather();
        log.info("GET to /weather, find: " + weatherData.size() + " weather data and send");
        return weatherData;
    }


    /**
     * GET `/weather?page=p&size=s`
     * GET all WeatherData with Pageable
     *
     * @param pageNumber amount of pages
     * @param pageSize   page size
     * @return Page<WeatherData>
     */
    @GetMapping(path = "",
            params = {"page", "size"},
            produces = "application/json")
    Page<WeatherData> getAllWeatherWithPageable(@RequestParam("page") int pageNumber,
                                                @RequestParam("size") int pageSize) {
        log.info("GET request to /weather with Pageable: page number=" + pageNumber + " page size=" + pageSize);

        return weatherService.getAllWeatherWithPageable(pageNumber, pageSize);
    }


    /**
     * GET `/weather` with Pageable and Sorting
     *
     * @param pageNumber amount of pages
     * @param pageSize   page size
     * @param sortByCity name of column for sorting
     * @param sortOrder  true=ascending, false=descending
     * @return Page<WeatherData>
     */
    @GetMapping(path = "",
            params = {"page", "size", "sort", "order"},
            produces = "application/json")
    Page<WeatherData> getAllWeatherWithPageableAndSorting(@RequestParam("page") int pageNumber,
                                                          @RequestParam("size") int pageSize,
                                                          @RequestParam("sort") String sortByCity,
                                                          @RequestParam("order") boolean sortOrder) {

        log.info("GET request to /weather with PageableAndSorting: page number=" + pageNumber + "; page size=" + pageSize + "; sort=" + sortByCity + "; order=" + sortOrder + ";");

        return weatherService.getAllWeatherWithPageableAndSorting(pageNumber, pageSize, sortByCity, sortOrder);
    }


    /**
     * GET `/weather/id`:
     * Get record by id
     * if the matching record exists, the response code is 200 and the response body is the matching object
     * if there is no record in the collection with the given id, the response code is 404
     */
    @GetMapping(path = "/{id}",
            produces = "application/json")
    Optional<WeatherData> getOneWeatherById(@PathVariable Long id) {
        return weatherService.getOneWeatherById(id);
    }


    /**
     * GET with optional @RequestParam
     *
     * @param state (required = false)
     * @param city  (required = false)
     * @return List<WeatherData>
     */
    @GetMapping(path = "/opt",
            produces = "application/json")
    List<WeatherData> getWeathersByExample(@RequestParam(required = false) String state,
                                           @RequestParam(required = false) String city) {
        log.info("GET request to /weather with getWeathersByExample: state= " + state + " city=" + city);

        WeatherData weatherDataExample = new WeatherData();
        weatherDataExample.setState(state);
        weatherDataExample.setCity(city);

        log.info("GET request to /weather with getWeathersByExample: and create new WeatherData: " + weatherDataExample);

        Example<WeatherData> example = Example.of(weatherDataExample);

        List<WeatherData> actual = weatherService.getWeathersByExample(example);

        log.info("GET request to /weather with getWeathersByExample:  and return: " + actual);
        return actual;
    }

    /*@GetMapping(path = "/opt")
    List<WeatherData> getWeathersByExampleWithSort(@RequestParam(required = false) String state,
                                                   @RequestParam(required = false) String city,
                                                   @RequestParam(name = "sort", required = false) String sortCity) {

        log.info("GET request to /weather with getWeathersByExample: state= " + state + " city=" + city + " sortCity=" + sortCity);

        // Create Example
        WeatherData weatherDataExample = new WeatherData();
        weatherDataExample.setState(state);
        weatherDataExample.setCity(city);
        Example<WeatherData> example = Example.of(weatherDataExample);
        log.info("GET request to /weather with getWeathersByExample: Create Example: " + weatherDataExample);

        // Create required = false Sort
        if (Objects.equals(sortCity, "city+") || Objects.equals(sortCity, "city-")) {
            Sort sort;
            if (Objects.equals(sortCity, "city+")) {
                sort = Sort.by(Sort.Order.asc("city"));
            } else {
                sort = Sort.by(Sort.Order.desc("city"));
            }
            return weatherRepository.findAll(example, sort);
        }

        List<WeatherData> actual = weatherRepository.findAll(example);

        log.info("GET request to /weather with getWeathersByExample:  and return: " + actual);
        return actual;
    }*/


    /**
     * POST `/weather`:
     * Crates a new weather data record
     * the response code is 201, and the response body is the created record, including its unique id
     */
    @PostMapping(path = "",
            produces = "application/json")
    //@ResponseStatus(HttpStatus.CREATED)
    WeatherData saveNewWeather(@RequestBody WeatherData newWeatherData) {
        log.info("POST request to /weather with incoming data:            " + newWeatherData);
        return weatherService.saveNewWeather(newWeatherData);
    }


    @PutMapping(path = "/{id}",
            produces = "application/json")
    WeatherData putWeather(@RequestBody WeatherData newWeatherData, @PathVariable Long id) {
        return weatherService.putWeather(newWeatherData, id);
    }


    /**
     * DELETE `/weather/id`:
     * Deletes the record with the given id, and return status code 200
     * If there was no record, the response code is 404
     */
    @DeleteMapping(path = "/{id}",
            produces = "application/json")
    WeatherData deleteOneWeatherById(@PathVariable Long id) {
        return weatherService.deleteWeatherById(id);
    }


    /**
     * DELETE `/weather?city=x`:
     * DELETE all WeatherData by City
     *
     * @return number of deleted WeatherData
     */
    @DeleteMapping(path = "",
            produces = "application/json")
    Long deleteWeatherByCity(@RequestParam String city) {
        return weatherService.deleteWeatherByCity(city);
    }//todo return json with count, proper return codes

}