package com.wugu.model;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: UserModel
 * @Description:用户实体/dao
 * @author yangch
 * @date 2014-12-19 
 *
 */
@TableBind(table="WG_USER")
public class UserModel extends Model<UserModel>{

    private static final long serialVersionUID = 1L;
    
    public static final UserModel dao = new UserModel();
}
