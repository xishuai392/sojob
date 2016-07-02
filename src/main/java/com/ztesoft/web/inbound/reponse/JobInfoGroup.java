/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ztesoft.framework.dto.AbstractDto;

/** 
 * <Description>职位聚合 <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.reponse <br>
 */

public class JobInfoGroup extends AbstractDto {
    private String version;
    @JsonProperty("status")
    private String status;
    @JsonProperty("resNum")
    private String resNum;
    private String hilight;
    @JsonProperty("dispNum")
    private String dispNum;
    private String listNum;
    private String page_type;
    @JsonProperty("disp_data")
    private JobInfo[] disp_data;

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

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
     * @return the resNum
     */
    public String getResNum() {
        return resNum;
    }

    /**
     * @param resNum the resNum to set
     */
    public void setResNum(String resNum) {
        this.resNum = resNum;
    }

    /**
     * @return the hilight
     */
    public String getHilight() {
        return hilight;
    }

    /**
     * @param hilight the hilight to set
     */
    public void setHilight(String hilight) {
        this.hilight = hilight;
    }

    /**
     * @return the dispNum
     */
    public String getDispNum() {
        return dispNum;
    }

    /**
     * @param dispNum the dispNum to set
     */
    public void setDispNum(String dispNum) {
        this.dispNum = dispNum;
    }

    /**
     * @return the listNum
     */
    public String getListNum() {
        return listNum;
    }

    /**
     * @param listNum the listNum to set
     */
    public void setListNum(String listNum) {
        this.listNum = listNum;
    }

    /**
     * @return the page_type
     */
    public String getPage_type() {
        return page_type;
    }

    /**
     * @param page_type the page_type to set
     */
    public void setPage_type(String page_type) {
        this.page_type = page_type;
    }

    /**
     * @return the disp_data
     */
    public JobInfo[] getDisp_data() {
        return disp_data;
    }

    /**
     * @param disp_data the disp_data to set
     */
    public void setDisp_data(JobInfo[] disp_data) {
        this.disp_data = disp_data;
    }
    
    
}
