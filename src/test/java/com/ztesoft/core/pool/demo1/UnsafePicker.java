/**
 * 
 */
package com.ztesoft.core.pool.demo1;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.StackObjectPool;

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

public class UnsafePicker extends Thread {
    private ObjectPool pool;

    public UnsafePicker(ObjectPool op) {
        pool = op;
    }

    public void run() {
        Object obj = null;
        try {
            /* 似乎…… */
            if (pool.getNumActive() < 5) {
                sleep((long) (Math.random() * 10));
                obj = pool.borrowObject();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ObjectPool pool = new StackObjectPool(
                new BasePoolableObjectFactorySample());
        Thread ts[] = new Thread[20];
        for (int j = 0; j < ts.length; j++) {
            ts[j] = new UnsafePicker(pool);
            ts[j].start();
        }
        try {
            Thread.sleep(1000);
            /* 然而…… */
            System.out.println("NumActive:" + pool.getNumActive());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
