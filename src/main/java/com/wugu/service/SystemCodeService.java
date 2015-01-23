package com.wugu.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.wugu.model.SystemCodeModel;
import com.wugu.utils.Constants;

/**
 * @ClassName: SystemCodeService
 * @Description: 系统码表业务逻辑层
 * @author yangch
 * @date 2014-12-17
 * 
 */
public class SystemCodeService extends BaseService {

    private static final long serialVersionUID = 1L;

    public static final SystemCodeService service = new SystemCodeService();

    /**
     * @Title: getSystemCodeByType
     * @Description: 根据码表类型获取码表信息
     * @author yangch
     * @date 2014-12-17
     * @param code_type
     * @throws
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SystemCodeModel> getSystemCodeByType(Hashtable info) {
        List<SystemCodeModel> list = null;
            list = SystemCodeModel.dao
                    .find("select * from hxm_system_code_node t where t.system_code = ? and t.type = ? ",
                            new Object[]{info.get(Constants.CODE_TYPE), 1});
         
        return list;
    }

    /**
      * @Title: saveSystemCodeType
      * @Description: 操作码表类型
      * @author yangch
      * @date 2015-1-21 
      * @param table
      * @throws
      */
    public void saveSystemCodeType(Map map) {
        SystemCodeModel model = new SystemCodeModel();
        handlerProperty(model, map);
        int time = (int) (System.currentTimeMillis()/1000);
        model.set("create_date", time);
        model.save();
    }

}
