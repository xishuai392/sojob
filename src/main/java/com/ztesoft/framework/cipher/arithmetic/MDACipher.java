package com.ztesoft.framework.cipher.arithmetic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 信息摘要算法
 * 
 * @author wang.zhenying
 * 
 */
public class MDACipher {
    /**
     * 算法(MD5,SHA)
     */
    private String algorithm = null;
    /**
     * 日志对象
     */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(MDACipher.class);
    /**
     * 构造函数(必须指定算法名)
     * @param alg
     */
    public MDACipher (String alg) {
        AssertUtils.isNotNull(alg);
        AssertUtils.isNotEmpty(alg);
        this.algorithm = alg;
    }
    /**
     * 加密
     * @param data 明文
     * @return 密文
     */ 
    public byte[] encrypt(byte[] data) {
        MessageDigest md = null;    
        AssertUtils.isNotEmpty(data);
        try {
            md = MessageDigest.getInstance(algorithm);
        } 
        catch (SecurityException se) {
            LOG.error(" Security failure. " + algorithm + " enc  ryption error ", se);
            throw new SysRuntimeException(se,
                    " Security failure. " + algorithm + " encryption error "
                            + se.getMessage());
        } 
        catch (NoSuchAlgorithmException ex) {
            LOG.error(" No Such Algorithm failure. " + algorithm + " encryption error", ex);
            throw new SysRuntimeException(ex,
                    " No Such Algorithm failure. " + algorithm + " encryption error "
                            + ex.getMessage());
        }
        return md.digest(data);

    }

//    /**
//     * 解密
//     * @param data 密文
//     * @return 明文
//     */
//    public byte[] decrypt(byte[] data) {
//        throw new SysRuntimeException(
//                algorithm + " decryption unsupported operation ! ");
//    }

}
