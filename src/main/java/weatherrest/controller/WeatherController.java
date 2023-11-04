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
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("weather")
public class WeatherController {

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private final WeatherRepository weatherRepository;

    WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
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
    List<WeatherData> getAllWeatherOnly() {
        List<WeatherData> weatherData = weatherRepository.findAll();
        log.info("GET request to /weather, find: " + weatherData.size() + " weather data and send");
        return weatherData;
    }

    /**
     * Get with Pageable
     *
     * @param pageNumber amount of pages
     * @param pageSize   page size
     * @return Page<WeatherData>
     */
    @GetMapping(path = "", params = {"page", "size"})
    Page<WeatherData> getAllWeatherWithPageable(@RequestParam("page") int pageNumber, @RequestParam("size") int pageSize) {
        log.info("GET request to /weather with Pageable: page number=" + pageNumber + " page size=" + pageSize);
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<WeatherData> weatherDataPage = weatherRepository.findAll(pageable);
        if (pageNumber > weatherDataPage.getTotalPages()) {
            throw new ResourceNotFoundException("Request wants " + pageNumber + " pages, but jpa have only: " + weatherDataPage.getTotalPages());
        }
        log.info("GET request to /weather with Pageable, find: " + weatherDataPage.getNumberOfElements() + " elements");
        return weatherDataPage;
    }

    /**
     * Get with Pageable and Sorting
     *
     * @param pageNumber amount of pages
     * @param pageSize   page size
     * @param sortByCity name of column for sorting
     * @param sortOrder  true=ascending, false=descending
     * @return Page<WeatherData>
     */
    @GetMapping(path = "", params = {"page", "size", "sort", "order"})
    Page<WeatherData> getAllWeatherWithPageableAndSorting(@RequestParam("page") int pageNumber,
                                                          @RequestParam("size") int pageSize,
                                                          @RequestParam("sort") String sortByCity,
                                                          @RequestParam("order") boolean sortOrder) {
        log.info("GET request to /weather with PageableAndSorting: page number=" + pageNumber + "; page size=" + pageSize + "; sort=" + sortByCity + "; order=" + sortOrder + ";");

        Sort sort;
        if (sortOrder) {
            sort = Sort.by(sortByCity).ascending();
        } else {
            sort = Sort.by(sortByCity).descending();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<WeatherData> weatherDataPage = weatherRepository.findAll(pageable);

        if (pageNumber > weatherDataPage.getTotalPages()) {
            throw new ResourceNotFoundException("Request wants " + pageNumber + " pages, but jpa have only: " + weatherDataPage.getTotalPages());
        }
        log.info("GET request to /weather with PageableAndSorting, find: " + weatherDataPage.getNumberOfElements() + " elements");
        return weatherDataPage;
    }


    /**
     * GET request to `/weather/id`:
     * Get record with the given id
     * if the matching record exists, the response code is 200 and the response body is the matching object
     * if there is no record in the collection with the given id, the response code is 404
     */
    @GetMapping("/{weatherId}")
    Optional<WeatherData> getOneById(@PathVariable Long weatherId) {

        Optional<WeatherData> optionalWeatherData = weatherRepository.findById(weatherId);
        if (optionalWeatherData.isPresent()) {
            log.info("GET request to /weather/" + weatherId + " and DB return " + optionalWeatherData.get());
            return optionalWeatherData;
        } else {
            log.info("GET request to /weather/" + weatherId + " failed with ResourceNotFoundException");
            throw new ResourceNotFoundException("Not found 543453" + weatherId);
        }
    }

    /**
     * GET with optional @RequestParam
     *
     * @param state (required = false)
     * @param city  (required = false)
     * @return List<WeatherData>
     */
    @GetMapping(path = "/opt")
    List<WeatherData> getWeathersByExample(@RequestParam(required = false) String state, @RequestParam(required = false) String city) {
        log.info("GET request to /weather with getWeathersByExample: state= " + state + " city=" + city);

        WeatherData weatherDataExample = new WeatherData();
        weatherDataExample.setState(state);
        weatherDataExample.setCity(city);

        log.info("GET request to /weather with getWeathersByExample: and create new WeatherData: " + weatherDataExample);

        Example<WeatherData> example = Example.of(weatherDataExample);

        List<WeatherData> actual = weatherRepository.findAll(example);

        log.info("GET request to /weather with getWeathersByExample:  and return: " + actual);
        return actual;
    }

    @GetMapping(path = "/opt")
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
    }


    /**
     * POST request to `/weather`:
     * Crates a new weather data record
     * the response code is 201, and the response body is the created record, including its unique id
     */
    @PostMapping("")
    //@ResponseStatus(HttpStatus.CREATED)
    WeatherData saveNewWeatherData(@RequestBody WeatherData weatherData) {
        log.info("POST request to /weather with incoming data:            " + weatherData);
        WeatherData savedWeatherData = weatherRepository.save(weatherData);
        log.info("POST request to /weather successful and saved in DB as: " + savedWeatherData);
        return savedWeatherData;
    }


    /**
     * PUT Behavior:
     * 1. If repository contain WeatherData with this Id - overwrite new data above old, without change Id
     * 2. If repository `Not` contain WeatherData with this Id - put weatherId in newWeatherData, and save in repository
     */
    @PutMapping("/{weatherId}")
    WeatherData putWeatherData(@RequestBody WeatherData newWeatherData, @PathVariable Long id) {

        return weatherRepository.findById(id)
                .map(weatherData -> {
                    weatherData.setDate(newWeatherData.getDate());
                    weatherData.setLat(newWeatherData.getLat());
                    weatherData.setLon(newWeatherData.getLon());
                    weatherData.setCity(newWeatherData.getCity());
                    weatherData.setState(newWeatherData.getState());
                    weatherData.setTemperatures(newWeatherData.getTemperatures());

                    return weatherRepository.save(weatherData);
                })
                .orElseGet(() -> {
                    newWeatherData.setId(id);

                    return weatherRepository.save(newWeatherData);
                });
    }


    /**
     * DELETE request to `/weather/<id>`:
     * Deletes the record with the given id from the database and return status code 200
     * if there was no record in the database with the given id, the response code is 404
     */
    @DeleteMapping("/{weatherId}")
    ResponseEntity<?> deleteOneWeatherById(@PathVariable Long weatherId) {

        if (!weatherRepository.existsById(weatherId)) {
            log.info("DELETE request to /weather/" + weatherId + " failed with ResourceNotFoundException");
            throw new ResourceNotFoundException("Not found " + weatherId);
        }
        weatherRepository.deleteById(weatherId);
        log.info("DELETE request to /weather/" + weatherId + " succeed");
        return ResponseEntity.status(HttpStatus.OK).build();
        // TODO: 17.10.23  weatherRepository.deleteById(weatherId); .orElseThrow ResourceNotFoundException. When resource delete between operation


    }
    @Transactional
    @DeleteMapping("")
    void deleteByCity(@RequestParam String city) {
        weatherRepository.deleteByCity(city);
    }

}