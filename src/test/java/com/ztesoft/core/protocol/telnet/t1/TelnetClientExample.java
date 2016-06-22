/**
 * 
 */
package com.ztesoft.core.protocol.telnet.t1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import org.apache.commons.net.telnet.SimpleOptionHandler;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TelnetNotificationHandler;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年9月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.protocol <br>
 */

public class TelnetClientExample implements Runnable, TelnetNotificationHandler {

    static TelnetClient tc = null;

    public static void main(String[] args) throws Exception {
        FileOutputStream fout = null;
        System.out.println("args:" + args.length);
        args = new String[1];
        args[0] = "10.45.44.202";
        System.out.println("args:" + args.length);
        
        if (args.length < 1) {
            System.err
                    .println("Usage: TelnetClientExample1 <remote-ip> [<remote-port>]");
            System.exit(1);
        }

        String remoteip = args[0];
        int remoteport;
        if (args.length > 1) {
            remoteport = new Integer(args[1]).intValue();
        }
        else {
            remoteport = 23;
        }

        try {
            fout = new FileOutputStream("spy.log", true);
        }
        catch (IOException e) {
            System.err.println("Exception while opening the spy file: "
                    + e.getMessage());
        }

        tc = new TelnetClient();

        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler(
                "VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true,
                false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true,
                true, true);
        try {
            tc.addOptionHandler(ttopt);
            tc.addOptionHandler(echoopt);
            tc.addOptionHandler(gaopt);
        }
        catch (InvalidTelnetOptionException e) {
            System.err.println("Error registering option handlers: "
                    + e.getMessage());
        }

        while (true) {
            boolean end_loop = false;
            try {
                tc.connect(remoteip, remoteport);

                Thread reader = new Thread(new TelnetClientExample());
                tc.registerNotifHandler(new TelnetClientExample());
                System.out.println("TelnetClientExample");
                System.out.println("Type AYT to send an AYT telnet command");
                System.out
                        .println("Type OPT to print a report of status of options (0-24)");
                System.out
                        .println("Type REGISTER to register a new SimpleOptionHandler");
                System.out
                        .println("Type UNREGISTER to unregister an OptionHandler");
                System.out
                        .println("Type SPY to register the spy (connect to port 3333 to spy)");
                System.out.println("Type UNSPY to stop spying the connection");

                reader.start();
                OutputStream outstr = tc.getOutputStream();

                byte[] buff = new byte[1024];
                int ret_read = 0;
                do {
                    try {
                        ret_read = System.in.read(buff);
                        if (ret_read > 0) {
                            if (new String(buff, 0, ret_read).startsWith("AYT")) {
                                try {
                                    System.out.println("Sending AYT");

                                    System.out.println("AYT response:"
                                            + tc.sendAYT(5000L));
                                }
                                catch (IOException e) {
                                    System.err
                                            .println("Exception waiting AYT response: "
                                                    + e.getMessage());
                                }
                            }
                            else if (new String(buff, 0, ret_read)
                                    .startsWith("OPT")) {
                                System.out.println("Status of options:");
                                for (int ii = 0; ii < 25; ++ii) {
                                    System.out.println("Local Option " + ii
                                            + ":" + tc.getLocalOptionState(ii)
                                            + " Remote Option " + ii + ":"
                                            + tc.getRemoteOptionState(ii));
                                }
                            }
                            else if (new String(buff, 0, ret_read)
                                    .startsWith("REGISTER")) {
                                StringTokenizer st = new StringTokenizer(
                                        new String(buff));
                                try {
                                    st.nextToken();
                                    int opcode = Integer.parseInt(st
                                            .nextToken());
                                    boolean initlocal = Boolean.parseBoolean(st
                                            .nextToken());
                                    boolean initremote = Boolean
                                            .parseBoolean(st.nextToken());
                                    boolean acceptlocal = Boolean
                                            .parseBoolean(st.nextToken());
                                    boolean acceptremote = Boolean
                                            .parseBoolean(st.nextToken());
                                    SimpleOptionHandler opthand = new SimpleOptionHandler(
                                            opcode, initlocal, initremote,
                                            acceptlocal, acceptremote);

                                    tc.addOptionHandler(opthand);
                                }
                                catch (Exception e) {
                                    if (e instanceof InvalidTelnetOptionException) {
                                        System.err
                                                .println("Error registering option: "
                                                        + e.getMessage());
                                    }
                                    else {
                                        System.err
                                                .println("Invalid REGISTER command.");
                                        System.err
                                                .println("Use REGISTER optcode initlocal initremote acceptlocal acceptremote");
                                        System.err
                                                .println("(optcode is an integer.)");
                                        System.err
                                                .println("(initlocal, initremote, acceptlocal, acceptremote are boolean)");
                                    }
                                }
                            }
                            else if (new String(buff, 0, ret_read)
                                    .startsWith("UNREGISTER")) {
                                StringTokenizer st = new StringTokenizer(
                                        new String(buff));
                                try {
                                    st.nextToken();
                                    int opcode = new Integer(st.nextToken())
                                            .intValue();
                                    tc.deleteOptionHandler(opcode);
                                }
                                catch (Exception e) {
                                    if (e instanceof InvalidTelnetOptionException) {
                                        System.err
                                                .println("Error unregistering option: "
                                                        + e.getMessage());
                                    }
                                    else {
                                        System.err
                                                .println("Invalid UNREGISTER command.");
                                        System.err
                                                .println("Use UNREGISTER optcode");
                                        System.err
                                                .println("(optcode is an integer)");
                                    }
                                }
                            }
                            else if (new String(buff, 0, ret_read)
                                    .startsWith("SPY")) {
                                tc.registerSpyStream(fout);
                            }
                            else if (new String(buff, 0, ret_read)
                                    .startsWith("UNSPY")) {
                                tc.stopSpyStream();
                            }
                            else {
                                try {
                                    outstr.write(buff, 0, ret_read);
                                    outstr.flush();
                                }
                                catch (IOException e) {
                                    end_loop = true;
                                }
                            }
                        }
                    }
                    catch (IOException e) {
                        System.err.println("Exception while reading keyboard:"
                                + e.getMessage());
                        end_loop = true;
                    }
                }
                while ((ret_read > 0) && (!end_loop));
                try {
                    tc.disconnect();
                }
                catch (IOException e) {
                    System.err.println("Exception while connecting:"
                            + e.getMessage());
                }
            }
            catch (IOException e) {
                System.err.println("Exception while connecting:"
                        + e.getMessage());
                System.exit(1);
            }
        }
    }

    public void receivedNegotiation(int negotiation_code, int option_code) {
        String command = null;
        if (negotiation_code == 1) {
            command = "DO";
        }
        else if (negotiation_code == 2) {
            command = "DONT";
        }
        else if (negotiation_code == 3) {
            command = "WILL";
        }
        else if (negotiation_code == 4) {
            command = "WONT";
        }
        System.out.println("Received " + command + " for option code "
                + option_code);
    }

    public void run() {
        InputStream instr = tc.getInputStream();
        try {
            byte[] buff = new byte[1024];
            int ret_read = 0;
            do {
                ret_read = instr.read(buff);
                if (ret_read <= 0)
                    continue;
                System.out.print(new String(buff, 0, ret_read));
            }

            while (ret_read >= 0);
        }
        catch (IOException e) {
            System.err.println("Exception while reading socket:"
                    + e.getMessage());
        }

        try {
            tc.disconnect();
        }
        catch (IOException e) {
            System.err.println("Exception while closing telnet:"
                    + e.getMessage());
        }
    }

}
