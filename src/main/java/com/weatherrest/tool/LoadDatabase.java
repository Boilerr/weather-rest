package com.weatherrest.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.weatherrest.model.WeatherData;
import com.weatherrest.repository.WeatherRepository;

import java.time.LocalDate;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WeatherRepository weatherRepository) {

        return args -> {
            LocalDate date =  LocalDate.of(1985, 1, 1);

            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "New York", "New York", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Houston", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Los Angeles", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Chicago", "Illinois", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Phoenix", "Arizona", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Philadelphia", "Pennsylvania", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "San Antonio", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "San Diego", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Dallas", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.7777, -86.7777, "Austin", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Jacksonville", "Florida", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "San Jose", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Fort Worth", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Columbus", "Ohio", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Charlotte", "North Carolina", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Indianapolis", "Indiana", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "San Francisco", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Seattle", "Washington", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Oklahoma City", "Oklahoma", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Nashville", "Tennessee", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "El Paso", "Texas", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Washington", "District of Columbia", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Las Vegas", "Nevada", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Boston", "Massachusetts", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Portland", "Oregon", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Louisville", "Kentucky", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Memphis", "Tennessee", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Detroit", "Michigan", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Baltimore", "Maryland", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Milwaukee", "Wisconsin", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Albuquerque", "New Mexico", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Tucson", "Arizona", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Fresno", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Sacramento", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Mesa", "Arizona", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Kansas City", "Missouri", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Atlanta", "Georgia", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Colorado Springs", "Colorado", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Omaha", "Nebraska", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Raleigh", "North Carolina", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Virginia Beach", "Virginia", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));
            weatherRepository.save(new WeatherData(date, 36.1189, -86.6892, "Long Beach", "California", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f}));

            log.info("LoadDatabase add 42 Weather data to DB for your convenience");
        };
    }
}

