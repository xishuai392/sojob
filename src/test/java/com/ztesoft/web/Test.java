/**
 * 
 */
package com.ztesoft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月24日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web <br>
 */

public class Test {
private Logger logger = Logger.getLogger(Test.class); 
    
    private String encoding;  
    private String[] legalNames;  
    private String[] illegalChars;  
    
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain filterChain) throws IOException, ServletException {  
          
        HttpServletRequest req = (HttpServletRequest)request;  
        HttpServletResponse res = (HttpServletResponse) response;  
          
        //必须手动指定编码格式  
        req.setCharacterEncoding(encoding);  
        res.setCharacterEncoding(encoding);
        res.setContentType("text/html;charset="+encoding);

        //解决 跨站点请求伪造
        res.addCookie(new Cookie("timstamp",UUID.randomUUID().toString()));
        
        String tempURL = req.getRequestURI();  
        if( logger.isDebugEnabled() )
        {
            logger.debug(tempURL);  
        }
        Enumeration<?> params = req.getParameterNames();  
          
        //是否执行过滤  true：执行过滤  false：不执行过滤  
        boolean executable = true;  
          
        //非法状态  true：非法  false；不非法  
        boolean illegalStatus = false;  
        String illegalChar = "";  
        //对参数名与参数进行判断  
        w:while(params.hasMoreElements()){  
              
            String paramName = (String) params.nextElement();  
              
            executable = true;  
              
            //密码不过滤  
            if(paramName.toLowerCase().contains("password")){  
                executable = false;  
            }else{  
                //检查提交参数的名字，是否合法，即不过滤其提交的值  
                f:for(int i=0;i<legalNames.length;i++){  
                    if(legalNames[i].equals(paramName)){  
                        executable = false;  
                        break f;  
                    }  
                }  
            }  
              
            if(executable){  
                String[] paramValues = req.getParameterValues(paramName);  
                  
                f1:for(int i=0;i<paramValues.length;i++){  
                      
                    String paramValue = paramValues[i];  
                      
                    f2:for(int j=0;j<illegalChars.length;j++){  
                          
                        illegalChar = illegalChars[j];  
                          
                        if(paramValue.indexOf(illegalChar) != -1){  
                            illegalStatus = true;//非法状态  
                            logger.warn("参数效验错误！参数："+paramValue+"；非法字符："+illegalChar);
                            logger.warn("--------------------------------------");
                            break f2;  
                        }  
                    }  
                      
                    if(illegalStatus){  
                        break f1;  
                    }  
                      
                }  
            }  
              
            if(illegalStatus){  
                break w;  
            }  
        }  
        //对URL进行判断  
        for(int j=0;j<illegalChars.length;j++){  
              
            illegalChar = illegalChars[j];  
              
            if(tempURL.indexOf(illegalChar) != -1){  
                illegalStatus = true;//非法状态  
                logger.warn("地址效验错误！URL："+tempURL+"；非法字符："+illegalChar);
                logger.warn("--------------------------------------");
                break;  
            }  
        }  
        String msg = "当前链接中存在非法字符";
        if(StringUtils.indexOf(tempURL,"//") != -1)
        {
            illegalStatus = true;//非法状态  
            msg = "当前链接格式不符合规范";
            logger.warn("当前链接格式不符合规范！URL："+tempURL+"；非法字符：//");
            logger.warn("--------------------------------------");
        }
        if(illegalStatus){  
            //必须手动指定编码格式  
//            res.setContentType("text/html;charset="+encoding);  
//            res.setCharacterEncoding(encoding);  
            PrintWriter pw = null;
            try
            {
                pw = res.getWriter();
                if( "XMLHttpRequest".equalsIgnoreCase(req.getHeader("x-requested-with")) ){
                    //ajax请求   
                    pw.print("exitIllegalChar");//在$.ajax的dataFilter里处理该字符串
                }
                else
                {
                    //url请求
                    pw.print("<script>window.alert('"+msg+"');window.history.go(-1);</script>"); 
//                  pw.print("<script type=\"text/javascript\">window.alert('当前链接中存在非法字符');window.history.go(-1);</script>");
                }
            }
            catch (Exception e)
            {
                logger.error(e.getMessage(),e);
            }
            finally
            {
                if( null != pw )
                {
                    try
                    {
                        pw.flush();
                        pw.close();
                    }
                    catch (Exception e)
                    {
                        logger.error(e.getMessage(),e);
                    }
                }
            }
        }
        else
        {
            filterChain.doFilter(request, response);  
        }  
    }  
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(System.currentTimeMillis());
        int n = 20;
        int t = 0;
//        for (int i = 0; i < n; i--) {
//            System.out.println("-" + t++);
//        }
        
        System.out.println("==============================");
        
        zengzs: for (int i = 0; i < 5; i++) {  
            System.out.println("运行第一重循环" + i);  
            dddd:for (int j = 0; j < 2; j++) {  
                // label: for (int j = 0; j <2; i++) {  
               eeee: {System.out.println("运行第二重循环" + j);  }
                for (int k = 0; k < 5; k++) {  
                    // break label;  
                    if (k == 1) {  
                        System.out.println("跳出多重循环");  
                        break dddd;  
                    }  
                    System.out.println("运行第三重循环" + k);  
                    System.out.println("**************************");  
                }  
            }  
        }  
        System.out.println("sdfsfsf");
        
        
        
        
    }

    
}
