package tech.generated.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ForClass {

    public String name() default "";

    public Class<?> value();

    public boolean strict() default false;

    public long metrics() default Long.MIN_VALUE;
}
