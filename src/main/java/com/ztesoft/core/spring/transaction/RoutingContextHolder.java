/**
 * 
 */
package com.ztesoft.core.spring.transaction;

import org.springframework.util.Assert;

/**
 * <Description>存储指定的事务管理器，一个连接池对应一个名字 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月5日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.spring.transaction <br>
 */

public class RoutingContextHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal();

    public static <T> void setContext(T context) {
        Assert.notNull(context, "必须指定路由的context");
        contextHolder.set(context);
    }

    public static <T> T getContext() {
        return (T) contextHolder.get();
    }
}
