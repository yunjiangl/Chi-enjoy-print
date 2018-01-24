package com.zx.share.platform.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fenggang on 1/24/18.
 *
 * @author fenggang
 * @date 1/24/18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ACSPermissions {

    /**
     * 是否登录（只有为false权限标识才生效）
     * @return
     */
    boolean loginStatus() default true;

    /**
     * 权限标识（user:edit）
     * 空为不需要任何权限
     * @return
     */
    String permissions() default "";
}
