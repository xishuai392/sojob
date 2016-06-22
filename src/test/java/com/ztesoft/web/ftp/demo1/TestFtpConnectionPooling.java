/**
 * 
 */
package com.ztesoft.web.ftp.demo1;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo1 <br>
 */

public class TestFtpConnectionPooling implements Runnable {
    private static int n = 0;

    private static int m = 1;

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            /******************** 业务代码调用样例 *********************/
            System.out.println(m++);
            FtpClientProxy ftpClientProxy = new FtpClientProxy();
            String t = "连接" + ++n;
            System.out.println(t + "连接成功,端口号：" + ftpClientProxy.getLocalPort());
            Thread.sleep(1000);
            System.out.println(t + "释放连接");
            ftpClientProxy.release();// 释放连接
            /***************************************************/
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /************ 需要在服务器启动时进行加载 **************/
        FtpClientInfo ftpClientInfo = new FtpClientInfo();
        ftpClientInfo.setFtpIp("10.45.44.188");
        ftpClientInfo.setFtpPassword("zxs88");
        ftpClientInfo.setFtpPort(21);
        ftpClientInfo.setFtpUserName("zxs");
        ftpClientInfo.setMaxConnects(5);
        FtpConnectionPooling.init(ftpClientInfo);
        /*******************************************/

        /*************************************************************/
        try {
            FtpClientProxy ftpClientProxy1 = new FtpClientProxy();
            System.out.println("本地端口" + ftpClientProxy1.getLocalPort());
            ftpClientProxy1.release();
            ftpClientProxy1.release();
            FtpClientProxy ftpClientProxy2 = new FtpClientProxy();
            System.out.println("本地端口" + ftpClientProxy2.getLocalPort());
            ftpClientProxy2.release();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /************************* 并发测试 *******************************/
        for (int i = 1; i <= 40; i++) {
            TestFtpConnectionPooling test = new TestFtpConnectionPooling();
            Thread t = new Thread(test);
            t.start();
        }
    }
}
