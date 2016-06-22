/**
 * Copyright 2010 ZTEsoft Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ZTEsoft Inc.
 * Use is subject to license terms.
 * 
 * $Tracker List
 * 
 * $TaskId: $ $Date: 9:24:36 AM (May 9, 2008) $comments: create 
 * $TaskId: $ $Date: 3:56:36 PM (SEP 13, 2010) $comments: upgrade jvm to jvm1.5 
 *  
 *  
 */
package com.ztesoft.framework.cipher.arithmetic;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 非对称算法 
 * 
 * @author wang.zhenying
 * 
 */
public class AsymmericCipher {
    /**
     * 算法(RSA)
     */
    private String algorithm = null;
    /**
     * 默认key长度
     */
    private int keysize = 1024;
    /**
     * 公钥
     */
    private final String publicKey = "RSAPublicKey";
    /**
     * 私钥
     */
    private final String privateKey = "RSAPrivateKey";

    /** 日志对象 */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(AsymmericCipher.class);
    
    /**
     * 构造函数(必须指定算法名)
     * @param alg
     */
    public AsymmericCipher (String alg) {
        AssertUtils.isNotNull(alg);
        AssertUtils.isNotEmpty(alg);
        this.algorithm = alg;
    }
    
    /**
     * 私钥解密
     * @param data 待解密数据
     * @param key 私钥
     * @return byte[] 解密数据
     */
    public byte[] decryptByPrivateKey(byte[] data, byte[] key) {
        byte[] bOutputArr = null;
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        try {
            //取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

            //生成私钥
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            //对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            bOutputArr = cipher.doFinal(data);
        } 
        catch (Exception is) {
            LOG.error(algorithm + " decrption by private key error ! ", is);
            throw new SysRuntimeException(is, algorithm + " decrption by private key error ! "
                    + is.getMessage());
        } 
        return bOutputArr;
    }

    /**
     * 公钥解密
     * @param data 待解密数据
     * @param key 公钥
     * @return byte[] 解密数据
     */
    public byte[] decryptByPublicKey(byte[] data, byte[] key) {
        byte[] bOutputArr = null;
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        try {
            //取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

            //生成公钥
            PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

            //对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            
            bOutputArr = cipher.doFinal(data);
        } 
        catch (Exception is) {
            LOG.error(algorithm + " decrption by public key error ! ", is);
            throw new SysRuntimeException(is, algorithm + " decrption by public key error ! "
                    + is.getMessage());
        } 
        return bOutputArr;
    }

    /**
     * 公钥加密
     * @param data 待加密数据
     * @param key 公钥
     * @return byte[] 加密数据
     */
    public byte[] encryptByPublicKey(byte[] data, byte[] key) {
        byte[] bOutputArr = null;
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        try {
            //取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

            PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

            //对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            
            bOutputArr = cipher.doFinal(data);
        } 
        catch (Exception is) {
            LOG.error(algorithm + " encrption by public key error ! ", is);
            throw new SysRuntimeException(is, algorithm + " encrption by public key error ! "
                    + is.getMessage());
        } 
        return bOutputArr;
    }

    /**
     * 私钥加密
     * @param data 待加密数据
     * @param key 私钥
     * @return byte[] 加密数据
     */
    public byte[] encryptByPrivateKey(byte[] data, byte[] key) {
        byte[] bOutputArr = null;
        AssertUtils.isNotEmpty(data);
        AssertUtils.isNotNull(key);
        try {
            //取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

            //生成私钥
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            //对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            bOutputArr = cipher.doFinal(data);
        } 
        catch (Exception is) {
            LOG.error(algorithm + " encrption by private key error ! ", is);
            throw new SysRuntimeException(is, algorithm + " encrption by private key error ! "
                    + is.getMessage());
        } 
        return bOutputArr;
    }

    /**
     * 取得私钥
     * @param keyMap 密钥Map
     * @return byte[] 私钥
     */
    public byte[] getPrivateKey(Map<String, Object> keyMap) {

        Key key = (Key) keyMap.get(privateKey);

        return key.getEncoded();
    }

    /**
     * 取得公钥
     * @param keyMap 密钥Map
     * @return byte[] 公钥
     */
    public byte[] getPublicKey(Map<String, Object> keyMap) {

        Key key = (Key) keyMap.get(publicKey);

        return key.getEncoded();
    }

    /**
     * 初始化密钥
     * @return Map 密钥Map
     */
    public Map<String, Object> initKey() {
        // 封装密钥
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        try {
            //实例化密钥对生成器
            KeyPairGenerator keyPairGen = KeyPairGenerator
                    .getInstance(algorithm);

            //初始化密钥对生成器
            keyPairGen.initialize(keysize);
            //生成密钥对
            KeyPair keyPair = keyPairGen.generateKeyPair();
            //公钥
            RSAPublicKey pubKey = (RSAPublicKey) keyPair.getPublic();
            //私钥
            RSAPrivateKey priKey = (RSAPrivateKey) keyPair.getPrivate();

            keyMap.put(publicKey, pubKey);
            keyMap.put(privateKey, priKey);
        } 
        catch (Exception e) {
            LOG.error(algorithm + " generate key error ! ", e);
            throw new SysRuntimeException(e, algorithm + " generate key error ! "
                    + e.getMessage());
        }
        return keyMap;
    }

}
