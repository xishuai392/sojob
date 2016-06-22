/**
 * 
 */
package com.ztesoft.core.threadpool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * <Description>使用Condition<br>
 * 要打印1到9这9个数字，由A线程先打印1，2，3，<br>
 * 然后由B线程打印4,5,6，然后再由A线程打印7，8，9<br>
 * <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.threadpool <br>
 */

public class TestLockCondition {
    static class NumberWrapper {
        public int value = 1;
    }

    // 初始化可重入锁
    final Lock lock = new ReentrantLock();

    // 第一个条件当屏幕上输出到3
    final Condition reachThreeCondition = lock.newCondition();

    // 第二个条件当屏幕上输出到6
    final Condition reachSixCondition = lock.newCondition();

    // NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
    // 注意这里不要用Integer, Integer 是不可变对象
    final NumberWrapper num = new NumberWrapper();

    class RunnableA implements Runnable {

        /*
         * (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            System.out.println("threadA running...");

            // 需要先获得锁
            lock.lock();
            try {
                System.out.println("threadA start write");

                // A线程先输出前3个数
                while (num.value < 4) {
                    System.out.println(num.value);
                    num.value++;
                }
                // 输出到3时要signal，告诉B线程可以开始了
                reachThreeCondition.signal();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }


            lock.lock();
            try {
                // 等待输出6的条件
                while (num.value < 7) {
                    reachSixCondition.await();
                }
                System.out.println("threadA start write");
                // 输出剩余数字
                while (num.value < 10) {
                    System.out.println(num.value);
                    num.value++;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

            System.out.println("threadA stop...");
        }
    }

    class RunnableB implements Runnable {
        /*
         * (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            System.out.println("threadB running...");
            try {
                lock.lock();

                while (num.value < 4) {
                    // 等待3输出完毕的信号
                    reachThreeCondition.await();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

            try {
                lock.lock();
                // 已经收到信号，开始输出4，5，6
                System.out.println("threadB start write");
                while (num.value < 7) {
                    System.out.println(num.value);
                    num.value++;
                }
                // 4，5，6输出完毕，告诉A线程6输出完了
                reachSixCondition.signal();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

            System.out.println("threadB stop...");
        }
    }

    @Test
    public void testPrint() {
        System.out.println("start ...");
        Thread threadA = new Thread(new RunnableA());
        Thread threadB = new Thread(new RunnableB());

        // 启动两个线程
        threadB.start();
        threadA.start();
    }
}
