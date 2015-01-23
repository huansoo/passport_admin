package com.wugu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegUtils
 * @Description: 校验类
 * @author yangch
 * @date 2014-12-25 
 *
 */
public class RegUtils {

    /**
     * 
      * @Title: checkEmail
      * @Description: 校验是否符合邮箱规则
      * @author yangch
      * @date 2014-12-25 
      * @param str
      * @return
      * @throws
     */
    public static boolean checkEmail(String str){
        return checkReg(str, "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
    }
    /**
     * 
      * @Title: checkEnglist
      * @Description:校验英文字母
      * @author yangch
      * @date 2014-12-25 
      * @param str
      * @return
      * @throws
     */
    public static boolean checkEnglish(String str){
       return checkReg(str, "^[a-zA-Z]+$");
    }
    /**
     * 
      * @Title: checkNumber
      * @Description: 校验必须为数字
      * @author yangch
      * @date 2014-12-25 
      * @param str
      * @return
      * @throws
     */
    public static boolean checkInteger(String str){
        return checkReg(str, "^\\d{1,10}$");
    }
    /**
     * 
      * @Title: checkUserName
      * @Description: 匹配数字字母下划线
      * 匹配中文[\u4e00-\u9fa5] 
      * @author yangch
      * @date 2014-12-25 
      * @return
      * @throws
     */
    public static boolean checkUserName(String str){
        return checkReg(str, "^[0-9a-zA-Z_]+$");
    }
    /**
     * 
      * @Title: checkReg
      * @Description: 校验正则
      * @author yangch
      * @date 2014-12-25 
      * @param str
      * @param reg
      * @return
      * @throws
     */
    public static boolean checkReg(String str, String reg){
        str = str.trim();
        if(StringUtils.isNullString(str)){
            return false;
        }
        Pattern pattern = Pattern.compile(reg);
        Matcher match = pattern.matcher(str);
        if(match.matches()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkInteger("1111111111"));
    }
}
