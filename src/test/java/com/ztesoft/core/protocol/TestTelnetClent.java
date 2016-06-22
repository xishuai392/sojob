/**
 * 
 */
package com.ztesoft.core.protocol;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.telnet.TelnetClient;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSchException;
import com.ztesoft.core.protocol.client.JSchClient;
import com.ztesoft.core.protocol.client.TelnetClientUtils;
import com.ztesoft.core.protocol.common.CommandResultDto;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.telnet.TelnetClientKeyedObjectPool;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.util.DateUtils;

/**
 * <Description>测试JSch连接池 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月31日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol.client <br>
 */

public class TestTelnetClent {

    class TelnetClientThread extends Thread {
        private int threadNum;

        private String host;

        private String user;

        private String password;

        private int port;

        private ServerConfig serverConfig;

        public TelnetClientThread(int threadNum, String host, String user,
                String password, int port) {
            this.threadNum = threadNum;
            this.host = host;
            this.user = user;
            this.password = password;
            this.port = port;
        }

        public TelnetClientThread(int threadNum, ServerConfig serverConfig) {
            this.threadNum = threadNum;
            this.host = serverConfig.getHost();
            this.user = serverConfig.getUser();
            this.password = serverConfig.getPassword();
            this.port = serverConfig.getPort();
            this.serverConfig = serverConfig;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            System.out.println(String.format(
                    "thread[%d],host=[%s] start .......", threadNum, host));

            String info = "thread["
                    + threadNum
                    + "],host=["
                    + host
                    + "],numActive:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumIdle();
            System.out.println(info);

            TelnetClient telnetClient = null;
            TelnetClientUtils tu = null;
            try {

                telnetClient = TelnetClientKeyedObjectPool.getInstance()
                        .getPool().borrowObject(this.serverConfig);

                tu = new TelnetClientUtils(this.serverConfig, telnetClient);

                boolean isLogin = tu.login(user, password);
                System.out.println(String.format(
                        "thread[%d],host=[%s] login .......", threadNum, host)
                        + isLogin);
                if (isLogin) {
                    CommandResultDto execResult = tu.exec("pwd","$");
                    System.out.println(String
                            .format("thread[%d],host=[%s] exec.......",
                                    threadNum, host)
                            + execResult.getCommandResult());
                }

                // try {
                // Thread.sleep(3);
                // }
                // catch (InterruptedException e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
                String info2 = "thread["
                        + threadNum
                        + "],host=["
                        + host
                        + "],numActive:"
                        + TelnetClientKeyedObjectPool.getInstance().getPool()
                                .getNumActive()
                        + ",numIdle:"
                        + TelnetClientKeyedObjectPool.getInstance().getPool()
                                .getNumIdle();
                System.out.println(info2);

            }
            catch (Exception e) {
                System.out
                        .println(String
                                .format("thread[%d],host=[%s] get telnetClent error .......[%s]",
                                        threadNum, host, e.getMessage()));
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

            String info1 = "thread["
                    + threadNum
                    + "],host=["
                    + host
                    + "],numActive:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumIdle();
            System.out.println(info1);
            System.out.println(String.format(
                    "thread[%d],host=[%s] end .......", threadNum, host));
        }

    }

    /**
     * @param args
     * @throws BaseAppException
     * @throws JSchException
     * @throws IOException
     */
    public static void main(String[] args) {
        System.out.println("开始测试");
        long t1 = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 2000, 1000,
                TimeUnit.DAYS, new LinkedBlockingQueue());

        ServerConfig serverConfig91 = new ServerConfig();
        serverConfig91.setHost("10.45.44.91");
        serverConfig91.setUser("doop");
        serverConfig91.setPassword("doop");
        serverConfig91.setPort(23);

        ServerConfig serverConfig186 = new ServerConfig();
        serverConfig186.setHost("10.45.44.186");
        serverConfig186.setUser("zxs");
        serverConfig186.setPassword("zxs88");
        serverConfig186.setPort(23);

        ServerConfig serverConfig202 = new ServerConfig();
        serverConfig202.setHost("10.45.44.202");
        serverConfig202.setUser("dccDop");
        serverConfig202.setPassword("dccDop");
        serverConfig202.setPort(23);

        ServerConfig serverConfig219 = new ServerConfig();
        serverConfig219.setHost("10.45.44.219");
        serverConfig219.setUser("gxhb");
        serverConfig219.setPassword("gxhb");
        serverConfig219.setPort(23);

        int total = 4;

        for (int i = 1; i <= 1000; i++) {
            System.out.println("i=" + i + ",i%" + total + "=" + (i % total));
            TelnetClientThread t;
            if ((i % total) == 0) {
                t = (new TestTelnetClent()).new TelnetClientThread(i,
                        serverConfig91);
                executor.execute(t);
            }
            if ((i % total) == 1) {
                t = (new TestTelnetClent()).new TelnetClientThread(i,
                        serverConfig186);
                executor.execute(t);
            }
            if ((i % total) == 2) {
                t = (new TestTelnetClent()).new TelnetClientThread(i,
                        serverConfig202);
                executor.execute(t);
            }
            if ((i % total) == 3) {
                t = (new TestTelnetClent()).new TelnetClientThread(i,
                        serverConfig219);
                executor.execute(t);
            }

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("启动完所有线程");
        executor.shutdown();
        while (!executor.isTerminated()) {
            // String info = "numActive:"
            // + JSchStackSessionPool.getInstance().getPool()
            // .getNumActive() + ",numIdle:"
            // + JSchStackSessionPool.getInstance().getPool().getNumIdle();
            // System.out.println(info);

            // try {
            // Thread.sleep(100);
            // }
            // catch (InterruptedException e) {
            // // TODO Auto-generated catch block
            // e.printStackTrace();
            // }

        }

        System.out.println("所有线程执行完");
        // try {
        // JSchStackSessionPool.getInstance().getPool().clear();
        // }
        // catch (UnsupportedOperationException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // catch (Exception e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        long t2 = System.currentTimeMillis();
        System.out.println("花费时间为：：：：" + (t2 - t1));
        System.out.println(DateUtils.getCurrentDate());

    }
}
