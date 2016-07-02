/**
 * 
 */
package com.ztesoft.web.qryjob.vo;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.qryjob.vo <br>
 */

public class QryJobParam extends AbstractDto {
    // 关键词
    private String query;

    // 城市
    private String city;
    

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

}
