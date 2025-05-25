package com.realmartynov.skyfetch.service.impl;

import com.realmartynov.skyfetch.exception.InvalidCityNameException;
import com.realmartynov.skyfetch.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final RestClient eolRestClient;

    @Value("${app.cred.token}")
    private String token;

    @Override
    public String getWeatherByCoordinateAndDate(String lon, String lat, String date) {
        return eolRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/weather/")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("date", date)
                        .queryParam("token", token)
                        .build())
                .retrieve()
                .body(String.class);
    }


    private void validateCity(String city) {
        if (!city.matches("^[А-Яа-яЁё\\-\\s]+$"))
            throw new InvalidCityNameException();
    }
}
