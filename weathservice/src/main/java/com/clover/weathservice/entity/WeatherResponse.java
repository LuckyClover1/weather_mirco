package com.clover.weathservice.entity;

import java.io.Serializable;

/**
 *  第三方天气接口返回的数据
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:45
 *  @version   1.0
 */
public class WeatherResponse implements Serializable {
    //状态码
    private String code;
    //天气数据
    private WeatherData data;
    //其他消息
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //    @Override
//    public WeatherResponse clone(){
//        try {
//            ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
//            ObjectOutputStream oout = new ObjectOutputStream(dataStream);
//            oout.writeObject(this);
//
//            ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(dataStream.toByteArray()));
//            return (WeatherResponse) oin.readObject();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }
}
