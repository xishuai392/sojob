package com.ztesoft.web.command.demo4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSchException;

public class PublicSSHExec {
    public String execNormalCommand(ChannelExec channel, String command)
            throws IOException, JSchException {
        channel.setCommand(command);
        InputStream in = channel.getInputStream();
        channel.connect(30000);
        byte[] tmp = new byte[1024];
        StringBuffer buffer = new StringBuffer();
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                buffer.append(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (in.available() > 0)
                    continue;
                break;
            }
        }
        return buffer.toString();
    }

    public String execShellCommand(ChannelShell channel, String command)
            throws IOException, JSchException {

        channel.connect(30000);

        // 获取输入流和输出流
        InputStream in = channel.getInputStream();
        OutputStream out = channel.getOutputStream();

        // 发送需要执行的SHELL命令，需要用\n结尾，表示回车
        command += " \n";
        out.write(command.getBytes());
        out.flush();

        byte[] tmp = new byte[1024];
        StringBuffer buffer = new StringBuffer();
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                buffer.append(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (in.available() > 0)
                    continue;
                break;
            }
        }
        out.close();
        in.close();
        return buffer.toString();
    }
}
