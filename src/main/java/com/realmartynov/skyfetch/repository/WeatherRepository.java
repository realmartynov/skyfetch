package com.realmartynov.skyfetch.repository;

import com.realmartynov.skyfetch.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    Optional<WeatherEntity> findByCityIgnoreCaseAndDate(String city, LocalDate date);
}

