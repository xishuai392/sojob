package com.ztesoft.framework.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ztesoft.framework.cipher.arithmetic.MDACipher;
import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.digest.CipherType.MDACipherType;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.log.ZTEsoftLogManager;

public class TestMD5 {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestMD5.class);
    /**
     * 测试MD5编码
     */
    @Test
    public void test() throws Exception {
 
        String inputStr = "MD5编码与解码";

        LOGGER.debug("原文:\n\t" + inputStr);
        MDACipher cipher = CipherDigest.getMDACipher(MDACipherType.MD5);
        LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));
        // 进行MD5编码
        byte[] outputStr1 = cipher.encrypt(inputStr.getBytes());
        LOGGER.debug("MD5编码后:\n\t" + ConvertUtil.bytesToHexString(outputStr1));

        // 再次MD5编码
        byte[] outputStr2 = cipher.encrypt(inputStr.getBytes());
        LOGGER.debug("MD5编码后:\n\t" + ConvertUtil.bytesToHexString(outputStr2));

        // 验证MD5编码解码一致性
        assertEquals(ConvertUtil.bytesToHexString(outputStr1), ConvertUtil.bytesToHexString(outputStr2));

    }

}
