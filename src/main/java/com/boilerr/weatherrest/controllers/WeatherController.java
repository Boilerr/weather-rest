package com.boilerr.weatherrest.controllers;

import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class WeatherController {


    @PostMapping("/weather")
    public String returnString() {
        System.out.println(new Timestamp(new Date().getTime()) + "    POST request to: /weather");
        return "POST request to: /weather";
    }


    @GetMapping("/weather")
    public String returnString2() {
        System.out.println(new Timestamp(new Date().getTime()) + "    GET request to: /weather");
        return "GET request to: /weather";
    }

}