package com.wugu.condition;

/**
 * @ClassName: UserCondition
 * @Description: 用户查询相关条件
 * @author yangch
 * @date 2014-12-19 
 *
 */
public class UserCondition {

    //id
    private Integer id;
    //用户名
    private String user_name;
    //密码
    private String password;
    //邮箱
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
