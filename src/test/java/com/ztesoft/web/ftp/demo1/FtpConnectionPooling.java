/**
 * 
 */
package com.ztesoft.web.ftp.demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * <Description>FTP连接池 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo1 <br>
 */

public abstract class FtpConnectionPooling {
    private static BlockingQueue<CustomFTPClient> fqueue;

    private static FtpClientInfo ftpClientInfo;

    /**
     * <br>
     * Description:初始化连接池 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @param ftpClientInfo
     */
    public static void init(FtpClientInfo info) {
        ftpClientInfo = info;
        fqueue = new PriorityBlockingQueue<CustomFTPClient>(
                ftpClientInfo.getMaxConnects(), new FtpClientComparator());// 初始化队列容量
        CustomFTPClient ftpClient;
        for (int i = 0; i < ftpClientInfo.getMaxConnects(); i++) {
            ftpClient = new CustomFTPClient();
            ftpClient.order = i;
            fqueue.add(ftpClient);
        }
    }

    public static FtpClientInfo getFtpClientInfo() {
        return ftpClientInfo;
    }

    /**
     * <br>
     * Description:向线程池中添加FTPClient <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @param ftpClient
     */
    public static boolean add(CustomFTPClient ftpClient) {
        boolean b = fqueue.contains(ftpClient);
        if (!b)
            return fqueue.add(ftpClient);
        return true;
    }

    /**
     * <br>
     * Description:获取FTPClient，如果线程池为空，则等待到FtpClientInfo中所设置的超时时间 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @return
     * @throws InterruptedException
     */
    public static CustomFTPClient poll() throws InterruptedException {
        return fqueue.poll(ftpClientInfo.getTimeout(),
                ftpClientInfo.getTimeUnit());
    }

    /**
     * <br>
     * Description:获取FTPClient，如果线程池为空，则一直等待。 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @return
     * @throws InterruptedException
     */
    public static CustomFTPClient take() throws InterruptedException {
        return fqueue.take();
    }
}
