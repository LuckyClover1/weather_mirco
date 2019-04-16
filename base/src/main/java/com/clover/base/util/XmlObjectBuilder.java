package com.clover.base.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
/**
 *  解析XMl文件数据为java实体工具类
 *
 *  @Author    Clover
 *  @date      2019/4/8 12:47
 *  @version   1.0
 */
public class XmlObjectBuilder {
    public static Object xmltoObject(Class<?> clazz,String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        Object object = unmarshaller.unmarshal(sr);
        sr.close();
        return object;
    }
}
