package com.ztesoft.web.command.demo4;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class SSHUserInfo implements UserInfo, UIKeyboardInteractive{

	String passwd;
	
	public SSHUserInfo(String passwd){
		this.passwd=passwd;
	}
	@Override
	public String[] promptKeyboardInteractive(String destination, String name,
			String instruction, String[] prompt, boolean[] echo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassphrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passwd;
	}

	@Override
	public boolean promptPassphrase(String message) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean promptPassword(String message) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean promptYesNo(String message) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}
