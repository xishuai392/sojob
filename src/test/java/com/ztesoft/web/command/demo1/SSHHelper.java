/**
 * 
 */
package com.ztesoft.web.command.demo1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
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

public class SSHHelper {

    /**
     * 利用JSch包实现远程主机SHELL命令执行
     * 
     * @param ip 主机IP
     * @param user 主机登陆用户名
     * @param psw 主机登陆密码
     * @param port 主机ssh2登陆端口，如果取默认值，传-1
     * @param privateKey 密钥文件路径
     * @param passphrase 密钥的密码
     */
    public static void sshShell(String ip, String user, String psw, int port,
            String privateKey, String passphrase) throws Exception {
        Session session = null;
        Channel channel = null;

        JSch jsch = new JSch();

        // 设置密钥和密码
        if (privateKey != null && !"".equals(privateKey)) {
            if (passphrase != null && "".equals(passphrase)) {
                // 设置带口令的密钥
                jsch.addIdentity(privateKey, passphrase);
            }
            else {
                // 设置不带口令的密钥
                jsch.addIdentity(privateKey);
            }
        }

        if (port <= 0) {
            // 连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        }
        else {
            // 采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        // 如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }

        // 设置登陆主机的密码
        session.setPassword(psw);// 设置密码
        // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        System.out.println("a1");
        // 设置登陆超时时间
        session.connect(30000);
        System.out.println("a2");
        System.out.println("session:" + session);
        try {
            // 创建sftp通信通道
            channel = (Channel) session.openChannel("shell");
            channel.connect(1000);

            // 获取输入流和输出流
            InputStream instream = channel.getInputStream();
            OutputStream outstream = channel.getOutputStream();

            // 发送需要执行的SHELL命令，需要用\n结尾，表示回车
            String shellCommand = "ls -l \n";
            outstream.write(shellCommand.getBytes());
            outstream.flush();

            System.out.println("a3");

            /**
            byte[] tmp = new byte[1024];
            while (true) {
                while (instream.available() > 0) {
                    int i = instream.read(tmp, 0, 1024);
                    if (i < 0)
                        break;
                    System.out.print(new String(tmp, 0, i,"gbk"));
                }
                if (channel.isClosed()) {
                    if (instream.available() > 0)
                        continue;
                    System.out.println("exit-status: "
                            + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                }
                catch (Exception ee) {
                }
            }*/
            
            byte[] tmp=new byte[1024];
            StringBuffer buffer=new StringBuffer();
            while(true){
                while(instream.available()>0){
                    int i=instream.read(tmp, 0, 1024);
                    if(i<0)break;
                    buffer.append(new String(tmp, 0, i));
                    System.out.print(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                  if(instream.available()>0) continue;
                  break;
                }
            }

            /** 获取命令执行的结果
            if (instream.available() > 0) {
                System.out.println("a4");
                byte[] data = new byte[instream.available()];
                int nLen = instream.read(data);

                if (nLen < 0) {
                    throw new Exception("network error.");
                }

                // 转换输出结果并打印出来
                String temp = new String(data, 0, nLen, "utf-8");
                System.out.println(temp);
            }
            */
            outstream.close();
            instream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.disconnect();
            channel.disconnect();
        }
    }

    public static void main(String[] args) {
        try {
            SSHHelper.sshShell("10.45.44.202", "dccDop", "dccDop", 0, "", "");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
