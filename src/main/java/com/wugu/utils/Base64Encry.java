package com.wugu.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Encry {

	/**
	 * 
	* @Title: decryptBASE64
	* @Description: BASE64解密 http://www.bt285.cn http://www.5a520.cn
	* @author lijun
	* @param key
	* @return
	* @throws Exception
	* @throws
	 */
	public static String decryptBASE64(String key) throws Exception {
		byte[] t=(new BASE64Decoder()).decodeBuffer(key);
		byte[] re=(new BASE64Decoder()).decodeBuffer(new String(t));
		return new String(re);
	}


	/**
	 * 
	* @Title: encryptBASE64
	* @Description: BASE64加密
	* @author lijun
	* @param str
	* @return
	* @throws Exception
	* @throws
	 */
	public static String encryptBASE64(String str) throws Exception {
		byte[] key=str.getBytes();
		String re=(new BASE64Encoder()).encodeBuffer(key);
		return (new BASE64Encoder()).encodeBuffer(re.getBytes());
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(encryptBASE64("Wu888gUpassW0RD"));
		System.out.println(encryptBASE64("991622230@qq.com"));
		System.out.println(decryptBASE64(encryptBASE64("wugu123")));
	}

}
