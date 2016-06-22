/**
 * 
 */
package com.ztesoft.core.protocol;

import com.ztesoft.core.protocol.common.ServerConfig;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月1日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol <br>
 */

public class TestServerConfig {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerConfig sc1 = new ServerConfig();
        ServerConfig sc2 = new ServerConfig();

        sc1.setHost("10.45.44.188");
        sc1.setUser("zxs");
        sc1.setPassword("zxs88");
        sc1.setPort(22);

        sc2.setHost("10.45.44.188");
        sc2.setUser("zxs");
        sc2.setPassword("zxs88");
        sc2.setPort(22);

        System.out.println("sc1==sc2:" + (sc1 == sc2));
        System.out.println("sc1 equals sc2:" + (sc1.equals(sc2)));
    }

}
