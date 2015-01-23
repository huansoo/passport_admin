package com.wugu.freemarker;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.wugu.utils.InfoUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @ClassName: TemplateUtils
 * @Description: 模板相关操作
 * @author yangch
 * @date 2014-12-23 
 *
 */
public class TemplateUtils {

    public static final Logger log = Logger.getLogger(TemplateUtils.class);
    public static Template getCommonTemplate(String templateName){
        Template template = null;
        
        //存放模板application级别信息，并负责创建和预解析模板
        Configuration cfg = new Configuration();
        
        //设置如何查看数据模板
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        
        //设置模板加载器  基于类文件相对位置
        //cfg.setTemplateLoader(new ClassTemplateLoader(Thread.currentThread().getContextClassLoader().getClass(), "WEB-INF/template"));
        //基于文件系统的路径
        String path = InfoUtil.getClassPath();
        path = path.replace("classes", "template");
        System.out.println(path);
        File file = new File(path);
        try {
            cfg.setDirectoryForTemplateLoading(file);
            template = cfg.getTemplate(templateName);
            log.info("获取到的模板名称为"+templateName);
        }
        catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return template;
    }
}
