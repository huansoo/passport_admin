package com.wugu.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.jfinal.plugin.activerecord.Model;
import com.wugu.utils.Constants;
import com.wugu.utils.StringUtils;


/**
 * @ClassName: BaseService
 * @Description: 业务处理基类
 * @author yangch
 * @date 2014-12-9 
 *
 */
public abstract class BaseService implements Serializable{

    private static final long serialVersionUID = 1L;
    public static final Logger log = Logger.getLogger(BaseService.class);
    public String sqlStr;
    public List<Object> params;
    /**
     * 
      * @Title: handlerCondition
      * @Description: 处理查询条件
      * @author yangch
      * @date 2014-12-22 
      * @param obj obj中所有属性不可含有对象类型 否则该方法会出错误
      * @return
      * @throws NoSuchMethodException
      * @throws SecurityException
      * @throws IllegalAccessException
      * @throws IllegalArgumentException
      * @throws InvocationTargetException
      * @throws
     */
    public void handlerCondition(Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        StringBuffer sb = new StringBuffer();
        params = new ArrayList<Object>();
        Class<?> clz = obj.getClass();
        Field[] field = obj.getClass().getDeclaredFields();
        for(int i = 0; i < field.length; i++){
            //属性名
            String fieldName = field[i].getName();
            Method method = clz.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1), null);
            Object val = method.invoke(obj, null);
            if(null == val || StringUtils.isNullString(String.valueOf(val))){
                continue;
            }
            sb.append(" and ").append(fieldName).append(" = ? ");
            params.add(val);
        }
        sqlStr = sb.toString();
    }
    
    /**
     * 
      * @Title: handlerProperty
      * @Description: 将map中所有值不为空的属性，设置到model中 ( 更新使用)
      * @author yangch
      * @date 2014-12-22 
      * @param map 包含属性和值的键值对
      * @throws
     */
    @SuppressWarnings("rawtypes")
    public void handlerProperty(Model<? extends Model> model, Map map){
        Set entrySet = map.keySet();
        Iterator ite = entrySet.iterator();
        while(ite.hasNext()){
            String key = (String) ite.next();
            Object val = map.get(key);
            //如果属性值为空
            if(Constants.PARAM_ID.equals(key) && StringUtils.isNullString(String.valueOf(val))){
                continue;   
            }
            model.set(key, val);
        }
    }
    /**
     * 
      * @Title: handlerProperty
      * @Description: 将map中所有值不为空的属性，拼接到where条件中
      * @author yangch
      * @date 2014-12-24 
      * @param map
      * @throws
     */
    @SuppressWarnings("rawtypes")
    public void handlerProperty(Map map){
        StringBuffer sb = new StringBuffer();
        params = new ArrayList<Object>();
        
        Set entrySet = map.keySet();
        Iterator ite = entrySet.iterator();
        while(ite.hasNext()){
            String key = (String) ite.next();
            Object val = map.get(key);
            //如果属性值为空
            if(null == val || StringUtils.isNullString(String.valueOf(val))){
                continue;   
            }
            sb.append(" and ").append(key).append(" = ? ");
            params.add(val);
        }
        sqlStr = sb.toString();
    }
}
