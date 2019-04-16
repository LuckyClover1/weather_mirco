package com.clover.cityserver.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *  城市列表读取实体
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:43
 *  @version   1.0
 */
@XmlRootElement(name = "RECORDS")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "RECORD")
    private List<CityVo> cityList;

    public List<CityVo> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityVo> cityList) {
        this.cityList = cityList;
    }
}
