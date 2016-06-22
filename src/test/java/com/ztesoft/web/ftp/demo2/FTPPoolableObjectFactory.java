/**
 * 
 */
package com.ztesoft.web.ftp.demo2;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @param <T>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo2 <br>
 */

public class FTPPoolableObjectFactory extends
        BasePoolableObjectFactory {
    private String host;

    private int port;

    private String user;

    private String password;

    private String passiveModeConf;

    public FTPPoolableObjectFactory(String host, int port, String user,
            String password, String passiveModeConf) {
        this.host = host;
        System.out.println("host:" + host);
        this.port = port;
        System.out.println("port:" + port);
        this.user = user;
        System.out.println("user:" + user);
        this.password = password;
        System.out.println("password:" + password);
        this.passiveModeConf = passiveModeConf;
        System.out.println("passiveModeConf:" + passiveModeConf);
    }

    @Override
    public Object makeObject() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(host, port);
        ftpClient.setControlKeepAliveTimeout(300);// set timeout to 5 minutes
        ftpClient.login(user, password);
        boolean passiveMode = false;
        if (passiveModeConf == null
                || Boolean.parseBoolean(passiveModeConf) == true) {
            passiveMode = true;
        }
        if (passiveMode) {
            ftpClient.enterLocalPassiveMode();
        }
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        return ftpClient;
    }

    @Override
    public void destroyObject(Object obj) throws Exception {
        if (obj instanceof FTPClient) {
            FTPClient ftpClient = (FTPClient) obj;
            if (!ftpClient.isConnected())
                return;
            try {
                ftpClient.disconnect();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean validateObject(Object obj) {
        if (obj instanceof FTPClient) {
            FTPClient ftpClient = (FTPClient) obj;
            try {
                return ftpClient.isConnected();
            }
            catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
