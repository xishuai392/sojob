package com.ztesoft.web.busiz.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class SjJobPO extends AbstractDto{
	private Integer  jobId;
	private String  jobName;
	private String  compName;
	private String  compId;
	private String  compAddr;
	private String  compDesc;
	private String  compEmail;
	private String  compType;
	private String  compScale;
	private Integer  compScaleMin;
	private Integer  compScaleMax;
	private String  salaryRange;
	private Integer  salaryMin;
	private Integer  salaryMax;
	private String  province;
	private String  city;
	private String  district;
	private String  location;
	private String  jobDesc;
	private String  jobType;
	private String  education;
	private String  sex;
	private String  number;
	private String  exp;
	private Integer  expMin;
	private Integer  expMax;
	private String  jobFirstClass;
	private String  jobSecondClass;
	private String  jobThirdClass;
	private String  jobFourthClass;
	private String  industry;
	private Date  startDate;
	private Date  endDate;
	private String  siteId;
	private String  siteName;
	private String  siteUrl;
	private String  jobUrl;
	private Long  version;
	private Long  cts;
	private Long  dts;
	private String  idts;
	private Long  ts;
	private String  state;
	private Integer  sortNum;
	private Integer  taskId;
	private Date  createDate;
    public Integer getJobId() {
        return jobId;
    }
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    
    public String getJobName() {
        return StringUtils.isBlank(jobName) ? jobName : jobName.trim();
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    
    public String getCompName() {
        return StringUtils.isBlank(compName) ? compName : compName.trim();
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }
    
    
    public String getCompId() {
        return StringUtils.isBlank(compId) ? compId : compId.trim();
    }
    public void setCompId(String compId) {
        this.compId = compId;
    }
    
    
    public String getCompAddr() {
        return StringUtils.isBlank(compAddr) ? compAddr : compAddr.trim();
    }
    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }
    
    
    public String getCompDesc() {
        return StringUtils.isBlank(compDesc) ? compDesc : compDesc.trim();
    }
    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }
    
    
    public String getCompEmail() {
        return StringUtils.isBlank(compEmail) ? compEmail : compEmail.trim();
    }
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }
    
    
    public String getCompType() {
        return StringUtils.isBlank(compType) ? compType : compType.trim();
    }
    public void setCompType(String compType) {
        this.compType = compType;
    }
    
    
    public String getCompScale() {
        return StringUtils.isBlank(compScale) ? compScale : compScale.trim();
    }
    public void setCompScale(String compScale) {
        this.compScale = compScale;
    }
    
    
    public Integer getCompScaleMin() {
        return compScaleMin;
    }
    public void setCompScaleMin(Integer compScaleMin) {
        this.compScaleMin = compScaleMin;
    }

    
    public Integer getCompScaleMax() {
        return compScaleMax;
    }
    public void setCompScaleMax(Integer compScaleMax) {
        this.compScaleMax = compScaleMax;
    }

    
    public String getSalaryRange() {
        return StringUtils.isBlank(salaryRange) ? salaryRange : salaryRange.trim();
    }
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
    
    public Integer getSalaryMin() {
        return salaryMin;
    }
    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    
    public Integer getSalaryMax() {
        return salaryMax;
    }
    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    
    public String getProvince() {
        return StringUtils.isBlank(province) ? province : province.trim();
    }
    public void setProvince(String province) {
        this.province = province;
    }
    
    
    public String getCity() {
        return StringUtils.isBlank(city) ? city : city.trim();
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String getDistrict() {
        return StringUtils.isBlank(district) ? district : district.trim();
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    
    
    public String getLocation() {
        return StringUtils.isBlank(location) ? location : location.trim();
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    
    public String getJobDesc() {
        return StringUtils.isBlank(jobDesc) ? jobDesc : jobDesc.trim();
    }
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    
    
    public String getJobType() {
        return StringUtils.isBlank(jobType) ? jobType : jobType.trim();
    }
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    
    public String getEducation() {
        return StringUtils.isBlank(education) ? education : education.trim();
    }
    public void setEducation(String education) {
        this.education = education;
    }
    
    
    public String getSex() {
        return StringUtils.isBlank(sex) ? sex : sex.trim();
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
    public String getNumber() {
        return StringUtils.isBlank(number) ? number : number.trim();
    }
    public void setNumber(String number) {
        this.number = number;
    }
    
    
    public String getExp() {
        return StringUtils.isBlank(exp) ? exp : exp.trim();
    }
    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
    public Integer getExpMin() {
        return expMin;
    }
    public void setExpMin(Integer expMin) {
        this.expMin = expMin;
    }

    
    public Integer getExpMax() {
        return expMax;
    }
    public void setExpMax(Integer expMax) {
        this.expMax = expMax;
    }

    
    public String getJobFirstClass() {
        return StringUtils.isBlank(jobFirstClass) ? jobFirstClass : jobFirstClass.trim();
    }
    public void setJobFirstClass(String jobFirstClass) {
        this.jobFirstClass = jobFirstClass;
    }
    
    
    public String getJobSecondClass() {
        return StringUtils.isBlank(jobSecondClass) ? jobSecondClass : jobSecondClass.trim();
    }
    public void setJobSecondClass(String jobSecondClass) {
        this.jobSecondClass = jobSecondClass;
    }
    
    
    public String getJobThirdClass() {
        return StringUtils.isBlank(jobThirdClass) ? jobThirdClass : jobThirdClass.trim();
    }
    public void setJobThirdClass(String jobThirdClass) {
        this.jobThirdClass = jobThirdClass;
    }
    
    
    public String getJobFourthClass() {
        return StringUtils.isBlank(jobFourthClass) ? jobFourthClass : jobFourthClass.trim();
    }
    public void setJobFourthClass(String jobFourthClass) {
        this.jobFourthClass = jobFourthClass;
    }
    
    
    public String getIndustry() {
        return StringUtils.isBlank(industry) ? industry : industry.trim();
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    public String getSiteId() {
        return StringUtils.isBlank(siteId) ? siteId : siteId.trim();
    }
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }
    
    
    public String getSiteName() {
        return StringUtils.isBlank(siteName) ? siteName : siteName.trim();
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    
    
    public String getSiteUrl() {
        return StringUtils.isBlank(siteUrl) ? siteUrl : siteUrl.trim();
    }
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
    
    
    public String getJobUrl() {
        return StringUtils.isBlank(jobUrl) ? jobUrl : jobUrl.trim();
    }
    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }
    
    
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    
    public Long getCts() {
        return cts;
    }
    public void setCts(Long cts) {
        this.cts = cts;
    }

    
    public Long getDts() {
        return dts;
    }
    public void setDts(Long dts) {
        this.dts = dts;
    }

    
    public String getIdts() {
        return StringUtils.isBlank(idts) ? idts : idts.trim();
    }
    public void setIdts(String idts) {
        this.idts = idts;
    }
    
    
    public Long getTs() {
        return ts;
    }
    public void setTs(Long ts) {
        this.ts = ts;
    }

    
    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
    public Integer getSortNum() {
        return sortNum;
    }
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    
    public Integer getTaskId() {
        return taskId;
    }
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
}