/**
 * 
 */
package com.ztesoft.web.command.demo2;

import com.jcraft.jsch.SftpProgressMonitor;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.command.demo2 <br>
 */

public class FileProgressMonitor implements SftpProgressMonitor {

    /* (non-Javadoc)
     * @see com.jcraft.jsch.SftpProgressMonitor#init(int, java.lang.String, java.lang.String, long)
     */
    @Override
    public void init(int op, String src, String dest, long max) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.jcraft.jsch.SftpProgressMonitor#count(long)
     */
    @Override
    public boolean count(long count) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.jcraft.jsch.SftpProgressMonitor#end()
     */
    @Override
    public void end() {
        // TODO Auto-generated method stub

    }

}
