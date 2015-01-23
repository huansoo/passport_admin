package com.wugu.model;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: SystemCodeModel
 * @Description: 码表相关dao和meodel
 * @author yangch
 * @date 2014-12-17 
 *
 */
@TableBind(table="hxm_system_code_node")
public class SystemCodeNodeModel extends Model<SystemCodeNodeModel>{

    private static final long serialVersionUID = 1L;

    public static final SystemCodeNodeModel dao = new SystemCodeNodeModel();
}
