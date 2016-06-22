package com.ztesoft.framework.cipher.digest;


import com.ztesoft.framework.cipher.arithmetic.AsymmericCipher;
import com.ztesoft.framework.cipher.arithmetic.Base64Cipher;
import com.ztesoft.framework.cipher.arithmetic.MDACipher;
import com.ztesoft.framework.cipher.arithmetic.SymmericCipher;
import com.ztesoft.framework.cipher.digest.CipherType.AsymmericCipherType;
import com.ztesoft.framework.cipher.digest.CipherType.MDACipherType;
import com.ztesoft.framework.cipher.digest.CipherType.SymmericCipherType;

/**
 * 获取加密、解密Digest
 * 
 * @author wang.zhenying
 * 
 */
public class CipherDigest {

    /**
     * 获取Base64加密器
     * @return Base64Cipher 加密器
     */
    public static Base64Cipher getBase64Cipher() {
        return new Base64Cipher();
    }
    /**
     * 获取MDA加密器(消息摘要算法)
     * @param MDACipherType 消息摘要算法类型
     * @return MDACipher 加密器
     */
    public static MDACipher getMDACipher(MDACipherType name) {
        return new MDACipher(name.getName());
    }
    /**
     * 获取对称加密器
     * @param SymmericCipherType 对称加密算法类型
     * @return SymmericCipher 加密器
     */
    public static SymmericCipher getSymmericCipher(SymmericCipherType name) {
        return new SymmericCipher(name.getName());
    }
    
    /**
     * 获取非对称加密器
     * @param AsymmericCipherType 非对称加密算法类型
     * @return AsymmericCipher 加密器
     */
    public static AsymmericCipher getAsymmericCipher(AsymmericCipherType name) {
        return new AsymmericCipher(name.getName());
    }


}
