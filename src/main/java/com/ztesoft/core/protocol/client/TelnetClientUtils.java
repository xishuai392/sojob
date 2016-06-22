/**
 * 
 */
package com.ztesoft.core.protocol.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.net.telnet.TelnetClient;

import com.ztesoft.core.protocol.common.CommandResultDto;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.telnet.TelnetClientKeyedObjectPool;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>Telnet 连接工具类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol.telnet <br>
 */

public class TelnetClientUtils {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TelnetClientUtils.class);

    public static final String DEFAULT_AIX_PROMPT = "$";

    /**
     * 字符集
     */
    private ThreadLocal<String> charset = new ThreadLocal<String>() {

    };

    private ThreadLocal<byte[]> buff = new ThreadLocal<byte[]>() {

        /*
         * (non-Javadoc)
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected byte[] initialValue() {
            return new byte[2048];
        }

    };

    private ThreadLocal<ServerConfig> serverConfig = new ThreadLocal<ServerConfig>();

    private ThreadLocal<TelnetClient> telnetClient = new ThreadLocal<TelnetClient>();

    private ThreadLocal<BufferedReader> telnetReader = new ThreadLocal<BufferedReader>();

    private ThreadLocal<BufferedWriter> telnetWirter = new ThreadLocal<BufferedWriter>();

    private ThreadLocal<InputStream> telnetIn = new ThreadLocal<InputStream>();

    private ThreadLocal<OutputStream> telnetOut = new ThreadLocal<OutputStream>();

    private ThreadLocal<String> prompt = new ThreadLocal<String>() {
        /*
         * (non-Javadoc)
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected String initialValue() {
            return DEFAULT_AIX_PROMPT;
        }
    };

    public TelnetClientUtils(ServerConfig serverConfig,
            TelnetClient telnetClient, String charset)
            throws UnsupportedEncodingException {
        telnetClient.setConnectTimeout(serverConfig.getTimeout());
        this.serverConfig.set(serverConfig);
        this.telnetClient.set(telnetClient);
        this.charset.set(charset);
        init();
    }

    public TelnetClientUtils(ServerConfig serverConfig,
            TelnetClient telnetClient) throws UnsupportedEncodingException {
        telnetClient.setConnectTimeout(serverConfig.getTimeout());
        this.serverConfig.set(serverConfig);
        this.telnetClient.set(telnetClient);
        init();
    }

    public TelnetClientUtils(String host, String user, String password,
            int port, TelnetClient telnetClient, String charset)
            throws UnsupportedEncodingException {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setHost(host);
        serverConfig.setUser(user);
        serverConfig.setPassword(password);
        serverConfig.setPort(port);
        telnetClient.setConnectTimeout(serverConfig.getTimeout());
        this.serverConfig.set(serverConfig);
        this.telnetClient.set(telnetClient);
        this.charset.set(charset);
        init();
    }

    public TelnetClientUtils(String host, String user, String password,
            int port, TelnetClient telnetClient)
            throws UnsupportedEncodingException {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setHost(host);
        serverConfig.setUser(user);
        serverConfig.setPassword(password);
        serverConfig.setPort(port);
        telnetClient.setConnectTimeout(serverConfig.getTimeout());
        this.serverConfig.set(serverConfig);
        this.telnetClient.set(telnetClient);
        init();
    }

    /**
     * 初始化输入输出流
     * 
     * @throws UnsupportedEncodingException
     */
    private void init() throws UnsupportedEncodingException {
        this.telnetIn.set(this.telnetClient.get().getInputStream());
        this.telnetOut.set(this.telnetClient.get().getOutputStream());
        if (null == this.charset.get()) {
            this.telnetReader.set(new BufferedReader(new InputStreamReader(
                    this.telnetIn.get())));
            this.telnetWirter.set(new BufferedWriter(new OutputStreamWriter(
                    this.telnetOut.get())));
        }
        else {
            this.telnetReader.set(new BufferedReader(new InputStreamReader(
                    this.telnetIn.get(), this.charset.get())));
            this.telnetWirter.set(new BufferedWriter(new OutputStreamWriter(
                    this.telnetOut.get(), this.charset.get())));
        }
    }

    public synchronized boolean login(String user, String password,
            String prompt) throws IOException, BaseAppException {
        /** Log the user on* */
        readStringUntil("login: ");
        writeText(user);

        readStringUntil("Password: ");
        writeText(password);

        /** Advance to a prompt */
        CommandResultDto loginResult = readStringUntil(prompt);

        return loginResult.isTimeout();
    }

    /**
     * 登录
     * 
     * @param user
     * @param passwd
     * @return 是否登录成功.
     * @throws IOException,BaseAppException
     */
    public synchronized boolean login(String user, String password)
            throws IOException, BaseAppException {
        boolean canSendUser = false;
        boolean canSendPsw = false;
        String read = readString();
        int times = this.serverConfig.get().getTimeout() / 100;
        for (int i = 0; i < times; i++) {
            if (-1 == read.indexOf("login")) {
                read = readString();
            }
            else {
                canSendUser = true;
                break;
            }
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
            }
        }
        if (!canSendUser) {
            throw ExceptionHandler
                    .publish(
                            "APP-00-0084",
                            "ERROR: input user timeout error when trying to telnet connect to serverConfig :  "
                                    + this.serverConfig.get());
        }
        writeText(user);

        read = readString();
        for (int i = 0; i < times; i++) {
            if (-1 == read.indexOf("Password")) {
                read = readString();
            }
            else {
                canSendPsw = true;
                break;
            }
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
            }
        }
        if (!canSendPsw) {
            throw ExceptionHandler
                    .publish(
                            "APP-00-0085",
                            "ERROR: input password timeout error when trying to telnet connect to serverConfig :  "
                                    + this.serverConfig.get());
        }
        writeText(password);

        for (int i = 0; i < times; i++) {
            read = readString();
            // System.out.println("last:"+read);
            if (-1 != read.indexOf("Last")) {
                return true;
            }
            else if (-1 != read.indexOf("incorrect")) {
                return false;
            }
            else if (-1 != read.indexOf("closed")) {
                return false;
            }
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
            }
        }
        return false;
    }

    private int readBytes(byte[] buff, int offset, int len) throws IOException {
        return this.telnetIn.get().read(buff, offset, len);
    }

    /**
     * 读取字符串<br/>
     * 相当于readByte()转为字符串
     * 
     * @return
     * @throws IOException
     */
    private String readString() throws IOException {
        int readLen = readBytes(this.buff.get(), 0, this.buff.get().length);
        if (0 < readLen)
            return new String(buff.get(), 0, readLen).trim();
        else
            return "";
    }

    public CommandResultDto readStringUntil(int timeout) {
        return readStringUntil(timeout, null);
    }

    public CommandResultDto readStringUntil(String pattern) {
        return readStringUntil(this.serverConfig.get().getTimeout(), pattern);
    }

    /**
     * 根据结束符返回，或者根据超时时间返回
     * 
     * @param timeout
     * @param pattern
     * @return
     */
    public CommandResultDto readStringUntil(int timeout, String prompt) {
        CommandResultDto result = new CommandResultDto();
        StringBuffer sb = new StringBuffer();
        try {
            char lastChar = '\0';
            if (null != prompt) {
                lastChar = prompt.charAt(prompt.length() - 1);
            }

            this.telnetClient.get().setSoTimeout(timeout);

            char ch = (char) this.telnetIn.get().read();
            while (true) {
                // System.out.print(ch);// ---需要注释掉
                sb.append(ch);
                if ('\0' != lastChar && ch == lastChar) {
                    if (null != prompt && sb.toString().endsWith(prompt)) {
                        break;
                    }
                }
                ch = (char) this.telnetIn.get().read();
            }
        }
        catch (IOException e) {
            result.setTimeout(true);
        }
        result.setCommandResult(sb.toString());
        return result;
    }

    /**
     * 读取一行<br/>
     * 如果服务器与客户端不是同一种操作系统，可能导致此方法计行失败。
     * 
     * @return
     * @throws IOException
     */
    private String readLine() throws IOException {
        String read = telnetReader.get().readLine();
        return null == read ? "" : read.trim();
    }

    private void writeBytes(byte[] buff, int offset, int len)
            throws IOException {
        telnetOut.get().write(buff, offset, len);
    }

    /**
     * 向服务器写字符串
     * 
     * @param text
     * @throws IOException
     */
    private void writeText(String text) throws IOException {
        telnetWirter.get().write(text);
        telnetWirter.get().write('\r');
        telnetWirter.get().write('\n');
        telnetWirter.get().flush();
    }

    /**
     * 执行命令，并返回结果<br/>
     * 相当于: <br>
     * writeText(); <br/>
     * return readString();
     * 
     * @param cmd
     * @return
     * @throws IOException
     */
    private String exec(String cmd) throws IOException {
        writeText(cmd);
        return readString();
    }

    /**
     * 设定超时时间，不设定休止符（根据不同主机的不同需要自行设定），执行命令。到超时时间了则返回，否则一直阻塞
     * 
     * @param cmd
     * @param timeout 超时时间 毫秒数
     * @return
     * @throws IOException
     */
    public CommandResultDto exec(String cmd, int timeout) throws IOException {
        return exec(cmd, timeout, null);
    }

    /**
     * 不设定超时时间（默认值serverConfig.getTimeout()），设定休止符（根据不同主机的不同需要自行设定），在超时时间内，如果有碰到休止符，则返回，超过超时时间也返回
     * 
     * @param cmd
     * @param prompt 休止符（根据不同主机的不同需要自行设定）
     * @return
     * @throws IOException
     */
    public CommandResultDto exec(String cmd, String prompt) throws IOException {
        return exec(cmd, this.serverConfig.get().getTimeout(), prompt);
    }

    /**
     * 设定超时时间，设定休止符（根据不同主机的不同需要自行设定），执行命令。在超时时间内，如果有碰到休止符，则返回，超过超时时间也返回
     * 
     * @param cmd
     * @param timeout 超时时间 毫秒数
     * @param prompt 休止符（根据不同主机的不同需要自行设定）
     * @return
     * @throws IOException
     */
    public CommandResultDto exec(String cmd, int timeout, String prompt)
            throws IOException {
        writeText(cmd);
        return readStringUntil(timeout, prompt);
    }

    /**
     * 把telnetClient返回连接池，并关闭打开的流
     * 
     * @throws BaseAppException
     */
    public synchronized void returnTelnetClient() throws BaseAppException {
        if (telnetClient.get() != null) {
            try {
                closeStream();
                TelnetClientKeyedObjectPool.getInstance().getPool()
                        .returnObject(serverConfig.get(), telnetClient.get());
            }
            catch (Exception e) {
                logger.error(
                        "ERROR: Return TelnetClient to pool cast exception : ",
                        e);
                throw ExceptionHandler.publish("APP-00-0083",
                        "ERROR: Return TelnetClient to pool cast exception : ",
                        e);
            }
        }
    }

    /**
     * 关闭
     */
    private void closeStream() {
        try {
            writeText("exit");
        }
        catch (Exception ex) {
        }

        try {
            if (null != telnetIn.get())
                telnetIn.get().close();
        }
        catch (Exception e) {
        }

        try {
            if (null != telnetOut.get())
                telnetOut.get().close();
        }
        catch (Exception e) {
        }

    }
}
