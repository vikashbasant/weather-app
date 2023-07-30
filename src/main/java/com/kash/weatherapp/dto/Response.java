package com.kash.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kash.weatherapp.constant.WeatherResponseConstant;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String status;
    private String statusCode;
    private String message;
    private transient Object data;

    private transient Object errorMessage;
    private String successRule;
    @JsonProperty("response_message")
    private String responseMessage = WeatherResponseConstant.RESPONSE_MESSAGE;
    @JsonProperty("response_type")
    private String responseType;

}