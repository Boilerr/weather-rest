package weatherrest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import weatherrest.exception.ResourceNotFoundException;
import weatherrest.exception.WeatherDataAlreadyExistsException;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private WeatherRepository weatherRepository;

    @Autowired
    public void setWeatherRepository(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Override
    public WeatherData addWeather(WeatherData weatherData) throws WeatherDataAlreadyExistsException {
        if (weatherRepository.existsById(weatherData.getId())) {
            throw new WeatherDataAlreadyExistsException("WeatherDataAlreadyExists");
        }
        return weatherRepository.save(weatherData);
    }

    @Override
    public List<WeatherData> getAllWeather() {
        return weatherRepository.findAll();
    }

    @Override
    public WeatherData getWeatherById(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    //todo bad! Refactoring to return instance, Transactional
    @Override
    public WeatherData deleteWeatherById(Long id) {
        Optional<WeatherData> optionalWeatherData = weatherRepository.findById(id);
        if (optionalWeatherData.isEmpty()) {
            throw new ResourceNotFoundException("Not found " + id);
        }
        weatherRepository.deleteById(id);
        return optionalWeatherData.get();
    }//todo @Transactional


    @Override
    public List<WeatherData> findAllWeather() {
        return null;
    }


    @Override
    public Optional<WeatherData> getOneWeatherById(Long id) {

        Optional<WeatherData> optionalWeatherData = weatherRepository.findById(id);
        if (optionalWeatherData.isPresent()) {
            log.info("GET request to /weather/" + id + " and DB return " + optionalWeatherData.get());
            return optionalWeatherData;
        } else {
            log.info("GET request to /weather/" + id + " failed with ResourceNotFoundException");
            throw new ResourceNotFoundException("Not found 543453" + id);
        }

    }

    @Override
    public List<WeatherData> getWeathersByExample(Example<WeatherData> example) {
        return null;
    }

    @Override
    public WeatherData saveNewWeather(WeatherData newWeatherData) {
        WeatherData savedWeatherData = weatherRepository.save(newWeatherData);
        log.info("POST request to /weather successful and saved in DB as: " + savedWeatherData);
        return savedWeatherData;
    }

    @Override
    public Long deleteWeatherByCity(String city) {
        return weatherRepository.deleteByCity(city);
    }

    /**
     * PUT Behavior:
     * 1. If repository contain WeatherData with this id - overwrite new data above old, without change id
     * 2. If repository `Not` contain WeatherData with this id - put weatherId in newWeatherData, and save in repository
     */
    @Override
    public WeatherData putWeather(WeatherData newWeatherData, Long id) {

        return weatherRepository.findById(id) //return Optional
                .map(weatherData -> { //set all fields except id
                    weatherData.setDate(newWeatherData.getDate());
                    weatherData.setLat(newWeatherData.getLat());
                    weatherData.setLon(newWeatherData.getLon());
                    weatherData.setCity(newWeatherData.getCity());
                    weatherData.setState(newWeatherData.getState());
                    weatherData.setTemperatures(newWeatherData.getTemperatures());

                    return weatherRepository.save(weatherData);
                })
                .orElseGet(() -> { // if Optional is empty put new id and save
                    newWeatherData.setId(id);

                    return weatherRepository.save(newWeatherData);
                });

    }

    @Override
    public Page<WeatherData> getAllWeatherWithPageable(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<WeatherData> weatherDataPage = weatherRepository.findAll(pageable);
        if (pageNumber > weatherDataPage.getTotalPages()) {
            throw new ResourceNotFoundException("Request wants " + pageNumber + " pages, but jpa have only: " + weatherDataPage.getTotalPages());
        }
        log.info("GET request to /weather with Pageable, find: " + weatherDataPage.getNumberOfElements() + " elements");
        return weatherDataPage;
    }

    @Override
    public Page<WeatherData> getAllWeatherWithPageableAndSorting(int pageNumber, int pageSize, String sortByCity, boolean sortOrder) {

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


}