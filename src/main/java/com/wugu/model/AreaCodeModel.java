package com.wugu.model;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: AreaCodeModel
 * @Description: 行政区划相关的信息
 * @author yangch
 * @date 2014-12-26 
 *
 */
@TableBind(table="xzqh")
public class AreaCodeModel extends Model<AreaCodeModel>{

    private static final long serialVersionUID = 1L;

    public static final AreaCodeModel dao = new AreaCodeModel();
}
