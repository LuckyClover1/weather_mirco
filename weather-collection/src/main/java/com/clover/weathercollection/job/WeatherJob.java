package com.clover.weathercollection.job;

import com.clover.weathercollection.entity.CityVo;
import com.clover.weathercollection.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

/**
 *  定时获取天气数据任务
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:46
 *  @version   1.0
 */
@Configuration
@EnableScheduling
public class WeatherJob {
    private Logger logger = LoggerFactory.getLogger(WeatherJob.class);
//    @Autowired
//    private CityService cityService;
    @Autowired
    private WeatherService weatherService;

    @Scheduled(cron = "${weather.job.cron}")
    public void weatherData(){
        logger.info("weather job start.");
        //todo 城市服务
        List<CityVo> cityVoList = new ArrayList<>();
        for (CityVo city : cityVoList){
            weatherService.getForcastWeatherByCityId(city.getCityId());
            weatherService.getAqiWeatherByCityId(city.getCityId());
            weatherService.getWeatherByCityId(city.getCityId());
        }
        logger.info("weather job end.");
    }

}
