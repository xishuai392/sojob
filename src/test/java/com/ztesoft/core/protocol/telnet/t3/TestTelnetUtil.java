/**
 * 
 */
package com.ztesoft.core.protocol.telnet.t3;

import java.io.IOException;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol.telnet.t3 <br>
 */

public class TestTelnetUtil {
    static void t2() {
        TelnetUtil tu = new TelnetUtil();
        try {
            tu.connect("10.45.44.202");
            System.out.println(tu.login("dccDop", "dccDop"));
            // tu.show();
            // System.out.println(tu.readString());
            // System.out.println(tu.exec("pwd"));

            System.out.println(tu.exec("echo \"123456789\">test.txt"));
            System.out.println(tu.exec("cat test.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        tu.close();
    }

    static void t1() {
        TelnetUtil tu = new TelnetUtil();
        try {
            tu.connect("10.45.44.202");
            System.out.println(tu.login("dccDop", "dccDop"));
            // tu.show();
            // System.out.println(tu.readString());
            System.out.println(tu.exec("pwd"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        tu.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestTelnetUtil.t1();
        TestTelnetUtil.t2();
    }

}
