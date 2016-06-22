/**
 * 
 */
package com.ztesoft.web.inbound.reponse;

import com.ztesoft.framework.dto.AbstractDto;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.reponse <br>
 */

public class UriInfo extends AbstractDto {

    private String query;
    private String salary;
    private String welfare;
    private String education;
    private String city;
    private String district;
    private String experience;
    private String employertype;
    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }
    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
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
     * @return the welfare
     */
    public String getWelfare() {
        return welfare;
    }
    /**
     * @param welfare the welfare to set
     */
    public void setWelfare(String welfare) {
        this.welfare = welfare;
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
    
    
}
