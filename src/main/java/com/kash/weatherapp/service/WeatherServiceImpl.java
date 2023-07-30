package com.kash.weatherapp.service;

import com.kash.weatherapp.constant.WeatherResponseConstant;
import com.kash.weatherapp.dto.Response;
import com.kash.weatherapp.dto.Weather;
import com.kash.weatherapp.dto.WeatherApiResponse;
import com.kash.weatherapp.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private final String weatherApiKey;
    private final String weatherApiBaseUrl;
    private final Response response;

    public WeatherServiceImpl(
            @Value("${WEATHER_API_KEY}") String weatherApiKey,
            @Value("${WEATHER_API_BASE_URL}") String weatherApiBaseUrl
    ) {
        this.restTemplate = new RestTemplate();
        this.weatherApiKey = weatherApiKey;
        this.weatherApiBaseUrl = weatherApiBaseUrl;
        this.response = new Response();
    }


    @Override
    public Response getWeather(String location) {


        try {
            log.info("=>> WeatherServiceImpl:: Inside getWeather Method<<=");

            // Make an API request to the weather API using the provided location and API key
            String apiUrl = weatherApiBaseUrl + "/weather?q=" + location + "&appid=" + weatherApiKey;


            // Here we can call the RestAPI:
            ResponseEntity<WeatherApiResponse> weatherApiResponse = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    WeatherApiResponse.class
            );

            // Extract the relevant weather data from the API response and create a Weather
            WeatherApiResponse apiResponse = weatherApiResponse.getBody();
            Weather weather = new Weather();

            assert apiResponse != null;
            weather.setLocation(apiResponse.getName());
            weather.setTemperature(apiResponse.getMain().getTemp());
            weather.setHumidity(apiResponse.getMain().getHumidity());
            weather.setWeatherCondition(apiResponse.getWeather().get(0).getDescription());



            /*----Simply Return The Response----*/
            response.setStatus(WeatherResponseConstant.SUCCESS_STATUS);
            response.setStatusCode(WeatherResponseConstant.STATUS_CODE);
            response.setMessage("Successfully Fetch the Weather Update!!");
            response.setData(weather);

            return response;
        }catch(Exception e){
            throw new WeatherException("Some Thing Goes Wrong!!");
        }
    }

}
