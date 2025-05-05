package com.realmartynov.skyfetch.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String city;
    private double temperature;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastAccessDatetime;

    public Weather(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }
}
