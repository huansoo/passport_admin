package com.wugu.plugin;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfinal.config.Routes;
import com.jfinal.plugin.IPlugin;
import com.wugu.controller.WuguBaseController;
import com.wugu.utils.StringUtils;
import com.wugu.utils.ToolClassSearcher;

/**
 * @ClassName: ControllerPlugin
 * @Description: 扫描controller注解
 * @author yangch
 * @date 2015-1-15 
 *
 */
public class ControllerPlugin implements IPlugin{

    public static final Logger log = Logger.getLogger(ControllerPlugin.class);
    
    private Routes me;
    public ControllerPlugin(Routes me){
        this.me = me;
    }
    /* (非 Javadoc)
    * <p>Title: start</p>
    * <p>Description: </p>
    * @return
    * @see com.jfinal.plugin.IPlugin#start()
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean start() {
        List<Class<? extends WuguBaseController>> list = null;
        try {
            list = ToolClassSearcher.of(WuguBaseController.class).search();
            //循环添加注解的类
            for(Class clz:list){
                ControllerKey annotationController = (ControllerKey) clz.getAnnotation(ControllerKey.class);
                if(null == annotationController){
                    log.error(clz.getName()+"继承了 jfinal的controller，但是没有注解绑定映射路径");
                    continue;
                }
                String[] controllerKeys = annotationController.controllerKey();
                //循环注解类的路径
                for(String key:controllerKeys){
                    if(StringUtils.isNullString(key)){
                        log.error(clz.getName() + "注解错误，映射路径为空");
                        continue;
                    }
                    
                    me.add(key, clz);
                }
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
        log.info("controller 注解添加成功");
        return true;
    }

    /* (非 Javadoc)
    * <p>Title: stop</p>
    * <p>Description: </p>
    * @return
    * @see com.jfinal.plugin.IPlugin#stop()
    */
    public boolean stop() {
        return true;
    }

}
