/**
 * 
 */
package com.ztesoft.web.command.demo6;

import java.net.Socket;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月30日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.command.demo6 <br>
 */

public class TestSocket {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Config config = new Config();
        config.maxActive = 16;
        config.maxWait = 30000;
        ConnectionPoolFactory poolFactory = new ConnectionPoolFactory(config,
                "127.0.0.1", 8011);
        Socket socket = null;
        try {
            socket = poolFactory.getConnection();
            // //
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                poolFactory.releaseConnection(socket);
            }
        }

    }

}
