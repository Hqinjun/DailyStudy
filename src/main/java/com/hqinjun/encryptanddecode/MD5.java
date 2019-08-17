package com.hqinjun.encryptanddecode;

import java.security.MessageDigest;

/**
 * MD5加密类
 *
 * @author Daniel 2010-6-2
 *
 */
public class MD5 {

    /**
     * MD5加密
     * @param source 原始字符串
     * @return 加密后的字符串
     */
    public static final String encrypt(String source){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = source.getBytes("UTF-16");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            //System.out.println("length:"+md.length+" data:"+new String(md));
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * MD5加密（使用默认的编码）
     * @param source 原始字符串
     * @return 加密后的字符串
     */
    public static final String encryptDftEncode(String source){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = source.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * MD5加密
     * @param source 原始字符串
     * @return 加密后的字符串
     */
    public static final String encrypt(String source, String encode){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = source.getBytes(encode);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        String result=encryptDftEncode("@sL123456");
        System.out.println("length:"+result.length()+" data:"+result);
    }
}
