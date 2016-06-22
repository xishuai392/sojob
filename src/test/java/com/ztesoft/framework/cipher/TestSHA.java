package com.ztesoft.framework.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ztesoft.framework.cipher.arithmetic.MDACipher;
import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.digest.CipherType.MDACipherType;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.log.ZTEsoftLogManager;

public class TestSHA {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestSHA.class);
    /**
     * 测试SHA编码与解码
     */
    @Test
    public void test() throws Exception {
 
        String inputStr = "SHA编码与解码";

        LOGGER.debug("原文:\n\t" + inputStr);
        MDACipher cipher = CipherDigest.getMDACipher(MDACipherType.SHA);
        LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));
        // 进行SHA编码
        byte[] outputStr1 = cipher.encrypt(inputStr.getBytes());
        LOGGER.debug("SHA编码后:\n\t" + ConvertUtil.bytesToHexString(outputStr1));

        // 再次SHA编码
        byte[] outputStr2 = cipher.encrypt(inputStr.getBytes());
        LOGGER.debug("SHA编码后:\n\t" + ConvertUtil.bytesToHexString(outputStr2));

        // 验证MD5编码解码一致性
        assertEquals(ConvertUtil.bytesToHexString(outputStr1), ConvertUtil.bytesToHexString(outputStr2));

    }
}
