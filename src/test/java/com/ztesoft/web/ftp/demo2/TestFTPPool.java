/**
 * 
 */
package com.ztesoft.web.ftp.demo2;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool.Config;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo2 <br>
 */

public class TestFTPPool {

    /**
     * 其中testOnBorrow、testOnReturn设置为true时，会在回调中调用validateObject方法进行对象检验。
     * pool.getResource()方法会从池中取出对象，pool.returnResource()方法会向池中还回对象。具体API含义请参见commons-pool的文档。
     * 
     * @param args
     */
    public static void main(String[] args) {
        GenericObjectPool.Config config = new Config();
        // 最大池容量
        config.maxActive = 5;
        // 从池中取对象达到最大时,继续创建新对象.
        config.whenExhaustedAction = GenericObjectPool.WHEN_EXHAUSTED_GROW;
        // 池为空时取对象等待的最大毫秒数.
        config.maxWait = 60 * 1000;
        // 取出对象时验证(此处设置成验证ftp是否处于连接状态).
        config.testOnBorrow = true;
        // 还回对象时验证(此处设置成验证ftp是否处于连接状态).
        config.testOnReturn = true;
        FTPPool pool = new FTPPool(config, "10.45.44.188", 21, "zxs", "zxs88",
                "true");
        System.out.println("getNumActive1:" + pool.getNumActive());
        System.out.println("getNumIdle1:" + pool.getNumIdle());
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 80; i++) {

            FtpConnectThread t = (new TestFTPPool()).new FtpConnectThread(pool,
                    i);
            t.start();
            // FTPClient ftpClient = pool.getResource();
            // System.out.println("ftpClient" + (i + 1) + " isConnected:"
            // + ftpClient.isConnected());
            // ftpClient.disconnect();
            // pool.returnResource(ftpClient);
            // pool.returnResource(ftpClient);
        }
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("time:" + (System.currentTimeMillis() - begin));
        System.out.println("getNumActive2:" + pool.getNumActive());
        System.out.println("getNumIdle2:" + pool.getNumIdle());
        // pool.destroy();

    }

    public class FtpConnectThread extends Thread {
        private FTPPool pool;

        private int threadNum;

        public FtpConnectThread(FTPPool pool, int threadNum) {
            this.pool = pool;
            this.threadNum = threadNum;
        }

        public void run() {
            FTPClient ftpClient = pool.getResource();
            System.out.println("ftpClient" + (threadNum + 1) + " isConnected:"
                    + ftpClient.isConnected() + ",ReplyString:"
                    + ftpClient.getReplyString() + ",getCharsetName:"
                    + ftpClient.getCharsetName());
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            pool.returnResource(ftpClient);
            System.out.println("ftpClient" + (threadNum + 1) + ",getNumActive:"
                    + pool.getNumActive() + ",getNumIdle:" + pool.getNumIdle());
        }
    }

}
