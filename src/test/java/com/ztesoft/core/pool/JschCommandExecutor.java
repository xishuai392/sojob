/**
 * 
 */
package com.ztesoft.core.pool;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Session;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.pool <br>
 */

public class JschCommandExecutor extends AbstractCommandExecutor {
    public JschCommandExecutor(ServerDetails serverDetails) {
        super(serverDetails);
    }

    public AbstractCommandExecutor execute(ExecutableCommand command) {
        Session session = null;
        Channel channel = null;
        try {

            session = StackSessionPool.getInstance().getPool()
                    .borrowObject(serverDetails);
            // ...do stuff
        }
        catch (Exception e) {
            throw new RuntimeException(
                    "ERROR: Unrecoverable error when performing remote command "
                            + e.getMessage(), e);
        }
        finally {
            if (null != channel && channel.isConnected()) {
                channel.disconnect();
            }
            if (null != session) {
                try {
                    StackSessionPool.getInstance().getPool()
                            .returnObject(serverDetails, session);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return this;
    }
}
