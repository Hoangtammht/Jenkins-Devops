package com.example.WeatherAppBackEnd.service.interf;

import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;

public interface WeatherService {

    ResponseWeatherData getInformationByLocation(String name);

}
