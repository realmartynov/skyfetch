package com.realmartynov.skyfetch.dto;

import lombok.Data;

@Data
public class WeatherDto {
    private String city;
    private double temperature;
    private String LastAccessDateTime;
}
