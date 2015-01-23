package com.wugu.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wugu.common.ApiResult;
import com.wugu.model.SystemCodeModel;
import com.wugu.plugin.ControllerKey;
import com.wugu.service.SystemCodeService;
import com.wugu.utils.Constants;
import com.wugu.utils.StringUtils;

/**
 * @ClassName: SystemCodeController
 * @Description: 系统码表相关控制器
 * @author yangch
 * @date 2015-1-21 
 *
 */
@ControllerKey(controllerKey="systemCode")
public class SystemCodeController extends WuguBaseController{

    public static final Logger log = Logger.getLogger(SystemCodeController.class);
    /**
     * 
      * @Title: getList
      * @Description: 获取所有码表类型列表
      * @author yangch
      * @date 2015-1-21 
      * @throws
     */
    public void getSystemCodeList(){
        try{
            Integer page_number = getParaToInt("page") == null ? 1:getParaToInt("page");
            Integer row_number = getParaToInt("rows") == null ? 10:getParaToInt("rows");
            Map map = new HashMap<String, Object>();
            Page<Record> page = SystemCodeModel.dao.getSystemCodeList(page_number, row_number);
            map.put("total", page.getTotalRow());
            map.put("rows", page.getList());
            renderJson(map);
            log.info("返回数据为：---->"+map);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    /**
     * 
      * @Title: getSysteCodeById
      * @Description: 通过码表类型id，获取码表类型详情
      * @author yangch
      * @date 2015-1-22 
      * @throws
     */
    public void getSysteCodeById(){
        ApiResult<Object> result = new ApiResult<Object>();
        try{
            String id = getPara(Constants.PARAM_ID);
            if(StringUtils.isNullString(id)){
                log.error(" param id is missed ,or id is null ,please check");
                throw new Exception(" param id is missed ,or id is null ,please check");
            }
            SystemCodeModel model = SystemCodeModel.dao.findById(id);
            setAttr("systemCode", model);
            result.setSuccessData(model);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result.setExceptionData(e.getMessage());
        }
        log.info(JSON.toJSONString(result));
        renderJson(result);
    }
    /**
     * 
      * @Title: saveSystemCodeType
      * @Description: 编辑码表类型
      * @author yangch
      * @date 2015-1-21 
      * @throws
     */
    public void saveSystemCodeType(){
        ApiResult<Object> result = new ApiResult<Object>();
        try{
            Map info = getParaMap();
            SystemCodeService.service.saveSystemCodeType(info);
            result.setSuccessData("success");
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result.setExceptionData(e.getMessage());
        }
        renderJson(result);
    }
}
