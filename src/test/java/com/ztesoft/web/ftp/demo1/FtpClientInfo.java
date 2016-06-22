/**
 * 
 */
package com.ztesoft.web.ftp.demo1;

import java.util.concurrent.TimeUnit;

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

public class FtpClientInfo {
    private String ftpIp; // ftp的IP地址

    private int ftpPort; // ftp的端口

    private String ftpUserName; // ftp的用户名

    private String ftpPassword; // ftp的密码

    private int maxConnects; // 最大连接数

    private long timeout; // 超时时间 ,默认60

    private TimeUnit timeUnit;// 超时时间单位,默认为秒

    public FtpClientInfo() {
        timeout = 60;
        timeUnit = TimeUnit.SECONDS;
    }

    /**
     * @return the ftpIp
     */
    public String getFtpIp() {
        return ftpIp;
    }

    /**
     * @param ftpIp the ftpIp to set
     */
    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    /**
     * @return the ftpPort
     */
    public int getFtpPort() {
        return ftpPort;
    }

    /**
     * @param ftpPort the ftpPort to set
     */
    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    /**
     * @return the ftpUserName
     */
    public String getFtpUserName() {
        return ftpUserName;
    }

    /**
     * @param ftpUserName the ftpUserName to set
     */
    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    /**
     * @return the ftpPassword
     */
    public String getFtpPassword() {
        return ftpPassword;
    }

    /**
     * @param ftpPassword the ftpPassword to set
     */
    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    /**
     * @return the maxConnects
     */
    public int getMaxConnects() {
        return maxConnects;
    }

    /**
     * @param maxConnects the maxConnects to set
     */
    public void setMaxConnects(int maxConnects) {
        this.maxConnects = maxConnects;
    }

    /**
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * @param timeout the timeout to set
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * @return the timeUnit
     */
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * @param timeUnit the timeUnit to set
     */
    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

}
