package com.realmartynov.skyfetch.service;

import com.realmartynov.skyfetch.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getOrGenerateWeather(String city);
}