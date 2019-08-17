package com.hqinjun.encryptanddecode;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static final String ENCODING_UTF8 = "UTF-8";
    private String key;
    private String iv;
    public AES(String key, String iv) {
        this.key = key;
        this.iv = iv;
    }
    public AES(){
        this.key = "xxtwebaes1234567";
        this.iv = "xxtwebaes1234567";
    }
    public String encrypt(String data) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING_UTF8), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING_UTF8));

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return new sun.misc.BASE64Encoder().encode(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String desEncrypt(String encData) throws Exception {
        try
        {
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(encData);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(ENCODING_UTF8), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes(ENCODING_UTF8));
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,ENCODING_UTF8);
            return originalString;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String args[]) throws Exception{
        String  encData="8+YQSZncNCpqMdbesVGqxw==";
        System.out.println("encData="+encData);
        AES aes=new AES("xxtwebaes1234567","xxtwebaes1234567");
        String data=aes.desEncrypt(encData);
        System.out.println("data="+data);
        String admin = "admin";
        System.out.println(aes.encrypt(admin));


    }
}
