package com.kash.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WeatherApiResponse {
    private String name;
    private WeatherMainData main;
    private List<WeatherCondition> weather;

    // Getters and setters
}




