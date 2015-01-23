package com.wugu.utils;

import java.util.Date;

import org.apache.log4j.Logger;

import com.danga.MemCached.MemCachedClient;
/**
 * 
* @ClassName: MemCachedMaker
* @Description: 应用缓存存取数据
* @author lijun
* @date 2013-12-26 
*
 */
public abstract class MemCachedMaker {
	private static MemCachedClient memClient = MemCached.getmcc();
	private static final Logger log = Logger.getLogger(MemCachedMaker.class);
	/**
	 * 
	* @Title: set
	* @Description: 设置对象缓存
	* @author lijun
	* @param key
	* @param value
	* @throws
	 */
	public  static void set(String key,Object value){
		if(key==null || key.equals("")) return;
        String md5Key = MD5Utils.MD5Encode(key); 
		memClient.set(md5Key, value);
		log.info("-----------------------------------memcached set key:"+ md5Key +" set value:"+value);
	}
	public  static void set(String key,Object value,int times){
		if(key==null || key.equals("")) return;
        String md5Key = MD5Utils.MD5Encode(key); 
		memClient.set(md5Key, value, new Date(times) );
		log.info("-----------------------------------memcached set key:"+ md5Key +" set value:"+value +" set time:"+times);
	}
	
	/**
	 * 
	* @Title: get
	* @Description: 获得对象缓存
	* @author lijun
	* @param key
	* @return
	* @throws
	 */
	public  static Object get(String key){
	    String md5Key = MD5Utils.MD5Encode(key); 
		return memClient.get(md5Key);
	}
	/**
	 * 
	* @Title: hasCache
	* @Description: 判断是否存在缓存
	* @author lijun
	* @param key
	* @return
	* @throws
	 */
	public static boolean hasCache(String key) {
	    return memClient.keyExists(MD5Utils.MD5Encode(key));
	}
	/**
	 * 
	* @Title: remove
	* @Description: 删除 指定缓存
	* @author lijun
	* @param key
	* @throws
	 */
	public static void remove(String key){
		memClient.delete(MD5Utils.MD5Encode(key));
		log.info("-----------------------------------memcached remove key:"+ MD5Utils.MD5Encode(key));
	}
}
