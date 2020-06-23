package com.cc.common.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/18 10:49
 * Description:
 */
public class RandomUtil {

    /** 用于随机选的数字 */
    public static final String BASE_NUMBER = "0123456789";
    /** 用于随机选的小写字符 */
    public static final String BASE_LOWER_CHAR = "abcdefghijklmnopqrstuvwxyz";
    /** 用于随机选的大写字符 */
    public static final String BASE_UPPER_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** 用于随机选的字符和数字 */
    public static final String BASE_CHAR_NUMBER = BASE_LOWER_CHAR + BASE_NUMBER;
    /** 用于随机选的大小字符和数字 */
    public static final String BASE_UPPER_LOWER_CHAR_NUMBER = BASE_UPPER_CHAR + BASE_LOWER_CHAR + BASE_NUMBER;

    /**
     * 获取随机数生成器对象<br>
     * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
     *
     * @return {@link ThreadLocalRandom}
     * @since 3.1.2
     */
    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }


    /**
     * 获得指定范围内的随机数 [0,limit)
     *
     * @param limit 限制随机数的范围，不包括这个数
     * @return 随机数
     */
    public static int randomInt(int limit) {
        return getRandom().nextInt(limit);
    }

    /**
     * 获得一个随机的字符串（只包含数字和字符）
     *
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomString(int length) {
        return randomString(BASE_CHAR_NUMBER, length);
    }

    /**
     * 获得一个随机的字符串（只包含数字和大写字符）
     *
     * @param length 字符串的长度
     * @return 随机字符串
     * @since 4.0.13
     */
    public static String randomStringUpper(int length) {
        return randomString(BASE_CHAR_NUMBER, length).toUpperCase();
    }

    /**
     * 获得一个随机的字符串（只包含数字和大写字符和小写）
     *
     * @param length 字符串的长度
     * @return 随机字符串
     * @since 4.0.13
     */
    public static String randomStringUpperLower(int length) {
        return randomString(BASE_CHAR_NUMBER, length);
    }
    /**
     * 获得一个只包含数字的字符串
     *
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomNumbers(int length) {
        return randomString(BASE_NUMBER, length);
    }

    /**
     * 获得一个随机的字符串
     *
     * @param baseString 随机字符选取的样本
     * @param length 字符串的长度
     * @return 随机字符串
     */
    public static String randomString(String baseString, int length) {
        final StringBuilder sb = new StringBuilder();

        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int number = getRandom().nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString().toUpperCase();
    }
}
