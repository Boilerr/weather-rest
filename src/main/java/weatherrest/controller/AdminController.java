package weatherrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.util.Random;


@RestController
@RequestMapping("admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/saverandomeone")
    public WeatherData saveRandomOne() {
        log.info("GET request to admin/saverandomeone");
        WeatherData weatherData = new WeatherData("1985-01-01", 36.1189, -86.6892, generatingRandomAlphabeticString10(), generatingRandomAlphabeticString10(), new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f});
        return weatherRepository.save(weatherData);
    }

    /**
     * Generate n random instances and try to save
     */
    @GetMapping("/saverandom/{n}")
    public String saveRandomN(@PathVariable int n) {
        log.info("GET request to admin/saverandom/" + n);

        for (int i = 0; i < n; i++) {
            saveRandomOne();
        }
        return "GET request to: admin/saverandom" + n;
    }


    @GetMapping("/creatone")
    public WeatherData creatOne() {
        log.info("GET request to admin/creatone");
        WeatherData weatherData = new WeatherData("1985-01-01", 36.1189, -86.6892, "Nashville", "Tennessee", new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f});
        return weatherRepository.save(weatherData);

    }


    public String generatingRandomAlphabeticString10() {
        int leftLim = 97; // letter 'a'
        int rightLim = 122; // letter 'z'
        int length = 10;
        Random random = new Random();

        return random.ints(leftLim, rightLim + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }
}