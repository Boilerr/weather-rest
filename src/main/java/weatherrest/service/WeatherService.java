package weatherrest.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import weatherrest.model.WeatherData;
import weatherrest.exception.WeatherDataAlreadyExistsException;


import java.util.List;
import java.util.Optional;

public interface WeatherService {

    WeatherData addWeatherData(WeatherData weatherData) throws WeatherDataAlreadyExistsException;
    List<WeatherData> getAllWeatherData();
    WeatherData getWeatherDataById(Long id);
    WeatherData deleteWeatherDataById(Long id);

    List<WeatherData> findAll();

    Page<WeatherData> getAllWeatherWithPageable(Pageable pageable);

    Page<WeatherData> getAllWeatherWithPageableAndSorting();

    Optional<WeatherData> getOneWeatherDataById(Long weatherId);

    List<WeatherData> getWeathersByExample(Example<WeatherData> example);

    WeatherData saveNewWeatherData(WeatherData weatherData);
}
