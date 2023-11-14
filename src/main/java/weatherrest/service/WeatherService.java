package weatherrest.service;

import weatherrest.model.WeatherData;
import weatherrest.exception.WeatherDataAlreadyExistsException;


import java.util.List;

public interface WeatherService {

    WeatherData addWeatherData(WeatherData weatherData) throws WeatherDataAlreadyExistsException;
    List<WeatherData> getAllWeatherData();
    WeatherData getWeatherDataById(Long id);
    WeatherData deleteWeatherDataById(Long id);

}
