/**
 * 
 */
package com.ztesoft.web.inbound.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.inbound.reponse.ResponseBDZP;

/**
 * <Description>百度招聘，查询服务 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.service <br>
 */

public class QryBDZPService {
    /** log4j对象 */
    private static final Logger logger = Logger.getLogger(QryBDZPService.class);

    @Autowired
    private HttpClentBDZP httpClentBDZP;

    public String qry(QryParamBDZP qryParam) {
        ResponseBDZP result = null;
        try {
            result = httpClentBDZP.doGet(qryParam);
        }
        catch (BaseAppException e) {
            logger.error("查询百度招聘，发生错误。", e);
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
