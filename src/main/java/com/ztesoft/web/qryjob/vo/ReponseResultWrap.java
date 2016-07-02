/**
 * 
 */
package com.ztesoft.web.qryjob.vo;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description>返回结果包装 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年7月2日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.qryjob.vo <br>
 */

public class ReponseResultWrap<T> extends AbstractDto {
    private boolean success = true;

    private String msg = "";

    private String errCode = "";

    private T entity;

    public ReponseResultWrap() {

    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * @return the entity
     */
    public T getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(T entity) {
        this.entity = entity;
    }

}
