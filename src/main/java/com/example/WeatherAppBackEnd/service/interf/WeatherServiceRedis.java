package com.example.WeatherAppBackEnd.service.interf;

import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherServiceRedis {

    void clear();

    ResponseWeatherData getInformationRedisByLocation(String keyword, String name) throws JsonProcessingException;

    void saveData(ResponseWeatherData responseWeatherData, String keyword) throws JsonProcessingException;

}
