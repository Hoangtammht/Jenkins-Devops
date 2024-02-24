package com.example.WeatherAppBackEnd.service.impl;

import com.example.WeatherAppBackEnd.domain.ResponseWeatherData;
import com.example.WeatherAppBackEnd.service.interf.WeatherServiceRedis;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceRedisImpl implements WeatherServiceRedis {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper redisObjectMapper;

    private String getKeyFrom(String keyword, String data) {
        String key = String.format("getLocation:%s", data);
        return key;
    }

    @Override
    public void clear() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

    @Override
    public ResponseWeatherData getInformationRedisByLocation(String keyword, String name) throws JsonProcessingException {
        String key = this.getKeyFrom(keyword, name);
        String json = (String) redisTemplate.opsForValue().get(key);
        ResponseWeatherData responseWeatherData =
                json != null ?
                        redisObjectMapper.readValue(json, new TypeReference<ResponseWeatherData>() {
                        }) : null;
        return responseWeatherData;
    }

    @Override
    //save to redis
    public void saveData(ResponseWeatherData responseWeatherData, String keyword) throws JsonProcessingException {
        String key = this.getKeyFrom(keyword, responseWeatherData.getLocation());
        String json = redisObjectMapper.writeValueAsString(responseWeatherData);
        redisTemplate.opsForValue().set(key, json);
    }

}
