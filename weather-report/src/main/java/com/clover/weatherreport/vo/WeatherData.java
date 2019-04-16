package com.clover.weatherreport.vo;

import java.io.Serializable;
import java.util.List;

/**
 *  第三方天气数据返回的数据实体
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:44
 *  @version   1.0
 */
public class WeatherData implements Serializable {
    private City city;

    private List<Forecast> forecast;

    private Condition condition;
    //空气质量AQI
    private AQI aqi;

    public AQI getAqi() {
        return aqi;
    }

    public void setAqi(AQI aqi) {
        this.aqi = aqi;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
