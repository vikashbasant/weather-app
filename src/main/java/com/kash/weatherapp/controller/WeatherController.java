package com.kash.weatherapp.controller;

import com.kash.weatherapp.dto.Response;
import com.kash.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;


    @GetMapping("/weather")
    public ResponseEntity<Response> getWeather(@RequestParam("location") String location) {
        Response response = weatherService.getWeather(location);
        return ResponseEntity.ok(response);
    }
}
