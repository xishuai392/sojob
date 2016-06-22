package com.ztesoft.framework.cipher.arithmetic;

import org.apache.commons.codec.binary.Base64;


/**
 * 无密钥Base64实现类
 * 
 * @author wang.zhenying
 * 
 */
public final class Base64Cipher {

    /**
     * Base64编码
     * @param data 待编码数据
     * @return byte[] 编码数据
     */
    public byte[] encrypt(byte[] data) {
        //执行编码
        byte[] b = Base64.encodeBase64(data);
        return b;
    }
    

    /**
     * Base64解码
     * @param data 待解码数据
     * @return byte[] 解码数据
     */
    public byte[] decrypt(byte[] data) {
        //执行解码
        byte[] b = Base64.decodeBase64(data);

        return b;
    }

}
