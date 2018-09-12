package bitcamp.java110.cms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})//배열이라 원래 {}를 써줘야함 근데 한개일떄는 안붙여도됨, 두개이상일땐 붙이자!
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
}