package com.clover.weathercollection.entity;

/**
 *  城市列表文件对应的城市实体
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:43
 *  @version   1.0
 */
public class CityVo {
    private String cityId;
    private String name;
    private String name_en;
    private String name_py;
    private String province_cn;
    private String weathercn;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_py() {
        return name_py;
    }

    public void setName_py(String name_py) {
        this.name_py = name_py;
    }

    public String getProvince_cn() {
        return province_cn;
    }

    public void setProvince_cn(String province_cn) {
        this.province_cn = province_cn;
    }

    public String getWeathercn() {
        return weathercn;
    }

    public void setWeathercn(String weathercn) {
        this.weathercn = weathercn;
    }
}
