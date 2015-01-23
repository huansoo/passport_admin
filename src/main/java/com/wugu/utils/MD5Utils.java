package com.wugu.utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @ClassName: MD5Utils
 * @Description: MD5加密相关
 * @author yangch
 * @date 2014-12-22 
 *
 */
public class MD5Utils implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    /**
     * 
      * @Title: MD5Encode
      * @Description: MD5加密算法
      * @author yangch
      * @date 2014-12-22 
      * @param origin
      * @return
      * @throws
     */
    public final static String MD5Encode(String origin) {
        return MD5Encode(origin, null); 
     }
    /**
     * 
      * @Title: MD5Encode
      * @Description: MD5加密算法
      * @author yangch
      * @date 2014-12-22 
      * @param str
      * @param original
      * @return
      * @throws
     */
    public final static String MD5Encode(String str, String original){
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if(StringUtils.isNullString(original)){
                //调用 digest 方法之一完成哈希计算，digest 方法只能被调用一次。
                //digest 被调用后，MessageDigest 对象被重新设置成其初始状态
                resultString = byteArrayToHexString(md.digest(str.getBytes()));
            }else{
               byte[] bytes = str.getBytes(original);
               resultString = byteArrayToHexString(md.digest(bytes));
            }
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    /**
     * 
      * @Title: byteToHexString
      * @Description: 将字节类型数转化为16进制数，并转化为string类型
      * @author yangch
      * @date 2014-12-22 
      * @param b
      * @return
      * @throws
     */
    private static String byteToHexString(byte b){
        int n = b;
        if(n < 0)
            n += 256;
        int d1 = n/16;
        int d2 = n%16;
        return hexDigits[d1] + hexDigits[d2];
    }
    /**
     * 
      * @Title: byteArrayToHexString
      * @Description: 字节数组转化为十六进制字符串
      * @author yangch
      * @date 2014-12-22 
      * @param b
      * @return
      * @throws
     */
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }
}
