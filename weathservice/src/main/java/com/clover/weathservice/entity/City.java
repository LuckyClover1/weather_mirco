package com.clover.weathservice.entity;

import java.io.Serializable;

/**
 *  天气数据中的城市信息
 *
 *  @author    Clover
 *  @date      2019/4/8 12:27
 *  @version   1.0
 */
public class City implements Serializable {
    private String cityId;
    private String counname;
    private String name;
    private String pname;
    private String ianatimezone;
    private String timezone;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCounname() {
        return counname;
    }

    public void setCounname(String counname) {
        this.counname = counname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getIanatimezone() {
        return ianatimezone;
    }

    public void setIanatimezone(String ianatimezone) {
        this.ianatimezone = ianatimezone;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
