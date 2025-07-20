package com.weatherrest.exception;

public class WeatherDataAlreadyExistsException extends RuntimeException{

    public WeatherDataAlreadyExistsException(String message) {
        super(message);
    }

    public WeatherDataAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
