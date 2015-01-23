package com.wugu.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wugu.plugin.TableBind;

/**
 * @ClassName: SystemCodeModel
 * @Description: 
 * @author yangch
 * @date 2015-1-21 
 *
 */
@TableBind(table="hxm_system_code")
public class SystemCodeModel extends Model<SystemCodeModel>{

    private static final long serialVersionUID = 1L;

    public static final SystemCodeModel dao = new SystemCodeModel();
    
    public static Page<Record> getSystemCodeList(Integer page_number, Integer row_number){
        return Db.paginate(page_number, row_number, "SELECT * ", "FROM hxm_system_code ");
    }
}
