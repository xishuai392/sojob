package com.ztesoft.web.command.demo5;

/**
 * 类描述：通过JSch实现远程服器命令的调用
 * @author: xu.xin
 * 
 *          History:2015  上午11:22:03 xu.xin Created.
 * 
 */
import java.io.File;
import java.util.Map;

import javax.swing.ProgressMonitor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

public class JschClient implements ISSHClient {
    private static Log log = LogFactory.getLog(JschClient.class);

    private Map<String, String> pro;

    private Session session;

    public JschClient(Map<String, String> pro, Session session) {
        this.pro = pro;
        this.session = session;
    }

    /**
     * 执行远程命令
     * 
     * @param cmd
     */
    @Override
    public boolean execCmd(String cmd) {

        Channel channel = null;
        try {
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(cmd);
            channel.setInputStream(null);
            channel.connect();
            // Pump stdout of the command to our WARN logs
            StreamPumper outPumper = new StreamPumper(log, cmd + " via ssh",
                    ((ChannelExec) channel).getInputStream(),
                    StreamPumper.StreamType.STDOUT);
            outPumper.start();

            // Pump stderr of the command to our WARN logs
            StreamPumper errPumper = new StreamPumper(log, cmd + " via ssh",
                    ((ChannelExec) channel).getErrStream(),
                    StreamPumper.StreamType.STDERR);
            errPumper.start();
            outPumper.join();
            errPumper.join();
            // InputStream in=channel.getInputStream();
            //
            //
            //
            //
            // byte[] tmp=new byte[1024];
            // while(true){
            // while(in.available()>0){
            // int i=in.read(tmp, 0, 1024);
            // if(i<0)break;
            // log.info(new String(tmp, 0, i));
            // }
            // if(channel.isClosed()){
            // if(in.available()>0) continue;
            // log.info("exec commands:%s"+cmd+".exit-status: "+channel.getExitStatus());
            // break;
            // }
            // try{Thread.sleep(1000);}catch(Exception ee){
            //
            // }
            // }
            return ((ChannelExec) channel).getExitStatus() == 0;
        }
        catch (Exception e) {
            log.error(String
                    .format("exec command failure,please check it  .commands:%s .errMsg:%s",
                            cmd, e.getCause().getMessage()));
            throw new RuntimeException(e);

        }
        finally {
            if (channel != null && !channel.isClosed()) {
                channel.disconnect();
            }
        }

    }

    /**
     * 上次MR。jar或者其他文件并执行命令
     * 
     * @param localFilePath
     * @param destFilePath
     * @param cmd
     */
    @Override
    public void uploadFileAndExecCmd(String localFilePath, String destFilePath,
            String cmd) {
        ChannelSftp sftpChannel = null;
        try {
            /**
             * 上传MR,shell，spark等作业文件.上传目录固定
             */
            String fixedPath = pro.get("fixed_path");
            if (destFilePath.startsWith("path_prefix")) {
                destFilePath = new StringBuilder().append(fixedPath)
                        .append(destFilePath).toString();
            }
            else {
                destFilePath = new StringBuilder().append(fixedPath)
                        .append("path_prefix").append(destFilePath).toString();
            }

            String mkdirCmd = new StringBuilder()
                    .append("mkdir -p ")
                    .append(StringUtils.substring(destFilePath, 0,
                            destFilePath.lastIndexOf("path_prefix")))
                    .toString();
            boolean isSuc = this.execCmd(mkdirCmd);
            sftpChannel = (com.jcraft.jsch.ChannelSftp) session
                    .openChannel("sftp");
            sftpChannel.connect();
            ;
            int mode = ChannelSftp.OVERWRITE;
            // SftpProgressMonitor monitor=new MyProgressMonitor() ;
            sftpChannel.put(localFilePath, destFilePath, null, mode);

            // if(sftpChannel!=null&&!sftpChannel.isClosed()){
            // sftpChannel.disconnect();
            // }
            /**
             * 执行cmd命令
             */
            boolean isSuc2 = this.execCmd(cmd);
            if (isSuc2 == false) {
                log.error(String.format("exec command error.cmd:%s", cmd));
                throw new RuntimeException(String.format(
                        "exec command error.cmd:%s", cmd));
            }
        }
        catch (Exception e) {
            log.error(String
                    .format("sftp command failure,please check it  .commands:%s .errMsg:%s",
                            cmd, e.getMessage()));
            throw new RuntimeException(e);
        }
        finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
        }

    }

    /**
     * 远程上传shell脚本至服务器并执行相关命令
     * 
     * @param shellFileLocalPath
     */
    @Override
    public void execShell(String shellFileLocalPath) {
        File file = new File(shellFileLocalPath);
        String shellFileName = file.getName();
        String shellfileDir = pro.get("fixed_path") + "shell_fixed_suffix_path";
        String destFilePath = "shell_fixed_suffix_path" + "path_prefix"
                + shellFileName;
        String cmds = new StringBuilder().append("cd ").append(shellfileDir)
                .append(";").append("sudo chmod +x ").append(shellFileName)
                .append(";").append("sh ").append(shellFileName).toString();
        this.uploadFileAndExecCmd(shellFileLocalPath, destFilePath, cmds);
    }

    private static class MyProgressMonitor implements SftpProgressMonitor {
        ProgressMonitor monitor;

        long count = 0;

        long max = 0;

        public void init(int op, String src, String dest, long max) {
            this.max = max;
            monitor = new ProgressMonitor(null,
                    ((op == SftpProgressMonitor.PUT) ? "put" : "get") + ": "
                            + src, "", 0, (int) max);
            count = 0;
            percent = -1;
            monitor.setProgress((int) this.count);
            monitor.setMillisToDecideToPopup(1000);
        }

        private long percent = -1;

        public boolean count(long count) {
            this.count += count;

            if (percent >= this.count * 100 / max) {
                return true;
            }
            percent = this.count * 100 / max;

            monitor.setNote("Completed " + this.count + "(" + percent
                    + "%) out of " + max + ".");
            monitor.setProgress((int) this.count);

            return !(monitor.isCanceled());
        }

        public void end() {
            monitor.close();
        }
    }

}
