package com.ztesoft.web.sys.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class SysCityPO extends AbstractDto{
	private Integer  cityId;
	private String  cityName;
	private String  cityShort;
	private String  hot;
	private String  cityPinyin;
	private String  firstChar;
	private Integer  sortNum;
	private Date  createDate;
	private String  state;
    public Integer getCityId() {
        return cityId;
    }
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    
    public String getCityName() {
        return StringUtils.isBlank(cityName) ? cityName : cityName.trim();
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
    public String getCityShort() {
        return StringUtils.isBlank(cityShort) ? cityShort : cityShort.trim();
    }
    public void setCityShort(String cityShort) {
        this.cityShort = cityShort;
    }
    
    
    public String getHot() {
        return StringUtils.isBlank(hot) ? hot : hot.trim();
    }
    public void setHot(String hot) {
        this.hot = hot;
    }
    
    
    public String getCityPinyin() {
        return StringUtils.isBlank(cityPinyin) ? cityPinyin : cityPinyin.trim();
    }
    public void setCityPinyin(String cityPinyin) {
        this.cityPinyin = cityPinyin;
    }
    
    
    public String getFirstChar() {
        return StringUtils.isBlank(firstChar) ? firstChar : firstChar.trim();
    }
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
    
    
    public Integer getSortNum() {
        return sortNum;
    }
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
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