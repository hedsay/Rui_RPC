package com.Nreal.annontation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NrealHttpClient {
    String value();
}
