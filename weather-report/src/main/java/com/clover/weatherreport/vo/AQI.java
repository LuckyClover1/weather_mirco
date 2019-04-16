package com.clover.weatherreport.vo;

/**
 *  空气质量指数
 *
 *  @author    Clover
 *  @date      2019/4/8 12:30
 *  @version   1.0
 */
public class AQI {
    private String cityName;
    private String pubtime;
    private String value;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
