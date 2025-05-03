package com.realmartynov.skyfetch.service.impl;

import com.realmartynov.skyfetch.service.WeatherService;
import org.springframework.stereotype.Service;
import com.realmartynov.skyfetch.domain.Weather;
import com.realmartynov.skyfetch.exception.InvalidCityNameException;
import com.realmartynov.skyfetch.repository.WeatherRepository;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    public Weather getOrGenerateWeather(String city) {
        validateCity(city);

        Optional<Weather> existing = repository.findByCity(city);
        if (existing.isPresent())
            return existing.get();

        double temperature = generateRandomTemp();
        Weather newWeather = new Weather(city, temperature);
        repository.save(newWeather);
        return newWeather;
    }

    private void validateCity(String city) {
        if (!city.matches("^[А-Яа-яЁё\\-\\s]+$"))
            throw new InvalidCityNameException();
    }

    private double generateRandomTemp() {
        return Math.random() * 200 - 100;
    }
}
