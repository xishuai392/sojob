/**
 * 
 */
package com.ztesoft.web.command.demo4;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSchException;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.command.demo4 <br>
 */

public class TestDemo {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("start:");
        SSHClient ssh = new SSHClient("dccDop", "dccDop", "10.45.44.205");
        ssh.creatSession();
        //ChannelExec channel = (ChannelExec) ssh.getExecChannel();
        ChannelShell channel = (ChannelShell)ssh.getShellChannel();

        PublicSSHExec SSHExec = new PublicSSHExec();
        String execResult = SSHExec.execShellCommand(channel, "ls -l;pwd");
        System.out.println("execResult:" + execResult);
        channel.disconnect();
        System.out.println("channel disconnect:");
        ssh.closeConnect();
        System.out.println("ssh closeConnect:");
    }

}
