package com.ztesoft.core.convert.objectxml.xstream;

import com.thoughtworks.xstream.XStream;
import com.ztesoft.core.convert.Converter;

public class ObjectToXml<T> implements Converter<T, String> {
    private XStream xstream;

    public ObjectToXml() {
        xstream = new XStream();
        xstream.setMode(XStream.NO_REFERENCES);
    }

    public ObjectToXml(Class<T> rootClass) {
        this();
        xstream.processAnnotations(rootClass);
    }

    public String convert(T inputData) {
        return xstream.toXML(inputData);
    }

}
