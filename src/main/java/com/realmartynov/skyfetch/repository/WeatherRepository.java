package com.realmartynov.skyfetch.repository;

import com.realmartynov.skyfetch.domain.Weather;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class WeatherRepository {

    public static final String FIND_BY_CITY = "SELECT city, temperature, created_at, updated_at, last_access_datetime FROM weather WHERE LOWER(city) = LOWER(?)";
    public static final String UPDATE_LAST_ACCESS = "UPDATE weather SET last_access_datetime = now() WHERE LOWER(city) = LOWER(?)";
    public static final String UPSERT = """
            INSERT INTO weather (city, temperature, created_at, updated_at, last_access_datetime)
            VALUES (?, ?, now(), now(), now())
            ON CONFLICT (city) DO UPDATE
            SET temperature = EXCLUDED.temperature,
                updated_at = now(),
                last_access_datetime = now()
            """;

    private final JdbcTemplate jdbc;

    public WeatherRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Weather> findByCity(String city) {
        return jdbc.query(FIND_BY_CITY, new Object[]{city}, (rs, rowNum) -> rowMap(rs))
                .stream()
                .findFirst()
                .map(w -> {
                    updateLastAccess(city);
                    return w;
                });
    }

    public void save(Weather weather) {
        jdbc.update(UPSERT, weather.getCity(), weather.getTemperature());
    }

    private void updateLastAccess(String city) {
        jdbc.update(UPDATE_LAST_ACCESS, city);
    }

    private Weather rowMap(ResultSet rs) throws SQLException {
        return new Weather(
                rs.getString("city"),
                rs.getDouble("temperature"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime(),
                rs.getTimestamp("last_access_datetime").toLocalDateTime()
        );
    }
}
