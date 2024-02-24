package com.example.WeatherAppBackEnd.dao;

import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherMapper {
    ResponseWeatherData getInformationByLocation(String location);

}
