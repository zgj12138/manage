package com.kevin.manage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密类（封装jdk自带MD5加密方法
 * @author zhangguoji
 * @date 2017/8/29 18:45
 */
public class MD5Util {
    public static String encrypt(String source) {
        return encodeMd5(source.getBytes());
    }

    private static String encodeMd5(byte[] source) {
        try {
            return encodeHex(MessageDigest.getInstance("MD5").digest(source));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
    private static String encodeHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for(int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Long.toString((int) bytes[i] & 0xff,16));
        }
        return stringBuilder.toString();
    }

}
