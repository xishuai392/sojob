/**
 * 
 */
package com.ztesoft.core.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ztesoft.core.threadpool.GeneralThreadPool;
import com.ztesoft.core.threadpool.ThreadPoolFactory;
import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service <br>
 */
public class TestFutureTask {

    @Before
    public void setUp() {
        System.out.println("Before test...");
    }

    @After
    public void setDown() {
        System.out.println("After test...");
    }

    @Test
    public void testTaskByCallable() throws BaseAppException {
        String result = null;

        // ExecutorService executor = Executors.newSingleThreadExecutor();
        GeneralThreadPool executor = ThreadPoolFactory
                .createSingleThreadPool("Test Single ThreadPool");
        FutureTask<String> future = new FutureTask<String>(
                new Callable<String>() {// 使用Callable接口作为构造参数
                    public String call() {
                        // 真正的任务在这里执行，这里的返回值类型为String，可以为任意类型

                        try {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return "hello world!";
                    }
                });
        executor.execute(future);
        // 在这里可以做别的任何事情
        try {
            // 取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
            result = future.get(5000, TimeUnit.MILLISECONDS);
            System.out.println("result:" + result);
        }
        catch (Exception e) {
            e.printStackTrace();
            future.cancel(true);
        }
        finally {
            executor.shutdown();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
