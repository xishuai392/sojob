/**
 * 
 */
package com.ztesoft.core.protocol;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.Session;
import com.ztesoft.core.protocol.client.JSchClient;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.ssh.JSchSessionKeyedObjectPool;

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

public class TestJSchClient3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerConfig serverConfig186 = new ServerConfig();
        serverConfig186.setHost("10.45.4.7");
        serverConfig186.setUser("zfyy");
        serverConfig186.setPassword("zfyy");
        serverConfig186.setPort(22);

        Session session;
        try {
            session = JSchClient.creatSession(serverConfig186);

            ChannelExec channelExec1 = (ChannelExec) JSchClient
                    .getExecChannel(session);

            // String channelExecResult = JSchClient.execNormalCommand(
            // channelExec, "vmstat|sed -n '$p'|awk '{print $14}'");
            String channelExecResult1 = JSchClient
                    .execNormalCommand(channelExec1,
                            "cd $HOME/src/cpp/billing/combiz/segidjudge; ");
            System.out.println("channelExecResult1:" + channelExecResult1);
//            try {
//                Thread.sleep(5000);
//            }
//            catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }

            ChannelExec channelExec2 = (ChannelExec) JSchClient
                    .getExecChannel(session);
            String channelExecResult2 = JSchClient.execNormalCommand(
                    channelExec2, "make -f Makefile.new clean all install ; ");
            System.out.println("channelExecResult2:" + channelExecResult2);

//            try {
//                Thread.sleep(5000);
//            }
//            catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }

            ChannelExec channelExec3 = (ChannelExec) JSchClient
                    .getExecChannel(session);
            String channelExecResult3 = JSchClient.execNormalCommand(
                    channelExec3, "echo $?; ");
            System.out.println("channelExecResult3:" + channelExecResult3);
//            try {
//                Thread.sleep(5000);
//            }
//            catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }

            ChannelExec channelExec4 = (ChannelExec) JSchClient
                    .getExecChannel(session);
            String channelExecResult4 = JSchClient.execNormalCommand(
                    channelExec4, "exit; ");
            System.out.println("channelExecResult4:" + channelExecResult4);

            // JSchSessionKeyedObjectPool.getInstance().getPoolConfig();

//            try {
//                Thread.sleep(2000);
//            }
//            catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            // JSchClient.closeChannel(channelExec);
            JSchClient.closeChannel(channelExec1);
            JSchClient.closeChannel(channelExec2);
            JSchClient.closeChannel(channelExec3);
            JSchClient.closeChannel(channelExec4);
            JSchClient.returnSession(serverConfig186, session);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
