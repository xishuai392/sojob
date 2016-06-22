/**
 * 
 */
package com.ztesoft.core.protocol;

import org.apache.commons.net.telnet.TelnetClient;

import com.ztesoft.core.protocol.client.TelnetClientUtils;
import com.ztesoft.core.protocol.common.CommandResultDto;
import com.ztesoft.core.protocol.common.ServerConfig;
import com.ztesoft.core.protocol.telnet.TelnetClientKeyedObjectPool;
import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月9日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol <br>
 */

public class TestTelnetClient4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig();
        // serverConfig.setHost("10.45.44.91");
        // serverConfig.setUser("doop");
        // serverConfig.setPassword("doop");
        // serverConfig.setPort(23);

        serverConfig.setHost("10.45.44.219");
        serverConfig.setUser("gxhb");
        serverConfig.setPassword("gxhb");
        serverConfig.setPort(23);

        TelnetClient telnetClient = null;
        TelnetClientUtils tu = null;
        try {

            telnetClient = TelnetClientKeyedObjectPool.getInstance().getPool()
                    .borrowObject(serverConfig);

            tu = new TelnetClientUtils(serverConfig, telnetClient);

            boolean isLogin = tu.login(serverConfig.getUser(),
                    serverConfig.getPassword());
            System.out.println(String.format("login .......[%b]", isLogin));
            if (isLogin) {
                CommandResultDto execResult = tu.exec(
                        "vmstat|sed -n '$p'|awk '{print $14}'", 2000);
                System.out.println(String.format("execResult.......[%s]",
                        execResult.getCommandResult()));
                String[] result = execResult.getCommandResult().split("\r\n");
                for (int i = 0; i < result.length; i++) {
                    System.out.println("result[" + i + "]:" + result[i]);
                }
            }

            String info2 = " host=["
                    + serverConfig.getHost()
                    + "],numActive:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumActive()
                    + ",numIdle:"
                    + TelnetClientKeyedObjectPool.getInstance().getPool()
                            .getNumIdle();
            System.out.println(info2);

        }
        catch (Exception e) {
            System.out.println(String.format(
                    " host=[%s] get telnetClent error .......[%s]",
                    serverConfig.getHost(), e.getMessage()));
            e.printStackTrace();
        }
        finally {
            if (null != tu)
                try {
                    tu.returnTelnetClient();
                }
                catch (BaseAppException e) {
                }
        }

    }

}
