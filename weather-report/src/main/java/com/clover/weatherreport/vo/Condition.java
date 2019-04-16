package com.clover.weatherreport.vo;

import java.util.Date;

/**
 *  天气情况
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:44
 *  @version   1.0
 */
public class Condition {
    //天气情况
    private String condition;
    //温度
    private String temp;
    //风向
    private String windDir;
    //风速
    private String windLevel;
    //湿度
    private String humidity;
    //发布时间
    private Date updateTime;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
