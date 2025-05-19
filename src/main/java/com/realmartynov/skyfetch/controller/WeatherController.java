package com.realmartynov.skyfetch.controller;

import com.realmartynov.skyfetch.dto.WeatherDto;
import com.realmartynov.skyfetch.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherDto getWeatherByCity(@PathVariable String city) {
        return weatherService.getOrGenerateWeather(city);
    }
}
