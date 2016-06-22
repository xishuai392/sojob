/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

import com.ztesoft.framework.dto.AbstractDto;

/** 
 * <Description>百度招聘返回的reponse整体 <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.reponse <br>
 */

public class ResponBDZP extends AbstractDto {
    private String status;
    private ResponBDZPBody data;
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the data
     */
    public ResponBDZPBody getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(ResponBDZPBody data) {
        this.data = data;
    }
    
}
