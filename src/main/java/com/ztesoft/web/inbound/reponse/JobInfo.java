/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ztesoft.framework.dto.AbstractDto;

/** 
 * <Description>每个职位描述 <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.reponse <br>
 */

public class JobInfo extends AbstractDto {
    @JsonProperty("name")
    private String jobName;
    @JsonProperty("commonname")
    private String commonname;
    @JsonProperty("officialname")
    private String compName;
    @JsonProperty("companyID")
    private String compId;
    @JsonProperty("companyaddress")
    private String compAddr;
    @JsonProperty("companydescription")
    private String compDesc;
    @JsonProperty("email")
    private String compEmail;//公司邮箱
    @JsonProperty("employertype")
    private String[] employertype;//公司性质
    @JsonProperty("size")
    private String[] size;//公司规模
    @JsonProperty("salary")
    private String salaryRange;
    
    
    @JsonProperty("province")
    private String  province;//省份
    @JsonProperty("city")
    private String  city;//城市
    @JsonProperty("district")
    private String  district;
    @JsonProperty("location")
    private String  location;
    
    @JsonProperty("description")
    private String  jobDesc;//岗位描述
    @JsonProperty("type")
    private String  jobType;//岗位类型：全职等
    @JsonProperty("education")
    private String  education;
    @JsonProperty("sex")
    private String  sex;
    @JsonProperty("number")
    private String  number;
    @JsonProperty("experience")
    private String[]  experience;
    @JsonProperty("jobfirstclass")
    private String  jobFirstClass;
    @JsonProperty("jobsecondclass")
    private String  jobSecondClass;
    @JsonProperty("jobthirdclass")
    private String  jobThirdClass;
    @JsonProperty("jobfourthclass")
    private String  jobFourthClass;
    @JsonProperty("industry")
    private String  industry;
    @JsonProperty("startdate")
    private String  startDateStr;
    @JsonProperty("enddate")
    private String  endDateStr;
    @JsonProperty("SiteId")
    private String  siteId;
    @JsonProperty("source")
    private String  siteName;
    @JsonProperty("sourcelink")
    private String  siteUrl;
    @JsonProperty("url")
    private String  jobUrl;
    @JsonProperty("_version")
    private Long  version;
    @JsonProperty("@cts")
    private Long  cts;
    @JsonProperty("@dts")
    private Long  dts;
    @JsonProperty("@id")
    private String  idts;
    @JsonProperty("@ts")
    private Long  ts;
    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }
    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    /**
     * @return the commonname
     */
    public String getCommonname() {
        return commonname;
    }
    /**
     * @param commonname the commonname to set
     */
    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }
    /**
     * @return the compName
     */
    public String getCompName() {
        return compName;
    }
    /**
     * @param compName the compName to set
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }
    /**
     * @return the compId
     */
    public String getCompId() {
        return compId;
    }
    /**
     * @param compId the compId to set
     */
    public void setCompId(String compId) {
        this.compId = compId;
    }
    /**
     * @return the compAddr
     */
    public String getCompAddr() {
        return compAddr;
    }
    /**
     * @param compAddr the compAddr to set
     */
    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }
    /**
     * @return the compDesc
     */
    public String getCompDesc() {
        return compDesc;
    }
    /**
     * @param compDesc the compDesc to set
     */
    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }
    /**
     * @return the compEmail
     */
    public String getCompEmail() {
        return compEmail;
    }
    /**
     * @param compEmail the compEmail to set
     */
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }
    /**
     * @return the employertype
     */
    public String[] getEmployertype() {
        return employertype;
    }
    /**
     * @param employertype the employertype to set
     */
    public void setEmployertype(String[] employertype) {
        this.employertype = employertype;
    }
    /**
     * @return the size
     */
    public String[] getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(String[] size) {
        this.size = size;
    }
    /**
     * @return the salaryRange
     */
    public String getSalaryRange() {
        return salaryRange;
    }
    /**
     * @param salaryRange the salaryRange to set
     */
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }
    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return the jobDesc
     */
    public String getJobDesc() {
        return jobDesc;
    }
    /**
     * @param jobDesc the jobDesc to set
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    /**
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }
    /**
     * @param jobType the jobType to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }
    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * @return the experience
     */
    public String[] getExperience() {
        return experience;
    }
    /**
     * @param experience the experience to set
     */
    public void setExperience(String[] experience) {
        this.experience = experience;
    }
    /**
     * @return the jobFirstClass
     */
    public String getJobFirstClass() {
        return jobFirstClass;
    }
    /**
     * @param jobFirstClass the jobFirstClass to set
     */
    public void setJobFirstClass(String jobFirstClass) {
        this.jobFirstClass = jobFirstClass;
    }
    /**
     * @return the jobSecondClass
     */
    public String getJobSecondClass() {
        return jobSecondClass;
    }
    /**
     * @param jobSecondClass the jobSecondClass to set
     */
    public void setJobSecondClass(String jobSecondClass) {
        this.jobSecondClass = jobSecondClass;
    }
    /**
     * @return the jobThirdClass
     */
    public String getJobThirdClass() {
        return jobThirdClass;
    }
    /**
     * @param jobThirdClass the jobThirdClass to set
     */
    public void setJobThirdClass(String jobThirdClass) {
        this.jobThirdClass = jobThirdClass;
    }
    /**
     * @return the jobFourthClass
     */
    public String getJobFourthClass() {
        return jobFourthClass;
    }
    /**
     * @param jobFourthClass the jobFourthClass to set
     */
    public void setJobFourthClass(String jobFourthClass) {
        this.jobFourthClass = jobFourthClass;
    }
    /**
     * @return the industry
     */
    public String getIndustry() {
        return industry;
    }
    /**
     * @param industry the industry to set
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    /**
     * @return the startDateStr
     */
    public String getStartDateStr() {
        return startDateStr;
    }
    /**
     * @param startDateStr the startDateStr to set
     */
    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }
    /**
     * @return the endDateStr
     */
    public String getEndDateStr() {
        return endDateStr;
    }
    /**
     * @param endDateStr the endDateStr to set
     */
    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }
    /**
     * @return the siteId
     */
    public String getSiteId() {
        return siteId;
    }
    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    /**
     * @return the siteName
     */
    public String getSiteName() {
        return siteName;
    }
    /**
     * @param siteName the siteName to set
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    /**
     * @return the siteUrl
     */
    public String getSiteUrl() {
        return siteUrl;
    }
    /**
     * @param siteUrl the siteUrl to set
     */
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
    /**
     * @return the jobUrl
     */
    public String getJobUrl() {
        return jobUrl;
    }
    /**
     * @param jobUrl the jobUrl to set
     */
    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }
    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }
    /**
     * @return the cts
     */
    public Long getCts() {
        return cts;
    }
    /**
     * @param cts the cts to set
     */
    public void setCts(Long cts) {
        this.cts = cts;
    }
    /**
     * @return the dts
     */
    public Long getDts() {
        return dts;
    }
    /**
     * @param dts the dts to set
     */
    public void setDts(Long dts) {
        this.dts = dts;
    }
    /**
     * @return the idts
     */
    public String getIdts() {
        return idts;
    }
    /**
     * @param idts the idts to set
     */
    public void setIdts(String idts) {
        this.idts = idts;
    }
    /**
     * @return the ts
     */
    public Long getTs() {
        return ts;
    }
    /**
     * @param ts the ts to set
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }
    
    
    
    
    
    
    
}
