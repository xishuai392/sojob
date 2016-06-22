/**
 * 
 */
package com.ztesoft.core.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月9日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol <br>
 */

public class TestTelnetClient3 {

    private TelnetClient telnet = new TelnetClient();

    private InputStream in;

    private PrintStream out;

    private static final String DEFAULT_AIX_PROMPT = "$";

    /**
     * telnet 端口
     */
    private String port;

    /**
     * 用户名
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    /**
     * IP 地址
     */
    private String ip;

    /**
     * 缺省端口
     */
    private static final int DEFAULT_TELNET_PORT = 23;

    public TestTelnetClient3(String ip, String user, String password) {
        this.ip = ip;
        this.port = String.valueOf(TestTelnetClient3.DEFAULT_TELNET_PORT);
        this.user = user;
        this.password = password;
    }

    public TestTelnetClient3(String ip, String port, String user,
            String password) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    /**
     * @return boolean 连接成功返回true，否则返回false
     */
    private boolean connect() {

        boolean isConnect = true;

        try {
            telnet.connect(ip, Integer.parseInt(port));

            telnet.setSoTimeout(5000);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());

            /** Log the user on* */
            readUntil("login: ");
            write(user);

            readUntil("Password: ");
            write(password);

            /** Advance to a prompt */
            readUntil(DEFAULT_AIX_PROMPT);

        }
        catch (Exception e) {
            isConnect = false;
            e.printStackTrace();
            return isConnect;
        }
        return isConnect;
    }

    public void su(String user, String password) {
        try {
            write("su" + " - " + user);
            readUntil("Password:");
            write(password);
            readUntil(DEFAULT_AIX_PROMPT);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readUntil(String pattern) {
        StringBuffer sb = new StringBuffer();
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            
            char ch = (char) in.read();
            while (true) {
                //System.out.print(ch);// ---需要注释掉
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        //return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return sb.toString();
        }
    }

    public void write(String value) {
        try {
            out.println(value);
            out.flush();
            //System.out.println(value);// ---需要注释掉
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(DEFAULT_AIX_PROMPT);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void disconnect() {
        try {
            telnet.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getNowDate() {
        this.connect();
        String nowDate = this.sendCommand("vmstat|sed -n '$p'|awk '{print $14}'");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(nowDate);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
        String[] temp = nowDate.split("\r\n");
        // 去除命令字符串
        if (temp.length > 1) {
            nowDate = temp[0];
        }
        else {
            nowDate = "";
        }
        this.disconnect();
        return nowDate;
    }

    public static void main(String[] args) {
        try {
            System.out.println("aaaaaaaaaaaa");
            TestTelnetClient3 telnet = new TestTelnetClient3("10.45.44.219",
                    "gxhb", "gxhb");
//            TestTelnetClient3 telnet = new TestTelnetClient3("10.45.44.186",
//                    "zxs", "zxs88");
            Thread.sleep(100);
            System.out.println("bbbbbbbbbbbbb");
            // String ls = telnet.sendCommand("ls");
            String nowDate = telnet.getNowDate();
            System.out.println("ccccccccccccc");
            System.out.println("nowDate:" + nowDate);
            //telnet.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
