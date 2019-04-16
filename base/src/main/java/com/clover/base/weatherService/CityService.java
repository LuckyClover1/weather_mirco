package com.clover.base.weatherService;

import com.clover.base.entity.CityVo;

import java.util.List;

public interface CityService {
    public List<CityVo> cityList();

    /**
     * 省城市列表
     * @param province 不需要包含省和自治区等后缀
     * @return
     */
    public List<CityVo> cityListOfProvince(String province);
}
