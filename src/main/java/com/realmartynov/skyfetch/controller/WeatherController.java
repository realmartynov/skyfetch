package com.realmartynov.skyfetch.controller;

import com.realmartynov.skyfetch.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    // http://localhost:8080/weather?lon=129.000&lat=62.000&date=2025-05-25T12:00
    @GetMapping("/weather")
    public String getWeather(@RequestParam String lon, @RequestParam String lat, @RequestParam String date) {
        return weatherService.getWeatherByCoordinateAndDate(lon, lat, date);
    }
}
