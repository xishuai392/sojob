/**
 * 
 */
package com.ztesoft.web.ftp.demo1;

import java.util.Comparator;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.ftp.demo1 <br>
 */

public class FtpClientComparator implements Comparator<CustomFTPClient> {
    @Override  
    public int compare(CustomFTPClient arg0, CustomFTPClient arg1) {  
        return arg0.order - arg1.order;  
    }  
}
