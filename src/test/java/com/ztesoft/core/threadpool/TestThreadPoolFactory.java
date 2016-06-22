package com.ztesoft.core.threadpool;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ztesoft.core.threadpool.GeneralThreadPool;
import com.ztesoft.core.threadpool.ThreadPoolFactory;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 测试线程池类
 * 
 * @author Administrator
 */
public class TestThreadPoolFactory {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestThreadPoolFactory.class);

    /**
     * 日志组件
     */
    public static List<String> threadNameList = null;

    /**
     * ExpectedException
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * 初始化函数
     */
    @Before
    public void before() {
        threadNameList = new ArrayList<String>();
    }

    /**
     * 1.测试单线程线程池
     */
    @Test
    public void testSingleThreadPool() {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory
                    .createSingleThreadPool("Test Single ThreadPool");
            for (int i = 0; i < 10; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();
            // 单线程线程池，线程名列表的数量应该为1
            // assertThat(threadNameList.size(), equalTo(1));
        }
        catch (Exception e) {
            LOGGER.error(e);
        }
    }

    /**
     * 2.测试固定线程线程池（不使用队列缓存）
     * 
     * @throws BaseAppException
     */
    @Test
    public void testFixedThreadPool1() throws BaseAppException {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory.createGeneralThreadPool(
                    "Test Fixed ThreadPool", 5);
            for (int i = 0; i < 10; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();

            LOGGER.debug("threadNameListSize = ", threadNameList.size());

            // 固定线程大小，不使用固定缓存，抛弃策略默认为执行线程本身run函数，必定大于等于5
            // assertTrue(threadNameList.size() >= 5);
        }
        catch (Exception e) {
            LOGGER.error(e);
        }

    }

    /**
     * 2.测试固定线程线程池（使用有界队列,队列小于线程数）
     * 
     * @throws BaseAppException
     */
    @Test
    public void testFixedThreadPool2() throws BaseAppException {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory
                    .createGeneralBoundedThreadPool("Test Fixed ThreadPool", 5,
                            5);
            for (int i = 0; i < 100; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();

            LOGGER.debug("threadNameListSize = ", threadNameList.size());

            // 固定线程大小，使用固定缓存未用满，抛弃策略默认为执行线程本身run函数，必定等于5
            // assertThat(threadNameList.size(), equalTo(5));
        }
        catch (Exception e) {
            LOGGER.error(e);
        }

    }

    /**
     * 2.测试固定线程线程池（使用有界队列，队列等于线程数）
     * 
     * @throws BaseAppException
     */
    @Test
    public void testFixedThreadPool3() throws BaseAppException {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory
                    .createGeneralBoundedThreadPool("Test Fixed ThreadPool", 5,
                            100);
            for (int i = 0; i < 100; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();

            LOGGER.debug("threadNameListSize = ", threadNameList.size());

            // 固定线程大小，使用固定缓存未用满，抛弃策略默认为执行线程本身run函数，必定等于5
            // assertThat(threadNameList.size(), equalTo(5));
        }
        catch (Exception e) {
            LOGGER.error(e);
        }

    }

    /**
     * 2.测试固定线程线程池（使用有界队列，队列大于线程数）
     * 
     * @throws BaseAppException
     */
    @Test
    public void testFixedThreadPool4() throws BaseAppException {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory
                    .createGeneralBoundedThreadPool("Test Fixed ThreadPool", 5,
                            200);
            for (int i = 0; i < 100; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();

            LOGGER.debug("threadNameListSize = ", threadNameList.size());

            // 固定线程大小，使用固定缓存未用满，抛弃策略默认为执行线程本身run函数，必定等于5
            // assertThat(threadNameList.size(), equalTo(5));
        }
        catch (Exception e) {
            LOGGER.error(e);
        }

    }

    /**
     * 3.测试固定线程线程池（使用无界队列）
     * 
     * @throws BaseAppException
     */
    @Test
    public void testFixednUnBoundedThreadPool() throws BaseAppException {
        try {
            threadNameList.clear();
            GeneralThreadPool gtp = ThreadPoolFactory
                    .createGeneralUnboundedThreadPool("Test Fixed ThreadPool",
                            5);
            for (int i = 0; i < 100; i++) {
                String name = "index[" + i + "]";
                TaskExecutor ste = new TaskExecutor(null);
                ste.setName(name);
                gtp.execute(ste);
            }
            gtp.shutdown();

            LOGGER.debug("threadNameListSize = ", threadNameList.size());

            // 固定线程大小，使用无界队列，抛弃策略默认为执行线程本身run函数，必定等于5
            // assertThat(threadNameList.size(), equalTo(5));
        }
        catch (Exception e) {
            LOGGER.error(e);
        }

    }
}
