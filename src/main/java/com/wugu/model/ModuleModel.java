package com.wugu.model;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: ModuleModel
 * @Description: 模块实体/dao
 * @author yangch
 * @date 2014-12-19 
 *
 */
@TableBind(table="WG_MODULE")
public class ModuleModel extends Model<ModuleModel>{

    private static final long serialVersionUID = 1L;

    public static final ModuleModel dao = new ModuleModel();
}
