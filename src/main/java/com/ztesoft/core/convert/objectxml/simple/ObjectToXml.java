package com.ztesoft.core.convert.objectxml.simple;


import org.apache.commons.beanutils.BeanUtils;

import com.ztesoft.core.convert.Converter;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.util.XmlUtils;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectToXml<T> implements Converter<List<T>, String> {
	private boolean fieldAsAttribute;//属性是否当做xml属性
	private String rootNodeName;
	private String rowNodeName;

	public ObjectToXml(boolean fieldAsAttribute, String rootNodeName,
			String rowNodeName) {
		this.fieldAsAttribute = fieldAsAttribute;
		this.rootNodeName = rootNodeName;
		this.rowNodeName = rowNodeName;
	}

	public String convert(List<T> inputData) throws BaseAppException {
		StringBuilder sb = new StringBuilder();
		XmlUtils.appendHeader(sb, rootNodeName);
		if (inputData != null) {
			for (T object : inputData) {
				if (fieldAsAttribute) {
					sb.append("<");
					sb.append(rowNodeName);
					sb.append(" ");
					for (Field field : object.getClass().getDeclaredFields()) {
						Object value = getAttributeValue(object, field);
						if (value != null) {
							sb.append(" ");
							sb.append(field.getName());
							sb.append("=\"");
							sb.append(value.toString());
							sb.append("\"");
						}
					}
					sb.append("/>");
				} else {
					for (Field field : object.getClass().getDeclaredFields()) {
						Object value = getAttributeValue(object, field);
						if (value != null) {
							XmlUtils.appendHeader(sb, rowNodeName);
							sb.append(value.toString());
							XmlUtils.appendFooter(sb, rowNodeName);
						}
					}
				}
			}
		}
		XmlUtils.appendFooter(sb, rootNodeName);
		return sb.toString();
	}

    private String getAttributeValue(T object, Field field)
            throws BaseAppException {
		try {
			Object value = BeanUtils.getProperty(object, field.getName());
			if (value == null) {
				return "";
			}
			return value.toString();
		} catch (Exception e) {
		    throw ExceptionHandler.publish("APP-00-1005",
                    "对象转XML时发生异常！", e);
		}
	}
}
