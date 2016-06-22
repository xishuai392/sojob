/**
 * 
 */
package com.ztesoft.core.protocol;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

import com.ztesoft.core.protocol.client.TelnetClientUtils;
import com.ztesoft.core.protocol.common.CommandResultDto;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.telnet.TelnetClientKeyedObjectPool;
import com.ztesoft.framework.exception.BaseAppException;

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

public class TestTelnetClient2 {

    private TelnetClient telnet = new TelnetClient();

    private InputStream in;

    private PrintStream out;

    private String prompt = "]$";// 普通用户结束

    public TestTelnetClient2(String ip, int port, String user, String password) {
        try {
            telnet.connect(ip, port);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
            // 根据root用户设置结束符
            this.prompt = user.equals("root") ? "#" : "]$";
            login(user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     * 
     * @param user
     * @param password
     */
    public void login(String user, String password) {
        // read()Until("login:");
        readUntil("login:");
        write(user);
        readUntil("Password:");
        write(password);
        readUntil(prompt + "");
    }

    /**
     * 读取分析结果
     * 
     * @param pattern
     * @return
     */
    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true) {
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
                System.out.print(ch);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写操作
     * 
     * @param value
     */
    public void write(String value) {
        try {
            out.println(value);
            out.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向目标发送命令字符串
     * 
     * @param command
     * @return
     */
    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(prompt + "");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接
     */
    public void disconnect() {
        try {
            telnet.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        // TelnetClient telnet = new TelnetClient();
        try {
            //TestTelnetClient2 she = new TestTelnetClient2("10.45.44.219", 23, "gxhb", "gxhb");
            TestTelnetClient2 she = new TestTelnetClient2("10.45.44.186", 23, "zxs", "zxs88");
            //System.out.println(she);
            // 执行的命令
            System.out.println();
            System.out.println("=====================================");
            System.out.println();
            System.out.println(she.sendCommand("pwd"));
            System.out.println();
            System.out.println("=====================================");
            System.out.println(she.sendCommand("vmstat|sed -n '$p'|awk '{print $14}'"));
            she.disconnect();

        }
        catch (Exception e) {
            // TODO: handle exception
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig();
        // serverConfig.setHost("10.45.44.91");
        // serverConfig.setUser("doop");
        // serverConfig.setPassword("doop");
        // serverConfig.setPort(23);

        serverConfig.setHost("10.45.44.219");
        serverConfig.setUser("gxhb");
        serverConfig.setPassword("gxhb");
        serverConfig.setPort(23);

        TelnetClient telnetClient = null;
        TelnetClientUtils tu = null;
        try {

            telnetClient = TelnetClientKeyedObjectPool.getInstance().getPool()
                    .borrowObject(serverConfig);

            tu = new TelnetClientUtils(serverConfig, telnetClient);

            boolean isLogin = tu.login(serverConfig.getUser(),
                    serverConfig.getPassword());
            System.out.println(String.format("login .......[%b]", isLogin));
            if (isLogin) {
                CommandResultDto execResult = tu
                        .exec("vmstat|sed -n '$p'|awk '{print $14}'",2000);
                System.out.println("===================================");
                System.out.println(String.format("execResult.......[%s]",
                        execResult));
                System.out.println("===================================");
            }

            String info2 = " host=["
                    + serverConfig.getHost()
                    + "],numActive:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumIdle();
            System.out.println(info2);

        }
        catch (Exception e) {
            System.out.println(String.format(
                    " host=[%s] get telnetClent error .......[%s]",
                    serverConfig.getHost(), e.getMessage()));
            e.printStackTrace();
        }
        finally {
            if (null != tu)
                try {
                    tu.returnTelnetClient();
                }
                catch (BaseAppException e) {
                }
        }

    }

}
