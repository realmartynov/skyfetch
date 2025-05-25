package com.realmartynov.skyfetch.service;

public interface WeatherService {
    String getWeatherByCoordinateAndDate(String lon, String lat, String date);
}