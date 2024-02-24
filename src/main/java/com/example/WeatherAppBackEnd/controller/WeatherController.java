package com.example.WeatherAppBackEnd.controller;

import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;
import com.example.WeatherAppBackEnd.service.interf.WeatherService;
import com.example.WeatherAppBackEnd.service.interf.WeatherServiceRedis;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherServiceRedis weatherServiceRedis;


    @GetMapping("/getLocation")
    public ResponseEntity<ResponseWeatherData> getInformationByLocation(@RequestParam String location) throws JsonProcessingException {
        try {
            ResponseWeatherData dataRedis = weatherServiceRedis.getInformationRedisByLocation(location, location);
            if(dataRedis == null){
                ResponseWeatherData data = weatherService.getInformationByLocation(location);
                weatherServiceRedis.saveData(data, location);
                return ResponseEntity.ok(data);
            }
            return ResponseEntity.ok(dataRedis);
        }catch (Exception e){
            throw e;
        }
    }

}
