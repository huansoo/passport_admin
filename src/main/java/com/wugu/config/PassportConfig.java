package com.wugu.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.wugu.model.AreaCodeModel;
import com.wugu.model.ModuleModel;
import com.wugu.model.RoleModel;
import com.wugu.model.UserModel;
import com.wugu.plugin.ControllerPlugin;
import com.wugu.plugin.TableBindPlugin;

/**
 * @ClassName: PassportConfig
 * @Description: 会员中心配置
 * @author yangch
 * @date 2014-12-19 
 *
 */
public class PassportConfig extends JFinalConfig{

    /* (非 Javadoc)
    * <p>Title: configConstant</p>
    * <p>Description: </p>
    * @param me
    * @see com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants)
    */
    @Override
    public void configConstant(Constants me) {
        loadPropertyFile(com.wugu.utils.Constants.PROPERTY_FILE);
        me.setDevMode(true);
        me.setEncoding("UTF-8");
        me.setViewType(ViewType.JSP);
    }

    /* (非 Javadoc)
    * <p>Title: configRoute</p>
    * <p>Description: </p>
    * @param me
    * @see com.jfinal.config.JFinalConfig#configRoute(com.jfinal.config.Routes)
    */
    @Override
    public void configRoute(Routes me) {
        new ControllerPlugin(me).start();
    }

    /* (非 Javadoc)
    * <p>Title: configPlugin</p>
    * <p>Description: </p>
    * @param me
    * @see com.jfinal.config.JFinalConfig#configPlugin(com.jfinal.config.Plugins)
    */
    @Override
    public void configPlugin(Plugins me) {
        //配置数据库链接池
        C3p0Plugin plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
        me.add(plugin);
        
        //数据库访问插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(plugin);
        arp.setDialect(new MysqlDialect());
        arp.setShowSql(true);
        
        new TableBindPlugin(arp).start();
        me.add(arp);
    }

    /* (非 Javadoc)
    * <p>Title: configInterceptor</p>
    * <p>Description: </p>
    * @param me
    * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
    */
    @Override
    public void configInterceptor(Interceptors me) {
        
    }

    /* (非 Javadoc)
    * <p>Title: configHandler</p>
    * <p>Description: </p>
    * @param me
    * @see com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
    */
    @Override
    public void configHandler(Handlers me) {
        
    }

}
