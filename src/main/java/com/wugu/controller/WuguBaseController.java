package com.wugu.controller;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;
import com.wugu.utils.Constants;
import com.wugu.utils.StringUtils;

/**
 * @ClassName: WuguBaseController
 * @Description: 吾谷网基础控制器
 * @author yangch
 * @date 2015-1-13 
 *
 */
public class WuguBaseController extends Controller{

    public static final Logger log = Logger.getLogger(WuguBaseController.class);
    
    /**
     * 
      * @Title: getParamInfo
      * @Description: 将前台传递过来的参数封装成hashtable
      * @author yangch
      * @date 2015-1-13 
      * @return
      * @throws Exception
      * @throws
     */
    @SuppressWarnings("rawtypes")
    public Hashtable getParamInfo() throws Exception{
        String json = getPara(Constants.PARAM_JSON);
        if (StringUtils.isNullString(json)) {
            log.error("param json missed or json value is null ！！！");
            throw new Exception(
                    "param json missed or json value is null ！！！");
        }
        Hashtable hashtable = JSON.parseObject(json, Hashtable.class);
        return hashtable;
    }
}
