/**
 * 
 */
package com.ztesoft.web.ftp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

/**
 * <Description>FTPClient代理类 <br>
 * 负责FTPClient功能的代理
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo1 <br>
 */

public class FtpClientProxy {
    private CustomFTPClient ftpClient;

    public FtpClientProxy() throws InterruptedException, SocketException,
            IOException {
        ftpClient = FtpConnectionPooling.poll();
        if (!ftpClient.isConnected()) {
            FtpClientInfo info = FtpConnectionPooling.getFtpClientInfo();// 获取ftpClient信息
            ftpClient.connect(info.getFtpIp(), info.getFtpPort());// 连接
            ftpClient.login(info.getFtpUserName(), info.getFtpPassword());// 登陆
            ftpClient.setFileType(CustomFTPClient.BINARY_FILE_TYPE);// 设置为二进制
        }
    }

    /**
     * <br>
     * Description:释放ftpClient <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @return
     */
    public boolean release() {
        if (ftpClient == null)
            return true;
        boolean b = FtpConnectionPooling.add(ftpClient);
        if (b)
            ftpClient = null;
        return b;
    }

    /**
     * <br>
     * Description:下载文件 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public InputStream retrieveFileStream(String remote) throws IOException {
        return ftpClient.retrieveFileStream(remote);
    }

    /**
     * <br>
     * Description:上传文件 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @param remote
     * @param local
     * @return
     * @throws IOException
     */
    public boolean storeFile(String remote, InputStream local)
            throws IOException {
        return ftpClient.storeFile(remote, local);
    }

    /**
     * <br>
     * Description:获取本地端口 <br>
     * Author:张智研(zhangzhiyan@neusoft.com) <br>
     * Date:2013-7-4
     * 
     * @return
     */
    public int getLocalPort() {
        System.out.println("ftpClient:"+ftpClient);
        return ftpClient.getLocalPort();
    }
}
