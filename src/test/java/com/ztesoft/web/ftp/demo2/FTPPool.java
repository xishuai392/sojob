/**
 * 
 */
package com.ztesoft.web.ftp.demo2;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.impl.GenericObjectPool.Config;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo2 <br>
 */

public class FTPPool extends Pool<FTPClient> {
    public FTPPool(Config poolConfig, String host, int port, String user,
            String password, String passiveModeConf) {
        super(poolConfig, new FTPPoolableObjectFactory(host, port, user,
                password, passiveModeConf));
    }
}
