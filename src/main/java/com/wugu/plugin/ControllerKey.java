package com.wugu.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ControllerKey
 * @Description: controller注解
 * @author yangch
 * @date 2015-1-15 
 *
 */
@Inherited
@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerKey {
    String[] controllerKey();
}
