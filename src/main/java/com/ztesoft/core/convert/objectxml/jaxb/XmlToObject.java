package com.ztesoft.core.convert.objectxml.jaxb;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.ztesoft.core.convert.Converter;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;

/**
 * <Description>xml转对象<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.convert.objectxml.jaxb <br>
 */
public class XmlToObject<T> implements Converter<String, T> {
    private String encode = "UTF-8";

    private JAXBContext context;

    private Unmarshaller unmarshaller;

    public XmlToObject(String className, String encode) throws BaseAppException {
        this(className);
        this.encode = encode;
    }

    public XmlToObject(String className) throws BaseAppException {
        try {
            context = JAXBContext.newInstance(className);
            unmarshaller = context.createUnmarshaller();
        }
        catch (Exception e) {
            throw ExceptionHandler.publish("APP-00-1003",
                    "构建JAXB XML数据反序列化器时发生异常！", e);
        }
    }

    public XmlToObject(Class<T> clazz) throws BaseAppException {
        try {
            context = JAXBContext.newInstance(clazz);
            unmarshaller = context.createUnmarshaller();
        }
        catch (Exception e) {
            throw ExceptionHandler.publish("APP-00-1003",
                    "构建JAXB XML数据反序列化器时发生异常！", e);
        }
    }

    @SuppressWarnings("unchecked")
    public T convert(String inputData) throws BaseAppException {

        try {
            return (T) unmarshaller.unmarshal(new ByteArrayInputStream(
                    inputData.getBytes(encode)));
        }
        catch (Exception e) {
            throw ExceptionHandler.publish("APP-00-1004",
                    "利用JAXB将XML转对象时发生异常！", e);

        }
    }
}
