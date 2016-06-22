package com.ztesoft.web.command.demo5;

/**
 * 类描述：通过ssh方式远程连接服务器执行命令的接口
 * @author: xu.xin
 * 
 *          History:2015  上午11:22:03 xu.xin Created.
 * 
 */
public interface ISSHClient {

	/**
	 * @param cmd
	 * @return 
	 */
	boolean execCmd(String cmd);

	/**
	 * @param localFilePath
	 * @param destFilePath
	 * @param cmd
	 */
	void uploadFileAndExecCmd(String localFilePath, String destFilePath,
			String cmd);

	/**
	 * @param shellFileLocalPath
	 */
	void execShell(String shellFileLocalPath);

}
