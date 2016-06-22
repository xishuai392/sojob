/**
 * 
 */
package com.ztesoft.core.protocol;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.ztesoft.core.protocol.client.JSchClient;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.ssh.JSchSessionKeyedObjectPool;
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

public class TestJSchClent {

    class JSchThread extends Thread {
        private int threadNum;

        private String host;

        private String user;

        private String password;

        private int port;

        public JSchThread(int threadNum, String host, String user,
                String password, int port) {
            this.threadNum = threadNum;
            this.host = host;
            this.user = user;
            this.password = password;
            this.port = port;
        }

        public JSchThread(int threadNum, ServerConfig serverConfig) {
            this.threadNum = threadNum;
            this.host = serverConfig.getHost();
            this.user = serverConfig.getUser();
            this.password = serverConfig.getPassword();
            this.port = serverConfig.getPort();
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
                    + JSchSessionKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + JSchSessionKeyedObjectPool.getInstance().getPool()
                            .getNumIdle();
            System.out.println(info);

            Session session;
            try {
                session = JSchClient.creatSession(host, user, password, port);

                // String result = JSchClient.execShellCommand(
                // (ChannelShell) JSchClient.getShellChannel(session), "ls");

                ChannelExec channelExec = (ChannelExec) JSchClient
                        .getExecChannel(session);

                String channelExecResult = JSchClient.execNormalCommand(
                        channelExec, "ls -l");
                System.out.println("channelExecResult:" + channelExecResult);

                ChannelShell channelShell = (ChannelShell) JSchClient
                        .getShellChannel(session);
                String channelShellResult = JSchClient.execShellCommand(
                        channelShell, "ls -l;exit;");

                System.out.println("channelShellResult:" + channelShellResult);

                // JSchSessionKeyedObjectPool.getInstance().getPoolConfig();

                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String info2 = "thread["
                        + threadNum
                        + "],host=["
                        + host
                        + "],numActive:"
                        + JSchSessionKeyedObjectPool.getInstance().getPool()
                                .getNumActive()
                        + ",numIdle:"
                        + JSchSessionKeyedObjectPool.getInstance().getPool()
                                .getNumIdle();
                System.out.println(info2);
                // System.out.println(result);
                JSchClient.closeChannel(channelExec);
                JSchClient.closeChannel(channelShell);
                JSchClient.returnSession(host, user, password, port, session);
            }
            catch (Exception e) {
                System.out.println(String.format(
                        "thread[%d],host=[%s] get session error .......[%s]",
                        threadNum, host, e.getMessage()));
            }

            String info1 = "thread["
                    + threadNum
                    + "],host=["
                    + host
                    + "],numActive:"
                    + JSchSessionKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + JSchSessionKeyedObjectPool.getInstance().getPool()
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

        ServerConfig serverConfig188 = new ServerConfig();
        serverConfig188.setHost("10.45.44.188");
        serverConfig188.setUser("zxs");
        serverConfig188.setPassword("zxs88");
        serverConfig188.setPort(22);

        ServerConfig serverConfig186 = new ServerConfig();
        serverConfig186.setHost("10.45.44.186");
        serverConfig186.setUser("zxs");
        serverConfig186.setPassword("zxs88");
        serverConfig186.setPort(22);

        ServerConfig serverConfig187 = new ServerConfig();
        serverConfig187.setHost("10.45.44.187");
        serverConfig187.setUser("zxs");
        serverConfig187.setPassword("zxs88");
        serverConfig187.setPort(22);

        for (int i = 1; i <= 1000; i++) {
            System.out.println("i=" + i + ",i%3=" + (i % 3));
            JSchThread t;
            if ((i % 3) == 0) {
                t = (new TestJSchClent()).new JSchThread(i, serverConfig188);
                executor.execute(t);
            }
            if ((i % 3) == 1) {
                t = (new TestJSchClent()).new JSchThread(i, serverConfig186);
                executor.execute(t);
            }
            if ((i % 3) == 2) {
                t = (new TestJSchClent()).new JSchThread(i, serverConfig187);
                executor.execute(t);
            }

            try {
                Thread.sleep(10);
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
