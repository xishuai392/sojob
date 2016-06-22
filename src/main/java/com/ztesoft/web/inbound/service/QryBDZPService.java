/**
 * 
 */
package com.ztesoft.web.inbound.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.inbound.param.QryParamBDZP;

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

   

    

    public String qry(QryParamBDZP qryParam) {

        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
