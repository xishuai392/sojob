/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

import com.ztesoft.framework.dto.AbstractDto;

/** 
 * <Description>百度招聘返回的reponse的body <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.reponse <br>
 */

public class ResponBDZPBody extends AbstractDto {

    private String status;
    private JobInfoGroup data;
    private long threeDays;
    private long onWeek;
    private long tenDays;
    
    private UriInfo uri_info;

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
    public JobInfoGroup getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(JobInfoGroup data) {
        this.data = data;
    }

    /**
     * @return the threeDays
     */
    public long getThreeDays() {
        return threeDays;
    }

    /**
     * @param threeDays the threeDays to set
     */
    public void setThreeDays(long threeDays) {
        this.threeDays = threeDays;
    }

    /**
     * @return the onWeek
     */
    public long getOnWeek() {
        return onWeek;
    }

    /**
     * @param onWeek the onWeek to set
     */
    public void setOnWeek(long onWeek) {
        this.onWeek = onWeek;
    }

    /**
     * @return the tenDays
     */
    public long getTenDays() {
        return tenDays;
    }

    /**
     * @param tenDays the tenDays to set
     */
    public void setTenDays(long tenDays) {
        this.tenDays = tenDays;
    }

    /**
     * @return the uri_info
     */
    public UriInfo getUri_info() {
        return uri_info;
    }

    /**
     * @param uri_info the uri_info to set
     */
    public void setUri_info(UriInfo uri_info) {
        this.uri_info = uri_info;
    }
    
}
