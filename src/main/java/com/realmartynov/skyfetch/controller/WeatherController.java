package com.realmartynov.skyfetch.controller;

import com.realmartynov.skyfetch.domain.Weather;
import com.realmartynov.skyfetch.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String city) {
        Weather weather = service.getOrGenerateWeather(city);
        return ResponseEntity.ok(weather);
    }
}
