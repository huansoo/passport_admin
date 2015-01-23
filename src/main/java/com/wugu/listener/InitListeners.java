package com.wugu.listener;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.wugu.utils.StringUtils;

/**
 * @ClassName: InitListeners
 * @Description: 
 * @author yangch
 * @date 2014-12-30 
 *
 */
public class InitListeners implements ServletContextListener{

    public static Logger log = Logger.getLogger(InitListeners.class);
    /* (非 Javadoc)
    * <p>Title: contextInitialized</p>
    * <p>Description: </p>
    * @param sce
    * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
    */
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String path = context.getRealPath("/");
        String logFile = context.getInitParameter("log4j_init_file");//  WEB-INF/classes/log4j.properties
        String log_path = context.getInitParameter("log4j_init_path");// WEB-INF/log/
        if(!StringUtils.isNullString(logFile)){
            try{
                Properties prop = new Properties();
                prop.load(new FileInputStream(path+logFile));//加载log4j.properties
                prop.setProperty("log4j.appender.index.File",path+log_path + prop.getProperty("log4j.appender.index.File")); //设置日志文件的输出路径   
                log.info("===================================>"+log_path);
                log.info("-------------------------------->"+path+log_path + prop.getProperty("log4j.appender.index.File"));
                PropertyConfigurator.configure(prop);
            }catch(Exception e){
                log.info("初始化log4j日志输入路径异常，请检查web.xml参数配置是否正常，异常发生在" + this.getClass().getName() + "类的public void init()方法，异常的愿意是：" + e.getMessage(), e.fillInStackTrace()); 
                log.error(e.getMessage());
            }
        }
    }

    /* (非 Javadoc)
    * <p>Title: contextDestroyed</p>
    * <p>Description: </p>
    * @param sce
    * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
    */
    public void contextDestroyed(ServletContextEvent sce) {
        
    }

    public static void main(String[] args) {
        try{
            log.debug("日志打印了。。。。。。。");
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }
}
