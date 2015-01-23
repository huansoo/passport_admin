package com.wugu.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: TableBind
 * @Description: 数据库相关注解
 * @author yangch
 * @date 2015-1-16 
 *
 */
@Inherited
@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableBind {

    public String table();
}
