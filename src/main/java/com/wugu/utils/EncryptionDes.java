package com.wugu.utils;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName: EncryptionDes
 * @Description: 可逆加密算法
 * @author yangch
 * @date 2014-12-23
 * 
 */
public class EncryptionDes implements Serializable {

    private static final long serialVersionUID = 1L;
    // byte数组(用来生成密钥的)
    private static final byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58,
            (byte) 0x88, 0x10, 0x40, 0x38, 0x28, 0x25, 0x79, 0x51, (byte) 0xCB,
            (byte) 0xDD, 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40,
            0x36, (byte) 0xE2 };
    private static final String Algorithm = "DESede"; // 定义 加密算法,可用
                                                      // DES,DESede,Blowfish
    private static final String hexString = "0123456789ABCDEF";

    public static byte[] encryptMode(byte[] src) {
        try {
            // 添加新安全算法,如果用JCE就要把它添加进去
            // 这里addProvider方法是增加一个新的加密算法提供者(个人理解没有找到好的答案,求补充)
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            // 根据给定的字节数组和算法构造一个密钥
            SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        }
        catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
        catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static byte[] decryptMode(byte[] encipheredData) {
        try {
            // 添加新安全算法,如果用JCE就要把它添加进去
            // 这里addProvider方法是增加一个新的加密算法提供者(个人理解没有找到好的答案,求补充)
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(encipheredData);
        }
        catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
        catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static String encode(String encipheredData) 
    { 
        //根据默认编码获取字节数组 
        byte[] bytes = encipheredData.getBytes(); 
        StringBuilder sb=new StringBuilder(bytes.length*2); 
    
        //将字节数组中每个字节拆解成2位16进制整数 
        for(int i=0;i < bytes.length; i++)
        { 
            sb.append(hexString.charAt((bytes[i]&0xf0)>>4)); 
            sb.append(hexString.charAt((bytes[i]&0x0f)>>0)); 
        } 
        return sb.toString(); 
        }    
    
    public static String decode(String bytes) 
        { 
        ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2); 
        //将每2位16进制整数组装成一个字节 
        for(int i=0;i<bytes.length();i++)
            baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1)))); 
        return new String(baos.toByteArray()); 
    }    
    
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }
}
