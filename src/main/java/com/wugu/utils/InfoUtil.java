package com.wugu.utils;

import java.util.ResourceBundle;

/**
 * 
* @ClassName: InfoUtil
* @Description: 提取指定资源文件key=>value
* @author lijun
* @date 2014-1-10 
*
 */
public class InfoUtil {
	private static InfoUtil instance = null;

	private InfoUtil() {

	}

	public synchronized static InfoUtil getInstance() {
		if (instance == null) {
			instance = new InfoUtil();
		}
		return instance;
	}
	
	/**
	 * 
	* @Title: getInfo
	* @Description: 获取配置文件中指定键值
	* @author lijun
	* @param name 配置文件名称
	* @param key 配置主键
	* @return 返回键值
	* @throws
	 */
	public String getInfo(String name,String key){
		ResourceBundle rb = ResourceBundle.getBundle(name);
		return rb.getString(key);
	}
	
	/**
	 * 
	* @Title: getClassPath
	* @Description: 获取系统根目录
	* @author lijun
	* @return
	* @throws
	 */
	public static String getClassPath(){
	    return getInstance().getClass().getClassLoader().getResource("").getPath();
	}
	
	public static void main(String[] args) throws Exception{
	    System.out.println(getClassPath());
	}
}
