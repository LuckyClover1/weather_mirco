package com.clover.base.weatherService;

import com.clover.base.config.Config;
import com.clover.base.entity.WeatherResponse;
import com.clover.base.util.HttpUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 *  天气数据服务
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:48
 *  @version   1.0
 */
@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

    private Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Config config;
    @Value("${redis.timeout}")
    private Long timeout;
    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getConditionPath(),param);
    }

    @Override
    public WeatherResponse getAqiWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getAqiPath(),param);
    }

    @Override
    public WeatherResponse getForcastWeatherByCityId(String cityId) {
        Map param = new HashMap<String,String>();
        param.put("cityId",cityId);
        return getWeather(config.getForcastPath(),param);
    }

    private WeatherResponse getWeather(String path, Map<String,String> param){
        String resultStr = "";
        try {
            String key = path + param.values().toString();
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            if(stringRedisTemplate.hasKey(key)){
                log.info("from redis");
                resultStr = ops.get(key);
            }else{
                log.info("from internet");
                String host = config.getHost();
                String method = config.getMethod();

                Map<String, String> headers = new HashMap<String, String>();
                //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
                headers.put("Authorization", "APPCODE " + config.getAppCode());
                //根据API的要求，定义相对应的Content-Type
                headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                Map<String, String> querys = new HashMap<String, String>();
                Map<String, String> bodys = new HashMap<String, String>();
                bodys.putAll(param);
                HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

                if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    resultStr = EntityUtils.toString(response.getEntity());
                }else{
                    throw new Exception("ERROR : " + response.getStatusLine().getStatusCode());
                }

            }
            if(StringUtils.isNotBlank(resultStr)){
                if(timeout < 0){
                    ops.set(key,resultStr);
                }else {
                    ops.set(key, resultStr, timeout, TimeUnit.SECONDS);
                }
                return new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                        .readValue(resultStr,WeatherResponse.class);
            }
        } catch (IOException e) {
            log.error("ERROR",e);
        } catch (Exception e) {
            log.error("get Weather from api fail !!",e);
        }
        return null;
    }


}
