/**
 * 
 */
package com.ztesoft.core.threadpool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description>假定有一个绑定的缓冲区，它支持 put 和 take 方法。如果试图在空的缓冲区上执行 take 操作，则在某一个项变得可用之前，线程将一直阻塞；如果试图在满的缓冲区上执行 put 操作，则在有空间变得可用之前，线程将一直阻塞。我们喜欢在单独的等待 set
 * 中保存put 线程和take 线程，这样就可以在缓冲区中的项或空间变得可用时利用最佳规划，一次只通知一个线程。可以使用两个Condition 实例来做到这一点。 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月7日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.threadpool <br>
 */

public class BoundedBuffer {
    final Lock lock = new ReentrantLock(); // 锁对象

    final Condition notFull = lock.newCondition(); // 写线程锁

    final Condition notEmpty = lock.newCondition(); // 读线程锁

    final Object[] items = new Object[100];// 缓存队列

    int putptr; // 写索引

    int takeptr; // 读索引

    int count; // 队列中数据数目

    // 写
    public void put(Object x) throws InterruptedException {
        lock.lock(); // 锁定
        try {
            // 如果队列满，则阻塞<写线程>
            while (count == items.length) {
                notFull.await();
            }
            // 写入队列，并更新写索引
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;

            // 唤醒<读线程>
            notEmpty.signal();
        }
        finally {
            lock.unlock();// 解除锁定
        }
    }

    // 读
    public Object take() throws InterruptedException {
        lock.lock(); // 锁定
        try {
            // 如果队列空，则阻塞<读线程>
            while (count == 0) {
                notEmpty.await();
            }

            // 读取队列，并更新读索引
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;

            // 唤醒<写线程>
            notFull.signal();
            return x;
        }
        finally {
            lock.unlock();// 解除锁定
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
