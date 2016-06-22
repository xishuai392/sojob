package com.ztesoft.core.convert.objectxml.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ztesoft.core.convert.Converter;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;

/**
 * <Description> 对象转XML<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.convert.objectxml.jaxb <br>
 */
public class ObjectToXml<T> implements Converter<T, String> {
    private JAXBContext context;

    private boolean format;

    private Marshaller marshaller;

    public ObjectToXml(String className, boolean format)
            throws BaseAppException {
        try {
            context = JAXBContext.newInstance(className);
            marshaller = context.createMarshaller();
            this.format = format;
        }
        catch (JAXBException e) {
            throw ExceptionHandler.publish("APP-00-1001",
                    "构建JAXB XML数据序列化器时发生异常！", e);
        }
    }

    public ObjectToXml(Class<T> clazz, boolean format) throws BaseAppException {
        try {
            context = JAXBContext.newInstance(clazz);
            marshaller = context.createMarshaller();
            this.format = format;
        }
        catch (JAXBException e) {
            throw ExceptionHandler.publish("APP-00-1001",
                    "构建JAXB XML数据序列化器时发生异常！", e);
        }
    }

    public String convert(T inputData) throws BaseAppException {

        StringWriter writer = new StringWriter();

        try {
            if (format) {
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                        Boolean.TRUE);
            }
            marshaller.marshal(inputData, writer);

        }
        catch (Exception e) {
            throw ExceptionHandler.publish("APP-00-1002",
                    "利用JAXB将对象转XML时发生异常！", e);
        }
        return writer.toString();
    }

}
