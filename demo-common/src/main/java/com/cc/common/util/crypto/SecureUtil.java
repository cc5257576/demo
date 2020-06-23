package com.cc.common.util.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 11:07
 * Description:
 */
public class SecureUtil {

    /**
     * 创建{@link MessageDigest}
     *
     * @param algorithm 算法
     * @since 4.5.2
     */
    public static MessageDigest createMessageDigest(String algorithm) {
        //可以设置密码包
        final Provider provider = null;

        MessageDigest messageDigest;
        try {
            messageDigest = (null == provider) ? MessageDigest.getInstance(algorithm) : MessageDigest.getInstance(algorithm, provider);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoException(e);
        }

        return messageDigest;
    }
}
