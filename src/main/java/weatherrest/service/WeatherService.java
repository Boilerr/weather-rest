package weatherrest.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import weatherrest.model.WeatherData;
import weatherrest.exception.WeatherDataAlreadyExistsException;


import java.util.List;
import java.util.Optional;

public interface WeatherService {

    WeatherData addWeather(WeatherData weatherData) throws WeatherDataAlreadyExistsException;
    List<WeatherData> getAllWeather();
    WeatherData getWeatherById(Long id);
    WeatherData deleteWeatherById(Long id);

    List<WeatherData> findAllWeather();


    Optional<WeatherData> getOneWeatherById(Long weatherId);

    List<WeatherData> getWeathersByExample(Example<WeatherData> example);

    WeatherData saveNewWeather(WeatherData weatherData);


    Long deleteWeatherByCity(String city);

    WeatherData putWeather(WeatherData newWeatherData, Long id);

    Page<WeatherData> getAllWeatherWithPageable(int pageNumber, int pageSize);

    Page<WeatherData> getAllWeatherWithPageableAndSorting(int pageNumber, int pageSize, String sortByCity, boolean sortOrder);
}
