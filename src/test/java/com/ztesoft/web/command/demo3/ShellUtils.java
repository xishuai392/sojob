/**
 * 
 */
package com.ztesoft.web.command.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.ztesoft.web.command.demo1.SSHHelper;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.command.demo3 <br>
 */

public class ShellUtils {
    private static JSch jsch;

    private static Session session;

    /**
     * 连接到指定的IP
     * 
     * @throws JSchException
     */
    public static void connect(String user, String passwd, String host)
            throws JSchException {
        jsch = new JSch();
        session = jsch.getSession(user, host, 22);
        session.setPassword(passwd);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
    }

    /**
     * 执行相关的命令
     * 
     * @throws JSchException
     */
    public static void execCmd(String command, String user, String passwd,
            String host) throws JSchException {
        connect(user, passwd, host);

        BufferedReader reader = null;
        Channel channel = null;

        try {
            if (command != null) {
                channel = session.openChannel("exec");
                ((ChannelExec) channel).setCommand(command);

                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(System.err);

                channel.connect();
                InputStream in = channel.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                String buf = null;
                while ((buf = reader.readLine()) != null) {
                    System.out.println(buf);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSchException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            channel.disconnect();
            session.disconnect();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("s1");
            ShellUtils.connect("dccDop", "dccDop", "10.45.44.202");
            System.out.println("s2");
            ShellUtils.execCmd("ls","dccDop", "dccDop", "10.45.44.202");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
