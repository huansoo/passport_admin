package com.wugu.plugin;

import java.util.List;

import org.apache.log4j.Logger;

import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.wugu.utils.StringUtils;
import com.wugu.utils.ToolClassSearcher;

/**
 * @ClassName: TableBindPlugin
 * @Description: 数据库相关注解
 * @author yangch
 * @date 2015-1-16 
 *
 */
public class TableBindPlugin implements IPlugin{

    public static final Logger log = Logger.getLogger(TableBindPlugin.class);
    /* (非 Javadoc)
    * <p>Title: start</p>
    * <p>Description: </p>
    * @return
    * @see com.jfinal.plugin.IPlugin#start()
    */
    private ActiveRecordPlugin arp = null;
    public TableBindPlugin(ActiveRecordPlugin arp){
        this.arp = arp;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean start() {
        List<Class<? extends Model>> classList = null;
        try{
            classList = ToolClassSearcher.of(Model.class).search();
            if(null == classList){
                log.error("没有发现继承Model的类......");
            }
            for(Class modelClz:classList){
                TableBind table = (TableBind) modelClz.getAnnotation(TableBind.class);
                if(table == null){
                    log.error(modelClz.getName()+"没有指定对应的表，请检查....");
                }
                String table_name = table.table();
                if(StringUtils.isNullString(table_name)){
                    log.error(modelClz.getName()+"没有指定对应的表，请检查....");
                }
                this.arp.addMapping(table_name, modelClz);
            }
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getStackTrace());
            return false;
        }
        log.info("table 注解成功");
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
