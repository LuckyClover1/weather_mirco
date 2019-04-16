package com.clover.cityserver.service;

import com.clover.cityserver.entity.CityList;
import com.clover.cityserver.entity.CityVo;
import com.clover.cityserver.utils.XmlObjectBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  城市数据服务
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:48
 *  @version   1.0
 */
@Service("cityService")
public class CityServiceImpl implements CityService {
    @Override
    public List<CityVo> cityList() {
        CityList cityList = new CityList();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new ClassPathResource("cityId.xml").getInputStream(),"UTF-8"));
            String line="";
            StringBuffer sb = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();

            cityList = (CityList) XmlObjectBuilder.xmltoObject(CityList.class,sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return cityList.getCityList();
    }

    @Override
    public List<CityVo> cityListOfProvince(String province) {
        province = province.replaceAll("省","")
                            .replaceAll("市","")
                            .replaceAll("自治区","");
//        List<CityVo> cityList = cityList();
        List<CityVo> provinceCityList = new ArrayList<>();

//        for (CityVo city : cityList){
//            if (city.getProvince_cn().indexOf(province) >= 0 ){
//                provinceCityList.add(city);
//            }
//        }
        CityVo cityVo = new CityVo();
        cityVo.setCityId("898");
        cityVo.setName("金湾区");
        provinceCityList.add(cityVo);

        cityVo = new CityVo();
        cityVo.setCityId("911");
        cityVo.setName("翁源县");
        provinceCityList.add(cityVo);

        return provinceCityList;
    }
}
