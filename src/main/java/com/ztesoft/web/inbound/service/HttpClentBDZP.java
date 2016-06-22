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
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.druid.support.json.JSONUtils;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.inbound.reponse.ResponBDZP;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.inbound.service <br>
 */

public class HttpClentBDZP {
    /** log4j对象 */
    private static final Logger logger = Logger.getLogger(HttpClentBDZP.class);

    public final static String BASEURL = "http://zhaopin.baidu.com/api/async?";

    private static CloseableHttpClient client = null;

    static {
        client = HttpClientBuilder.create()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .build();

    }

    /**
     * 创建HttpClient
     * 
     * @param isMultiThread
     * @return
     */
    public synchronized static HttpClient getHttpClient() {
        return client;

    }

    /**
     * 构建公用RequestConfig
     * 
     * @param timeOut
     * @return
     */
    public static RequestConfig buildRequestConfig(int timeOut) {
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeOut).setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut).build();
        return requestConfig;
    }

    public String doGet(String url) throws BaseAppException {
        logger.info("QUERY FROM BaiduZhaoPin BEGIN，URL = " + url);
        long t01 = System.currentTimeMillis();
        HttpClient client = getHttpClient();
        HttpGet httpGet = null;
        HttpResponse httpResponse = null;
        String jsonContent = "";
        Integer timeout = 5 * 60*60;
        try {
            // get 方法
            httpGet = new HttpGet(url);
            if (timeout != null) {
                httpGet.setConfig(buildRequestConfig(timeout));
            }

            // 1.http header 设置
            httpResponse = client.execute(httpGet);

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 获取响应实体
                HttpEntity httpEntity = httpResponse.getEntity();
                // 响应内容的长度
                long length = httpEntity.getContentLength();
                // 响应内容
                jsonContent = EntityUtils.toString(httpEntity);
                logger.debug("QUERY RESULT:" + jsonContent);
            }
            else {
                logger.error("QUERY FROM BaiduZhaoPin NOT RETURN HTTP 200! PLEASE CHECK OUT! \n");
                throw new BaseAppException(
                        "QUERY FROM BaiduZhaoPin NOT RETURN HTTP 200! PLEASE CHECK OUT!");
            }

        }
        catch (Exception e) {
            logger.error("QUERY FROM BaiduZhaoPin CATCH EXCEPTION,FAILED! ERROR MESSAGE ：\n"
                    + e.getMessage());
            throw new BaseAppException(e.getMessage());
        }
        finally {
            try {
                // 关闭连接 ,释放资源

            }
            catch (Exception e) {
            }
        }
        long t02 = System.currentTimeMillis();
        logger.info("QUERY FROM BaiduZhaoPin RETURN ,TIME [" + (t02 - t01)
                + "]ms jsonContent =[" + jsonContent + "] ");
        return jsonContent;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HttpClentBDZP client = new HttpClentBDZP();
        QryParamBDZP param = new QryParamBDZP();
        param.setRn("2");
        String url = client.BASEURL + param.encodeToUrl();
        System.out.println("url:" + url);
        try {
            String result = client.doGet(url);
            System.out.println("result:" + result);
            
            //Object ooo = JSONUtils.parse(result);
            ResponBDZP aaaa = JsonUtil.toBean(result, ResponBDZP.class);
            System.out.println(aaaa);
        }
        catch (BaseAppException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
