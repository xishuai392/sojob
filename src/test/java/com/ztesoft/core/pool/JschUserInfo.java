/**
 * 
 */
package com.ztesoft.core.pool;

import com.jcraft.jsch.UserInfo;

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

public class JschUserInfo implements UserInfo {
    private String user;

    private String password;

    public JschUserInfo(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#getPassphrase()
     */
    @Override
    public String getPassphrase() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#getPassword()
     */
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#promptPassword(java.lang.String)
     */
    @Override
    public boolean promptPassword(String message) {
        // TODO Auto-generated method stub
        return true;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#promptPassphrase(java.lang.String)
     */
    @Override
    public boolean promptPassphrase(String message) {
        // TODO Auto-generated method stub
        return true;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#promptYesNo(java.lang.String)
     */
    @Override
    public boolean promptYesNo(String message) {
        // TODO Auto-generated method stub
        return true;
    }

    /*
     * (non-Javadoc)
     * @see com.jcraft.jsch.UserInfo#showMessage(java.lang.String)
     */
    @Override
    public void showMessage(String message) {
        // TODO Auto-generated method stub

    }

}
