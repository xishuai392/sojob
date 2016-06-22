/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

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

    @JsonProperty("StdStg")
    private String stdStg;
    @JsonProperty("StdStl")
    private String stdStl;
    private String _update_time;
    @JsonProperty("@cts")
    private String cts;
    @JsonProperty("@dts")
    private String dts;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("@ts")
    private String ts;
    private String build;
    private String city;
    private String commonname;
    private String companyID;
    private String companyaddress;
    private String companydescription;
    private String description;
    private String dgw_site;
    private String dgw_trunk;
    private String district;
    private String domain;
    private String education;
    private String email;
    private String employertype;
    private String employerurl;
    private String enddate;
    private String experience;
    private String haswapurl;
    private String industry;
    private String jobfirstclass;
    private String jobfourthclass;
    private String jobsecondclass;
    private String jobthirdclass;
    private String location;
    private String[] n_officialname;
    private String name;
    private String officialname;
    private String ori_city;
    private String ori_district;
    private String ori_education;
    private String ori_employertype;
    private String ori_experience;
    private String ori_jobfirstclass;
    private String ori_jobfourthclass;
    private String ori_jobsecondclass;
    private String ori_jobthirdclass;
    private String ori_salary;
    private String ori_size;
    private String ori_type;
    private String province;
    private String salary;
    private String secondindustry;
    private String sex;
    private String size;
    private String source;
    private String sourcelink;
    private String startdate;
    private String title;
    private String type;
    private String url;
    private String wapurl;
    private String loc;
    @JsonProperty("SiteId")
    private String siteId;
    private String _version;
    private String _select_time;
    private String number;
    @JsonProperty("title_jd")
    private String title_jd;
    @JsonProperty("description_jd")
    private String description_jd;
    /**
     * @return the stdStg
     */
    public String getStdStg() {
        return stdStg;
    }
    /**
     * @param stdStg the stdStg to set
     */
    public void setStdStg(String stdStg) {
        this.stdStg = stdStg;
    }
    /**
     * @return the stdStl
     */
    public String getStdStl() {
        return stdStl;
    }
    /**
     * @param stdStl the stdStl to set
     */
    public void setStdStl(String stdStl) {
        this.stdStl = stdStl;
    }
    /**
     * @return the _update_time
     */
    public String get_update_time() {
        return _update_time;
    }
    /**
     * @param _update_time the _update_time to set
     */
    public void set_update_time(String _update_time) {
        this._update_time = _update_time;
    }
    /**
     * @return the cts
     */
    public String getCts() {
        return cts;
    }
    /**
     * @param cts the cts to set
     */
    public void setCts(String cts) {
        this.cts = cts;
    }
    /**
     * @return the dts
     */
    public String getDts() {
        return dts;
    }
    /**
     * @param dts the dts to set
     */
    public void setDts(String dts) {
        this.dts = dts;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the ts
     */
    public String getTs() {
        return ts;
    }
    /**
     * @param ts the ts to set
     */
    public void setTs(String ts) {
        this.ts = ts;
    }
    /**
     * @return the build
     */
    public String getBuild() {
        return build;
    }
    /**
     * @param build the build to set
     */
    public void setBuild(String build) {
        this.build = build;
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
     * @return the companyID
     */
    public String getCompanyID() {
        return companyID;
    }
    /**
     * @param companyID the companyID to set
     */
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    /**
     * @return the companyaddress
     */
    public String getCompanyaddress() {
        return companyaddress;
    }
    /**
     * @param companyaddress the companyaddress to set
     */
    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }
    /**
     * @return the companydescription
     */
    public String getCompanydescription() {
        return companydescription;
    }
    /**
     * @param companydescription the companydescription to set
     */
    public void setCompanydescription(String companydescription) {
        this.companydescription = companydescription;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the dgw_site
     */
    public String getDgw_site() {
        return dgw_site;
    }
    /**
     * @param dgw_site the dgw_site to set
     */
    public void setDgw_site(String dgw_site) {
        this.dgw_site = dgw_site;
    }
    /**
     * @return the dgw_trunk
     */
    public String getDgw_trunk() {
        return dgw_trunk;
    }
    /**
     * @param dgw_trunk the dgw_trunk to set
     */
    public void setDgw_trunk(String dgw_trunk) {
        this.dgw_trunk = dgw_trunk;
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
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }
    /**
     * @param domain the domain to set
     */
    public void setDomain(String domain) {
        this.domain = domain;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the employertype
     */
    public String getEmployertype() {
        return employertype;
    }
    /**
     * @param employertype the employertype to set
     */
    public void setEmployertype(String employertype) {
        this.employertype = employertype;
    }
    /**
     * @return the employerurl
     */
    public String getEmployerurl() {
        return employerurl;
    }
    /**
     * @param employerurl the employerurl to set
     */
    public void setEmployerurl(String employerurl) {
        this.employerurl = employerurl;
    }
    /**
     * @return the enddate
     */
    public String getEnddate() {
        return enddate;
    }
    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    /**
     * @return the experience
     */
    public String getExperience() {
        return experience;
    }
    /**
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }
    /**
     * @return the haswapurl
     */
    public String getHaswapurl() {
        return haswapurl;
    }
    /**
     * @param haswapurl the haswapurl to set
     */
    public void setHaswapurl(String haswapurl) {
        this.haswapurl = haswapurl;
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
     * @return the jobfirstclass
     */
    public String getJobfirstclass() {
        return jobfirstclass;
    }
    /**
     * @param jobfirstclass the jobfirstclass to set
     */
    public void setJobfirstclass(String jobfirstclass) {
        this.jobfirstclass = jobfirstclass;
    }
    /**
     * @return the jobfourthclass
     */
    public String getJobfourthclass() {
        return jobfourthclass;
    }
    /**
     * @param jobfourthclass the jobfourthclass to set
     */
    public void setJobfourthclass(String jobfourthclass) {
        this.jobfourthclass = jobfourthclass;
    }
    /**
     * @return the jobsecondclass
     */
    public String getJobsecondclass() {
        return jobsecondclass;
    }
    /**
     * @param jobsecondclass the jobsecondclass to set
     */
    public void setJobsecondclass(String jobsecondclass) {
        this.jobsecondclass = jobsecondclass;
    }
    /**
     * @return the jobthirdclass
     */
    public String getJobthirdclass() {
        return jobthirdclass;
    }
    /**
     * @param jobthirdclass the jobthirdclass to set
     */
    public void setJobthirdclass(String jobthirdclass) {
        this.jobthirdclass = jobthirdclass;
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
     * @return the n_officialname
     */
    public String[] getN_officialname() {
        return n_officialname;
    }
    /**
     * @param n_officialname the n_officialname to set
     */
    public void setN_officialname(String[] n_officialname) {
        this.n_officialname = n_officialname;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the officialname
     */
    public String getOfficialname() {
        return officialname;
    }
    /**
     * @param officialname the officialname to set
     */
    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }
    /**
     * @return the ori_city
     */
    public String getOri_city() {
        return ori_city;
    }
    /**
     * @param ori_city the ori_city to set
     */
    public void setOri_city(String ori_city) {
        this.ori_city = ori_city;
    }
    /**
     * @return the ori_district
     */
    public String getOri_district() {
        return ori_district;
    }
    /**
     * @param ori_district the ori_district to set
     */
    public void setOri_district(String ori_district) {
        this.ori_district = ori_district;
    }
    /**
     * @return the ori_education
     */
    public String getOri_education() {
        return ori_education;
    }
    /**
     * @param ori_education the ori_education to set
     */
    public void setOri_education(String ori_education) {
        this.ori_education = ori_education;
    }
    /**
     * @return the ori_employertype
     */
    public String getOri_employertype() {
        return ori_employertype;
    }
    /**
     * @param ori_employertype the ori_employertype to set
     */
    public void setOri_employertype(String ori_employertype) {
        this.ori_employertype = ori_employertype;
    }
    /**
     * @return the ori_experience
     */
    public String getOri_experience() {
        return ori_experience;
    }
    /**
     * @param ori_experience the ori_experience to set
     */
    public void setOri_experience(String ori_experience) {
        this.ori_experience = ori_experience;
    }
    /**
     * @return the ori_jobfirstclass
     */
    public String getOri_jobfirstclass() {
        return ori_jobfirstclass;
    }
    /**
     * @param ori_jobfirstclass the ori_jobfirstclass to set
     */
    public void setOri_jobfirstclass(String ori_jobfirstclass) {
        this.ori_jobfirstclass = ori_jobfirstclass;
    }
    /**
     * @return the ori_jobfourthclass
     */
    public String getOri_jobfourthclass() {
        return ori_jobfourthclass;
    }
    /**
     * @param ori_jobfourthclass the ori_jobfourthclass to set
     */
    public void setOri_jobfourthclass(String ori_jobfourthclass) {
        this.ori_jobfourthclass = ori_jobfourthclass;
    }
    /**
     * @return the ori_jobsecondclass
     */
    public String getOri_jobsecondclass() {
        return ori_jobsecondclass;
    }
    /**
     * @param ori_jobsecondclass the ori_jobsecondclass to set
     */
    public void setOri_jobsecondclass(String ori_jobsecondclass) {
        this.ori_jobsecondclass = ori_jobsecondclass;
    }
    /**
     * @return the ori_jobthirdclass
     */
    public String getOri_jobthirdclass() {
        return ori_jobthirdclass;
    }
    /**
     * @param ori_jobthirdclass the ori_jobthirdclass to set
     */
    public void setOri_jobthirdclass(String ori_jobthirdclass) {
        this.ori_jobthirdclass = ori_jobthirdclass;
    }
    /**
     * @return the ori_salary
     */
    public String getOri_salary() {
        return ori_salary;
    }
    /**
     * @param ori_salary the ori_salary to set
     */
    public void setOri_salary(String ori_salary) {
        this.ori_salary = ori_salary;
    }
    /**
     * @return the ori_size
     */
    public String getOri_size() {
        return ori_size;
    }
    /**
     * @param ori_size the ori_size to set
     */
    public void setOri_size(String ori_size) {
        this.ori_size = ori_size;
    }
    /**
     * @return the ori_type
     */
    public String getOri_type() {
        return ori_type;
    }
    /**
     * @param ori_type the ori_type to set
     */
    public void setOri_type(String ori_type) {
        this.ori_type = ori_type;
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
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }
    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }
    /**
     * @return the secondindustry
     */
    public String getSecondindustry() {
        return secondindustry;
    }
    /**
     * @param secondindustry the secondindustry to set
     */
    public void setSecondindustry(String secondindustry) {
        this.secondindustry = secondindustry;
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
     * @return the size
     */
    public String getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }
    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * @return the sourcelink
     */
    public String getSourcelink() {
        return sourcelink;
    }
    /**
     * @param sourcelink the sourcelink to set
     */
    public void setSourcelink(String sourcelink) {
        this.sourcelink = sourcelink;
    }
    /**
     * @return the startdate
     */
    public String getStartdate() {
        return startdate;
    }
    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * @return the wapurl
     */
    public String getWapurl() {
        return wapurl;
    }
    /**
     * @param wapurl the wapurl to set
     */
    public void setWapurl(String wapurl) {
        this.wapurl = wapurl;
    }
    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }
    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
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
     * @return the _version
     */
    public String get_version() {
        return _version;
    }
    /**
     * @param _version the _version to set
     */
    public void set_version(String _version) {
        this._version = _version;
    }
    /**
     * @return the _select_time
     */
    public String get_select_time() {
        return _select_time;
    }
    /**
     * @param _select_time the _select_time to set
     */
    public void set_select_time(String _select_time) {
        this._select_time = _select_time;
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
     * @return the title_jd
     */
    public String getTitle_jd() {
        return title_jd;
    }
    /**
     * @param title_jd the title_jd to set
     */
    public void setTitle_jd(String title_jd) {
        this.title_jd = title_jd;
    }
    /**
     * @return the description_jd
     */
    public String getDescription_jd() {
        return description_jd;
    }
    /**
     * @param description_jd the description_jd to set
     */
    public void setDescription_jd(String description_jd) {
        this.description_jd = description_jd;
    }
    
    
}
