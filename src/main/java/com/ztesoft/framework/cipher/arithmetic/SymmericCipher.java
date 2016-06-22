package com.ztesoft.framework.cipher.arithmetic;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.ByteUtils;

/**
 * 对称密钥算法实现类
 * 
 * @author wang.zhenying
 * 
 */
public class SymmericCipher {
    /**
     * 算法(DES,AES,DESede)
     */
    private String algorithm = null;
    /**
     * des初始化向量
     */
    private static byte[] desiv = { (byte) 0x12, (byte) 0x34, (byte) 0x56,  
        (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
    /**
     * aes初始化向量
     */
    private static byte[] aesiv = { (byte) 0x12, (byte) 0x34, (byte) 0x56,  
        (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF, (byte) 0x12, (byte) 0x34, (byte) 0x56,  
        (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};
    /**
     * 日志对象
     */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(SymmericCipher.class);
    /**
     * 加密算法 /工作模式 /填充方式
     */
    private String cipherAlgorithm = "/CBC/PKCS5PADDING";
    
    /**
     * 构造函数(必须指定算法名)
     * @param alg
     */
    public SymmericCipher (String alg) {
        AssertUtils.isNotNull(alg);
        AssertUtils.isNotEmpty(alg);
        this.algorithm = alg;
        this.cipherAlgorithm = this.algorithm + cipherAlgorithm;
    }

    /**
     * 转换密钥
     * @param key 二进制密钥
     * @return Key 密钥
     */
    private Key toKey(byte[] key) {
        //实例化DES密钥材料
//        DESKeySpec dks;
        SecretKey secretKey = null;
        try {
//            dks = new DESKeySpec(key);
//            //实例化秘密密钥工厂
//            SecretKeyFactory keyFactory = SecretKeyFactory
//                    .getInstance(algorithm);
//
//            //生成秘密密钥
//            secretKey = keyFactory.generateSecret(dks);
            secretKey = new SecretKeySpec(key, algorithm);
        } 
        catch (Exception e) {
            LOG.error(algorithm + " generate key error ! ", e);
            throw new SysRuntimeException(e, algorithm + " generate key error ! "
                    + e.getMessage());
        }
        return secretKey;
    }
    
    /**
     * 解密
     * @param data 密文
     * @param key 密钥
     * @return byte[] 明文
     */
    public byte[] decrypt(byte[] data, byte[] key) {
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        Key k = toKey(key);
        byte[] bOutputArr = doFinal(data, Cipher.DECRYPT_MODE,
                k);
        return bOutputArr;
    }

    /**
     * 加密
     * @param data 明文
     * @param key 密钥
     * @return byte[] 密文
     */
    public byte[] encrypt(byte[] data, byte[] key) {
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        Key k = toKey(key);
        byte[] bOutputArr = doFinal(data, Cipher.ENCRYPT_MODE,
                k);
        return bOutputArr;
    }

    /**
     * 生成密钥
     * @return byte[] 密钥
     */
    public byte[] initKey() {
        SecretKey key = null;
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            kg.init(new SecureRandom());
            key = kg.generateKey();
        } 
        catch (NoSuchAlgorithmException e) {
            LOG.error(algorithm + " No such alorithm", e);
            throw new SysRuntimeException(e, " No such alorithm "
                    + e.getMessage());
        }
        return key.getEncoded();
    }

    /**
     * 进行实际加密解密操作
     * @param bInputArr 明文
     * @param cipherMode 加密类型
     * @param key 密钥
     * @return 密文
     */
    private byte[] doFinal(byte[] bInputArr, int cipherMode, Key key) {
        byte[] bOutputArr = null;
        try {
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            byte[] iv = desiv;
            if (algorithm.equals("AES")) {
                iv = aesiv;
            }
            IvParameterSpec ivps = new IvParameterSpec(iv); 
            cipher.init(cipherMode, key, ivps);
            bOutputArr = cipher.doFinal(bInputArr);
        } 
        catch (Exception e) {
            LOG.error(
                    " Encrypt or decrypt error in " + algorithm + " arithmetic operation doFinal ",
                    e);
            throw new SysRuntimeException(e,
                    " Encrypt or decrypt error in " + algorithm + " arithmetic operation doFinal "
                            + e.getMessage());
        }
        return bOutputArr;
    }
}
