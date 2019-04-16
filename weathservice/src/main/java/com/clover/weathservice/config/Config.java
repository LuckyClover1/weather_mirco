package com.clover.weathservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api")
@Component
public class Config {
    private String appCode;
    private String host;
    private String forcastPath;
    private String conditionPath;
    private String aqiPath;
    private String method;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getForcastPath() {
        return forcastPath;
    }

    public void setForcastPath(String forcastPath) {
        this.forcastPath = forcastPath;
    }

    public String getConditionPath() {
        return conditionPath;
    }

    public void setConditionPath(String conditionPath) {
        this.conditionPath = conditionPath;
    }

    public String getAqiPath() {
        return aqiPath;
    }

    public void setAqiPath(String aqiPath) {
        this.aqiPath = aqiPath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
