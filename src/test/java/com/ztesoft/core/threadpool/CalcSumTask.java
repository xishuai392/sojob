package com.ztesoft.core.threadpool;

import java.util.concurrent.Callable;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 求和计算测试类
 * 
 * @author wang.zhenying
 * 
 */
public class CalcSumTask implements Callable<Integer> {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(CalcSumTask.class);
    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        LOGGER.debug("子线程在进行计算");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        LOGGER.debug("子线程在计算完毕");
        return sum;
    }

}
