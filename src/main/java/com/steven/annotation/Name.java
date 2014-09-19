package com.steven.annotation;

import java.lang.annotation.*;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {

    String originate();
    String community();
}
