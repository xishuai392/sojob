/**
 * 
 */
package com.ztesoft.core.protocol.telnet;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;

import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>TelnetClient的工厂类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol.telnet <br>
 */

public class TelnetClientFactory extends
        BaseKeyedPoolableObjectFactory<ServerConfig, TelnetClient> {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TelnetClientFactory.class);

    /**
     * This creates a Session if not already present in the pool.
     */
    @Override
    public synchronized TelnetClient makeObject(ServerConfig serverConfig)
            throws BaseAppException {
        TelnetClient telnetClient = null;
        // 默认端口 22
        if (serverConfig.getPort() == 0) {
            serverConfig.setPort(23);
        }
        try {
            telnetClient = new TelnetClient();
            telnetClient
                    .connect(serverConfig.getHost(), serverConfig.getPort());
            telnetClient.setConnectTimeout(serverConfig.getTimeout());

        }
        catch (Exception e) {
            logger.error(
                    "ERROR: Unrecoverable error when trying to telnet connect to serverConfig :  "
                            + serverConfig, e);
            throw ExceptionHandler.publish("APP-00-0080",
                    "ERROR: Unrecoverable error when trying to telnet connect to serverConfig :  "
                            + serverConfig, e);

        }
        return telnetClient;
    }

    /**
     * This is called when closing the pool object
     * 
     * @throws IOException
     */
    @Override
    public synchronized void destroyObject(ServerConfig serverConfig,
            TelnetClient telnetClient) throws IOException {
        telnetClient.disconnect();
    }

    /*
     * (non-Javadoc)
     * @see org.apache.commons.pool.BaseKeyedPoolableObjectFactory#validateObject(java.lang.Object, java.lang.Object)
     */
    @Override
    public synchronized boolean validateObject(ServerConfig key,
            TelnetClient telnetClient) {
        return telnetClient.isConnected();
    }

    /*
     * (non-Javadoc)
     * @see org.apache.commons.pool.BaseKeyedPoolableObjectFactory#activateObject(java.lang.Object, java.lang.Object)
     */
    @Override
    public synchronized void activateObject(ServerConfig serverConfig,
            TelnetClient telnetClient) throws Exception {
        super.activateObject(serverConfig, telnetClient);
        telnetClient.connect(serverConfig.getHost(), serverConfig.getPort());
        telnetClient.setConnectTimeout(serverConfig.getTimeout());
    }

    /*
     * (non-Javadoc)
     * @see org.apache.commons.pool.BaseKeyedPoolableObjectFactory#passivateObject(java.lang.Object, java.lang.Object)
     */
    @Override
    public synchronized void passivateObject(ServerConfig key, TelnetClient obj)
            throws Exception {
        super.passivateObject(key, obj);
        obj.disconnect();
    }

}
