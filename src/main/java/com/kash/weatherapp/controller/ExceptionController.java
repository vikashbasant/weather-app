package com.kash.weatherapp.controller;

import com.kash.weatherapp.constant.WeatherResponseConstant;
import com.kash.weatherapp.dto.Response;
import com.kash.weatherapp.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.lang.reflect.Type;

@RestControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler implements RequestBodyAdvice {

    // => Invoked first to determine if this interceptor applies:
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    // => Invoked second before the request body is read and converted:
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    // => Invoked third (and last) after the request body is converted to an Object:
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    // => Invoked second (and last) if the body is empty:
    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        
        return body;
    }

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<Object> handledWeatherException(WeatherException ex) {

        log.info("=>> ExceptionController:: Inside handleWeatherException Method<<=");
        String message = ex.getMessage();
        return new ResponseEntity<>(getResponse(message, "WAPP_400"), HttpStatus.BAD_REQUEST);

    }



    // => Handle The Custom RuntimeException Exception:
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> runtimeException (RuntimeException ex) {

        log.info("===: ExceptionController:: Inside runtimeException Method :===");
        String message = ex.getMessage();
        return new ResponseEntity<>(getResponse(message, "WAPP_500"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // => Handle The Custom Exception:
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException (final Exception ex) {

        log.info("===: ExceptionController:: Inside handleAllException Method :===");
        ex.printStackTrace();
        return ResponseEntity.ok().body(getResponse(ex.getMessage(), "WAPP_500"));

    }


    // => Template to send Http Response to a client:
    private Response getResponse (String message, String code) {
        Response response = new Response();
        response.setStatus(WeatherResponseConstant.FAILURE_STATUS);
        response.setErrorMessage(message);
        response.setStatusCode(code);
        response.setResponseType(WeatherResponseConstant.RESPONSE_TYPE);
        return response;
    }
}
