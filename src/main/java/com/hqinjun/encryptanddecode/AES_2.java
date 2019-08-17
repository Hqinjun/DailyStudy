package com.hqinjun.encryptanddecode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;

public class AES_2{
        private Map<String,String> map = new HashMap<String,String>();

        public Map<String,String> getMap(){
            return map;
        }

        public  Map<String,String> Datalist(String data){
            if(data == null)
                return null;
            String [] ss = data.split(";");
            String [] bb = null;
            String code ;
            String codeDate;
            //System.out.println(ss.length);
            for( int i = 0; i < ss.length; i++ )
            {    bb=ss[i].split("=");
                code = bb[0];
                if(bb.length > 1){
                    codeDate = bb[1];
                }else {
                    codeDate = null;
                }
                map.put( code, codeDate );
            }
            return map;
        }


        // 加密
        public static String Encrypt(String sSrc, String sKey) throws Exception {
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());

            return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        }

        // 解密
        public static String Decrypt(String sSrc, String sKey) throws Exception {
            try {
                // 判断Key是否正确
                if (sKey == null) {
                    System.out.print("Key为空null");
                    return null;
                }
                // 判断Key是否为16位
                if (sKey.length() != 16) {
                    System.out.print("Key长度不是16位");
                    return null;
                }
                byte[] raw = sKey.getBytes("ASCII");
                SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
                try {
                    byte[] original = cipher.doFinal(encrypted1);
                    String originalString = new String(original);
                    return originalString;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    return null;
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                return null;
            }
        }

        public static void main(String[] args) throws Exception {
            /*
             * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
             * 此处使用AES-128-CBC加密模式，key需要为16位。
             */
            String cKey = "1234567890123456";
            // 需要加密的字串
            String cSrc = "Email : arix04@xxx.com";
            System.out.println(cSrc);
            // 加密
            long lStart = System.currentTimeMillis();
            String enString = AES_2.Encrypt(cSrc, cKey);
            System.out.println("加密后的字串是：" + enString);

            long lUseTime = System.currentTimeMillis() - lStart;
            System.out.println("加密耗时：" + lUseTime + "毫秒");
            // 解密
            lStart = System.currentTimeMillis();
            String DeString = AES_2.Decrypt(enString, cKey);
            System.out.println("解密后的字串是：" + DeString);
            lUseTime = System.currentTimeMillis() - lStart;
            System.out.println("解密耗时：" + lUseTime + "毫秒");
            System.out.println("==========================================");
            AES_2 aes_2 =  new AES_2();
            String key = "gzxxtgzxxtgzxxt1";
            String data = "";
            String bizdata = "psw=5857a19344ee6aa35ae5a0e02fd2003a;account=admin;code=524932";
            String overbizdata=aes_2.Encrypt(bizdata,key);
            System.out.println(overbizdata);
            System.out.println("==========================================");
            data = aes_2.Decrypt(overbizdata,key);
            System.out.println(data);
            aes_2.Datalist(data);
            System.out.println(aes_2.getMap().toString());
            System.out.println("==========================================1");



        }
}
