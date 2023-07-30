package com.kash.weatherapp.service;

import com.kash.weatherapp.dto.Response;

public interface WeatherService {
    Response getWeather(String location);

}
