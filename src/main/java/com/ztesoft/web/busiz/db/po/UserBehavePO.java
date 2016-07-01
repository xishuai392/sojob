package com.ztesoft.web.busiz.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class UserBehavePO extends AbstractDto{
	private Integer  behavId;
	private Integer  userId;
	private String  deviceCode;
	private String  deviceType;
	private Integer  sysType;
	private String  sysVersion;
	private String  appVersion;
	private String  userPhone;
	private String  module;
	private String  reqUrl;
	private Date  createDate;
	private String  state;
    public Integer getBehavId() {
        return behavId;
    }
    public void setBehavId(Integer behavId) {
        this.behavId = behavId;
    }

    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getDeviceCode() {
        return StringUtils.isBlank(deviceCode) ? deviceCode : deviceCode.trim();
    }
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }
    
    
    public String getDeviceType() {
        return StringUtils.isBlank(deviceType) ? deviceType : deviceType.trim();
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    
    
    public Integer getSysType() {
        return sysType;
    }
    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    
    public String getSysVersion() {
        return StringUtils.isBlank(sysVersion) ? sysVersion : sysVersion.trim();
    }
    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }
    
    
    public String getAppVersion() {
        return StringUtils.isBlank(appVersion) ? appVersion : appVersion.trim();
    }
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
    
    
    public String getUserPhone() {
        return StringUtils.isBlank(userPhone) ? userPhone : userPhone.trim();
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    
    public String getModule() {
        return StringUtils.isBlank(module) ? module : module.trim();
    }
    public void setModule(String module) {
        this.module = module;
    }
    
    
    public String getReqUrl() {
        return StringUtils.isBlank(reqUrl) ? reqUrl : reqUrl.trim();
    }
    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }
    
    
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
}