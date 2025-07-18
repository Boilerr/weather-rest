package com.weatherrest.service;

import org.springframework.data.domain.Page;
import com.weatherrest.model.WeatherData;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
    Long deleteAllWeathersByCity(String city);

    WeatherData deleteOneWeatherById(Long id);

    WeatherData putWeather(WeatherData newWeatherData, Long id);

    WeatherData saveNewWeather(WeatherData newWeatherData);

    List<WeatherData> getWeathersByCityAndDateAndSort();

    List<WeatherData> getWeathersByDateAndSort();

    List<WeatherData> getWeathersByCityAndSort();

    List<WeatherData> getWeathersByCityAndDate();

    List<WeatherData> getAllWeathersWithSort();

    List<WeatherData> getWeathersByDate();

    List<WeatherData> getWeathersByCity();

    Optional<WeatherData> getOneWeatherById(Long id);

    Page<WeatherData> getAllWeatherWithPageableAndSorting(int pageNumber, int pageSize, String sortByCity, boolean sortOrder);

    Page<WeatherData> getAllWeatherWithPageable(int pageNumber, int pageSize);

    List<WeatherData> getAllWeather();
}
