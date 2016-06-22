/**
 * 
 */
package com.ztesoft.web.qryjob.controller;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年6月15日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.qryjob.controller <br>
 */

public class TestController {

    public static String ascii2native(String ascii) {
        int n = ascii.length() / 6;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0, j = 2; i < n; i++, j += 6) {
            String code = ascii.substring(j, j + 4);
            char ch = (char) Integer.parseInt(code, 16);
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "\u53a6\u95e8\u0000\u0000";
        System.out.println(str);
        System.out.println("ddd");
        System.out.println(TestController.ascii2native(str));
    }

}
