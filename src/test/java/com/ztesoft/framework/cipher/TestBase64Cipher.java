/**
 * 2009-8-20
 */
package com.ztesoft.framework.cipher;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ztesoft.framework.cipher.arithmetic.Base64Cipher;
import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.log.ZTEsoftLogManager;


/**
 * Base64编码与解码测试类
 * 
 * @author wang.zhenying
 */
public class TestBase64Cipher {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestBase64Cipher.class);
	/**
	 * 测试Base64编码与解码
	 */
	@Test
	public void test() throws Exception {
 
		String inputStr = "Base64编码与解码";

		LOGGER.debug("原文:\n\t" + inputStr);
		Base64Cipher cipher = CipherDigest.getBase64Cipher();
		LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));
		// 进行Base64编码
		byte[] code = cipher.encrypt(inputStr.getBytes());
		LOGGER.debug("Base64编码后:\n\t" + ConvertUtil.bytesToHexString(code));

		// 进行Base64解码
		byte[] outputStr = cipher.decrypt(code);
		LOGGER.debug("Base64解码后:\n\t" + ConvertUtil.bytesToHexString(outputStr));

		// 验证Base64编码解码一致性
		assertEquals(ConvertUtil.bytesToHexString(inputStr.getBytes()), ConvertUtil.bytesToHexString(outputStr));

	}
	

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestBase64Cipher t = new TestBase64Cipher();
        try {
            t.test();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
