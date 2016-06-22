package com.ztesoft.core.threadpool;

import com.ztesoft.core.threadpool.SimpleTaskExecutor;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 线程测试类
 * 
 * @author wang.zhenying
 * 
 */
public class TaskExecutor extends SimpleTaskExecutor {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TaskExecutor.class);
    /**
     * 数字
     */
    private int number = 0;
    /**
     * 名字
     */
    private String name = null;

    /**
     * 构造函数
     * 
     * @param param
     *            对象参数
     */
    protected TaskExecutor(Object param) {
        super(param);
        // TODO Auto-generated constructor stub
    }

    /**
     * 执行任务
     * 
     * @param param
     *            执行参数
     * @return 返回值
     */
    public int doWork(Object param) {
        // TODO Auto-generated method stub
        try {
            LOGGER.debug("Thead [" + Thread.currentThread().getName()
                    + "] is executing[name:" + name + "]");
            countThead(Thread.currentThread().getName());
        } 
        catch (Exception ex) {
            LOGGER.error(ex);
            return -1;
        }
        return 0;
    }

    /**
     * 计数线程名
     * @param threadName 线程名
     */
    public void countThead(String threadName) {
        synchronized (TestThreadPoolFactory.threadNameList) {
            if (!TestThreadPoolFactory.threadNameList.contains(threadName)) {
                TestThreadPoolFactory.threadNameList.add(threadName);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
