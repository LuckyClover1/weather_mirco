package com.clover.base;

import com.clover.base.entity.WeatherResponse;
import com.clover.base.weatherService.WeatherServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private WeatherServiceImpl weatherServiceImpl;
    @Test
    public void testGetWeather(){

        Set<String> keys = stringRedisTemplate.keys("*");

        for(String key :keys){
//            stringRedisTemplate.expire(key,-1,TimeUnit.SECONDS);
            stringRedisTemplate.persist(key);
        }
//        WeatherResponse weatherResponse = weatherServiceImpl.getForcastWeatherByCityId("2");
//        System.out.println(weatherResponse.getCode());
//        String test = "{\"code\":0,\"data\":{\"city\":{\"cityId\":2,\"counname\":\"中国\",\"ianatimezone\":\"Asia\\/Shanghai\",\"name\":\"北京市\",\"pname\":\"北京市\",\"timezone\":\"8\"},\"forecast\":[{\"conditionDay\":\"晴\",\"conditionIdDay\":\"0\",\"conditionIdNight\":\"31\",\"conditionNight\":\"多云\",\"predictDate\":\"2019-04-01\",\"tempDay\":\"16\",\"tempNight\":\"1\",\"updatetime\":\"2019-04-01 21:05:00\",\"windDegreesDay\":\"180\",\"windDegreesNight\":\"180\",\"windDirDay\":\"南风\",\"windDirNight\":\"南风\",\"windLevelDay\":\"3\",\"windLevelNight\":\"3\"}]}}";
//        try {
//            WeatherResponse we = new ObjectMapper().readValue(test,WeatherResponse.class);
//            System.out.println(we);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
