package com.ztesoft.framework.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ztesoft.framework.cipher.arithmetic.SymmericCipher;
import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.digest.CipherType.SymmericCipherType;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.log.ZTEsoftLogManager;

public class TestAES {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestAES.class);
    /**
     * 测试AES加密与解密
     */
    @Test
    public void test() throws Exception {
 
        String inputStr = "AES编码与解码";

        LOGGER.debug("原文:\n\t" + inputStr);
        SymmericCipher cipher = CipherDigest.getSymmericCipher(SymmericCipherType.AES);
        LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));
        //获取密钥
        byte[] key = cipher.initKey();
        
        // 进行AES加密
        byte[] code = cipher.encrypt(inputStr.getBytes(), key);
        LOGGER.debug("AES加密后:\n\t" + ConvertUtil.bytesToHexString(code));

        // 进行AES解密
        byte[] outputStr = cipher.decrypt(code, key);
        LOGGER.debug("AES解密后:\n\t" + ConvertUtil.bytesToHexString(outputStr));

        // 验证AES加密解密一致性
        assertEquals(ConvertUtil.bytesToHexString(inputStr.getBytes()), ConvertUtil.bytesToHexString(outputStr));

    }
}
