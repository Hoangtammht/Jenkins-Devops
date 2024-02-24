package com.example.WeatherAppBackEnd.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWeatherData {
    private int weather_id;
    private String weather_name;
    private String location;
    private int min;
    private int max;
    private int temp;
    private String code;
}
