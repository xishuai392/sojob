/**
 * 
 */
package com.ztesoft.core.pool.demo1;

import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月21日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.pool.demo1 <br>
 */

public class BasePoolableObjectFactorySample extends
        BasePoolableObjectFactory<String> {

    /*
     * (non-Javadoc)
     * @see org.apache.commons.pool.BasePoolableObjectFactory#makeObject()
     */
    @Override
    public  String makeObject() throws Exception {
        return String.valueOf(Math.random());
    }
}
