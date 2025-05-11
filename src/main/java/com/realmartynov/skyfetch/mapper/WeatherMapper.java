package com.realmartynov.skyfetch.mapper;

import com.realmartynov.skyfetch.dto.WeatherDto;
import com.realmartynov.skyfetch.entity.WeatherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    @Mapping(source = "lastAccessDatetime", target = "lastAccessDateTime")
    WeatherDto toDto(WeatherEntity entity);

}
