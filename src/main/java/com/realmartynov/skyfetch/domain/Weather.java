package com.realmartynov.skyfetch.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Weather {
    private final String city;
    private double temperature;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastAccessDatetime;

    public Weather(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public Weather(String city, double temperature, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastAccessDatetime) {
        this.city = city;
        this.temperature = temperature;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastAccessDatetime = lastAccessDatetime;
    }
}
