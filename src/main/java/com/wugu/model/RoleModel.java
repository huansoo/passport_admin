package com.wugu.model;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: RoleModel
 * @Description: 角色实体/dao
 * @author yangch
 * @date 2014-12-19 
 *
 */
@TableBind(table="WG_USER_ROLE")
public class RoleModel extends Model<RoleModel>{

    private static final long serialVersionUID = 1L;
    public static final RoleModel dao = new RoleModel();
}
