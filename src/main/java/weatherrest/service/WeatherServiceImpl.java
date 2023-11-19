package weatherrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import weatherrest.exception.WeatherDataAlreadyExistsException;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;

    @Autowired
    public void setWeatherRepository(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }


    @Override
    public WeatherData addWeatherData(WeatherData weatherData) throws WeatherDataAlreadyExistsException {
        if (weatherRepository.existsById(weatherData.getId())) {
            throw new WeatherDataAlreadyExistsException("WeatherDataAlreadyExists");
        }
        return weatherRepository.save(weatherData);
    }

    @Override
    public List<WeatherData> getAllWeatherData() {
        return weatherRepository.findAll();
    }

    @Override
    public WeatherData getWeatherDataById(Long id) {
        return weatherRepository.findById(id).orElse(null);
    }

    //todo bad! Refactoring to return instance, Transactional
    @Override
    public WeatherData deleteWeatherDataById(Long id) {
        Optional<WeatherData> optional = weatherRepository.findById(id);

        WeatherData product = null;
        if (optional.isPresent()) {
            product = weatherRepository.findById(id).get();
            weatherRepository.deleteById(id);
        }
        return product;
    }

    @Override
    public List<WeatherData> findAll() {
        return null;
    }

    @Override
    public Page<WeatherData> getAllWeatherWithPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Page<WeatherData> getAllWeatherWithPageableAndSorting() {
        return null;
    }

    @Override
    public Optional<WeatherData> getOneWeatherDataById(Long weatherId) {
        return Optional.empty();
    }

    @Override
    public List<WeatherData> getWeathersByExample(Example<WeatherData> example) {
        return null;
    }

    @Override
    public WeatherData saveNewWeatherData(WeatherData weatherData) {
        return null;
    }
}