package com.kash.weatherapp.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class WeatherException extends RuntimeException {

    public WeatherException(String message) {
        super(message);
    }

    public WeatherException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
