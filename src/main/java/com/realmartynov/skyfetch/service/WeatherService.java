package com.realmartynov.skyfetch.service;

import com.realmartynov.skyfetch.domain.Weather;

public interface WeatherService {
    Weather getOrGenerateWeather(String city);
}