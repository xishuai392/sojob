/**
 * 
 */
package com.ztesoft.core.pool;

import org.apache.commons.pool.KeyedObjectPool;
import org.apache.commons.pool.impl.StackKeyedObjectPool;

import com.jcraft.jsch.Session;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.pool <br>
 */

public class StackSessionPool {
    private KeyedObjectPool<ServerDetails, Session> pool;

    private static class SingletonHolder {
        public static final StackSessionPool INSTANCE = new StackSessionPool();
    }

    public static StackSessionPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private StackSessionPool() {
        startPool();
    }

    /**
     * @return the org.apache.commons.pool.KeyedObjectPool class
     */
    public KeyedObjectPool<ServerDetails, Session> getPool() {
        return pool;
    }

    /**
     * @return the org.apache.commons.pool.KeyedObjectPool class
     */
    public void startPool() {
        pool = new StackKeyedObjectPool<ServerDetails, Session>(
                new SessionFactory(), 10);
    }
}
