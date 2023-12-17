package com.Nreal.annontation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NrealMapping {
    //api路径
    String api() default "";
    //调用的主机和端口
    String url() default "";
}

