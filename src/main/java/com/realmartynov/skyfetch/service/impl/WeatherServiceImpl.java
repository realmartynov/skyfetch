package com.realmartynov.skyfetch.service.impl;

import com.realmartynov.skyfetch.dto.WeatherDto;
import com.realmartynov.skyfetch.entity.WeatherEntity;
import com.realmartynov.skyfetch.mapper.WeatherMapper;
import com.realmartynov.skyfetch.service.WeatherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.realmartynov.skyfetch.exception.InvalidCityNameException;
import com.realmartynov.skyfetch.repository.WeatherRepository;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;
    private final WeatherMapper mapper;

    @Override
    @Transactional
    public WeatherDto getOrGenerateWeather(String city) {
        validateCity(city);

        WeatherEntity entity = repository.findByCityIgnoreCase(city)
                .map(existing -> {
                    existing.setLastAccessDatetime(LocalDateTime.now());
                    return repository.save(existing);
                })
                .orElseGet(() -> {
                    WeatherEntity newEntity = WeatherEntity.builder()
                            .city(city)
                            .temperature(generateRandomTemp())
                            .lastAccessDatetime(LocalDateTime.now())
                            .build();
                    return repository.save(newEntity);
                });

        return mapper.toDto(entity);
    }

    private void validateCity(String city) {
        if (!city.matches("^[А-Яа-яЁё\\-\\s]+$"))
            throw new InvalidCityNameException();
    }

    private double generateRandomTemp() {
        return Math.random() * 200 - 100;
    }
}
