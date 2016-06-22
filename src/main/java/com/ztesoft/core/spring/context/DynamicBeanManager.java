/**
 * 
 */
package com.ztesoft.core.spring.context;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * <Description>动态刷新、注册Spring的Bean <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月5日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.spring.context <br>
 */

public class DynamicBeanManager {

    public synchronized void refreshAllBean() {
        ((ConfigurableApplicationContext) SpringApplicationContextHolder
                .getApplicationContext()).refresh();

    }

    public synchronized void refreshBeanByName(String beanName,
            String beanClassName) {
        XmlWebApplicationContext xmlWebApplicationContext = (XmlWebApplicationContext) ContextLoader
                .getCurrentWebApplicationContext();
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) xmlWebApplicationContext
                .getBeanFactory();
        BeanDefinition beanDefinition = defaultListableBeanFactory
                .getBeanDefinition(beanName);
        beanDefinition.setBeanClassName(beanClassName);
        defaultListableBeanFactory.registerBeanDefinition(beanName,
                beanDefinition);
    }
}
