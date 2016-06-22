/**
 * 
 */
package com.ztesoft.web.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年1月20日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.controller <br>
 */
@Controller
@RequestMapping("/demo/json")
public class JsonController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(JsonController.class);

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public String queryRecordByPage(HttpServletRequest request, @RequestParam(
            value = "jsonName", required = true) String jsonName,
            Page<String> resultPage) throws BaseAppException {
        String currPath = JsonController.class.getProtectionDomain()
                .getCodeSource().getLocation().toString();

        String path = request.getSession().getServletContext().getRealPath("");
        String jsonFilePath = path + File.separator + "jsconData"
                + File.separator;

        // 分页
        jsonFilePath += jsonName + resultPage.getPage() + ".json";

        System.out.println("currPath:" + currPath);
        System.out.println("path:" + path);
        String line;
        StringBuffer jsonStrb = new StringBuffer();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(jsonFilePath),
                    1 * 1024 * 1024/* 1M */);

            while ((line = br.readLine()) != null) {
                // 略过空行串
                if (StringUtils.isEmpty(line))
                    continue;
                jsonStrb.append(line);
            }
        }
        catch (Exception e) {
            jsonStrb.append("{\"code\":\"ERROR-1001\",\"message\":\"");
            jsonStrb.append(e.getMessage());
            jsonStrb.append("\"}");
            logger.error(e);
        }

        return jsonStrb.toString();
    }

    @RequestMapping("queryAllRecord")
    public void queryAllRecord(HttpServletRequest request,
            HttpServletResponse response, @RequestParam(value = "jsonName",
                    required = true) String jsonName) throws BaseAppException {
        
        String currPath = JsonController.class.getProtectionDomain()
                .getCodeSource().getLocation().toString();

        String path = request.getSession().getServletContext().getRealPath("");
        String jsonFilePath = path + File.separator + "jsonData"
                + File.separator;

        // 分页
        jsonFilePath += jsonName + ".json";

        System.out.println("currPath:" + currPath);
        System.out.println("path:" + path);
        String line;
        StringBuffer jsonStrb = new StringBuffer();
        BufferedReader br;
        PrintWriter out = null;
        try {
            br = new BufferedReader(new FileReader(jsonFilePath),
                    1 * 1024 * 1024/* 1M */);

            while ((line = br.readLine()) != null) {
                // 略过空行串
                if (StringUtils.isEmpty(line))
                    continue;
                jsonStrb.append(line);
            }
        }
        catch (Exception e) {
            jsonStrb.append("{\"code\":\"ERROR-1001\",\"message\":\"");
            jsonStrb.append(e.getMessage());
            jsonStrb.append("\"}");
            logger.error(e);
        }

        System.out.println("time:"
                + DateUtils.date2String(new Date(),
                        DateUtils.STR_DEFAULT_DATE_FORMAT_WITH_SPLIT));
        System.out.println("return json:" + jsonStrb);

        try {
            response.setContentType("text/xml;charset=UTF-8");
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Access-Control-Allow-Origin", "*");
            out = response.getWriter();
            out.println(jsonStrb.toString());
            out.flush();
            out.close();
            System.out.println("success return!!!");
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error(e);
        }

    }

}
