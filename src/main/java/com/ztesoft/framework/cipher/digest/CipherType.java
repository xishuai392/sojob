package com.ztesoft.framework.cipher.digest;

/**
 * 算法类型
 * 
 * @author wang.zhenying
 *
 */
public final class CipherType {
    /**
     * 消息摘要算法类别
     */
    public enum MDACipherType{
        MD5("MD5"), 
        SHA("SHA"),
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512");
        
        private final String name;

        MDACipherType (String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    /**
     * 对称加密算法类别
     */
    public enum SymmericCipherType{
        DES("DES"), 
        AES("AES"),
        DESede("DESede");
        
        private final String name;

        SymmericCipherType (String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    /**
     * 非对称加密算法类别
     */
    public enum AsymmericCipherType{
        RSA("RSA");

        private final String name;

        AsymmericCipherType (String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

}
