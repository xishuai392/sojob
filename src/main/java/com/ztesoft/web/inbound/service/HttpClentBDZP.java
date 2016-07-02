/**
 * 
 */
package com.ztesoft.web.inbound.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
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
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.ztesoft.core.common.JsonObjectMapper;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.inbound.param.QryParamBDZP;
import com.ztesoft.web.inbound.reponse.ResponseBDZP;

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

@Component
public class HttpClentBDZP {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(HttpClentBDZP.class);

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

    public ResponseBDZP doGet(QryParamBDZP param) throws BaseAppException {
        String url = BASEURL +  StringEscapeUtils.unescapeJava(param.encodeToUrl());
        logger.error("url:" + url);
        String result = doGet(url);
        logger.error("result:" + result);
        ResponseBDZP responseBDZP = HttpClentBDZP.toBean(result, ResponseBDZP.class);
        return responseBDZP;
    }
    
    

    private String doGet(String url) throws BaseAppException {
        logger.info("QUERY FROM BaiduZhaoPin BEGIN，URL = " + url);
        long t01 = System.currentTimeMillis();
        HttpClient client = getHttpClient();
        HttpGet httpGet = null;
        HttpResponse httpResponse = null;
        String jsonContent = "";
        Integer timeout = 5 * 60 * 60;
        try {
            // 创建URL对象
            //java.net.URL connURL = new java.net.URL(url);
            //httpGet = new HttpGet(connURL.toURI());
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

    public ResponseBDZP doPost(QryParamBDZP param) throws BaseAppException {
        String result = sendPost(param);
        logger.error("result:" + result);
        ResponseBDZP responseBDZP = HttpClentBDZP.toBean(result, ResponseBDZP.class);
        return responseBDZP;
    }
    
    private  String sendPost(QryParamBDZP param ) {
        Map<String, String> parameters = param.converToParams();
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        StringBuffer sb = new StringBuffer();// 处理请求参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name)
                            .append("=")
                            .append(java.net.URLEncoder.encode(
                                    parameters.get(name), "UTF-8"));
                }
                params = sb.toString();
            }
            else {
                for (String name : parameters.keySet()) {
                    sb.append(name)
                            .append("=")
                            .append(java.net.URLEncoder.encode(
                                    parameters.get(name), "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(BASEURL);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    private static final JsonObjectMapper mapper=new JsonObjectMapper();
    /**
     * 字符串转为bean
     * 
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T toBean(String content, Class<T> valueType) {
        try {
            mapper.configure( DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            
            return mapper.readValue(content, valueType);
        }
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

    
    
    /**
     * @param args
     * @throws BaseAppException
     */
    public static void main(String[] args) throws BaseAppException {
        HttpClentBDZP client = new HttpClentBDZP();
        QryParamBDZP param = new QryParamBDZP();
        param.setQuery("建筑师");
        param.setPn("0");
        param.setRn("5");
        String url = client.BASEURL + param.encodeToUrl();
        System.out.println("url:" + url);
        try {
            String result = client.doGet(url);
            System.out.println("result:" + result);

            // Object ooo = JSONUtils.parse(result);
            ResponseBDZP aaaa = HttpClentBDZP.toBean(result, ResponseBDZP.class);
            System.out.println(aaaa);
            System.out.println(JsonUtil.toJson(aaaa));
        }
        catch (BaseAppException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
