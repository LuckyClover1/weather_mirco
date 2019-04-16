package com.clover.base.job;

import com.clover.base.entity.CityVo;
import com.clover.base.weatherService.CityService;
import com.clover.base.weatherService.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

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
public class WeatherJob{
    private Logger logger = LoggerFactory.getLogger(WeatherJob.class);
    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;
    @Value("${weather.job.province}")
    private String province;
    @Scheduled(cron = "${weather.job.cron}")
    public void weatherData(){
        logger.info("weather job start.");
        List<CityVo> cityVoList = cityService.cityListOfProvince(province);
        for (CityVo city : cityVoList){
            weatherService.getForcastWeatherByCityId(city.getCityId());
            weatherService.getAqiWeatherByCityId(city.getCityId());
            weatherService.getWeatherByCityId(city.getCityId());
        }
        logger.info("weather job end.");
    }

}
