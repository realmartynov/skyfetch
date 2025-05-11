package com.realmartynov.skyfetch.controller;

import com.realmartynov.skyfetch.dto.WeatherDto;
import com.realmartynov.skyfetch.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherDto getWeatherByCity(@PathVariable String city) {
        return weatherService.getOrGenerateWeather(city);
    }
}
