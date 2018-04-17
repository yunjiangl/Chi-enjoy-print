package com.zx.share.platform.console.api.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017年3月8日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
