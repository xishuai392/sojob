/**
 * 
 */
package com.ztesoft.web.inbound.param;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringEscapeUtils;

import com.ztesoft.framework.dto.AbstractDto;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.FrameWorkConstants;
import com.ztesoft.framework.util.StringUtils;

/**
 * <Description> 百度招聘请求参数<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.param <br>
 */

public class QryParamBDZP extends AbstractDto {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(QryParamBDZP.class);

    // 关键词
    private String query;

    // 月薪，不限为空，范围以“_”分割，例如：10000以上：&salary=10000_99999999
    // 月薪：不限,面议,2000以下,2001-3000,3001-5000,5001-8000,8001-10000,10000以上,自定义
    private String salary;

    // 福利，多选 空：不限，多个值以“,”分割，
    // 不限,五险一金,年度旅游,餐补,房补,通讯补贴,绩效奖金,年底双薪,年终分红,加班补助
    private String welfare;

    // 学历，下拉 空：不限
    private String education;

    // 排序方式：空：默认， 5：按发布时间倒序，4：按薪资倒序
    private String sort_key;

    // 默认1
    private String sort_type = "1";

    // 城市
    private String city;

    // 地区
    private String district;

    // 工作经验
    private String experience;

    // 公司性质
    private String employertype;

    //
    private String jobfirstclass;

    private String jobsecondclass;

    private String jobthirdclass;

    // 发布时间： yyyyMMdd_yyyyMMdd
    private String date;

    //
    private String detailmode = "close";

    // 分页参数中，等价于pagesize，每页记录数
    private String rn;

    // 分页参数中，起始记录下标，从0开始
    private String pn;

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
     * @return the sort_key
     */
    public String getSort_key() {
        return sort_key;
    }

    /**
     * @param sort_key the sort_key to set
     */
    public void setSort_key(String sort_key) {
        this.sort_key = sort_key;
    }

    /**
     * @return the sort_type
     */
    public String getSort_type() {
        return sort_type;
    }

    /**
     * @param sort_type the sort_type to set
     */
    public void setSort_type(String sort_type) {
        this.sort_type = sort_type;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the detailmode
     */
    public String getDetailmode() {
        return detailmode;
    }

    /**
     * @param detailmode the detailmode to set
     */
    public void setDetailmode(String detailmode) {
        this.detailmode = detailmode;
    }

    /**
     * @return the rn
     */
    public String getRn() {
        return rn;
    }

    /**
     * @param rn the rn to set
     */
    public void setRn(String rn) {
        this.rn = rn;
    }

    /**
     * @return the pn
     */
    public String getPn() {
        return pn;
    }

    /**
     * @param pn the pn to set
     */
    public void setPn(String pn) {
        this.pn = pn;
    }

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

    // 转换成URL地址
    public String encodeToUrl() throws BaseAppException {
        StringBuffer strb = new StringBuffer();
        try {
//            strb.append("query=").append(
//                    new String(StringUtils.encode(
//                            StringUtils.toString(this.query),
//                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));

//            strb.append("query=").append(
//                    java.net.URLEncoder.encode(
//                            StringUtils.toString(this.query),
//                            FrameWorkConstants.UTF_8_ENCODING));
            
            strb.append("query=").append(
                    StringEscapeUtils.escapeJava(this.query));
            

            strb.append("&salary=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.salary),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&welfare=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.welfare),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&education=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.education),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&sort_key=").append(
                    StringUtils.toString(this.sort_key));
            strb.append("&sort_type=").append(
                    StringUtils.toString(this.sort_type));
            strb.append("&city=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.city),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&district=").append(
                    StringUtils.toString(this.district));
            strb.append("&experience=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.experience),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&employertype=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.employertype),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&jobfirstclass=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.jobfirstclass),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&jobsecondclass=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.jobsecondclass),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&jobthirdclass=").append(
                    new String(java.net.URLEncoder.encode(
                            StringUtils.toString(this.jobthirdclass),
                            FrameWorkConstants.UTF_8_ENCODING).getBytes()));
            strb.append("&date=").append(StringUtils.toString(this.date));
            strb.append("&detailmode=").append(
                    StringUtils.toString(this.detailmode));
            strb.append("&rn=").append(StringUtils.toString(this.rn));
            strb.append("&pn=").append(StringUtils.toString(this.pn));
        }
        catch (UnsupportedEncodingException e) {
            logger.error("将查询参数转换成URL时发生异常：", e);
            ExceptionHandler.publish("APP-00-0064");
        }
        return strb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        // String name = "中文";
        String name = "";
        // URL编码
        String nameStr = new String(java.net.URLEncoder.encode(name, "utf-8")
                .getBytes());
        System.out.println(nameStr);

        String cnStr = "中文";
        String cnStr1 = "";
        
        System.out.println(
                StringEscapeUtils.escapeJava("中国"));

        cnStr1 = new String(java.net.URLEncoder.encode(cnStr, "UTF-8")
                .getBytes(), "ISO-8859-1");
        System.out.println(cnStr1);
        // URL解码
        System.out.println(java.net.URLDecoder.decode(
                new String(cnStr1.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));

    }
}
