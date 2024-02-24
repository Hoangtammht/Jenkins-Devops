package com.example.WeatherAppBackEnd.service.impl;

import com.example.WeatherAppBackEnd.dao.WeatherMapper;
import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;
import com.example.WeatherAppBackEnd.service.interf.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherMapper weatherMapper;

    @Override
    public ResponseWeatherData getInformationByLocation(String name) {
        return weatherMapper.getInformationByLocation(name);
    }
}
