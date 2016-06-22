package com.ztesoft.web.command.demo4;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class SSHClient {
	
	private String passWord;
	private String host;
	private String user;
	private Session session;
	private Channel channel;
	public SSHClient(String user,String passWord,String host){
		this.user=user;
		this.passWord=passWord;
		this.host=host;
	}
	
	public void creatSession() throws JSchException{
		JSch jsch=new JSch();
		session=jsch.getSession(user, host, 22);
		
		UserInfo ui=new SSHUserInfo(passWord);
		session.setUserInfo(ui);
		session.connect(40000);
	}
	
	public Channel getExecChannel() throws JSchException{
		channel=session.openChannel("exec");
		return channel;
	}
	
	public Channel getShellChannel() throws JSchException{
		channel=session.openChannel("shell");
		return channel;
	}
	
	public Channel getSftpChannel() throws JSchException{
		channel=session.openChannel("sftp");
		return channel;
	}
	
	public void closeConnect(){
		if(channel!=null){
			channel.disconnect();
		}
		if(session!=null){
			session.disconnect();
		}
	}
}
