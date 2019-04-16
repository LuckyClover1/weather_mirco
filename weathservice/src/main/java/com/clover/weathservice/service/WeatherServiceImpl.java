package com.clover.weathservice.service;

import com.clover.weathservice.config.Config;
import com.clover.weathservice.entity.WeatherResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  天气数据服务
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:48
 *  @version   1.0
 */
@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

    private Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Config config;

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getConditionPath(),param);
    }

    @Override
    public WeatherResponse getAqiWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getAqiPath(),param);
    }

    @Override
    public WeatherResponse getForcastWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getForcastPath(),param);
    }

    private WeatherResponse getWeather(String path, Map<String,String> param){
        String resultStr = "";
        try {
            String key = path + param.values().toString();
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            if(stringRedisTemplate.hasKey(key)){
                log.info("from redis");
                resultStr = ops.get(key);
            }else{
                log.error("don't weather data !");
            }

            if(StringUtils.isNotBlank(resultStr)){
                return new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                        .readValue(resultStr,WeatherResponse.class);
            }
        } catch (IOException e) {
            log.error("ERROR",e);
        }
        return null;
    }


}
