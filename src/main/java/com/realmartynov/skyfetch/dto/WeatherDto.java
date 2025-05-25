package com.realmartynov.skyfetch.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WeatherDto {
    private String city;
    private double temperature;
    private LocalDate date; // дата прогноза
}
