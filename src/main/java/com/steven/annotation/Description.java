package com.steven.annotation;

import java.lang.annotation.*;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    String value();
}
