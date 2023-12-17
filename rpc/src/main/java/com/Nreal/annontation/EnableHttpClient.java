package com.Nreal.annontation;

import com.Nreal.bean.NrealBeanDefinitionRegistry;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(NrealBeanDefinitionRegistry.class)
public @interface EnableHttpClient {
    //扫包路径
    String basePackage();
}