package com.ztesoft.framework.cipher;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import com.ztesoft.framework.cipher.arithmetic.AsymmericCipher;
import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.digest.CipherType.AsymmericCipherType;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.log.ZTEsoftLogManager;

public class TestRSA {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(TestRSA.class);

    /**
     * 加密器
     */
    private AsymmericCipher cipher;
    /**
     * 公钥
     */
    private byte[] publicKey;

    /**
     * 私钥
     */
    private byte[] privateKey;

    /**
     * 初始化密钥
     * 
     * @throws Exception
     */
    @Before
    public void initKey() throws Exception {
        cipher = CipherDigest.getAsymmericCipher(AsymmericCipherType.RSA);

        // 初始化密钥
        Map<String, Object> keyMap = cipher.initKey();

        publicKey = cipher.getPublicKey(keyMap);
        privateKey = cipher.getPrivateKey(keyMap);

        LOGGER.debug("公钥: \n" + Base64.encodeBase64String(publicKey));
        LOGGER.debug("私钥： \n" + Base64.encodeBase64String(privateKey));
    }
    
    /**
     * 私钥加密——公钥解密
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        LOGGER.debug("\n---私钥加密——公钥解密---");
        String inputStr = "RSA编码与解码";

        LOGGER.debug("原文:\n\t" + inputStr);
        LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));

        
        // 进行私钥加密
        byte[] code = cipher.encryptByPrivateKey(inputStr.getBytes(), privateKey);
        LOGGER.debug("RSA私钥加密后:\n\t" + ConvertUtil.bytesToHexString(code));

        // 进行公钥解密
        byte[] outputStr = cipher.decryptByPublicKey(code, publicKey);
        LOGGER.debug("RSA公钥解密后:\n\t" + ConvertUtil.bytesToHexString(outputStr));

        // 验证RSA加密解密一致性
        assertEquals(ConvertUtil.bytesToHexString(inputStr.getBytes()), ConvertUtil.bytesToHexString(outputStr));

    }
    
    /**
     * 公钥加密——私钥解密
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        LOGGER.debug("\n---公钥加密——私钥解密---");
        String inputStr = "RSA编码与解码";

        LOGGER.debug("原文:\n\t" + inputStr);
        LOGGER.debug("原文十六进制:\n\t" + ConvertUtil.bytesToHexString(inputStr.getBytes()));

        
        // 进行公钥加密
        byte[] code = cipher.encryptByPublicKey(inputStr.getBytes(), publicKey);
        LOGGER.debug("RSA公钥加密后:\n\t" + ConvertUtil.bytesToHexString(code));

        // 进行私钥解密
        byte[] outputStr = cipher.decryptByPrivateKey(code, privateKey);
        LOGGER.debug("RSA私钥解密后:\n\t" + ConvertUtil.bytesToHexString(outputStr));

        // 验证RSA加密解密一致性
        assertEquals(ConvertUtil.bytesToHexString(inputStr.getBytes()), ConvertUtil.bytesToHexString(outputStr));

    }
}
