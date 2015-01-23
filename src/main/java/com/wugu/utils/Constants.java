package com.wugu.utils;

import java.io.Serializable;

/**
 * @ClassName: Constants
 * @Description: 存放常量工具类
 * @author yangch
 * @date 2014-12-12 
 *
 */
public class Constants implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_FILE = "a_little_config.txt";
    //邮件相关配置文件
    public static final String PROPERTY_MAIL = "mail.properties";
    //邮件发送人地址
    public static final String MAIL_SERVER = "serverAddress";
    //邮件发送协议
    public static final String MAIL_SMTP = "smtp";
    //邮件发送端口
    public static final String MAIL_PORT = "port";
    //邮件发送人姓名
    public static final String MAIL_SEND_NAME = "sendName";
    //邮件模板地址
    public static final String MAIL_TEMPLATE_PATH = "templatePath";
    //加密权重
    public static final String PASSWORD_SALT = "salt";
    //json参数
    public static final String PARAM_JSON="json";
    //id参数
    public static final String PARAM_ID="id";
    //type
    public static final String PARAM_TYPE = "type";
    //状态  1有效  0-未激活  -1删除
    public static final String PARAM_STATUS = "status";
    //用户名
    public static final String USER_NAME="user_name";
    public static final String USER_EMAIL = "email";
    //密码
    public static final String PASSWORD = "password";
    //根据码表类型获取码表信息
    public static final String CODE_TYPE = "code_type";
    
    //标志 激活类型(发送邮件时使用)
    public static final String CODE_ACTIVE = "active";
    //标志 忘记密码类型(发送邮件时使用)
    public static final String CODE_FORGET = "forget";
    //标志 绑定邮箱类型(发送邮件时使用)
    public static final String CODE_BIND = "bind";
    //标志 修改绑定邮箱类型(发送邮件时使用)
    public static final String CODE_BIND_UPDATE = "bindUpdate";
    
    //整形类型
    public static final String TYPE_INT = "int";
    //成功标志
    public static final String SUCCESS = "success";
    
    //失败标志
    public static final String FAILURE = "failure";
    
    //判断该条记录有效
    public static final Integer TYPE_EFFICIENT = 1;
    
    //判断该条记录无效
    public static final Integer TYPE_INFFICIENT = -1;
    
    //政府招商项目正在进行中
    public static final Integer STATUS_ING = 2;
    //政府招商项目已完成
    public static final Integer STATUS_COMPLETE = 4;
    
    //排序正序排列 asc
    public static final Integer SORT_ASC = 1;
    
    //排序倒序排列 desc
    public static final Integer SORT_DESC = -1;
    
    //一天的秒数  1419563790
    public static final Integer ONE_DAY_SECOND = 86400;
    
}
