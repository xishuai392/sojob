/**
 * 
 */
package com.ztesoft.web.command.demo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.command <br>
 */

public class VersouSshUtil {
    private ChannelSftp channelSftp;

    private ChannelExec channelExec;

    private Session session = null;

    private int timeout = 60000;

    private static final Logger LOG = Logger.getLogger(VersouSshUtil.class);

    public VersouSshUtil(SshConfiguration conf) throws Exception {
        LOG.info("尝试连接到....host:" + conf.getHost() + ",username:"
                + conf.getUsername() + ",password:" + conf.getPassword()
                + ",port:" + conf.getPort());
        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(conf.getUsername(), conf.getHost(),
                conf.getPort()); // 根据用户名，主机ip，端口获取一个Session对象
        session.setPassword(conf.getPassword()); // 设置密码
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
    }

    public void download(String src, String dst) throws Exception {
        channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.get(src, dst, new FileProgressMonitor(),
                ChannelSftp.OVERWRITE);
        channelSftp.quit();
    }

    public void upload(String src, String dst) throws Exception {
        channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.put(src, dst, new FileProgressMonitor(),
                ChannelSftp.OVERWRITE);
        channelSftp.quit();
    }

    public void runCmd(String cmd, String charset) throws Exception {
        channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in,
                Charset.forName(charset)));
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            System.out.println(buf);
        }
        reader.close();
        channelExec.disconnect();
    }

    public void close() {
        session.disconnect();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
