package weatherrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weatherrest.model.WeatherData;
import weatherrest.repository.WeatherRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/saverandomeone")
    public WeatherData saverandomeone() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /saverandomeone");

        WeatherData weatherData = new WeatherData("1985-01-01", 36.1189, -86.6892, generatingRandomAlphabeticString10(), generatingRandomAlphabeticString10(), new float[]{17.3f, 16.8f, 16.4f, 16.0f, 15.6f, 15.3f, 15.0f, 14.9f, 15.8f, 18.0f, 20.2f, 22.3f, 23.8f, 24.9f, 25.5f, 25.7f, 24.9f, 23.0f, 21.7f, 20.8f, 29.9f, 29.2f, 28.6f, 28.1f});
        return weatherRepository.save(weatherData);

    }

    /*
    Generate n random instances and try to save
     */
    @GetMapping("/saverandom/{n}")
    public String saverandomn(@PathVariable int n) {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /saverandomn");

        for (int i = 0; i < n; i++) {
            saverandomeone();
        }
        return "GET request to: /saverandom" + n;
    }


    @GetMapping("/creatone")
    public WeatherData creatone() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /creatOne");
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