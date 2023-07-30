package com.kash.weatherapp.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Weather {
    private String location;
    private double temperature;
    private int humidity;
    private String weatherCondition;

    // Getters and setters
}
